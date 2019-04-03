package it.lsoft.steambath;

import java.io.IOException;

import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

public class I2CComm {
    public static final int I2C_STARRYSKY = 7;
    public static final int I2C_LIGHTSTRIPE = 8;

    public static final byte CTRLID_RGBSTRIPE = 1;
    public static final byte CTRLID_STARRYSKY = 2;
    public static final byte CTRLID_STEAM_POWER = 3;
    public static final byte CTRLID_STEAM_WATER_IN = 4;
    public static final byte CTRLID_STEAM_WATER_OUT = 5;
    public static final byte CTRLID_HUMIDITY_SENSOR = 6;

    public static final byte LEDRGB_GET_ACTUAL = 1;
    public static final byte LEDRGB_SET_MANUAL = 2;
    public static final byte LEDRGB_SET_AUTO = 3;
    public static final byte LEDRGB_SET_BRIGHTNESS = 4;
    public static final byte LEDRGB_SWITCH_ON_OFF = 5;
    public static final byte LEDRGB_SET_SPEED = 6;
    public static final byte LEDRGB_RESET_TIMERS = 7;
	public static final byte LEDRGB_FADE_IN_OUT = 8;
	public static final byte LEDRGB_SET_TIMERS = 9;
    
    public static final byte I2CCMD_ACK = (byte)0xFF;
    public static final byte I2CCMD_MASTER_START = 0x1;
    public static final byte I2CCMD_GET = 0x2;
    public static final byte I2CCMD_SET = 0x3;
    public static final byte I2CCMD_AUTO = 0x3;
    public static final byte I2CCMD_MANUAL = 0x3;
    
    private static final byte NULL = 0x0;

    private I2CDevice starry;
    private I2CDevice lights;
    
    private byte[] readBuffer = new byte[255];
    private byte[] writeBuffer = new byte[255];

    private void memset(byte[] buffer, int size, byte value)
    {
    	for(int i = 0; i < size; i++)
    	{
    		buffer[i] = value;
    	}
    }

	public void alertDeviceOnStart() throws IOException
    {
    	memset(readBuffer, readBuffer.length, NULL);
    	memset(writeBuffer, writeBuffer.length, NULL);
    	writeBuffer[0] = I2CCMD_MASTER_START;
    	try
    	{
	    	starry.write(writeBuffer, 0, 1);
	    	Thread.sleep(100);
	    	starry.read(readBuffer, 0, 2);
	    	if (readBuffer[1] != I2CCMD_ACK)
	    	{
	    		// TODO: gestire errore
	    		return;
	    	}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}

    	memset(readBuffer, readBuffer.length, NULL);
    	try
    	{
	    	lights.write(writeBuffer, 0, 1);
	    	Thread.sleep(100);
	    	lights.read(readBuffer, 0, 2);
	    	if (readBuffer[1] != I2CCMD_ACK)
	    	{
	    		// TODO: gestire errore
	    		return;
	    	}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }

    public I2CComm() throws UnsupportedBusNumberException, IOException, InterruptedException
    {
        I2CBus i2c = I2CFactory.getInstance(I2CBus.BUS_1);

        starry = i2c.getDevice(I2C_STARRYSKY);
        lights = i2c.getDevice(I2C_LIGHTSTRIPE);
    }
    
    public boolean command(byte[] cmd) throws UnsupportedBusNumberException, IOException, InterruptedException
    {
        I2CDevice ctrl = null;

		byte[] readBuffer = new byte[128];
		int idx = 0;
		
		if (cmd[0] == 7)
		{
			ctrl = starry;
		}
		else if (cmd[0] == 8)
		{
			ctrl = lights;
		}

		System.out.println("writing a total of " + idx + " bytes.");
		try
		{
			ctrl.write(writeBuffer, 1, idx - 1);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		Thread.sleep(1000);
		int bytesRead = 0;
    	System.out.println("Going to receive message.");
    	boolean pendingHdr = true;
    	int doItAgain = 0;
		do {
	    	try
	    	{
	    		bytesRead = ctrl.read(readBuffer, 0, readBuffer.length);
	    	}
	    	catch(IOException e)
	    	{
	    		e.printStackTrace();
	    	}

	    	if (bytesRead < 2)
    		{
    			System.out.println("Something went wrong... restarting");
    			return false;
    		}
    		else
    		{
		    	System.out.println("Message received. Status is " + ((int)readBuffer[1]));
	    		switch(readBuffer[1])
	    		{
	    		case (byte) 0xFF:
	    			System.out.println("Rejection received");
	    		case 0:
	    			pendingHdr = false;
	    			break;

	    		case (byte)0xFE:
	    			// Wait for an answer
	    			if (++doItAgain == 10)
	    			{
		    			System.out.println("No answer received, command aborted");
		    			pendingHdr = false;
	    			}
	    			else
					{
		    			System.out.println("No answer ready yet, keep pushing");
	    				Thread.sleep(300);
					}
	    			break;
	    		}
    		}
		} while(pendingHdr);
		
		if (readBuffer[0] > 2)
		{
    		System.out.println("Reading response " + readBuffer[0] + " bytes long");
    		for(int i = 0; i < readBuffer[0]; i++)
    		{
    			System.out.print(" " + String.format("0x%02X", readBuffer[i]));
			}
    		System.out.println();
		}
		return true;
    }
}