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

// import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import it.lsoft.steambath.Commons.Parameters;
import it.lsoft.steambath.Commons.TimerHandler;
import it.lsoft.steambath.Commons.VirtualKeyboard;
import it.lsoft.steambath.Commons.Visualizer;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.apache.log4j.Logger;

public class SteamBathManager 
	extends JPanel
	implements  MouseListener, ItemListener, FocusListener, ActionListener
{
	final static Logger logger = Logger.getLogger(SteamBathManager.class);
	Parameters parms = Parameters.getInstance("/conf/config.txt");

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JRadioButton rdbtnLightsAuto, rdbtnLightsManual, rdbtnStarryAuto, rdbtnStarryManual;
	private JToggleButton starrySaveManual, lightsSaveManual;
	private JToggleButton tglbtnCabinLights, tglbtnStarrySky;
	private JToggleButton tglFade;
	private I2CComm i2c;
	private Visualizer v;
	private JTextField starryManRedVal;
	private JTextField starryManGreenVal;
	private JTextField starryManBlueVal;
	private JTextField lightsManRedVal;
	private JTextField lightsManGreenVal;
	private JTextField lightsManBlueVal;
//	private JWebBrowser wb;
	private VirtualKeyboard keyb;
	private boolean valuesChanged = false;
	private int iniValue;
	private byte[] request = new byte[4];
	
	/**
	 * Create the application.
	 * @throws InterruptedException 
	 * @throws IOException 
	 * @throws UnsupportedBusNumberException 
	 */
	public SteamBathManager(I2CComm i2c) throws UnsupportedBusNumberException, IOException, InterruptedException 
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
		dateAndTime.setBounds(22, 186, 548, 73);
		add(dateAndTime);
		TimerHandler tm = new TimerHandler(dateAndTime);
		tm.start();
		
		JLabel lblNewLabel = new JLabel("Edwin Jarvis, here to serve you");
		lblNewLabel.setFont(new Font("Arsenal", Font.PLAIN, 14));
		lblNewLabel.setBounds(52, 25, 247, 15);
		lblNewLabel.addMouseListener(this);
		lblNewLabel.setName("exitApp");
		add(lblNewLabel);

		tglFade = new JToggleButton("Fade");
		tglFade.setName("fadeLights");
		tglFade.setForeground(Color.DARK_GRAY);
		tglFade.setFont(new Font("Dialog", Font.PLAIN, 18));
		tglFade.setBackground(Color.WHITE);
		tglFade.setBounds(32, 536, 146, 48);
		tglFade.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try 
				{
					if (tglFade.isSelected())
					{
						request[0] = 1;
						request[1] = 2;
						i2c.prepareCommand(I2CComm.I2C_LIGHTS_AND_STEAM, I2CComm.CTRLID_RGBSTRIPE, 
										I2CComm.LEDRGB_FADE_IN_OUT, request, parms);
						request[1] = 1;
						i2c.prepareCommand(I2CComm.I2C_LIGHTS_AND_STEAM, I2CComm.CTRLID_STARRYSKY, 
										I2CComm.LEDRGB_FADE_IN_OUT, request, parms);
					}
					else
					{
						request[0] = 0;
						request[1] = 0;
						i2c.prepareCommand(I2CComm.I2C_LIGHTS_AND_STEAM, I2CComm.CTRLID_RGBSTRIPE, 
										I2CComm.LEDRGB_FADE_IN_OUT, request, parms);
						request[1] = 0;
						i2c.prepareCommand(I2CComm.I2C_LIGHTS_AND_STEAM, I2CComm.CTRLID_STARRYSKY, 
										I2CComm.LEDRGB_FADE_IN_OUT, request, parms);
					}
				} 
				catch (UnsupportedBusNumberException | IOException | InterruptedException e1) 
				{
					// TODO implement logger
					e1.printStackTrace();
				}
			}
		});
		add(tglFade);

		tglbtnStarrySky = new JToggleButton("Starry sky");
		tglbtnStarrySky.setForeground(Color.DARK_GRAY);
		tglbtnStarrySky.setBackground(Color.WHITE);
		tglbtnStarrySky.setFont(new Font("Arsenal", Font.PLAIN, 18));
		tglbtnStarrySky.setBounds(32, 295, 146, 48);
		tglbtnStarrySky.addItemListener(this);
		tglbtnStarrySky.setName("starryCommand");
		add(tglbtnStarrySky);
		
		JLabel lblStarryManRed = new JLabel("Red");
		lblStarryManRed.setFont(new Font("Arsenal", Font.PLAIN, 14));
		lblStarryManRed.setBounds(282, 284, 41, 33);
		add(lblStarryManRed);
		JLabel lblStarryManGreen = new JLabel("Green");
		lblStarryManGreen.setFont(new Font("Arsenal", Font.PLAIN, 14));
		lblStarryManGreen.setBounds(376, 284, 41, 33);
		add(lblStarryManGreen);
		JLabel lblStarryManBlue = new JLabel("Blue");
		lblStarryManBlue.setFont(new Font("Arsenal", Font.PLAIN, 14));
		lblStarryManBlue.setBounds(473, 284, 41, 33);
		add(lblStarryManBlue);
		starryManRedVal = new JTextField();
		starryManRedVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryManRedVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		starryManRedVal.setColumns(10);
		starryManRedVal.setBounds(316, 284, 48, 33);
		starryManRedVal.addActionListener(this);
		starryManRedVal.addFocusListener(this);
		starryManRedVal.setText(String.valueOf(parms.getStarryManual()[Parameters.RED]));
		add(starryManRedVal);
		
		starryManGreenVal = new JTextField();
		starryManGreenVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryManGreenVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		starryManGreenVal.setColumns(10);
		starryManGreenVal.setBounds(417, 284, 48, 33);
		starryManGreenVal.addActionListener(this);
		starryManGreenVal.addFocusListener(this);
		starryManGreenVal.setText(String.valueOf(parms.getStarryManual()[Parameters.GREEN]));
		add(starryManGreenVal);
		
		starryManBlueVal = new JTextField();
		starryManBlueVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryManBlueVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		starryManBlueVal.setColumns(10);
		starryManBlueVal.setBounds(510, 284, 48, 33);
		starryManBlueVal.addActionListener(this);
		starryManBlueVal.addFocusListener(this);
		starryManBlueVal.setText(String.valueOf(parms.getStarryManual()[Parameters.BLUE]));
		add(starryManBlueVal);

		starrySaveManual = new JToggleButton("Save");
		starrySaveManual.setName("starrySaveManual");
		starrySaveManual.setForeground(Color.DARK_GRAY);
		starrySaveManual.setFont(new Font("Arsenal", Font.PLAIN, 18));
		starrySaveManual.setBackground(Color.WHITE);
		starrySaveManual.setBounds(375, 329, 109, 25);
		starrySaveManual.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnStarryManual.isSelected())
				{
					parms.setStarryManual(Parameters.RED, Integer.valueOf(starryManRedVal.getText()));
					parms.setStarryManual(Parameters.GREEN, Integer.valueOf(starryManGreenVal.getText()));
					parms.setStarryManual(Parameters.BLUE, Integer.valueOf(starryManBlueVal.getText()));
					parms.save();
					starrySaveManual.setSelected(false);
					if (tglbtnStarrySky.isSelected())
					{
						try {
							request[0] = 1;
							i2c.prepareCommand(I2CComm.I2C_LIGHTS_AND_STEAM, I2CComm.CTRLID_STARRYSKY, 
											  I2CComm.LEDRGB_SET_BRIGHTNESS, request, parms);
						}
						catch(UnsupportedBusNumberException | IOException | InterruptedException e1)
						{
							e1.printStackTrace();
						}
					}
				}
			}
		});
		add(starrySaveManual);
		
		rdbtnStarryAuto = new JRadioButton("Auto");
		rdbtnStarryAuto.setForeground(Color.DARK_GRAY);
		rdbtnStarryAuto.setBackground(Color.WHITE);
		rdbtnStarryAuto.setSelected(true);
		rdbtnStarryAuto.setFont(new Font("Arsenal", Font.PLAIN, 18));
		rdbtnStarryAuto.setBounds(189, 291, 149, 23);
		rdbtnStarryAuto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblStarryManRed.setVisible(false);
				lblStarryManGreen.setVisible(false);
				lblStarryManBlue.setVisible(false);
				starryManRedVal.setVisible(false);
				starryManGreenVal.setVisible(false);
				starryManBlueVal.setVisible(false);
				starrySaveManual.setVisible(false);
				if (valuesChanged)
				{
					parms.save();
					valuesChanged = false;
				}
				if (tglbtnStarrySky.isSelected())
				{
					try 
					{
						request[0] = 1;
						i2c.prepareCommand(I2CComm.I2C_LIGHTS_AND_STEAM, I2CComm.CTRLID_STARRYSKY, 
								I2CComm.LEDRGB_SET_TIMERS, request, parms);
						i2c.prepareCommand(I2CComm.I2C_LIGHTS_AND_STEAM, I2CComm.CTRLID_STARRYSKY, 
								I2CComm.LEDRGB_SET_AUTO, request, parms);
					}
					catch (UnsupportedBusNumberException | IOException | InterruptedException e1) 
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		add(rdbtnStarryAuto);
		
		rdbtnStarryManual = new JRadioButton("Manual");
		rdbtnStarryManual.setForeground(Color.DARK_GRAY);
		rdbtnStarryManual.setBackground(Color.WHITE);
		rdbtnStarryManual.setFont(new Font("Arsenal", Font.PLAIN, 18));
		rdbtnStarryManual.setBounds(189, 325, 87, 23);
		rdbtnStarryManual.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblStarryManRed.setVisible(true);
				lblStarryManGreen.setVisible(true);
				lblStarryManBlue.setVisible(true);
				starryManRedVal.setVisible(true);
				starryManGreenVal.setVisible(true);
				starryManBlueVal.setVisible(true);
				starrySaveManual.setVisible(true);
				if (tglbtnStarrySky.isSelected())
				{
					try 
					{
						request[0] = 1;
						i2c.prepareCommand(I2CComm.I2C_LIGHTS_AND_STEAM, I2CComm.CTRLID_STARRYSKY, 
								I2CComm.LEDRGB_SET_MANUAL, request, parms);	
					}
					catch (UnsupportedBusNumberException | IOException | InterruptedException e1) 
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		add(rdbtnStarryManual);
		
		ButtonGroup bgStarry = new ButtonGroup();    
		bgStarry.add(rdbtnStarryAuto);
		bgStarry.add(rdbtnStarryManual);
		
		tglbtnCabinLights = new JToggleButton("Cabin lights");
		tglbtnCabinLights.setForeground(Color.DARK_GRAY);
		tglbtnCabinLights.setBackground(Color.WHITE);
		tglbtnCabinLights.setFont(new Font("Arsenal", Font.PLAIN, 18));
		tglbtnCabinLights.setBounds(32, 403, 146, 48);
		tglbtnCabinLights.addItemListener(this);
		tglbtnCabinLights.setName("lightsCommand");
		add(tglbtnCabinLights);
		
		JLabel lblLightsManRed = new JLabel("Red");
		lblLightsManRed.setFont(new Font("Arsenal", Font.PLAIN, 14));
		lblLightsManRed.setBounds(282, 403, 41, 33);
		add(lblLightsManRed);
		JLabel lblLightsManGreen = new JLabel("Green");
		lblLightsManGreen.setFont(new Font("Arsenal", Font.PLAIN, 14));
		lblLightsManGreen.setBounds(376, 403, 41, 33);
		add(lblLightsManGreen);
		JLabel lblLightsManBlue = new JLabel("Blue");
		lblLightsManBlue.setFont(new Font("Arsenal", Font.PLAIN, 14));
		lblLightsManBlue.setBounds(473, 403, 41, 33);
		add(lblLightsManBlue);
		lightsManRedVal = new JTextField();
		lightsManRedVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsManRedVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lightsManRedVal.setColumns(10);
		lightsManRedVal.setBounds(316, 403, 48, 33);
		lightsManRedVal.addActionListener(this);
		lightsManRedVal.addFocusListener(this);
		lightsManRedVal.setText(String.valueOf(parms.getLightsManual()[Parameters.RED]));
		add(lightsManRedVal);

		lightsManGreenVal = new JTextField();
		lightsManGreenVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsManGreenVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lightsManGreenVal.setColumns(10);
		lightsManGreenVal.setBounds(417, 403, 48, 33);
		lightsManGreenVal.addActionListener(this);
		lightsManGreenVal.addFocusListener(this);
		lightsManGreenVal.setText(String.valueOf(parms.getLightsManual()[Parameters.GREEN]));
		add(lightsManGreenVal);

		lightsManBlueVal = new JTextField();
		lightsManBlueVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsManBlueVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lightsManBlueVal.setColumns(10);
		lightsManBlueVal.setBounds(510, 403, 48, 33);
		lightsManBlueVal.addActionListener(this);
		lightsManBlueVal.addFocusListener(this);
		lightsManBlueVal.setText(String.valueOf(parms.getLightsManual()[Parameters.BLUE]));
		add(lightsManBlueVal);
		
		lightsSaveManual = new JToggleButton("Save");
		lightsSaveManual.setName("lightsSaveManual");
		lightsSaveManual.setForeground(Color.DARK_GRAY);
		lightsSaveManual.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lightsSaveManual.setBackground(Color.WHITE);
		lightsSaveManual.setBounds(375, 448, 109, 25);
		lightsSaveManual.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnLightsManual.isSelected())
				{
					parms.setLightsManual(Parameters.RED, Integer.valueOf(lightsManRedVal.getText()));
					parms.setLightsManual(Parameters.GREEN, Integer.valueOf(lightsManGreenVal.getText()));
					parms.setLightsManual(Parameters.BLUE, Integer.valueOf(lightsManBlueVal.getText()));
					parms.save();
					lightsSaveManual.setSelected(false);
					if (tglbtnCabinLights.isSelected())
					{
						try {
							request[0] = 1;
							i2c.prepareCommand(I2CComm.I2C_LIGHTS_AND_STEAM, I2CComm.CTRLID_RGBSTRIPE, 
											  I2CComm.LEDRGB_SET_BRIGHTNESS, request, parms);
						}
						catch(UnsupportedBusNumberException | IOException | InterruptedException e1)
						{
							e1.printStackTrace();
						}
					}
				}
			}
		});
		add(lightsSaveManual);

		rdbtnLightsAuto = new JRadioButton("Auto");
		rdbtnLightsAuto.setForeground(Color.DARK_GRAY);
		rdbtnLightsAuto.setBackground(Color.WHITE);
		rdbtnLightsAuto.setSelected(true);
		rdbtnLightsAuto.setFont(new Font("Arsenal", Font.PLAIN, 18));
		rdbtnLightsAuto.setBounds(189, 403, 149, 23);
		rdbtnLightsAuto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblLightsManRed.setVisible(false);
				lblLightsManGreen.setVisible(false);
				lblLightsManBlue.setVisible(false);
				lightsManRedVal.setVisible(false);
				lightsManGreenVal.setVisible(false);
				lightsManBlueVal.setVisible(false);
				lightsSaveManual.setVisible(false);
				if (valuesChanged)
				{
					parms.save();
					valuesChanged = false;
				}
				if (tglbtnCabinLights.isSelected())
				{
					try 
					{
						request[0] = 1;
						i2c.prepareCommand(I2CComm.I2C_LIGHTS_AND_STEAM, I2CComm.CTRLID_RGBSTRIPE, 
								I2CComm.LEDRGB_SET_TIMERS, request, parms);
						i2c.prepareCommand(I2CComm.I2C_LIGHTS_AND_STEAM, I2CComm.CTRLID_RGBSTRIPE, 
								I2CComm.LEDRGB_SET_AUTO, request, parms);
					}
					catch (UnsupportedBusNumberException | IOException | InterruptedException e1) 
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		add(rdbtnLightsAuto);
		
		rdbtnLightsManual = new JRadioButton("Manual");
		rdbtnLightsManual.setForeground(Color.DARK_GRAY);
		rdbtnLightsManual.setBackground(Color.WHITE);
		rdbtnLightsManual.setFont(new Font("Arsenal", Font.PLAIN, 18));
		rdbtnLightsManual.setBounds(189, 436, 87, 23);
		rdbtnLightsManual.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblLightsManRed.setVisible(true);
				lblLightsManGreen.setVisible(true);
				lblLightsManBlue.setVisible(true);
				lightsManRedVal.setVisible(true);
				lightsManGreenVal.setVisible(true);
				lightsManBlueVal.setVisible(true);
				lightsSaveManual.setVisible(true);
				if (tglbtnCabinLights.isSelected())
				{
					try 
					{
						request[0] = 1;
						i2c.prepareCommand(I2CComm.I2C_LIGHTS_AND_STEAM, I2CComm.CTRLID_RGBSTRIPE, 
								I2CComm.LEDRGB_SET_MANUAL, request, parms);	
					}
					catch (UnsupportedBusNumberException | IOException | InterruptedException e1) 
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
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
		starrySaveManual.setVisible(false);
		lightsSaveManual.setVisible(false);
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
				((JPanel) v.getFrame("sm")).setVisible(false);
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
		logger.trace("Entering itemStateCHanged");
		boolean request = false;
		if ((e.getSource().getClass().getName().compareTo("javax.swing.JToggleButton") == 0) && !tglFade.isSelected())		
		{
			if(e.getStateChange()==ItemEvent.SELECTED)
			{
				request = true;
			} 
			else if(e.getStateChange()==ItemEvent.DESELECTED)
			{
				request = false;
			}		
			JToggleButton source = (JToggleButton)e.getSource();
			if (source.getName().compareTo("starryCommand") == 0)
			{
				handleStarrySwitches(request);
			}
			else if (source.getName().compareTo("lightsCommand") == 0)
			{
				handleCabinLightsSwitches(request);
			}
		}
	}
	private void handleStarrySwitches(boolean b)
	{
		Parameters parms = Parameters.getInstance("/conf/config.txt");
		try 
		{
			if (tglbtnStarrySky.isSelected())
			{
				request[0] = 1;
				if (rdbtnStarryAuto.isSelected())
				{
					i2c.prepareCommand(I2CComm.I2C_LIGHTS_AND_STEAM, I2CComm.CTRLID_STARRYSKY, 
							I2CComm.LEDRGB_SET_TIMERS, request, parms);
					i2c.prepareCommand(I2CComm.I2C_LIGHTS_AND_STEAM, I2CComm.CTRLID_STARRYSKY, 
							I2CComm.LEDRGB_SET_AUTO, request, parms);
				}
				else if (rdbtnStarryManual.isSelected())
				{
					i2c.prepareCommand(I2CComm.I2C_LIGHTS_AND_STEAM, I2CComm.CTRLID_STARRYSKY, 
							I2CComm.LEDRGB_SET_MANUAL, request, parms);	
				}
			}
			request[0] = (byte) (b ? 1 : 0);
			i2c.prepareCommand(I2CComm.I2C_LIGHTS_AND_STEAM, I2CComm.CTRLID_STARRYSKY, 
					I2CComm.LEDRGB_SWITCH_ON_OFF, request, parms);
		} 
		catch (UnsupportedBusNumberException | IOException | InterruptedException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private void handleCabinLightsSwitches(boolean b)
	{
		Parameters parms = Parameters.getInstance("/conf/config.txt");
		try 
		{
			request[0] = 1;
			if (tglbtnCabinLights.isSelected())
			{
				if (rdbtnLightsAuto.isSelected())
				{
					i2c.prepareCommand(I2CComm.I2C_LIGHTS_AND_STEAM, I2CComm.CTRLID_RGBSTRIPE, 
							I2CComm.LEDRGB_SET_TIMERS, request, parms);
					i2c.prepareCommand(I2CComm.I2C_LIGHTS_AND_STEAM, I2CComm.CTRLID_RGBSTRIPE, 
							I2CComm.LEDRGB_SET_AUTO, request, parms);
				}
				else if (rdbtnLightsManual.isSelected())
				{
					i2c.prepareCommand(I2CComm.I2C_LIGHTS_AND_STEAM, I2CComm.CTRLID_RGBSTRIPE, 
							I2CComm.LEDRGB_SET_MANUAL, request, parms);
				}
			}
			request[0] = (byte) (b ? 1 : 0);
			i2c.prepareCommand(I2CComm.I2C_LIGHTS_AND_STEAM, I2CComm.CTRLID_RGBSTRIPE, 
							I2CComm.LEDRGB_SWITCH_ON_OFF, request, parms);
		} 
		catch (UnsupportedBusNumberException | IOException | InterruptedException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
