package it.lsoft.steambath.Commons;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Visualizer {
	JPanel mw, conf, sm;
	JFrame vk;
	
	public Visualizer(JPanel mw, JPanel conf, JFrame vk, JPanel sm)
	{
		this.mw = mw;
		this.conf = conf;
		this.vk = vk;
		this.sm = sm;
	}
	
	public void visualize(String frameName)
	{
		mw.setVisible(false);
		conf.setVisible(false);
		sm.setVisible(false);
		// vk.setVisible(false);
		// vk.toFront();
		switch(frameName)
		{
		case "mw":
			mw.setVisible(true);
			break;
		case "sm":
			sm.setVisible(true);
			break;
		case "conf":
			conf.setVisible(true);
			break;
		case "vk":
			// vk.setVisible(true);
			// vk.toFront();
			break;
		}
	}
	
	public Object getFrame(String frameName)
	{
		switch(frameName)
		{
		case "mw":
			return mw;

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

