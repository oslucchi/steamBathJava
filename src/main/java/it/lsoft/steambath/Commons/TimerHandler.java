package it.lsoft.steambath.Commons;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

import org.apache.log4j.Logger;

import it.lsoft.steambath.I2CComm;

public class TimerHandler extends Thread {
	final static Logger logger = Logger.getLogger(TimerHandler.class);

	JLabel component;
	SimpleDateFormat df = new SimpleDateFormat("EEE dd MMM HH:mm:ss");
	
	public TimerHandler(JLabel component)
	{
		this.component = component;
	}
	
    public void run()
    {
    	while(true)
    	{
    		try
    		{
				Thread.sleep(1000);
			}
    		catch (InterruptedException e)
    		{
    			logger.error(e);
			}
    		this.component.setText(df.format(new Date()));
    	}
    }
}
