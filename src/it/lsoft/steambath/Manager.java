package it.lsoft.steambath;

import java.io.IOException;

import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;
//import javafx.application.Platform;
//import javafx.embed.swing.JFXPanel;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.paint.Color;
//import javafx.scene.text.Font;
//import javafx.scene.text.Text;
//import javax.swing.JFrame;
//import javax.swing.SwingUtilities;

public class Manager {
	I2CComm communicator;
	
	public Manager() throws UnsupportedBusNumberException, IOException, InterruptedException 
	{
		byte[] buffer = new byte[1024];
		
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                initAndShowGUI();
//            }
//        });
		
		communicator = new I2CComm();
		
		try {
			communicator.alertDeviceOnStart();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			buffer = communicator.getControllerStatus(I2CComm.PRO_MINI_1);
			for(int i = 1; i < buffer[0]; i = i + 2)
			{
				System.out.printf("device %d - value %d\n", buffer[i], buffer[i + 1]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			buffer = communicator.getControllerStatus(I2CComm.PRO_MINI_2);
			for(int i = 1; i < buffer[0]; i = i + 2)
			{
				System.out.printf("device %d - value %d\n", buffer[i], buffer[i + 1]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


//    private static void initAndShowGUI() {
//        // This method is invoked on the EDT thread
//        JFrame frame = new JFrame("Swing and JavaFX");
//        final JFXPanel fxPanel = new JFXPanel();
//        frame.add(fxPanel);
//        frame.setSize(300, 200);
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        Platform.runLater(new Runnable() {
//            public void run() {
//                initFX(fxPanel);
//            }
//       });
//    }
//
//    private static void initFX(JFXPanel fxPanel) {
//        // This method is invoked on the JavaFX thread
//        Scene scene = createScene();
//        fxPanel.setScene(scene);
//    }
//
//    private static Scene createScene() {
//        Group  root  =  new  Group();
//        Scene  scene  =  new  Scene(root, Color.ALICEBLUE);
//        Text  text  =  new  Text();
//        
//        text.setX(40);
//        text.setY(100);
//        text.setFont(new Font(25));
//        text.setText("Welcome JavaFX!");
//
//        root.getChildren().add(text);
//
//        return (scene);
//    }
	    
}
