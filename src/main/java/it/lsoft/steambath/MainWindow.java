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
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class MainWindow 
	extends JPanel
	implements  MouseListener, ItemListener, FocusListener, ActionListener, ChangeListener
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
	private JSpinner steamTime;
	private JSpinner humiditySet;
	private JSpinner fadeStarryTmr;
	private JSpinner fadeStripeTmr;
	private JSpinner fadeStarryDuration;
	private JSpinner fadeStripeDuration;
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
		settingsIcon.setBounds(529, 20, 20, 20);
		settingsIcon.addMouseListener(this);
		settingsIcon.setName("settings");
		add(settingsIcon);
		
		JLabel lblNewLabel = new JLabel("Steam bath activation menu");
		lblNewLabel.setFont(new Font("Arsenal", Font.PLAIN, 14));
		lblNewLabel.setBounds(52, 25, 247, 15);
		lblNewLabel.addMouseListener(this);
		lblNewLabel.setName("exitApp");
		add(lblNewLabel);
		
		
		/*
		 * Starry Panel
		 */
		JPanel pnlStarry = new JPanel();
		pnlStarry.setBackground(Color.WHITE);
		pnlStarry.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlStarry.setBounds(22, 60, 259, 149);
		pnlStarry.setLayout(null);
		add(pnlStarry);
				
		JLabel lblStarry = new JLabel("Starry");
		lblStarry.setFont(new Font("Dialog", Font.BOLD, 14));
		lblStarry.setBounds(2, 2, 70, 15);
		pnlStarry.add(lblStarry);

		JLabel lblStarryManRed = new JLabel("Red");
		lblStarryManRed.setFont(new Font("Arsenal", Font.PLAIN, 14));
		lblStarryManRed.setBounds(135, 8, 41, 33);
		pnlStarry.add(lblStarryManRed);
		JLabel lblStarryManGreen = new JLabel("Green");
		lblStarryManGreen.setFont(new Font("Arsenal", Font.PLAIN, 14));
		lblStarryManGreen.setBounds(135, 58, 41, 33);
		pnlStarry.add(lblStarryManGreen);
		JLabel lblStarryManBlue = new JLabel("Blue");
		lblStarryManBlue.setFont(new Font("Arsenal", Font.PLAIN, 14));
		lblStarryManBlue.setBounds(135, 108, 41, 33);
		pnlStarry.add(lblStarryManBlue);
		starryManRedVal = new JTextField();
		starryManRedVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryManRedVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		starryManRedVal.setColumns(10);
		starryManRedVal.setBounds(190, 8, 48, 33);
		starryManRedVal.addActionListener(this);
		starryManRedVal.addFocusListener(this);
		starryManRedVal.setText(String.valueOf(parms.getStarryManual()[Parameters.RED]));
		pnlStarry.add(starryManRedVal);
		
		starryManGreenVal = new JTextField();
		starryManGreenVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryManGreenVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		starryManGreenVal.setColumns(10);
		starryManGreenVal.setBounds(190, 58, 48, 33);
		starryManGreenVal.addActionListener(this);
		starryManGreenVal.addFocusListener(this);
		starryManGreenVal.setText(String.valueOf(parms.getStarryManual()[Parameters.GREEN]));
		pnlStarry.add(starryManGreenVal);
		
		starryManBlueVal = new JTextField();
		starryManBlueVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryManBlueVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		starryManBlueVal.setColumns(10);
		starryManBlueVal.setBounds(190, 108, 48, 33);
		starryManBlueVal.addActionListener(this);
		starryManBlueVal.addFocusListener(this);
		starryManBlueVal.setText(String.valueOf(parms.getStarryManual()[Parameters.BLUE]));
		pnlStarry.add(starryManBlueVal);
		
		rdbtnStarryAuto = new JRadioButton("Auto");
		rdbtnStarryAuto.setForeground(Color.DARK_GRAY);
		rdbtnStarryAuto.setBackground(Color.WHITE);
		rdbtnStarryAuto.setSelected(true);
		rdbtnStarryAuto.setFont(new Font("Arsenal", Font.PLAIN, 18));
		rdbtnStarryAuto.setBounds(20, 35, 87, 23);
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
		pnlStarry.add(rdbtnStarryAuto);
		
		rdbtnStarryManual = new JRadioButton("Manual");
		rdbtnStarryManual.setForeground(Color.DARK_GRAY);
		rdbtnStarryManual.setBackground(Color.WHITE);
		rdbtnStarryManual.setFont(new Font("Arsenal", Font.PLAIN, 18));
		rdbtnStarryManual.setBounds(20, 80, 87, 23);
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
		pnlStarry.add(rdbtnStarryManual);
		
		ButtonGroup bgStarry = new ButtonGroup();    
		bgStarry.add(rdbtnStarryAuto);
		bgStarry.add(rdbtnStarryManual);
		
		/*
		 * Stripe Panel
		 */
		JPanel pnlStripe = new JPanel();
		pnlStripe.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlStripe.setBackground(Color.WHITE);
		pnlStripe.setBounds(293, 60, 259, 149);
		pnlStripe.setLayout(null);
		add(pnlStripe);
		
		JLabel lblStripe = new JLabel("Stripe");
		lblStripe.setBounds(2, 2, 65, 17);
		lblStripe.setFont(new Font("Dialog", Font.BOLD, 14));
		pnlStripe.add(lblStripe);
		
		JLabel lblLightsManRed = new JLabel("Red");
		lblLightsManRed.setFont(new Font("Arsenal", Font.PLAIN, 14));
		lblLightsManRed.setBounds(140, 8, 41, 33);
		pnlStripe.add(lblLightsManRed);
		JLabel lblLightsManGreen = new JLabel("Green");
		lblLightsManGreen.setFont(new Font("Arsenal", Font.PLAIN, 14));
		lblLightsManGreen.setBounds(140, 58, 41, 33);
		pnlStripe.add(lblLightsManGreen);
		JLabel lblLightsManBlue = new JLabel("Blue");
		lblLightsManBlue.setFont(new Font("Arsenal", Font.PLAIN, 14));
		lblLightsManBlue.setBounds(140, 108, 41, 33);
		pnlStripe.add(lblLightsManBlue);
		
		lightsManRedVal = new JTextField();
		lightsManRedVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsManRedVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lightsManRedVal.setColumns(10);
		lightsManRedVal.setBounds(190, 8, 48, 33);
		lightsManRedVal.addActionListener(this);
		lightsManRedVal.addFocusListener(this);
		lightsManRedVal.setText(String.valueOf(parms.getLightsManual()[Parameters.RED]));
		pnlStripe.add(lightsManRedVal);

		lightsManGreenVal = new JTextField();
		lightsManGreenVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsManGreenVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lightsManGreenVal.setColumns(10);
		lightsManGreenVal.setBounds(190, 58, 48, 33);
		lightsManGreenVal.addActionListener(this);
		lightsManGreenVal.addFocusListener(this);
		lightsManGreenVal.setText(String.valueOf(parms.getLightsManual()[Parameters.GREEN]));
		pnlStripe.add(lightsManGreenVal);

		lightsManBlueVal = new JTextField();
		lightsManBlueVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsManBlueVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lightsManBlueVal.setColumns(10);
		lightsManBlueVal.setBounds(190, 108, 48, 33);
		lightsManBlueVal.addActionListener(this);
		lightsManBlueVal.addFocusListener(this);
		lightsManBlueVal.setText(String.valueOf(parms.getLightsManual()[Parameters.BLUE]));
		pnlStripe.add(lightsManBlueVal);

		rdbtnLightsAuto = new JRadioButton("Auto");
		rdbtnLightsAuto.setForeground(Color.DARK_GRAY);
		rdbtnLightsAuto.setBackground(Color.WHITE);
		rdbtnLightsAuto.setSelected(true);
		rdbtnLightsAuto.setFont(new Font("Arsenal", Font.PLAIN, 18));
		rdbtnLightsAuto.setBounds(20, 35, 87, 23);
		rdbtnLightsAuto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblLightsManRed.setVisible(false);
				lblLightsManGreen.setVisible(false);
				lblLightsManBlue.setVisible(false);
				lightsManRedVal.setVisible(false);
				lightsManGreenVal.setVisible(false);
				lightsManBlueVal.setVisible(false);
				if (valuesChanged)
				{
					parms.save();
					valuesChanged = false;
				}
			}
		});
		pnlStripe.add(rdbtnLightsAuto);
		
		rdbtnLightsManual = new JRadioButton("Manual");
		rdbtnLightsManual.setForeground(Color.DARK_GRAY);
		rdbtnLightsManual.setBackground(Color.WHITE);
		rdbtnLightsManual.setFont(new Font("Arsenal", Font.PLAIN, 18));
		rdbtnLightsManual.setBounds(20, 80, 87, 23);
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
		pnlStripe.add(rdbtnLightsManual);

		ButtonGroup bgLights = new ButtonGroup();    
		bgLights.add(rdbtnLightsAuto);
		bgLights.add(rdbtnLightsManual);
		
		/*
		 * Time and humidity panel
		 */
		JPanel pnlOtherParms = new JPanel();
		pnlOtherParms.setForeground(Color.BLACK);
		pnlOtherParms.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlOtherParms.setBackground(Color.WHITE);
		pnlOtherParms.setBounds(22, 221, 530, 143);
		pnlOtherParms.setLayout(null);
		add(pnlOtherParms);

		JLabel lblTimeAndHumidity = new JLabel("Other parameters");
		lblTimeAndHumidity.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTimeAndHumidity.setBounds(2, 2, 175, 15);
		pnlOtherParms.add(lblTimeAndHumidity);
		
		JLabel lblsteamTime = new JLabel("Time");
		lblsteamTime.setFont(new Font("Arsenal", Font.PLAIN, 14));
		lblsteamTime.setBounds(20, 50, 50, 15);
		pnlOtherParms.add(lblsteamTime);
		JLabel lblsteamHumidity = new JLabel("Humidity");
		lblsteamHumidity.setFont(new Font("Arsenal", Font.PLAIN, 14));
		lblsteamHumidity.setBounds(20, 100, 50, 15);
		pnlOtherParms.add(lblsteamHumidity);
		steamTime = new JSpinner();
		steamTime.setModel(new SpinnerNumberModel(35, 35, 60, 5));
		steamTime.setFont(new Font("Arsenal", Font.PLAIN, 18));
		steamTime.setBounds(75, 41, 48, 33);
		steamTime.addChangeListener(this);
		steamTime.addFocusListener(this);
		pnlOtherParms.add(steamTime );
		humiditySet = new JSpinner();
		humiditySet.setModel(new SpinnerNumberModel(50, 50, 90, 5));
		humiditySet.setFont(new Font("Arsenal", Font.PLAIN, 18));
		humiditySet.setBounds(75, 91, 48, 33);
		humiditySet.addFocusListener(this);
		pnlOtherParms.add(humiditySet);
		
		JLabel lblFadeCycle = new JLabel("Fade:    cycle");
		lblFadeCycle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFadeCycle.setFont(new Font("Arsenal", Font.PLAIN, 14));
		lblFadeCycle.setBounds(167, 20, 80, 15);
		pnlOtherParms.add(lblFadeCycle);
		JLabel lblFadeStripeTmr = new JLabel("Stripe");
		lblFadeStripeTmr.setFont(new Font("Arsenal", Font.PLAIN, 14));
		lblFadeStripeTmr.setBounds(160, 50, 80, 15);
		pnlOtherParms.add(lblFadeStripeTmr);
		JLabel lblFadeStarryTmr = new JLabel("Starry");
		lblFadeStarryTmr.setFont(new Font("Arsenal", Font.PLAIN, 14));
		lblFadeStarryTmr.setBounds(160, 100, 80, 15);
		pnlOtherParms.add(lblFadeStarryTmr);
		fadeStripeTmr = new JSpinner();
		fadeStripeTmr.setModel(new SpinnerNumberModel(35, 35, 60, 5));
		fadeStripeTmr.setFont(new Font("Arsenal", Font.PLAIN, 18));
		fadeStripeTmr.setBounds(200, 41, 48, 33);
		fadeStripeTmr.addFocusListener(this);
		pnlOtherParms.add(fadeStripeTmr);
		fadeStarryTmr = new JSpinner();
		fadeStarryTmr.setModel(new SpinnerNumberModel(50, 50, 90, 5));
		fadeStarryTmr.setFont(new Font("Arsenal", Font.PLAIN, 18));
		fadeStarryTmr.setBounds(200, 91, 48, 33);
		fadeStarryTmr.addFocusListener(this);
		pnlOtherParms.add(fadeStarryTmr);

		JLabel lblFadeDuration = new JLabel("duration");
		lblFadeDuration.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFadeDuration.setFont(new Font("Arsenal", Font.PLAIN, 14));
		lblFadeDuration.setBounds(250, 20, 58, 15);
		pnlOtherParms.add(lblFadeDuration);
		fadeStripeDuration = new JSpinner();
		fadeStripeDuration.setModel(new SpinnerNumberModel(35, 35, 60, 5));
		fadeStripeDuration.setFont(new Font("Arsenal", Font.PLAIN, 18));
		fadeStripeDuration.setBounds(260, 41, 48, 33);
		pnlOtherParms.add(fadeStripeDuration);
		fadeStarryDuration = new JSpinner();
		fadeStarryDuration.setModel(new SpinnerNumberModel(50, 50, 90, 5));
		fadeStarryDuration.setFont(new Font("Arsenal", Font.PLAIN, 18));
		fadeStarryDuration.setBounds(260, 91, 48, 33);
		pnlOtherParms.add(fadeStarryDuration);
		
		/*
		 * Music
		 */
		JPanel pnlMusic= new JPanel();
		pnlMusic.setForeground(Color.BLACK);
		pnlMusic.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlMusic.setBackground(Color.WHITE);
		pnlMusic.setBounds(22, 377, 530, 143);
		pnlMusic.setLayout(null);
		add(pnlMusic);

		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.setBounds(172, 708, 247, 48);
		add(btnNewButton);
		
		



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
		Parameters parms = Parameters.getInstance("/conf/config.txt");
		if (e.getSource().getClass().getName().compareTo("javax.swing.JToggleButton") == 0)
		{
			if(e.getStateChange()==ItemEvent.SELECTED)
			{
				request[0] = 1;
			} 
			else if(e.getStateChange()==ItemEvent.DESELECTED)
			{
				request[0] = 0;
			}		
			JToggleButton source = (JToggleButton)e.getSource();
			if (source.getName().compareTo("starryCommand") == 0)
			{
				try 
				{
					if (rdbtnStarryManual.isSelected())
					{
						i2c.prepareCommand(I2CComm.I2C_LIGHTS_AND_STEAM, I2CComm.CTRLID_STARRYSKY, 
								I2CComm.LEDRGB_SET_MANUAL, request, parms);
					}
					else
					{
						i2c.prepareCommand(I2CComm.I2C_LIGHTS_AND_STEAM, I2CComm.CTRLID_STARRYSKY, 
								I2CComm.LEDRGB_SET_AUTO, request, parms);
					}
				} 
				catch (UnsupportedBusNumberException | IOException | InterruptedException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if (source.getName().compareTo("lightsCommand") == 0)
			{
				try 
				{
					if (rdbtnLightsManual.isSelected())
					{
						i2c.prepareCommand(I2CComm.I2C_LIGHTS_AND_STEAM, I2CComm.CTRLID_RGBSTRIPE, 
								I2CComm.LEDRGB_SET_MANUAL, request, parms);
					}
					else
					{
						i2c.prepareCommand(I2CComm.I2C_LIGHTS_AND_STEAM, I2CComm.CTRLID_RGBSTRIPE, 
								I2CComm.LEDRGB_SET_AUTO, request, parms);
					}
				} 
				catch (UnsupportedBusNumberException | IOException | InterruptedException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
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

	@Override
	public void stateChanged(ChangeEvent e) {
		if (keyb != null)
		{
			keyb.setVisible(true);
			keyb.dispose();
		}
		
	}
}
