package it.lsoft.steambath;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

import it.lsoft.steambath.Commons.TimerHandler;
import it.lsoft.steambath.Commons.VirtualKeyboard;

import javax.swing.JRadioButton;

public class MainWindow 
	extends JFrame 
	implements MouseListener, ItemListener 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JRadioButton rdbtnLightsAuto, rdbtnLightsManual, rdbtnStarryAuto, rdbtnStarryManual;
	private I2CComm i2c;
	private VirtualKeyboard keyb;
	
	/**
	 * Create the application.
	 * @throws InterruptedException 
	 * @throws IOException 
	 * @throws UnsupportedBusNumberException 
	 */
	public MainWindow(I2CComm i2c) throws UnsupportedBusNumberException, IOException, InterruptedException 
	{
		this.i2c = i2c;
        EventQueue.invokeLater(() -> {
            keyb = new VirtualKeyboard();
        });

		setUndecorated(true);
		initialize();
	}

	public VirtualKeyboard getKeyb()
	{
		return keyb;
	}
	
	/**
	 * Initialize the contents of the 
	 */
	private void initialize() 
	{
		setBounds(0, 0, 600, 1024);
		getContentPane().setFont(new Font("Arsenal", Font.PLAIN, 14));
		// setSize(new Dimension(600, 1024));
		setExtendedState(MAXIMIZED_BOTH);
		setBackground(Color.WHITE);
		// setAlwaysOnTop(true);
		setResizable(false);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(getClass().getResourceAsStream("/images/settings20x20.png"));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		JLabel settingsIcon = new JLabel(new ImageIcon(myPicture));
		settingsIcon.setBounds(550, 10, 20, 20);
		settingsIcon.addMouseListener(this);
		settingsIcon.setName("settings");
		getContentPane().add(settingsIcon);
		
		JLabel dateAndTime = new JLabel("");
		dateAndTime.setFont(new Font("Arsenal", Font.BOLD, 46));
		dateAndTime.setBounds(52, 217, 542, 63);
		getContentPane().add(dateAndTime);
		TimerHandler tm = new TimerHandler(dateAndTime);
		tm.start();
		
		JLabel lblNewLabel = new JLabel("Edwin Jarvis, here to serve you");
		lblNewLabel.setFont(new Font("Arsenal", Font.PLAIN, 14));
		lblNewLabel.setBounds(52, 25, 247, 15);
		lblNewLabel.addMouseListener(this);
		lblNewLabel.setName("exitApp");
		getContentPane().add(lblNewLabel);
		
		JToggleButton tglbtnStarrySky = new JToggleButton("Starry sky");
		tglbtnStarrySky.setFont(new Font("Arsenal", Font.BOLD, 18));
		tglbtnStarrySky.setBounds(52, 307, 146, 25);
		tglbtnStarrySky.addItemListener(this);
		tglbtnStarrySky.setName("starryCommand");
		getContentPane().add(tglbtnStarrySky);
		
		rdbtnStarryAuto = new JRadioButton("Auto");
		rdbtnStarryAuto.setSelected(true);
		rdbtnStarryAuto.setFont(new Font("Arsenal", Font.BOLD, 18));
		rdbtnStarryAuto.setBounds(219, 295, 149, 23);
		getContentPane().add(rdbtnStarryAuto);
		
		rdbtnStarryManual = new JRadioButton("Manual");
		rdbtnStarryManual.setFont(new Font("Arsenal", Font.BOLD, 18));
		rdbtnStarryManual.setBounds(219, 328, 149, 23);
		getContentPane().add(rdbtnStarryManual);
		
		ButtonGroup bgStarry = new ButtonGroup();    
		bgStarry.add(rdbtnStarryAuto);bgStarry.add(rdbtnStarryManual);    
		
		JToggleButton tglbtnCabinLights = new JToggleButton("Cabin lights");
		tglbtnCabinLights.setFont(new Font("Arsenal", Font.BOLD, 18));
		tglbtnCabinLights.setBounds(52, 414, 146, 25);
		tglbtnCabinLights.addItemListener(this);
		tglbtnCabinLights.setName("lightsCommand");
		getContentPane().add(tglbtnCabinLights);
		
		rdbtnLightsAuto = new JRadioButton("Auto");
		rdbtnLightsAuto.setSelected(true);
		rdbtnLightsAuto.setFont(new Font("Arsenal", Font.BOLD, 18));
		rdbtnLightsAuto.setBounds(219, 403, 149, 23);
		getContentPane().add(rdbtnLightsAuto);
		
		rdbtnLightsManual = new JRadioButton("Manual");
		rdbtnLightsManual.setFont(new Font("Arsenal", Font.BOLD, 18));
		rdbtnLightsManual.setBounds(219, 436, 149, 23);
		getContentPane().add(rdbtnLightsManual);

		ButtonGroup bgLights = new ButtonGroup();    
		bgLights.add(rdbtnLightsAuto);bgLights.add(rdbtnLightsManual);    
	}
	
	public JFrame getFrame()
	{
		return frame;
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		if (e.getSource().getClass().getName().compareTo("javax.swing.JLabel") == 0)
		{
			JLabel source = (JLabel)e.getSource();
			switch(source.getName())
			{
			case "settings":
				SteambathConfiguration window = new SteambathConfiguration(keyb);
				window.getFrame().setVisible(true);
				
				break;
			case "exitApp":
				dispose();
				System.exit(0);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent e)
	{
		byte[] command = new byte[256];
		
		if (e.getSource().getClass().getName().compareTo("javax.swing.JToggleButton") == 0)
		{
			JToggleButton source = (JToggleButton)e.getSource();
			if (source.getName().compareTo("starryCommand") == 0)
			{
				command[0] = I2CComm.I2C_STARRYSKY;
				if (rdbtnStarryManual.isSelected())
				{
					command[1] = 4;
					command[2] = I2CComm.I2CCMD_MANUAL;
					command[3] = 2;
					command[4] = (byte) (e.getStateChange() == ItemEvent.SELECTED ? 1 : 0);
				}
				else
				{
				 
				}
				try 
				{
					i2c.command(command, (byte) I2CComm.I2C_STARRYSKY);
				} 
				catch (UnsupportedBusNumberException | IOException | InterruptedException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if (source.getName().compareTo("lightsCommand") == 0)
			{
				if(e.getStateChange()==ItemEvent.SELECTED)
				{
					System.out.println("avrei acceso lights in " + 
									   (rdbtnStarryAuto.isSelected() ? " auto " : "manual ") + "mode");
				} 
				else if(e.getStateChange()==ItemEvent.DESELECTED)
				{
					System.out.println("avrei spento lights");
				}		
			}
		}
	}
}
