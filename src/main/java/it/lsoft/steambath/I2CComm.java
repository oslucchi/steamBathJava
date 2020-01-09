package it.lsoft.steambath;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

import it.lsoft.steambath.Commons.Parameters;

public class I2CComm {
	final static Logger logger = Logger.getLogger(I2CComm.class);

	public static final byte I2C_LIGHTS_AND_STEAM = 8;
    public static final byte I2C_WATER_AND_FANS = 7;

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
	public static final byte LEDRGB_SET_TIMERS = 8;
	public static final byte LEDRGB_FADE_IN_OUT = 9;
    
    public static final byte I2CCMD_ACK = (byte)0xFF;
    public static final byte I2CCMD_MASTER_START = 0x1;
    public static final byte I2CCMD_GET = 0x2;
    public static final byte I2CCMD_SET = 0x3;
    public static final byte I2CCMD_AUTO = 0x3;
    public static final byte I2CCMD_MANUAL = 0x3;
    
    private static final byte NULL = 0x0;

    private I2CDevice starry;
    private I2CDevice lights;
    
    private byte[] readBuffer = new byte[256];
    private byte[] writeBuffer = new byte[256];

    public boolean prepareCommand(byte deviceId, byte unityId, byte cmdId, boolean request, Parameters parms) 
    		throws UnsupportedBusNumberException, IOException, InterruptedException
    {
    	byte len = -1;
		byte[] command = new byte[256];
		int[][] dummyArOfAr2 = null;
		int[][] dummyArOfAr1 = null;
		int[] dummyAr = null;
		
		if (unityId == CTRLID_RGBSTRIPE)
		{
			dummyArOfAr2 = parms.getLights();
			dummyArOfAr1 = parms.getLightsTimers();
			dummyAr = parms.getLightsManual();
		}
		else if (unityId == CTRLID_STARRYSKY)
		{
			dummyArOfAr2 = parms.getStarry();
			dummyArOfAr1 = parms.getStarryTimers();
			dummyAr = parms.getStarryManual();
		}

		/* 
		 * Protocol for a command over I2C:
		 * byte  0: Arduino device I2C BUS address
		 * byte  1: msg len excluding the I2C BUS address byte
		 * byte  2: control unit id among those handled by the device
		 * byte  3: command id
		 * bytes 4 -- end: command parameters
		 */
		command[0] = deviceId;
		command[2] = unityId;
		command[3] = cmdId;
		switch(cmdId)
		{
		case LEDRGB_SET_MANUAL:
			len = 6;
			command[4] = (byte) dummyAr[Parameters.RED];
			command[5] = (byte) dummyAr[Parameters.GREEN];
			command[6] = (byte) dummyAr[Parameters.BLUE];
			break;
			
		case LEDRGB_SET_AUTO: 
			len = 21;
			command[4] = (byte) dummyArOfAr2[Parameters.RED][Parameters.MAX];
			command[5] = (byte) dummyArOfAr2[Parameters.GREEN][Parameters.MAX];
			command[6] = (byte) dummyArOfAr2[Parameters.BLUE][Parameters.MAX];
			command[7] = (byte) dummyArOfAr2[Parameters.RED][Parameters.MIN];
			command[8] = (byte) dummyArOfAr2[Parameters.GREEN][Parameters.MIN];
			command[9] = (byte) dummyArOfAr2[Parameters.BLUE][Parameters.MIN];
			command[10] = (byte) dummyArOfAr2[Parameters.RED][Parameters.SPEED];
			command[11] = (byte) dummyArOfAr2[Parameters.GREEN][Parameters.SPEED];
			command[12] = (byte) dummyArOfAr2[Parameters.BLUE][Parameters.SPEED];
			command[13] = (byte) dummyArOfAr2[Parameters.RED][Parameters.ACT];
			command[14] = (byte) dummyArOfAr2[Parameters.GREEN][Parameters.ACT];
			command[15] = (byte) dummyArOfAr2[Parameters.BLUE][Parameters.ACT];
			command[16] = (byte) dummyArOfAr1[Parameters.RED][Parameters.TMR_BYTE_0];
			command[17] = (byte) dummyArOfAr1[Parameters.RED][Parameters.TMR_BYTE_1];
			command[18] = (byte) dummyArOfAr1[Parameters.GREEN][Parameters.TMR_BYTE_0];
			command[19] = (byte) dummyArOfAr1[Parameters.GREEN][Parameters.TMR_BYTE_1];
			command[20] = (byte) dummyArOfAr1[Parameters.BLUE][Parameters.TMR_BYTE_0];
			command[21] = (byte) dummyArOfAr1[Parameters.BLUE][Parameters.TMR_BYTE_1];
			break;
			
		case LEDRGB_SET_BRIGHTNESS:
			len = 6;
			if (unityId == CTRLID_RGBSTRIPE)
			{
				dummyAr = parms.getLightsManual();
			}
			else if (unityId == CTRLID_STARRYSKY)
			{
				dummyAr = parms.getStarryManual();
			}
			command[4] = (byte) dummyAr[Parameters.RED];
			command[5] = (byte) dummyAr[Parameters.GREEN];
			command[6] = (byte) dummyAr[Parameters.BLUE];
			break;
			
		case LEDRGB_SWITCH_ON_OFF:
			len = 4;
			command[4] = (byte) (request ? 1 : 0);
			break;
			
		case LEDRGB_SET_SPEED:
			len = 6;
			if (unityId == CTRLID_RGBSTRIPE)
			{
				dummyArOfAr2 = parms.getLights();
			}
			else if (unityId == CTRLID_STARRYSKY)
			{
				dummyArOfAr2 = parms.getStarry();
			}
			command[4] = (byte) dummyArOfAr2[Parameters.RED][Parameters.SPEED];
			command[5] = (byte) dummyArOfAr2[Parameters.GREEN][Parameters.SPEED];
			command[6] = (byte) dummyArOfAr2[Parameters.BLUE][Parameters.SPEED];
			break;
			
		case LEDRGB_RESET_TIMERS:
			len = 3;
			break;
			
		case LEDRGB_SET_TIMERS:
			len = 9;
			if (unityId == CTRLID_RGBSTRIPE)
			{
				dummyArOfAr1 = parms.getLightsTimers();
			}
			else if (unityId == CTRLID_STARRYSKY)
			{
				dummyArOfAr1 = parms.getStarryTimers();
			}
			command[4] = (byte) dummyArOfAr1[Parameters.RED][Parameters.TMR_BYTE_0];
			command[5] = (byte) dummyArOfAr1[Parameters.RED][Parameters.TMR_BYTE_1];
			command[6] = (byte) dummyArOfAr1[Parameters.GREEN][Parameters.TMR_BYTE_0];
			command[7] = (byte) dummyArOfAr1[Parameters.GREEN][Parameters.TMR_BYTE_1];
			command[8] = (byte) dummyArOfAr1[Parameters.BLUE][Parameters.TMR_BYTE_0];
			command[9] = (byte) dummyArOfAr1[Parameters.BLUE][Parameters.TMR_BYTE_1];
			break;

		case LEDRGB_FADE_IN_OUT:
			len = 4;
			command[4] = (byte) (request ? 1 : 0);
			break;	
		}
		command[1] = len;
		
		String cmdStr = "";
		String sep = "";
		for(int i = 0; i <= command[1]; i++)
		{
			cmdStr += sep + (command[i] <0 ? command[i] + 256 : command[i]); 
			sep = " ";
		}
		logger.debug("Sending command: '" + cmdStr + "'");

		try {
			return sendCommand(command);
		}
		catch(Exception e)
		{
			return false;
		}
    }
    
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

    public I2CComm(boolean debug) throws UnsupportedBusNumberException, IOException, InterruptedException
    {
    	if (!debug)
    	{
	        I2CBus i2c = I2CFactory.getInstance(I2CBus.BUS_1);
	
	        starry = i2c.getDevice(I2C_LIGHTS_AND_STEAM);
	        lights = i2c.getDevice(I2C_WATER_AND_FANS);
    	}
    	else
    	{
	        starry = null;
	        lights = null;
    	}
    }
    
    public boolean sendCommand(byte[] cmd) throws UnsupportedBusNumberException, IOException, InterruptedException
    {
        I2CDevice ctrl = null;

		byte[] readBuffer = new byte[128];
		
		if (cmd[0] == CTRLID_STARRYSKY)
		{
			ctrl = starry;
		}
		else if (cmd[0] == CTRLID_RGBSTRIPE)
		{
			ctrl = lights;
		}

		System.out.println("writing a total of " + cmd[1] + " bytes.");
		try
		{
			ctrl.write(cmd, 1, cmd[1]);
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