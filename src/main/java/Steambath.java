import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;

import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

import it.lsoft.steambath.I2CComm;
import it.lsoft.steambath.MainWindow;
import it.lsoft.steambath.SteambathConfiguration;
import it.lsoft.steambath.Commons.VirtualKeyboard;
import it.lsoft.steambath.Commons.Visualizer;

public class Steambath {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		JFrame container = new JFrame();
		try {
			EventQueue.invokeLater(new Runnable() {
				// I2CComm i2c = new I2CComm();
				I2CComm i2c = null;
				public void run() {
					MainWindow mw = null;
					VirtualKeyboard vk = null;
					SteambathConfiguration conf = null;
					Visualizer v;
					try {
						conf = new SteambathConfiguration();
						mw = new MainWindow(i2c);
						v = new Visualizer(mw, conf, vk);
						conf.setVisualizer(v);
						mw.setVisualizer(v);
						mw.setVisible(true);
						container.add(mw);
						container.add(conf);
						container.setUndecorated(true);
						container.setBounds(1, 1, 598, 1022);
						container.setResizable(false);
						container.setFocusable(false);
						container.setVisible(true);
					} 
					catch (UnsupportedBusNumberException | IOException | InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
