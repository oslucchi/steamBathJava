package it.lsoft.steambath;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.log4j.Logger;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class SerialHandler {
	final static Logger logger = Logger.getLogger(SerialHandler.class);

    OutputStream out;
    public SerialHandler (String devicePath)
    {
    	try
    	{
	        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(devicePath);
	        if (portIdentifier.isCurrentlyOwned())
	        {
	            System.out.println("Error: Port is currently in use");
	        }
	        else
	        {
	        	logger.trace("got portIdentifier: " + portIdentifier.getName());
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
    		e.printStackTrace();
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
            String msgOut = "";
            int i = 0;
            logger.trace("Data available event received");
            try
            {
                i = in.read(buffer);
            }
            catch ( IOException e )
            {
                logger.error(e);
                System.exit(-1);
            }
            for(int a = 0 ; a < i; a++)
            	msgOut += String.format("%02X", buffer[a]) + " "; 
            logger.debug("Received dump: " + msgOut);
            logger.debug("Received dump - ascii: " + new String(buffer));            
        }
    }

    /** */
    public boolean serialWrite(byte[] cmd)
    {
        try
        {
        	logger.debug("Sending msg");
        	out.write(cmd, 1, cmd[1]);
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