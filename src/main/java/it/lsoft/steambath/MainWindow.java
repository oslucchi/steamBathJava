package it.lsoft.steambath;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

import it.lsoft.steambath.Commons.Parameters;
import it.lsoft.steambath.Commons.TimerHandler;
import it.lsoft.steambath.Commons.VirtualKeyboard;
import it.lsoft.steambath.Commons.Visualizer;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainWindow 
	extends JPanel
	implements  MouseListener, ItemListener, FocusListener, ActionListener
{
	Parameters parms = Parameters.getInstance("/conf/config.txt");

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JRadioButton rdbtnLightsAuto, rdbtnLightsManual, rdbtnStarryAuto, rdbtnStarryManual;
	private I2CComm i2c;
	private Visualizer v;
	private JTextField starryManRedVal;
	private JTextField starryManGreenVal;
	private JTextField starryManBlueVal;
	private JTextField lightsManRedVal;
	private JTextField lightsManGreenVal;
	private JTextField lightsManBlueVal;
	private VirtualKeyboard keyb;
	private boolean valuesChanged = false;
	private int iniValue;
	
	/**
	 * Create the application.
	 * @throws InterruptedException 
	 * @throws IOException 
	 * @throws UnsupportedBusNumberException 
	 */
	public MainWindow(I2CComm i2c) throws UnsupportedBusNumberException, IOException, InterruptedException 
	{
		this.i2c = i2c;
		initialize();
	}

	public void setVisualizer(Visualizer v)
	{
		this.v = v;
	}
	
	/**
	 * Initialize the contents of the 
	 */
	private void initialize() 
	{
		setFont(new Font("Arsenal", Font.PLAIN, 14));
		setSize(600, 1024);
		setBackground(Color.WHITE);
		setLayout(null);
		
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
		add(settingsIcon);
		
		JLabel dateAndTime = new JLabel(".");
		dateAndTime.setFont(new Font("Arsenal", Font.ITALIC, 44));
		dateAndTime.setBounds(52, 210, 548, 73);
		add(dateAndTime);
		TimerHandler tm = new TimerHandler(dateAndTime);
		tm.start();
		
		JLabel lblNewLabel = new JLabel("Edwin Jarvis, here to serve you");
		lblNewLabel.setFont(new Font("Arsenal", Font.PLAIN, 14));
		lblNewLabel.setBounds(52, 25, 247, 15);
		lblNewLabel.addMouseListener(this);
		lblNewLabel.setName("exitApp");
		add(lblNewLabel);
		
		JToggleButton tglbtnStarrySky = new JToggleButton("Starry sky");
		tglbtnStarrySky.setForeground(Color.DARK_GRAY);
		tglbtnStarrySky.setBackground(Color.WHITE);
		tglbtnStarrySky.setFont(new Font("Arsenal", Font.PLAIN, 18));
		tglbtnStarrySky.setBounds(52, 307, 146, 25);
		tglbtnStarrySky.addItemListener(this);
		tglbtnStarrySky.setName("starryCommand");
		add(tglbtnStarrySky);
		
		JLabel lblStarryManRed = new JLabel("Red");
		lblStarryManRed.setFont(new Font("Arsenal", Font.PLAIN, 14));
		lblStarryManRed.setBounds(312, 323, 41, 33);
		add(lblStarryManRed);
		JLabel lblStarryManGreen = new JLabel("Green");
		lblStarryManGreen.setFont(new Font("Arsenal", Font.PLAIN, 14));
		lblStarryManGreen.setBounds(406, 323, 41, 33);
		add(lblStarryManGreen);
		JLabel lblStarryManBlue = new JLabel("Blue");
		lblStarryManBlue.setFont(new Font("Arsenal", Font.PLAIN, 14));
		lblStarryManBlue.setBounds(503, 323, 41, 33);
		add(lblStarryManBlue);
		starryManRedVal = new JTextField();
		starryManRedVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryManRedVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		starryManRedVal.setColumns(10);
		starryManRedVal.setBounds(346, 323, 48, 33);
		starryManRedVal.addActionListener(this);
		starryManRedVal.addFocusListener(this);
		starryManRedVal.setText(String.valueOf(parms.getStarryManual()[Parameters.RED]));
		add(starryManRedVal);
		
		starryManGreenVal = new JTextField();
		starryManGreenVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryManGreenVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		starryManGreenVal.setColumns(10);
		starryManGreenVal.setBounds(447, 323, 48, 33);
		starryManGreenVal.addActionListener(this);
		starryManGreenVal.addFocusListener(this);
		starryManGreenVal.setText(String.valueOf(parms.getStarryManual()[Parameters.GREEN]));
		add(starryManGreenVal);
		
		starryManBlueVal = new JTextField();
		starryManBlueVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryManBlueVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		starryManBlueVal.setColumns(10);
		starryManBlueVal.setBounds(540, 323, 48, 33);
		starryManBlueVal.addActionListener(this);
		starryManBlueVal.addFocusListener(this);
		starryManBlueVal.setText(String.valueOf(parms.getStarryManual()[Parameters.BLUE]));
		add(starryManBlueVal);
		
		rdbtnStarryAuto = new JRadioButton("Auto");
		rdbtnStarryAuto.setForeground(Color.DARK_GRAY);
		rdbtnStarryAuto.setBackground(Color.WHITE);
		rdbtnStarryAuto.setSelected(true);
		rdbtnStarryAuto.setFont(new Font("Arsenal", Font.PLAIN, 18));
		rdbtnStarryAuto.setBounds(219, 295, 149, 23);
		rdbtnStarryAuto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblStarryManRed.setVisible(false);
				lblStarryManGreen.setVisible(false);
				lblStarryManBlue.setVisible(false);
				starryManRedVal.setVisible(false);
				starryManGreenVal.setVisible(false);
				starryManBlueVal.setVisible(false);
				if (valuesChanged)
				{
					parms.save();
					valuesChanged = false;
				}
			}
		});
		add(rdbtnStarryAuto);
		
		rdbtnStarryManual = new JRadioButton("Manual");
		rdbtnStarryManual.setForeground(Color.DARK_GRAY);
		rdbtnStarryManual.setBackground(Color.WHITE);
		rdbtnStarryManual.setFont(new Font("Arsenal", Font.PLAIN, 18));
		rdbtnStarryManual.setBounds(219, 328, 87, 23);
		rdbtnStarryManual.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblStarryManRed.setVisible(true);
				lblStarryManGreen.setVisible(true);
				lblStarryManBlue.setVisible(true);
				starryManRedVal.setVisible(true);
				starryManGreenVal.setVisible(true);
				starryManBlueVal.setVisible(true);
			}
		});
		add(rdbtnStarryManual);
		
		ButtonGroup bgStarry = new ButtonGroup();    
		bgStarry.add(rdbtnStarryAuto);
		bgStarry.add(rdbtnStarryManual);
		
		JToggleButton tglbtnCabinLights = new JToggleButton("Cabin lights");
		tglbtnCabinLights.setForeground(Color.DARK_GRAY);
		tglbtnCabinLights.setBackground(Color.WHITE);
		tglbtnCabinLights.setFont(new Font("Arsenal", Font.PLAIN, 18));
		tglbtnCabinLights.setBounds(52, 414, 146, 25);
		tglbtnCabinLights.addItemListener(this);
		tglbtnCabinLights.setName("lightsCommand");
		add(tglbtnCabinLights);
		
		JLabel lblLightsManRed = new JLabel("Red");
		lblLightsManRed.setFont(new Font("Arsenal", Font.PLAIN, 14));
		lblLightsManRed.setBounds(312, 431, 41, 33);
		add(lblLightsManRed);
		JLabel lblLightsManGreen = new JLabel("Green");
		lblLightsManGreen.setFont(new Font("Arsenal", Font.PLAIN, 14));
		lblLightsManGreen.setBounds(406, 431, 41, 33);
		add(lblLightsManGreen);
		JLabel lblLightsManBlue = new JLabel("Blue");
		lblLightsManBlue.setFont(new Font("Arsenal", Font.PLAIN, 14));
		lblLightsManBlue.setBounds(503, 431, 41, 33);
		add(lblLightsManBlue);
		lightsManRedVal = new JTextField();
		lightsManRedVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsManRedVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lightsManRedVal.setColumns(10);
		lightsManRedVal.setBounds(346, 431, 48, 33);
		lightsManRedVal.addActionListener(this);
		lightsManRedVal.addFocusListener(this);
		lightsManRedVal.setText(String.valueOf(parms.getLightsManual()[Parameters.RED]));
		add(lightsManRedVal);

		lightsManGreenVal = new JTextField();
		lightsManGreenVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsManGreenVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lightsManGreenVal.setColumns(10);
		lightsManGreenVal.setBounds(447, 431, 48, 33);
		lightsManGreenVal.addActionListener(this);
		lightsManGreenVal.addFocusListener(this);
		lightsManGreenVal.setText(String.valueOf(parms.getLightsManual()[Parameters.GREEN]));
		add(lightsManGreenVal);

		lightsManBlueVal = new JTextField();
		lightsManBlueVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsManBlueVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lightsManBlueVal.setColumns(10);
		lightsManBlueVal.setBounds(540, 431, 48, 33);
		lightsManBlueVal.addActionListener(this);
		lightsManBlueVal.addFocusListener(this);
		lightsManBlueVal.setText(String.valueOf(parms.getLightsManual()[Parameters.BLUE]));
		add(lightsManBlueVal);

		rdbtnLightsAuto = new JRadioButton("Auto");
		rdbtnLightsAuto.setForeground(Color.DARK_GRAY);
		rdbtnLightsAuto.setBackground(Color.WHITE);
		rdbtnLightsAuto.setSelected(true);
		rdbtnLightsAuto.setFont(new Font("Arsenal", Font.PLAIN, 18));
		rdbtnLightsAuto.setBounds(219, 403, 149, 23);
		rdbtnLightsAuto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblLightsManRed.setVisible(false);
				lblLightsManGreen.setVisible(false);
				lblLightsManBlue.setVisible(false);
				lightsManRedVal.setVisible(false);
				lightsManGreenVal.setVisible(false);
				lightsManBlueVal.setVisible(false);
			}
		});
		add(rdbtnLightsAuto);
		
		rdbtnLightsManual = new JRadioButton("Manual");
		rdbtnLightsManual.setForeground(Color.DARK_GRAY);
		rdbtnLightsManual.setBackground(Color.WHITE);
		rdbtnLightsManual.setFont(new Font("Arsenal", Font.PLAIN, 18));
		rdbtnLightsManual.setBounds(219, 436, 87, 23);
		rdbtnLightsManual.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblLightsManRed.setVisible(true);
				lblLightsManGreen.setVisible(true);
				lblLightsManBlue.setVisible(true);
				lightsManRedVal.setVisible(true);
				lightsManGreenVal.setVisible(true);
				lightsManBlueVal.setVisible(true);
			}
		});
		add(rdbtnLightsManual);

		ButtonGroup bgLights = new ButtonGroup();    
		bgLights.add(rdbtnLightsAuto);
		bgLights.add(rdbtnLightsManual);

		lblStarryManRed.setVisible(false);
		lblStarryManGreen.setVisible(false);
		lblStarryManBlue.setVisible(false);
		starryManRedVal.setVisible(false);
		starryManGreenVal.setVisible(false);
		starryManBlueVal.setVisible(false);
		lblLightsManRed.setVisible(false);
		lblLightsManGreen.setVisible(false);
		lblLightsManBlue.setVisible(false);
		lightsManRedVal.setVisible(false);
		lightsManGreenVal.setVisible(false);
		lightsManBlueVal.setVisible(false);
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
				((JPanel) v.getFrame("mw")).setVisible(false);
				((JPanel) v.getFrame("conf")).setVisible(true);
				
				break;
			case "exitApp":
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
		Parameters parms = Parameters.getInstance("/conf/config.txt");
		
		if (e.getSource().getClass().getName().compareTo("javax.swing.JToggleButton") == 0)
		{
			JToggleButton source = (JToggleButton)e.getSource();
			if (source.getName().compareTo("starryCommand") == 0)
			{
				command[0] = I2CComm.I2C_STARRYSKY;
				if (rdbtnStarryManual.isSelected())
				{
					command[1] = 4;
					command[2] = I2CComm.CTRLID_STARRYSKY;
					command[3] = I2CComm.LEDRGB_SET_MANUAL;
					command[4] = (byte) (e.getStateChange() == ItemEvent.SELECTED ? 1 : 0);
				}
				else
				{
					command[1] = 4;
					command[2] = I2CComm.CTRLID_STARRYSKY;
					command[3] = I2CComm.LEDRGB_SET_AUTO;
					command[4] = (byte) parms.getLights()[Parameters.RED][Parameters.MAX];
					command[5] = (byte) parms.getLights()[Parameters.GREEN][Parameters.MAX];
					command[6] = (byte) parms.getLights()[Parameters.BLUE][Parameters.MAX];
					command[7] = (byte) parms.getLights()[Parameters.RED][Parameters.MIN];
					command[8] = (byte) parms.getLights()[Parameters.GREEN][Parameters.MIN];
					command[9] = (byte) parms.getLights()[Parameters.BLUE][Parameters.MIN];
					command[10] = (byte) parms.getLights()[Parameters.RED][Parameters.SPEED];
					command[11] = (byte) parms.getLights()[Parameters.GREEN][Parameters.SPEED];
					command[12] = (byte) parms.getLights()[Parameters.BLUE][Parameters.SPEED];
					command[13] = (byte) parms.getLights()[Parameters.RED][Parameters.SPEED];
					command[14] = (byte) parms.getLights()[Parameters.GREEN][Parameters.SPEED];
					command[15] = (byte) parms.getLights()[Parameters.BLUE][Parameters.SPEED];
					command[16] = (byte) parms.getLights()[Parameters.RED][Parameters.MIN];
					command[17] = (byte) parms.getLights()[Parameters.GREEN][Parameters.MIN];
					command[18] = (byte) parms.getLights()[Parameters.BLUE][Parameters.MIN];
					
					command[19] = (byte) parms.getLights()[Parameters.RED][Parameters.MIN];
					command[20] = (byte) parms.getLights()[Parameters.GREEN][Parameters.MIN];
					command[21] = (byte) parms.getLights()[Parameters.BLUE][Parameters.MIN];
					command[22] = (byte) parms.getLights()[Parameters.GREEN][Parameters.MIN];
					command[23] = (byte) parms.getLights()[Parameters.BLUE][Parameters.MIN];
					command[24] = (byte) parms.getLights()[Parameters.GREEN][Parameters.MIN];
				}
				try 
				{
					i2c.command(command);
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

	@Override
	public void actionPerformed(ActionEvent e)
	{
		JTextField source = (JTextField)e.getSource();
		if (Integer.parseInt(source.getText()) != iniValue)
		{
			valuesChanged = true;
		}
		this.requestFocus();
	}

	@Override
	public void focusGained(FocusEvent e) {
		JTextField source = (JTextField)e.getSource();
		keyb = new VirtualKeyboard();
		int x = source.getX();
		if (x + keyb.getSize().width > getSize().getWidth())
		{
			x = (int) (getSize().getWidth() - keyb.getSize().width  - 1);
		}
		int y = source.getY() + source.getSize().height;
		if (y > getSize().getHeight())
		{
			y = (int) (source.getY() - keyb.getSize().height - 1);
		}
		keyb.setBounds(x, y, keyb.getSize().width, keyb.getSize().height);
		keyb.toFront();
		keyb.setVisible(true);

		source.selectAll();
		iniValue = Integer.parseInt(source.getText());
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (keyb != null)
		{
			keyb.setVisible(true);
			keyb.dispose();
		}
	}
}
