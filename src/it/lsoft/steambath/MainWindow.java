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
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

import it.lsoft.steambath.Commons.TimerHandler;

import javax.swing.JRadioButton;

public class MainWindow implements MouseListener, ItemListener {

	private JFrame frame;
	private JRadioButton rdbtnLightsAuto, rdbtnLightsManual, rdbtnStarryAuto, rdbtnStarryManual;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws InterruptedException 
	 * @throws IOException 
	 * @throws UnsupportedBusNumberException 
	 */
	public MainWindow() throws UnsupportedBusNumberException, IOException, InterruptedException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(1200, 0, 720, 1080);
		frame.getContentPane().setFont(new Font("Laksaman", Font.PLAIN, 14));
		frame.setSize(new Dimension(720, 1080));
		frame.setBackground(Color.WHITE);
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("images/settings20x20.png"));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		JLabel settingsIcon = new JLabel(new ImageIcon(myPicture));
		settingsIcon.setBounds(690, 10, 20, 20);
		settingsIcon.addMouseListener(this);
		settingsIcon.setName("settings");
		frame.getContentPane().add(settingsIcon);
		
		JLabel dateAndTime = new JLabel("");
		dateAndTime.setFont(new Font("Laksaman", Font.BOLD, 46));
		dateAndTime.setBounds(52, 217, 542, 63);
		frame.getContentPane().add(dateAndTime);
		TimerHandler tm = new TimerHandler(dateAndTime);
		tm.start();
		
		JLabel lblNewLabel = new JLabel("Edwin Jarvis, here to serve you");
		lblNewLabel.setFont(new Font("Laksaman", Font.PLAIN, 14));
		lblNewLabel.setBounds(52, 25, 247, 15);
		lblNewLabel.addMouseListener(this);
		lblNewLabel.setName("exitApp");
		frame.getContentPane().add(lblNewLabel);
		
		JToggleButton tglbtnStarrySky = new JToggleButton("Starry sky");
		tglbtnStarrySky.setFont(new Font("Laksaman", Font.BOLD, 18));
		tglbtnStarrySky.setBounds(52, 307, 146, 25);
		tglbtnStarrySky.addItemListener(this);
		tglbtnStarrySky.setName("starryCommand");
		frame.getContentPane().add(tglbtnStarrySky);
		
		rdbtnStarryAuto = new JRadioButton("Auto");
		rdbtnStarryAuto.setSelected(true);
		rdbtnStarryAuto.setFont(new Font("Laksaman", Font.BOLD, 18));
		rdbtnStarryAuto.setBounds(219, 295, 149, 23);
		frame.getContentPane().add(rdbtnStarryAuto);
		
		rdbtnStarryManual = new JRadioButton("Manual");
		rdbtnStarryManual.setFont(new Font("Laksaman", Font.BOLD, 18));
		rdbtnStarryManual.setBounds(219, 328, 149, 23);
		frame.getContentPane().add(rdbtnStarryManual);
		
		ButtonGroup bgStarry = new ButtonGroup();    
		bgStarry.add(rdbtnStarryAuto);bgStarry.add(rdbtnStarryManual);    
		
		JToggleButton tglbtnCabinLights = new JToggleButton("Cabin lights");
		tglbtnCabinLights.setFont(new Font("Laksaman", Font.BOLD, 18));
		tglbtnCabinLights.setBounds(52, 414, 146, 25);
		tglbtnCabinLights.addItemListener(this);
		tglbtnCabinLights.setName("lightsCommand");
		frame.getContentPane().add(tglbtnCabinLights);
		
		rdbtnLightsAuto = new JRadioButton("Auto");
		rdbtnLightsAuto.setSelected(true);
		rdbtnLightsAuto.setFont(new Font("Laksaman", Font.BOLD, 18));
		rdbtnLightsAuto.setBounds(219, 403, 149, 23);
		frame.getContentPane().add(rdbtnLightsAuto);
		
		rdbtnLightsManual = new JRadioButton("Manual");
		rdbtnLightsManual.setFont(new Font("Laksaman", Font.BOLD, 18));
		rdbtnLightsManual.setBounds(219, 436, 149, 23);
		frame.getContentPane().add(rdbtnLightsManual);

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
		System.out.println(e.getSource().getClass().getName());
		if (e.getSource().getClass().getName().compareTo("javax.swing.JLabel") == 0)
		{
			JLabel source = (JLabel)e.getSource();
			switch(source.getName())
			{
			case "settings":
				SteambathConfiguration window = new SteambathConfiguration();
				window.getFrame().setVisible(true);
				break;
			case "exitApp":
				frame.dispose();
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
	public void itemStateChanged(ItemEvent e) {
		System.out.println(e.getSource().getClass().getName());
		if (e.getSource().getClass().getName().compareTo("javax.swing.JToggleButton") == 0)
		{
			JToggleButton source = (JToggleButton)e.getSource();
			System.out.println(source.getName());
			if (source.getName().compareTo("starryCommand") == 0)
			{
				if(e.getStateChange()==ItemEvent.SELECTED)
				{
					System.out.println("avrei acceso starry in " + 
									   (rdbtnStarryAuto.isSelected() ? " auto " : "manual ") + "mode");
				} 
				else if(e.getStateChange()==ItemEvent.DESELECTED)
				{
					System.out.println("avrei spento starry");
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
