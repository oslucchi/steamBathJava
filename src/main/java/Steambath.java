import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;

import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import it.lsoft.steambath.I2CComm;
import it.lsoft.steambath.MainWindow;
import it.lsoft.steambath.SteamBathManager;
import it.lsoft.steambath.SteambathConfiguration;
import it.lsoft.steambath.Commons.VirtualKeyboard;
import it.lsoft.steambath.Commons.Visualizer;

public class Steambath {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		JFrame container = new JFrame();
		NativeInterface.open();
		try {
			EventQueue.invokeLater(new Runnable() {
				// I2CComm i2c = new I2CComm();
				I2CComm i2c = null;
				public void run() {
					MainWindow mw = null;
					VirtualKeyboard vk = null;
					SteambathConfiguration conf = null;
					SteamBathManager sm = null;
					Visualizer v;
					try {
						i2c = new I2CComm(true);
//						mw = new MainWindow(i2c);
						conf = new SteambathConfiguration();
						sm = new SteamBathManager(i2c);
						
						v = new Visualizer(mw, conf, vk, sm);
						
//						mw.setVisualizer(v);
//						mw.setVisible(true);
//						container.add(mw);
						conf.setVisualizer(v);
						conf.setVisible(false);
						container.add(conf);
						sm.setVisualizer(v);
						sm.setVisible(true);
						container.add(sm);

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
		
		NativeInterface.runEventPump();
	}
}
