package it.lsoft.steambath;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class SerialHandler {
    OutputStream out;
    public SerialHandler (String devicePath)
    {
    	try
    	{
	        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(devicePath);
	        if ( portIdentifier.isCurrentlyOwned())
	        {
	            System.out.println("Error: Port is currently in use");
	        }
	        else
	        {
	            CommPort commPort = portIdentifier.open(this.getClass().getName(),2000);
	            if (commPort instanceof SerialPort)
	            {
	                SerialPort serialPort = (SerialPort) commPort;
	                serialPort.setSerialPortParams(19200,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);
	                
	                InputStream in = serialPort.getInputStream();
	                serialPort.addEventListener(new SerialReader(in));
	                serialPort.notifyOnDataAvailable(true);
	                out = serialPort.getOutputStream();
	            }
	            else
	            {
	                System.out.println("Error: Only serial ports are handled by this example.");
	            }
	        }
    	}
    	catch(Exception e)
    	{
    		
    	}
    }
    
    /** */
    public static class SerialReader implements SerialPortEventListener 
    {
        private InputStream in;
        private byte[] buffer = new byte[1024];
        
        public SerialReader(InputStream in)
        {
            this.in = in;
        }
        
        public void serialEvent(SerialPortEvent arg0)
        {
            int data;
          
            try
            {
                int len = in.read();
                for(int i = 1; i < len; i++)
                {
                	data = in.read();
                    buffer[i - 1] = (byte) data;
                }
                System.out.print(new String(buffer, 0, len - 1));
            }
            catch ( IOException e )
            {
                e.printStackTrace();
                System.exit(-1);
            }             
        }
    }

    /** */
    public boolean serialWrite(byte[] cmd)
    {
        try
        {                
        	out.write(cmd, 0, cmd[0]);
        	return(true);
        }
        catch ( IOException e )
        {
            e.printStackTrace();
            System.exit(-1);
        }       
        return(false);
    }
}