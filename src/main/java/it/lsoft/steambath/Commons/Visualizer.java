package it.lsoft.steambath.Commons;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Visualizer {
	JPanel conf, sm;
	JFrame vk;
	
	public Visualizer(JPanel conf, JFrame vk, JPanel sm)
	{
		this.conf = conf;
		this.vk = vk;
		this.sm = sm;
	}
	
	public void visualize(String frameName)
	{
		conf.setVisible(false);
		sm.setVisible(false);
		switch(frameName)
		{
		case "sm":
			sm.setVisible(true);
			break;
		case "conf":
			conf.setVisible(true);
			break;
		case "vk":
			break;
		}
	}
	
	public Object getFrame(String frameName)
	{
		switch(frameName)
		{
		case "sm":
			return sm;

		case "conf":
			return conf;

		case "vk":
			return vk;
		}
		return null;
	}
}