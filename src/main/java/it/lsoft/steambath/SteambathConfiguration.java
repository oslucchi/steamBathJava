package it.lsoft.steambath;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;

import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import it.lsoft.steambath.Commons.Parameters;
import it.lsoft.steambath.Commons.VirtualKeyboard;
import it.lsoft.steambath.Commons.Visualizer;

import javax.swing.JButton;
import javax.swing.JSpinner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SteambathConfiguration 
		extends JPanel
		implements ChangeListener, ActionListener, FocusListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Parameters parms = Parameters.getInstance("/conf/config.txt");

	// private JFrame frame;
	private JTextField starryRedMinVal;
	private JTextField starryGreenMinVal;
	private JTextField starryBlueMinVal;
	private JTextField starryRedMaxVal;
	private JTextField starryGreenMaxVal;
	private JTextField starryBlueMaxVal;
	private JTextField starryRedSpeedVal;
	private JTextField starryGreenSpeedVal;
	private JTextField starryBlueSpeedVal;
	private JTextField lightsRedMinVal;
	private JTextField lightsGreenMinVal;
	private JTextField lightsBlueMinVal;
	private JTextField lightsRedMaxVal;
	private JTextField lightsGreenMaxVal;
	private JTextField lightsBlueMaxVal;
	private JTextField lightsRedSpeedVal;
	private JTextField lightsGreenSpeedVal;
	private JTextField lightsBlueSpeedVal;
	private Visualizer v;
	private VirtualKeyboard keyb;
	
	/**
	 * Create the application.
	 */
	public SteambathConfiguration() 
	{
		initialize();
	}

	public void setVisualizer(Visualizer v)
	{
		this.v = v;
	}

	/**
	 * Initialize the contents of the 
	 */
	private void initialize() {
		setLayout(null);
		setFont(new Font("Arsenal", Font.PLAIN, 14));
		setBackground(Color.WHITE);
		// setResizable(false);
		// setBounds(1, 1, 598, 1022);
		setSize(600, 1024);
		// setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		// setUndecorated(true);
		
		JLabel lblStarrysky = new JLabel("Starry sky");
		lblStarrysky.setFont(new Font("Arsenal", Font.BOLD, 24));
		lblStarrysky.setBounds(96, 51, 109, 32);
		add(lblStarrysky);
		
		JLabel lblMin = new JLabel("min");
		lblMin.setFont(new Font("Arsenal", Font.BOLD, 16));
		lblMin.setBounds(12, 139, 35, 15);
		add(lblMin);
		
		JLabel lblMax = new JLabel("MAX");
		lblMax.setFont(new Font("Arsenal", Font.BOLD, 16));
		lblMax.setBounds(12, 259, 35, 15);
		add(lblMax);
		
		JLabel lblSpeed = new JLabel("Speed");
		lblSpeed.setFont(new Font("Arsenal", Font.BOLD, 16));
		lblSpeed.setBounds(12, 394, 51, 25);
		add(lblSpeed);
		
		JLabel lblStarryRed = new JLabel("R");
		lblStarryRed.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lblStarryRed.setBounds(59, 95, 20, 30);
		add(lblStarryRed);

		JSlider starryRedMin = new JSlider();
		starryRedMin.setForeground(Color.DARK_GRAY);
		starryRedMin.setBackground(Color.WHITE);
		starryRedMin.setBounds(76, 95, 140, 30);
		starryRedMin.setMinimum(0);
		starryRedMin.setMaximum(255);
		starryRedMin.setName("starryRedMin");
		starryRedMin.setValue(parms.getStarry()[Parameters.RED][Parameters.MIN]);
		starryRedMin.addChangeListener(this);
		add(starryRedMin);
		
		JSlider starryRedMax = new JSlider();
		starryRedMax.setForeground(Color.DARK_GRAY);
		starryRedMax.setBackground(Color.WHITE);
		starryRedMax.setBounds(77, 223, 140, 30);
		starryRedMax.setMinimum(0);
		starryRedMax.setMaximum(255);
		starryRedMax.setName("starryRedMax");
		starryRedMax.setValue(parms.getStarry()[Parameters.RED][Parameters.MAX]);
		starryRedMax.addChangeListener(this);
		add(starryRedMax);
		
		JSlider starryRedSpeed = new JSlider();
		starryRedSpeed.setForeground(Color.DARK_GRAY);
		starryRedSpeed.setBackground(Color.WHITE);
		starryRedSpeed.setBounds(77, 355, 140, 30);
		starryRedSpeed.setMinimum(50);
		starryRedSpeed.setMaximum(10000);
		starryRedSpeed.setName("starryRedSpeed");
		starryRedSpeed.setValue(parms.getStarry()[Parameters.RED][Parameters.SPEED]);
		starryRedSpeed.addChangeListener(this);
		add(starryRedSpeed);
		
		JLabel lblGreen = new JLabel("G");
		lblGreen.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lblGreen.setBounds(59, 131, 20, 30);
		add(lblGreen);
		
		JSlider starryGreenMin = new JSlider();
		starryGreenMin.setForeground(Color.DARK_GRAY);
		starryGreenMin.setBackground(Color.WHITE);
		starryGreenMin.setBounds(77, 131, 140, 30);
		starryGreenMin.setMinimum(0);
		starryGreenMin.setMaximum(255);
		starryGreenMin.setName("starryGreenMin");
		starryGreenMin.setValue(parms.getStarry()[Parameters.GREEN][Parameters.MIN]);
		starryGreenMin.addChangeListener(this);
		add(starryGreenMin);
		
		JSlider starryGreenMax = new JSlider();
		starryGreenMax.setForeground(Color.DARK_GRAY);
		starryGreenMax.setBackground(Color.WHITE);
		starryGreenMax.setBounds(77, 259, 140, 30);
		starryGreenMax.setMinimum(0);
		starryGreenMax.setMaximum(255);
		starryGreenMax.setName("starryGreenMax");
		starryGreenMax.setValue(parms.getStarry()[Parameters.GREEN][Parameters.MAX]);
		starryGreenMax.addChangeListener(this);
		add(starryGreenMax);
		
		JSlider starryGreenSpeed = new JSlider();
		starryGreenSpeed.setForeground(Color.DARK_GRAY);
		starryGreenSpeed.setBackground(Color.WHITE);
		starryGreenSpeed.setBounds(77, 391, 140, 30);
		starryGreenSpeed.setMinimum(50);
		starryGreenSpeed.setMaximum(10000);
		starryGreenSpeed.setName("starryGreenSpeed");
		starryGreenSpeed.setValue(parms.getStarry()[Parameters.GREEN][Parameters.SPEED]);
		starryGreenSpeed.addChangeListener(this);
		add(starryGreenSpeed);
		
		JLabel lblBlue = new JLabel("B");
		lblBlue.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lblBlue.setBounds(59, 167, 20, 30);
		add(lblBlue);
		
		JSlider starryBlueMin = new JSlider();
		starryBlueMin.setForeground(Color.DARK_GRAY);
		starryBlueMin.setBackground(Color.WHITE);
		starryBlueMin.setBounds(77, 167, 140, 30);
		starryBlueMin.setMinimum(0);
		starryBlueMin.setMaximum(255);
		starryBlueMin.setName("starryBlueMin");
		starryBlueMin.setValue(parms.getStarry()[Parameters.BLUE][Parameters.MIN]);
		starryBlueMin.addChangeListener(this);
		add(starryBlueMin);
		
		JSlider starryBlueMax = new JSlider();
		starryBlueMax.setForeground(Color.DARK_GRAY);
		starryBlueMax.setBackground(Color.WHITE);
		starryBlueMax.setBounds(77, 295, 140, 30);
		starryBlueMax.setMinimum(0);
		starryBlueMax.setMaximum(255);
		starryBlueMax.setName("starryBlueMax");
		starryBlueMax.setValue(parms.getStarry()[Parameters.BLUE][Parameters.MAX]);
		starryBlueMax.addChangeListener(this);
		add(starryBlueMax);
		
		JSlider starryBlueSpeed = new JSlider();
		starryBlueSpeed.setForeground(Color.DARK_GRAY);
		starryBlueSpeed.setBackground(Color.WHITE);
		starryBlueSpeed.setBounds(77, 427, 140, 30);
		starryBlueSpeed.setMinimum(50);
		starryBlueSpeed.setMaximum(10000);
		starryBlueSpeed.setName("starryBlueSpeed");
		starryBlueSpeed.setValue(parms.getStarry()[Parameters.BLUE][Parameters.SPEED]);
		starryBlueSpeed.addChangeListener(this);
		add(starryBlueSpeed);
		
		starryRedMinVal = new JTextField();
		starryRedMinVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryRedMinVal.setName("starryRedMinVal");
		starryRedMinVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		starryRedMinVal.setBounds(218, 93, 40, 34);
		starryRedMinVal.setColumns(10);
		starryRedMinVal.setText(String.valueOf(parms.getStarry()[Parameters.RED][Parameters.MIN]));
		starryRedMinVal.addActionListener(this);
		starryRedMinVal.addFocusListener(this);
		add(starryRedMinVal);
		
		starryGreenMinVal = new JTextField();
		starryGreenMinVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryGreenMinVal.setName("starryGreenMinVal");
		starryGreenMinVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		starryGreenMinVal.setColumns(10);
		starryGreenMinVal.setBounds(218, 129, 40, 34);
		starryGreenMinVal.setText(String.valueOf(parms.getStarry()[Parameters.GREEN][Parameters.MIN]));
		starryGreenMinVal.addActionListener(this);
		starryGreenMinVal.addFocusListener(this);
		add(starryGreenMinVal);
		
		starryBlueMinVal = new JTextField();
		starryBlueMinVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryBlueMinVal.setName("starryBlueMinVal");
		starryBlueMinVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		starryBlueMinVal.setColumns(10);
		starryBlueMinVal.setBounds(218, 165, 40, 34);
		starryBlueMinVal.setText(String.valueOf(parms.getStarry()[Parameters.BLUE][Parameters.MIN]));
		starryBlueMinVal.addActionListener(this);
		starryBlueMinVal.addFocusListener(this);
		add(starryBlueMinVal);
		
		starryRedMaxVal = new JTextField();
		starryRedMaxVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryRedMaxVal.setName("starryRedMaxVal");
		starryRedMaxVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		starryRedMaxVal.setColumns(10);
		starryRedMaxVal.setBounds(218, 221, 40, 34);
		starryRedMaxVal.setText(String.valueOf(parms.getStarry()[Parameters.RED][Parameters.MAX]));
		starryRedMaxVal.addActionListener(this);
		starryRedMaxVal.addFocusListener(this);
		add(starryRedMaxVal);
		
		starryGreenMaxVal = new JTextField();
		starryGreenMaxVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryGreenMaxVal.setName("starryGreenMaxVal");
		starryGreenMaxVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		starryGreenMaxVal.setColumns(10);
		starryGreenMaxVal.setBounds(218, 257, 40, 34);
		starryGreenMaxVal.setText(String.valueOf(parms.getStarry()[Parameters.GREEN][Parameters.MAX]));
		starryGreenMaxVal.addActionListener(this);
		starryGreenMaxVal.addFocusListener(this);
		add(starryGreenMaxVal);
		
		starryBlueMaxVal = new JTextField();
		starryBlueMaxVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryBlueMaxVal.setName("starryBlueMaxVal");
		starryBlueMaxVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		starryBlueMaxVal.setColumns(10);
		starryBlueMaxVal.setBounds(218, 293, 40, 34);
		starryBlueMaxVal.setText(String.valueOf(parms.getStarry()[Parameters.BLUE][Parameters.MAX]));
		starryBlueMaxVal.addActionListener(this);
		starryBlueMaxVal.addFocusListener(this);
		add(starryBlueMaxVal);
		
		starryRedSpeedVal = new JTextField();
		starryRedSpeedVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryRedSpeedVal.setName("starryRedSpeedVal");
		starryRedSpeedVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		starryRedSpeedVal.setColumns(10);
		starryRedSpeedVal.setBounds(218, 353, 40, 34);
		starryRedSpeedVal.setText(String.valueOf(parms.getStarry()[Parameters.RED][Parameters.SPEED]));
		starryRedSpeedVal.addActionListener(this);
		starryRedSpeedVal.addFocusListener(this);
		add(starryRedSpeedVal);
		
		starryGreenSpeedVal = new JTextField();
		starryGreenSpeedVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryGreenSpeedVal.setName("starryGreenSpeedVal");
		starryGreenSpeedVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		starryGreenSpeedVal.setColumns(10);
		starryGreenSpeedVal.setBounds(218, 389, 40, 34);
		starryGreenSpeedVal.setText(String.valueOf(parms.getStarry()[Parameters.GREEN][Parameters.SPEED]));
		starryGreenSpeedVal.addActionListener(this);
		starryGreenSpeedVal.addFocusListener(this);
		add(starryGreenSpeedVal);
		
		starryBlueSpeedVal = new JTextField();
		starryBlueSpeedVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryBlueSpeedVal.setName("starryBlueSpeedVal");
		starryBlueSpeedVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		starryBlueSpeedVal.setColumns(10);
		starryBlueSpeedVal.setBounds(218, 425, 40, 34);
		starryBlueSpeedVal.setText(String.valueOf(parms.getStarry()[Parameters.BLUE][Parameters.SPEED]));
		starryBlueSpeedVal.addActionListener(this);
		starryBlueSpeedVal.addFocusListener(this);
		add(starryBlueSpeedVal);
		
		JLabel lblCabinLights = new JLabel("Cabin lights");
		lblCabinLights.setFont(new Font("Arsenal", Font.BOLD, 24));
		lblCabinLights.setBounds(405, 51, 128, 32);
		add(lblCabinLights);
		
		JSlider lightsRedMin = new JSlider();
		lightsRedMin.setForeground(Color.DARK_GRAY);
		lightsRedMin.setBackground(Color.WHITE);
		lightsRedMin.setBounds(383, 95, 140, 30);
		lightsRedMin.setMinimum(0);
		lightsRedMin.setMaximum(255);
		lightsRedMin.setName("lightsRedMin");
		lightsRedMin.setValue(parms.getLights()[Parameters.RED][Parameters.MIN]);
		lightsRedMin.addChangeListener(this);
		add(lightsRedMin);
		
		JSlider lightsRedMax = new JSlider();
		lightsRedMax.setForeground(Color.DARK_GRAY);
		lightsRedMax.setBackground(Color.WHITE);
		lightsRedMax.setBounds(383, 223, 140, 30);
		lightsRedMax.setMinimum(0);
		lightsRedMax.setMaximum(255);
		lightsRedMax.setName("lightsRedMax");
		lightsRedMax.setValue(parms.getLights()[Parameters.RED][Parameters.MAX]);
		lightsRedMax.addChangeListener(this);
		add(lightsRedMax);
		
		JSlider lightsRedSpeed = new JSlider();
		lightsRedSpeed.setForeground(Color.DARK_GRAY);
		lightsRedSpeed.setBackground(Color.WHITE);
		lightsRedSpeed.setBounds(383, 355, 140, 30);
		lightsRedSpeed.setMinimum(50);
		lightsRedSpeed.setMaximum(10000);
		lightsRedSpeed.setName("lightsRedSpeed");
		lightsRedSpeed.setValue(parms.getLights()[Parameters.RED][Parameters.SPEED]);
		lightsRedSpeed.addChangeListener(this);
		add(lightsRedSpeed);
		
		JSlider lightsGreenMin = new JSlider();
		lightsGreenMin.setForeground(Color.DARK_GRAY);
		lightsGreenMin.setBackground(Color.WHITE);
		lightsGreenMin.setBounds(383, 131, 140, 30);
		lightsGreenMin.setMinimum(0);
		lightsGreenMin.setMaximum(255);
		lightsGreenMin.setName("lightsGreenMin");
		lightsGreenMin.setValue(parms.getLights()[Parameters.GREEN][Parameters.MIN]);
		lightsGreenMin.addChangeListener(this);
		add(lightsGreenMin);
		
		JSlider lightsGreenMax = new JSlider();
		lightsGreenMax.setForeground(Color.DARK_GRAY);
		lightsGreenMax.setBackground(Color.WHITE);
		lightsGreenMax.setBounds(383, 259, 140, 30);
		lightsGreenMax.setMinimum(0);
		lightsGreenMax.setMaximum(255);
		lightsGreenMax.setName("lightsGreenMax");
		lightsGreenMax.setValue(parms.getLights()[Parameters.GREEN][Parameters.MAX]);
		lightsGreenMax.addChangeListener(this);
		add(lightsGreenMax);
		
		JSlider lightsGreenSpeed = new JSlider();
		lightsGreenSpeed.setForeground(Color.DARK_GRAY);
		lightsGreenSpeed.setBackground(Color.WHITE);
		lightsGreenSpeed.setBounds(383, 391, 140, 30);
		lightsGreenSpeed.setMinimum(50);
		lightsGreenSpeed.setMaximum(10000);
		lightsGreenSpeed.setName("lightsGreenSpeed");
		lightsGreenSpeed.setValue(parms.getLights()[Parameters.GREEN][Parameters.SPEED]);
		lightsGreenSpeed.addChangeListener(this);
		add(lightsGreenSpeed);
		
		JSlider lightsBlueMin = new JSlider();
		lightsBlueMin.setForeground(Color.DARK_GRAY);
		lightsBlueMin.setBackground(Color.WHITE);
		lightsBlueMin.setBounds(383, 167, 140, 30);
		lightsBlueMin.setMinimum(0);
		lightsBlueMin.setMaximum(255);
		lightsBlueMin.setName("lightsBlueMin");
		lightsBlueMin.setValue(parms.getLights()[Parameters.BLUE][Parameters.MIN]);
		lightsBlueMin.addChangeListener(this);
		add(lightsBlueMin);
		
		JSlider lightsBlueMax = new JSlider();
		lightsBlueMax.setForeground(Color.DARK_GRAY);
		lightsBlueMax.setBackground(Color.WHITE);
		lightsBlueMax.setBounds(383, 295, 140, 30);
		lightsBlueMax.setMinimum(0);
		lightsBlueMax.setMaximum(255);
		lightsBlueMax.setName("lightsBlueMax");
		lightsBlueMax.setValue(parms.getLights()[Parameters.BLUE][Parameters.MAX]);
		lightsBlueMax.addChangeListener(this);
		add(lightsBlueMax);
		
		JSlider lightsBlueSpeed = new JSlider();
		lightsBlueSpeed.setForeground(Color.DARK_GRAY);
		lightsBlueSpeed.setBackground(Color.WHITE);
		lightsBlueSpeed.setBounds(383, 427, 140, 30);
		lightsBlueSpeed.setMinimum(50);
		lightsBlueSpeed.setMaximum(10000);
		lightsBlueSpeed.setName("lightsBlueSpeed");
		lightsBlueSpeed.setValue(parms.getLights()[Parameters.BLUE][Parameters.SPEED]);
		lightsBlueSpeed.addChangeListener(this);
		add(lightsBlueSpeed);
		
		lightsRedMinVal = new JTextField();
		lightsRedMinVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsRedMinVal.setName("lightsRedMinVal");
		lightsRedMinVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lightsRedMinVal.setColumns(10);
		lightsRedMinVal.setBounds(524, 93, 50, 34);
		lightsRedMinVal.setText(String.valueOf(parms.getLights()[Parameters.RED][Parameters.MIN]));
		lightsRedMinVal.addActionListener(this);
		lightsRedMinVal.addFocusListener(this);
		add(lightsRedMinVal);
		
		lightsGreenMinVal = new JTextField();
		lightsGreenMinVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsGreenMinVal.setName("lightsGreenMinVal");
		lightsGreenMinVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lightsGreenMinVal.setColumns(10);
		lightsGreenMinVal.setBounds(524, 129, 50, 34);
		lightsGreenMinVal.setText(String.valueOf(parms.getLights()[Parameters.GREEN][Parameters.MIN]));
		lightsGreenMinVal.addActionListener(this);
		lightsGreenMinVal.addFocusListener(this);
		add(lightsGreenMinVal);
		
		lightsBlueMinVal = new JTextField();
		lightsBlueMinVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsBlueMinVal.setName("lightsBlueMinVal");
		lightsBlueMinVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lightsBlueMinVal.setColumns(10);
		lightsBlueMinVal.setBounds(524, 165, 50, 34);
		lightsBlueMinVal.setText(String.valueOf(parms.getLights()[Parameters.BLUE][Parameters.MIN]));
		lightsBlueMinVal.addActionListener(this);
		lightsBlueMinVal.addFocusListener(this);
		add(lightsBlueMinVal);
		
		lightsRedMaxVal = new JTextField();
		lightsRedMaxVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsRedMaxVal.setName("lightsRedMaxVal");
		lightsRedMaxVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lightsRedMaxVal.setColumns(10);
		lightsRedMaxVal.setBounds(524, 221, 50, 34);
		lightsRedMaxVal.setText(String.valueOf(parms.getLights()[Parameters.RED][Parameters.MAX]));
		lightsRedMaxVal.addActionListener(this);
		lightsRedMaxVal.addFocusListener(this);
		add(lightsRedMaxVal);
		
		lightsGreenMaxVal = new JTextField();
		lightsGreenMaxVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsGreenMaxVal.setName("lightsGreenMaxVal");
		lightsGreenMaxVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lightsGreenMaxVal.setColumns(10);
		lightsGreenMaxVal.setBounds(524, 257, 50, 34);
		lightsGreenMaxVal.setText(String.valueOf(parms.getLights()[Parameters.GREEN][Parameters.MAX]));
		lightsGreenMaxVal.addActionListener(this);
		lightsGreenMaxVal.addFocusListener(this);
		add(lightsGreenMaxVal);
		
		lightsBlueMaxVal = new JTextField();
		lightsBlueMaxVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsBlueMaxVal.setName("lightsBlueMaxVal");
		lightsBlueMaxVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lightsBlueMaxVal.setColumns(10);
		lightsBlueMaxVal.setBounds(524, 293, 50, 34);
		lightsBlueMaxVal.setText(String.valueOf(parms.getLights()[Parameters.BLUE][Parameters.MAX]));
		lightsBlueMaxVal.addActionListener(this);
		lightsBlueMaxVal.addFocusListener(this);
		add(lightsBlueMaxVal);
		
		lightsRedSpeedVal = new JTextField();
		lightsRedSpeedVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsRedSpeedVal.setName("lightsRedSpeedVal");
		lightsRedSpeedVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lightsRedSpeedVal.setColumns(10);
		lightsRedSpeedVal.setBounds(524, 355, 50, 30);
		lightsRedSpeedVal.setText(String.valueOf(parms.getLights()[Parameters.RED][Parameters.SPEED]));
		lightsRedSpeedVal.addActionListener(this);
		lightsRedSpeedVal.addFocusListener(this);
		add(lightsRedSpeedVal);
		
		lightsGreenSpeedVal = new JTextField();
		lightsGreenSpeedVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsGreenSpeedVal.setName("lightsGreenSpeedVal");
		lightsGreenSpeedVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lightsGreenSpeedVal.setColumns(10);
		lightsGreenSpeedVal.setBounds(524, 389, 50, 34);
		lightsGreenSpeedVal.setText(String.valueOf(parms.getLights()[Parameters.GREEN][Parameters.SPEED]));
		lightsGreenSpeedVal.addActionListener(this);
		lightsGreenSpeedVal.addFocusListener(this);
		add(lightsGreenSpeedVal);
		
		lightsBlueSpeedVal = new JTextField();
		lightsBlueSpeedVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsBlueSpeedVal.setName("lightsBlueSpeedVal");
		lightsBlueSpeedVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lightsBlueSpeedVal.setColumns(10);
		lightsBlueSpeedVal.setBounds(524, 425, 50, 34);
		lightsBlueSpeedVal.setText(String.valueOf(parms.getLights()[Parameters.BLUE][Parameters.SPEED]));
		lightsBlueSpeedVal.addActionListener(this);
		lightsBlueSpeedVal.addFocusListener(this);
		add(lightsBlueSpeedVal);
				
		JLabel lblVapor = new JLabel("Steam bath");
		lblVapor.setFont(new Font("Arsenal", Font.BOLD, 24));
		lblVapor.setBounds(228, 481, 140, 32);
		add(lblVapor);
		
		JLabel lblHumidity = new JLabel("Humidity");
		lblHumidity.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lblHumidity.setBounds(33, 525, 81, 32);
		add(lblHumidity);
		
		JLabel lblTemperature = new JLabel("Temperature");
		lblTemperature.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lblTemperature.setBounds(220, 525, 99, 32);
		add(lblTemperature);
		
		JLabel lblNewLabel = new JLabel("%");
		lblNewLabel.setFont(new Font("Arsenal", Font.PLAIN, 12));
		lblNewLabel.setBounds(173, 536, 70, 15);
		add(lblNewLabel);
		
		JLabel lblC = new JLabel("C°");
		lblC.setFont(new Font("Arsenal", Font.PLAIN, 14));
		lblC.setBounds(394, 535, 28, 15);
		add(lblC);
		
		JLabel lblTimer = new JLabel("Timer");
		lblTimer.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lblTimer.setBounds(445, 525, 75, 32);
		add(lblTimer);
		
		JLabel lblMin_1 = new JLabel("min");
		lblMin_1.setFont(new Font("Arsenal", Font.PLAIN, 14));
		lblMin_1.setBounds(551, 553, 35, 15);
		add(lblMin_1);
		
		JLabel lblMusic = new JLabel("Music");
		lblMusic.setFont(new Font("Arsenal", Font.BOLD, 24));
		lblMusic.setBounds(252, 597, 70, 32);
		add(lblMusic);
		
		JLabel lblSteamBathConfigration = new JLabel("Steam bath configuration");
		lblSteamBathConfigration.setHorizontalAlignment(SwingConstants.CENTER);
		lblSteamBathConfigration.setFont(new Font("Arsenal", Font.BOLD, 32));
		lblSteamBathConfigration.setBounds(110, 1, 372, 45);
		add(lblSteamBathConfigration);
		
		JSpinner timer = new JSpinner();
		timer.setFont(new Font("Arsenal", Font.PLAIN, 18));
		timer.setBounds(494, 525, 70, 32);
		timer.setValue(parms.getHumidity());
		add(timer);
		
		JSpinner humidity = new JSpinner();
		humidity.setFont(new Font("Arsenal", Font.PLAIN, 18));
		humidity.setBounds(100, 526, 70, 32);
		humidity.setValue(parms.getTemperature());
		add(humidity);
		
		JSpinner temperature = new JSpinner();
		temperature.setFont(new Font("Arsenal", Font.PLAIN, 18));
		temperature.setBounds(320, 526, 70, 32);
		temperature.setValue(parms.getTimer());
		add(temperature);

		JButton btnSave = new JButton("Save");
		btnSave.setForeground(Color.DARK_GRAY);
		btnSave.setBackground(Color.WHITE);
		btnSave.setFont(new Font("Arsenal", Font.BOLD, 14));
		btnSave.setBounds(86, 982, 117, 25);
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				parms.setStarryElement(Parameters.RED, Parameters.MIN, starryRedMin.getValue());
				parms.setStarryElement(Parameters.RED, Parameters.MAX, starryRedMax.getValue());
				parms.setStarryElement(Parameters.RED, Parameters.SPEED, starryRedSpeed.getValue());
				parms.setStarryElement(Parameters.GREEN, Parameters.MIN, starryGreenMin.getValue());
				parms.setStarryElement(Parameters.GREEN, Parameters.MAX, starryGreenMax.getValue());
				parms.setStarryElement(Parameters.GREEN, Parameters.SPEED, starryGreenSpeed.getValue());
				parms.setStarryElement(Parameters.BLUE, Parameters.MIN, starryBlueMin.getValue());
				parms.setStarryElement(Parameters.BLUE, Parameters.MAX, starryBlueMax.getValue());
				parms.setStarryElement(Parameters.BLUE, Parameters.SPEED, starryBlueSpeed.getValue());
				parms.setLightsElement(Parameters.RED, Parameters.MIN, lightsRedMin.getValue());
				parms.setLightsElement(Parameters.RED, Parameters.MAX, lightsRedMax.getValue());
				parms.setLightsElement(Parameters.RED, Parameters.SPEED, lightsRedSpeed.getValue());
				parms.setLightsElement(Parameters.GREEN, Parameters.MIN, lightsGreenMin.getValue());
				parms.setLightsElement(Parameters.GREEN, Parameters.MAX, lightsGreenMax.getValue());
				parms.setLightsElement(Parameters.GREEN, Parameters.SPEED, lightsGreenSpeed.getValue());
				parms.setLightsElement(Parameters.BLUE, Parameters.MIN, lightsBlueMin.getValue());
				parms.setLightsElement(Parameters.BLUE, Parameters.MAX, lightsBlueMax.getValue());
				parms.setLightsElement(Parameters.BLUE, Parameters.SPEED, lightsBlueSpeed.getValue());
				parms.setHumidity((int)humidity.getValue());
				parms.setTemperature((int)temperature.getValue());
				parms.setTimer((int)timer.getValue());
				parms.save();
				if (keyb != null)
					keyb.dispose();
				((JPanel) v.getFrame("mw")).setVisible(true);
				setVisible(false);
			}
		});
		
		add(btnSave);
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.DARK_GRAY);
		btnCancel.setBackground(Color.WHITE);
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if (keyb != null)
					keyb.dispose();
				((JPanel) v.getFrame("mw")).setVisible(true);
				setVisible(false);
			}
		});
		btnCancel.setFont(new Font("Arsenal", Font.BOLD, 14));
		btnCancel.setBounds(405, 982, 117, 25);
		add(btnCancel);		
		
		JLabel label_10 = new JLabel("R");
		label_10.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_10.setBounds(59, 223, 20, 30);
		add(label_10);
		
		JLabel label_11 = new JLabel("G");
		label_11.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_11.setBounds(59, 259, 20, 30);
		add(label_11);
		
		JLabel label_12 = new JLabel("B");
		label_12.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_12.setBounds(59, 295, 20, 30);
		add(label_12);
		
		JLabel label_13 = new JLabel("R");
		label_13.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_13.setBounds(59, 355, 20, 30);
		add(label_13);
		
		JLabel label_14 = new JLabel("G");
		label_14.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_14.setBounds(59, 391, 20, 30);
		add(label_14);
		
		JLabel label_15 = new JLabel("B");
		label_15.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_15.setBounds(59, 427, 20, 30);
		add(label_15);
		
		JLabel label_16 = new JLabel("R");
		label_16.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_16.setBounds(365, 93, 20, 30);
		add(label_16);
		
		JLabel label_17 = new JLabel("G");
		label_17.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_17.setBounds(365, 129, 20, 30);
		add(label_17);
		
		JLabel label_18 = new JLabel("B");
		label_18.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_18.setBounds(365, 165, 20, 30);
		add(label_18);
		
		JLabel label_19 = new JLabel("R");
		label_19.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_19.setBounds(365, 221, 20, 30);
		add(label_19);
		
		JLabel label_20 = new JLabel("G");
		label_20.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_20.setBounds(365, 257, 20, 30);
		add(label_20);
		
		JLabel label_21 = new JLabel("B");
		label_21.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_21.setBounds(365, 293, 20, 30);
		add(label_21);
		
		JLabel label_22 = new JLabel("R");
		label_22.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_22.setBounds(365, 353, 20, 30);
		add(label_22);
		
		JLabel label_23 = new JLabel("G");
		label_23.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_23.setBounds(365, 389, 20, 30);
		add(label_23);
		
		JLabel label_24 = new JLabel("B");
		label_24.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_24.setBounds(365, 425, 20, 30);
		add(label_24);
	}
	
	private Component findComponentByName(String name)
	{
		for (Component item : getComponents())
		{
			if ((item.getName() != null) && (item.getName().compareTo(name) == 0))
			{
				return(item);
			}
		}	
		return(null);
	}
	

	public void stateChanged(ChangeEvent e) 
	{
		if (e.getSource().getClass().getName().compareTo("javax.swing.JSlider") == 0)
		{
			JSlider source = (JSlider)e.getSource();
			JTextField value = (JTextField) findComponentByName(source.getName() + "Val");
			if (value != null)
			{
				value.setText(String.valueOf(source.getValue()));
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		JTextField source = (JTextField)e.getSource();
		JSlider value = (JSlider) findComponentByName(source.getName().replaceAll("Val", ""));
		if (value != null)
		{
			value.setValue(Integer.parseInt(source.getText()));
		}
		if (keyb != null)
		{
			keyb.dispose();
			keyb = null;
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource().getClass().getName().compareTo("javax.swing.JTextField") == 0)
		{
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
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (e.getSource().getClass().getName().compareTo("javax.swing.JTextField") == 0)
		{
			JTextField source = (JTextField)e.getSource();
			JSlider value = (JSlider) findComponentByName(source.getName().replaceAll("Val", ""));
			if (value != null)
			{
				value.setValue(Integer.parseInt(source.getText()));
			}
			if (keyb != null)
				keyb.dispose();
		}
	}	
}
