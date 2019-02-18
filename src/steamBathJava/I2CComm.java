package steamBathJava;


import java.io.IOException;

import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

public class I2CComm {
    public static final int PRO_MINI_1 = 0;
    public static final int PRO_MINI_2 = 1;



    public static final byte I2CCMD_ACK = (byte)0xFF;
    public static final byte I2CCMD_MASTER_START = 0x1;
    public static final byte I2CCMD_GET = 0x2;
    public static final byte I2CCMD_SET = 0x3;
    
    public static final int I2C_ADDR_BUS = 0;
    public static final int I2C_ADDR_STARRYSKY_RED = 1;
    public static final int I2C_ADDR_STARRYSKY_GREEN = 2;
    public static final int I2C_ADDR_STARRYSKY_BLUE = 3;
    public static final int I2C_ADDR_LIGHTSTRIPE_RED = 4;
    public static final int I2C_ADDR_LIGHTSTRIPE_GREEN = 5;
    public static final int I2C_ADDR_LIGHTSTRIPE_BLUE = 6;
    public static final int I2C_ADDR_HUMIDITY_AND_TEMP = 7;
    public static final int I2C_ADDR_SG_TEMP = 8;
    public static final int I2C_ADDR_SG = 9;
    
    public static final int I2C_ADDR_WATER_IN_A = 1; 
    public static final int I2C_ADDR_WATER_IN_B = 2;
    public static final int I2C_ADDR_WATER_OUT_A = 3;
    public static final int I2C_ADDR_WATER_OUT_B = 4;
    public static final int I2C_ADDR_WATER_RINSE = 5;
    public static final int I2C_ADDR_OVERFLOW = 6;
    public static final int I2C_ADDR_UNDERFLOW = 7;
    public static final int I2C_ADDR_RINSE_PUMP = 8;
    public static final int I2C_ADDR_RINSE_FAN = 8;
    
    public static final byte[][] devAddresses = 
    	new byte[][] {
			{
				0x07, // BUS Address 
				0x01, // starry sky RED
				0x02, // starry sky GREEN
				0x03, // starry sky BLUE
				0x04, // RGB light stripe RED 
				0x05, // RGB light stripe GREEN
				0x06, // RGB light stripeBLUE
				0x07, // humidity/temperature sensor dht22
				0x08, // temperature sensor steam generator
				0x09, // steam generator on/off
				0x0A  //spare 
			},	
			{
				0x08, // BUS Address
				0x01, // valve water IN A 
				0x02, // valve water IN B
				0x03, // valve water OUT A
				0x04, // valve water OUT B
				0x05, // valve water rinse ON
				0x06, // overflow 
				0x07, // underflow 
				0x08, // rinse pump ON
				0x09, // heater ON 
				0x0A  // steam evacuation fan ON
			}	
    	};
    
    private static final byte NULL = 0x0;

