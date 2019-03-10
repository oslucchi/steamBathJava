package it.lsoft.steambath.Commons;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

public class TimerHandler extends Thread {
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
				e.printStackTrace();
			}
    		this.component.setText(df.format(new Date()));
    	}
    }
}
