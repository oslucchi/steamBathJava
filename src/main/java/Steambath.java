import java.awt.EventQueue;
import java.io.IOException;

import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

import it.lsoft.steambath.I2CComm;
import it.lsoft.steambath.MainWindow;

public class Steambath {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			I2CComm i2c = null;
			public void run() {
				MainWindow w = null;
				try {
					w = new MainWindow(i2c);
					w.setVisible(true);
				} catch (UnsupportedBusNumberException | IOException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