    private I2CDevice proMini1;
    private I2CDevice proMini2;
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
	    	proMini1.write(writeBuffer, 0, 1);
	    	Thread.sleep(100);
	    	proMini1.read(readBuffer, 0, 2);
	    	if (readBuffer[1] != I2CCMD_ACK)
	    	{
	    		// TODO: gestire errore
	    		return;
	    	}
	    	System.out.printf("device %d - received %d\n", devAddresses[0][0], (int) readBuffer[1]);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}

    	memset(readBuffer, readBuffer.length, NULL);
    	try
    	{
	    	proMini2.write(writeBuffer, 0, 1);
	    	Thread.sleep(100);
	    	proMini2.read(readBuffer, 0, 2);
	    	if (readBuffer[1] != I2CCMD_ACK)
	    	{
	    		// TODO: gestire errore
	    		return;
	    	}
	    	System.out.printf("device %d - received %d\n", devAddresses[1][0], (int) readBuffer[1]);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }

    public I2CComm() throws UnsupportedBusNumberException, IOException, InterruptedException
    {
        I2CBus i2c = I2CFactory.getInstance(I2CBus.BUS_1);

        proMini1 = i2c.getDevice(devAddresses[PRO_MINI_1][I2C_ADDR_BUS]);
        proMini2 = i2c.getDevice(devAddresses[PRO_MINI_2][I2C_ADDR_BUS]);
    }
    
    
    public byte[] getControllerStatus(int controllerIdx) throws IOException, InterruptedException
    {
    	I2CDevice dummy = (controllerIdx == PRO_MINI_1 ? proMini1 : proMini2);
    	
    	memset(writeBuffer, writeBuffer.length, NULL);
    	writeBuffer[0] = I2CCMD_GET;
    	writeBuffer[1] = 4;
    	writeBuffer[2] = I2C_ADDR_STARRYSKY_GREEN;
    	writeBuffer[3] = I2C_ADDR_LIGHTSTRIPE_RED;
    	writeBuffer[4] = I2C_ADDR_LIGHTSTRIPE_BLUE;
    	writeBuffer[5] = I2C_ADDR_SG_TEMP;
//    	writeBuffer[2] = I2C_ADDR_STARRYSKY_RED;
//    	writeBuffer[3] = I2C_ADDR_STARRYSKY_GREEN;
//    	writeBuffer[4] = I2C_ADDR_STARRYSKY_BLUE;
//    	writeBuffer[5] = I2C_ADDR_LIGHTSTRIPE_RED;
//    	writeBuffer[6] = I2C_ADDR_LIGHTSTRIPE_GREEN;
//    	writeBuffer[7] = I2C_ADDR_LIGHTSTRIPE_BLUE;
//    	writeBuffer[8] = I2C_ADDR_HUMIDITY_AND_TEMP;
//    	writeBuffer[9] = I2C_ADDR_SG_TEMP;
//    	writeBuffer[10] = I2C_ADDR_SG;
    	dummy.write(writeBuffer, 0, writeBuffer[1] + 2);

    	Thread.sleep(500);
    	memset(readBuffer, readBuffer.length, NULL);
    	int bytesRead = dummy.read(readBuffer, 0, readBuffer.length);
		System.out.printf("device %d - read %d - message len returned is %d\n", 
					devAddresses[controllerIdx][0],
					bytesRead,
					(int) readBuffer[0]);
    	// dummy.read(readBuffer, 1, (int) readBuffer[0]);
    	for(int i = 0; i < readBuffer[0]; i++)
    	{
    		System.out.printf("%d ", readBuffer[i + 1]);
    	}
    	System.out.println();
    	return readBuffer;   	
    }

    public byte[] getDeviceStatus(int controllerIdx, byte deviceIdx) throws IOException, InterruptedException
    {
    	I2CDevice dummy = (controllerIdx == 1 ? proMini1 : proMini2);
    	
    	memset(writeBuffer, writeBuffer.length, NULL);
    	writeBuffer[0] = I2CCMD_GET;
    	writeBuffer[1] = 1;
    	writeBuffer[2] = deviceIdx;
    	dummy.write(writeBuffer, 0, 3);

    	Thread.sleep(500);
    	memset(readBuffer, readBuffer.length, NULL);
    	dummy.read(readBuffer, 0, 1);
    	dummy.read(readBuffer, 1, readBuffer[0]);

    	return readBuffer;   	
    }

    public byte[] setDeviceValue(int controllerIdx, byte deviceIdx, byte value) throws IOException, InterruptedException
    {
    	I2CDevice dummy = (controllerIdx == 1 ? proMini1 : proMini2);
    	
    	memset(writeBuffer, writeBuffer.length, NULL);
    	writeBuffer[0] = I2CCMD_GET;
    	writeBuffer[1] = 2;
    	writeBuffer[2] = deviceIdx;
    	writeBuffer[3] = value;
    	dummy.write(writeBuffer, 0, 4);

    	Thread.sleep(500);
    	memset(readBuffer, readBuffer.length, NULL);
    	dummy.read(readBuffer, 0, 1);
    	dummy.read(readBuffer, 1, readBuffer[0]);

    	return readBuffer;   	
    }
}