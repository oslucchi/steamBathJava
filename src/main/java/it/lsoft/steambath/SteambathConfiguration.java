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
	private JTextField starryRedTmrHoursVal;
	private JTextField starryGreenTmrHoursVal;
	private JTextField starryBlueTmrHoursVal;
	private JTextField starryRedTmrMinsVal;
	private JTextField starryGreenTmrMinsVal;
	private JTextField starryBlueTmrMinsVal;
	private JTextField starryRedTmrSecsVal;
	private JTextField starryGreenTmrSecsVal;
	private JTextField starryBlueTmrSecsVal;
	private JTextField starryRedTmrMilsVal;
	private JTextField starryGreenTmrMilsVal;
	private JTextField starryBlueTmrMilsVal;
	private JTextField lightsRedTmrHoursVal;
	private JTextField lightsGreenTmrHoursVal;
	private JTextField lightsBlueTmrHoursVal;
	private JTextField lightsRedTmrMinsVal;
	private JTextField lightsGreenTmrMinsVal;
	private JTextField lightsBlueTmrMinsVal;
	private JTextField lightsRedTmrSecsVal;
	private JTextField lightsGreenTmrSecsVal;
	private JTextField lightsBlueTmrSecsVal;
	private JTextField lightsRedTmrMilsVal;
	private JTextField lightsGreenTmrMilsVal;
	private JTextField lightsBlueTmrMilsVal;
	
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
		lblStarrysky.setBackground(Color.WHITE);
		lblStarrysky.setForeground(Color.DARK_GRAY);
		lblStarrysky.setFont(new Font("Arsenal", Font.BOLD, 24));
		lblStarrysky.setBounds(96, 51, 109, 32);
		add(lblStarrysky);
		
		JLabel lblMin = new JLabel("min");
		lblMin.setBackground(Color.WHITE);
		lblMin.setForeground(Color.DARK_GRAY);
		lblMin.setFont(new Font("Arsenal", Font.BOLD, 16));
		lblMin.setBounds(12, 139, 35, 15);
		add(lblMin);
		
		JLabel lblMax = new JLabel("MAX");
		lblMax.setBackground(Color.WHITE);
		lblMax.setForeground(Color.DARK_GRAY);
		lblMax.setFont(new Font("Arsenal", Font.BOLD, 16));
		lblMax.setBounds(12, 259, 35, 15);
		add(lblMax);
		
		JLabel lblSpeed = new JLabel("Speed");
		lblSpeed.setBackground(Color.WHITE);
		lblSpeed.setForeground(Color.DARK_GRAY);
		lblSpeed.setFont(new Font("Arsenal", Font.BOLD, 16));
		lblSpeed.setBounds(12, 394, 51, 25);
		add(lblSpeed);
		
		JLabel lblStarryRed = new JLabel("R");
		lblStarryRed.setBackground(Color.WHITE);
		lblStarryRed.setForeground(Color.DARK_GRAY);
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
		starryRedSpeed.setMinimum(1);
		starryRedSpeed.setMaximum(5);
		starryRedSpeed.setName("starryRedSpeed");
		starryRedSpeed.setValue(parms.getStarry()[Parameters.RED][Parameters.SPEED]);
		starryRedSpeed.addChangeListener(this);
		add(starryRedSpeed);
		
		JLabel lblGreen = new JLabel("G");
		lblGreen.setBackground(Color.WHITE);
		lblGreen.setForeground(Color.DARK_GRAY);
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
		starryGreenSpeed.setMinimum(1);
		starryGreenSpeed.setMaximum(5);
		starryGreenSpeed.setName("starryGreenSpeed");
		starryGreenSpeed.setValue(parms.getStarry()[Parameters.GREEN][Parameters.SPEED]);
		starryGreenSpeed.addChangeListener(this);
		add(starryGreenSpeed);
		
		JLabel lblBlue = new JLabel("B");
		lblBlue.setBackground(Color.WHITE);
		lblBlue.setForeground(Color.DARK_GRAY);
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
		starryBlueSpeed.setMinimum(1);
		starryBlueSpeed.setMaximum(5);
		starryBlueSpeed.setName("starryBlueSpeed");
		starryBlueSpeed.setValue(parms.getStarry()[Parameters.BLUE][Parameters.SPEED]);
		starryBlueSpeed.addChangeListener(this);
		add(starryBlueSpeed);
		
		starryRedMinVal = new JTextField();
		starryRedMinVal.setForeground(Color.DARK_GRAY);
		starryRedMinVal.setBackground(Color.WHITE);
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
		starryGreenMinVal.setForeground(Color.DARK_GRAY);
		starryGreenMinVal.setBackground(Color.WHITE);
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
		starryBlueMinVal.setForeground(Color.DARK_GRAY);
		starryBlueMinVal.setBackground(Color.WHITE);
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
		starryRedMaxVal.setForeground(Color.DARK_GRAY);
		starryRedMaxVal.setBackground(Color.WHITE);
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
		starryGreenMaxVal.setForeground(Color.DARK_GRAY);
		starryGreenMaxVal.setBackground(Color.WHITE);
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
		starryBlueMaxVal.setForeground(Color.DARK_GRAY);
		starryBlueMaxVal.setBackground(Color.WHITE);
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
		starryRedSpeedVal.setForeground(Color.DARK_GRAY);
		starryRedSpeedVal.setBackground(Color.WHITE);
		starryRedSpeedVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryRedSpeedVal.setName("starryRedSpeedVal");
		starryRedSpeedVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		starryRedSpeedVal.setColumns(10);
		starryRedSpeedVal.setBounds(218, 353, 50, 34);
		starryRedSpeedVal.setText(String.valueOf(parms.getStarry()[Parameters.RED][Parameters.SPEED]));
		starryRedSpeedVal.addActionListener(this);
		starryRedSpeedVal.addFocusListener(this);
		add(starryRedSpeedVal);
		
		starryGreenSpeedVal = new JTextField();
		starryGreenSpeedVal.setForeground(Color.DARK_GRAY);
		starryGreenSpeedVal.setBackground(Color.WHITE);
		starryGreenSpeedVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryGreenSpeedVal.setName("starryGreenSpeedVal");
		starryGreenSpeedVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		starryGreenSpeedVal.setColumns(10);
		starryGreenSpeedVal.setBounds(218, 389, 50, 34);
		starryGreenSpeedVal.setText(String.valueOf(parms.getStarry()[Parameters.GREEN][Parameters.SPEED]));
		starryGreenSpeedVal.addActionListener(this);
		starryGreenSpeedVal.addFocusListener(this);
		add(starryGreenSpeedVal);
		
		starryBlueSpeedVal = new JTextField();
		starryBlueSpeedVal.setForeground(Color.DARK_GRAY);
		starryBlueSpeedVal.setBackground(Color.WHITE);
		starryBlueSpeedVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryBlueSpeedVal.setName("starryBlueSpeedVal");
		starryBlueSpeedVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		starryBlueSpeedVal.setColumns(10);
		starryBlueSpeedVal.setBounds(218, 425, 50, 34);
		starryBlueSpeedVal.setText(String.valueOf(parms.getStarry()[Parameters.BLUE][Parameters.SPEED]));
		starryBlueSpeedVal.addActionListener(this);
		starryBlueSpeedVal.addFocusListener(this);
		add(starryBlueSpeedVal);
		
		JLabel lblCabinLights = new JLabel("Cabin lights");
		lblCabinLights.setBackground(Color.WHITE);
		lblCabinLights.setForeground(Color.DARK_GRAY);
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
		lightsRedSpeed.setMinimum(1);
		lightsRedSpeed.setMaximum(5);
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
		lightsGreenSpeed.setMinimum(1);
		lightsGreenSpeed.setMaximum(5);
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
		lightsBlueSpeed.setMinimum(1);
		lightsBlueSpeed.setMaximum(5);
		lightsBlueSpeed.setName("lightsBlueSpeed");
		lightsBlueSpeed.setValue(parms.getLights()[Parameters.BLUE][Parameters.SPEED]);
		lightsBlueSpeed.addChangeListener(this);
		add(lightsBlueSpeed);
		
		lightsRedMinVal = new JTextField();
		lightsRedMinVal.setForeground(Color.DARK_GRAY);
		lightsRedMinVal.setBackground(Color.WHITE);
		lightsRedMinVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsRedMinVal.setName("lightsRedMinVal");
		lightsRedMinVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lightsRedMinVal.setColumns(10);
		lightsRedMinVal.setBounds(524, 93, 40, 34);
		lightsRedMinVal.setText(String.valueOf(parms.getLights()[Parameters.RED][Parameters.MIN]));
		lightsRedMinVal.addActionListener(this);
		lightsRedMinVal.addFocusListener(this);
		add(lightsRedMinVal);
		
		lightsGreenMinVal = new JTextField();
		lightsGreenMinVal.setForeground(Color.DARK_GRAY);
		lightsGreenMinVal.setBackground(Color.WHITE);
		lightsGreenMinVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsGreenMinVal.setName("lightsGreenMinVal");
		lightsGreenMinVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lightsGreenMinVal.setColumns(10);
		lightsGreenMinVal.setBounds(524, 129, 40, 34);
		lightsGreenMinVal.setText(String.valueOf(parms.getLights()[Parameters.GREEN][Parameters.MIN]));
		lightsGreenMinVal.addActionListener(this);
		lightsGreenMinVal.addFocusListener(this);
		add(lightsGreenMinVal);
		
		lightsBlueMinVal = new JTextField();
		lightsBlueMinVal.setForeground(Color.DARK_GRAY);
		lightsBlueMinVal.setBackground(Color.WHITE);
		lightsBlueMinVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsBlueMinVal.setName("lightsBlueMinVal");
		lightsBlueMinVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lightsBlueMinVal.setColumns(10);
		lightsBlueMinVal.setBounds(524, 165, 40, 34);
		lightsBlueMinVal.setText(String.valueOf(parms.getLights()[Parameters.BLUE][Parameters.MIN]));
		lightsBlueMinVal.addActionListener(this);
		lightsBlueMinVal.addFocusListener(this);
		add(lightsBlueMinVal);
		
		lightsRedMaxVal = new JTextField();
		lightsRedMaxVal.setForeground(Color.DARK_GRAY);
		lightsRedMaxVal.setBackground(Color.WHITE);
		lightsRedMaxVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsRedMaxVal.setName("lightsRedMaxVal");
		lightsRedMaxVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lightsRedMaxVal.setColumns(10);
		lightsRedMaxVal.setBounds(524, 221, 40, 34);
		lightsRedMaxVal.setText(String.valueOf(parms.getLights()[Parameters.RED][Parameters.MAX]));
		lightsRedMaxVal.addActionListener(this);
		lightsRedMaxVal.addFocusListener(this);
		add(lightsRedMaxVal);
		
		lightsGreenMaxVal = new JTextField();
		lightsGreenMaxVal.setForeground(Color.DARK_GRAY);
		lightsGreenMaxVal.setBackground(Color.WHITE);
		lightsGreenMaxVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsGreenMaxVal.setName("lightsGreenMaxVal");
		lightsGreenMaxVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lightsGreenMaxVal.setColumns(10);
		lightsGreenMaxVal.setBounds(524, 257, 40, 34);
		lightsGreenMaxVal.setText(String.valueOf(parms.getLights()[Parameters.GREEN][Parameters.MAX]));
		lightsGreenMaxVal.addActionListener(this);
		lightsGreenMaxVal.addFocusListener(this);
		add(lightsGreenMaxVal);
		
		lightsBlueMaxVal = new JTextField();
		lightsBlueMaxVal.setForeground(Color.DARK_GRAY);
		lightsBlueMaxVal.setBackground(Color.WHITE);
		lightsBlueMaxVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsBlueMaxVal.setName("lightsBlueMaxVal");
		lightsBlueMaxVal.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lightsBlueMaxVal.setColumns(10);
		lightsBlueMaxVal.setBounds(524, 293, 40, 34);
		lightsBlueMaxVal.setText(String.valueOf(parms.getLights()[Parameters.BLUE][Parameters.MAX]));
		lightsBlueMaxVal.addActionListener(this);
		lightsBlueMaxVal.addFocusListener(this);
		add(lightsBlueMaxVal);
		
		lightsRedSpeedVal = new JTextField();
		lightsRedSpeedVal.setForeground(Color.DARK_GRAY);
		lightsRedSpeedVal.setBackground(Color.WHITE);
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
		lightsGreenSpeedVal.setForeground(Color.DARK_GRAY);
		lightsGreenSpeedVal.setBackground(Color.WHITE);
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
		lightsBlueSpeedVal.setForeground(Color.DARK_GRAY);
		lightsBlueSpeedVal.setBackground(Color.WHITE);
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
		lblVapor.setBackground(Color.WHITE);
		lblVapor.setForeground(Color.DARK_GRAY);
		lblVapor.setFont(new Font("Arsenal", Font.BOLD, 24));
		lblVapor.setBounds(233, 653, 140, 32);
		add(lblVapor);
		
		JLabel lblHumidity = new JLabel("Humidity");
		lblHumidity.setBackground(Color.WHITE);
		lblHumidity.setForeground(Color.DARK_GRAY);
		lblHumidity.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lblHumidity.setBounds(41, 693, 81, 32);
		add(lblHumidity);
		
		JLabel lblTemperature = new JLabel("Temperature");
		lblTemperature.setBackground(Color.WHITE);
		lblTemperature.setForeground(Color.DARK_GRAY);
		lblTemperature.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lblTemperature.setBounds(220, 693, 99, 32);
		add(lblTemperature);
		
		JLabel lblNewLabel = new JLabel("%");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Arsenal", Font.PLAIN, 12));
		lblNewLabel.setBounds(180, 700, 35, 15);
		add(lblNewLabel);
		
		JLabel lblC = new JLabel("C°");
		lblC.setBackground(Color.WHITE);
		lblC.setForeground(Color.DARK_GRAY);
		lblC.setFont(new Font("Arsenal", Font.PLAIN, 14));
		lblC.setBounds(394, 700, 28, 15);
		add(lblC);
		
		JLabel lblTimer = new JLabel("Timer");
		lblTimer.setBackground(Color.WHITE);
		lblTimer.setForeground(Color.DARK_GRAY);
		lblTimer.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lblTimer.setBounds(445, 693, 51, 32);
		add(lblTimer);
		
		JLabel lblMin_1 = new JLabel("min");
		lblMin_1.setBackground(Color.WHITE);
		lblMin_1.setForeground(Color.DARK_GRAY);
		lblMin_1.setFont(new Font("Arsenal", Font.PLAIN, 14));
		lblMin_1.setBounds(544, 700, 35, 15);
		add(lblMin_1);
		
		JLabel lblMusic = new JLabel("Music");
		lblMusic.setFont(new Font("Arsenal", Font.BOLD, 24));
		lblMusic.setBounds(259, 735, 70, 32);
		add(lblMusic);
		
		JLabel lblSteamBathConfigration = new JLabel("Steam bath configuration");
		lblSteamBathConfigration.setBackground(Color.WHITE);
		lblSteamBathConfigration.setForeground(Color.DARK_GRAY);
		lblSteamBathConfigration.setHorizontalAlignment(SwingConstants.CENTER);
		lblSteamBathConfigration.setFont(new Font("Arsenal", Font.BOLD, 32));
		lblSteamBathConfigration.setBounds(110, 1, 372, 45);
		add(lblSteamBathConfigration);
		
		JSpinner timer = new JSpinner();
		timer.setForeground(Color.DARK_GRAY);
		timer.setBackground(Color.WHITE);
		timer.setFont(new Font("Arsenal", Font.PLAIN, 18));
		timer.setBounds(488, 693, 51, 32);
		timer.setValue(parms.getHumidity());
		add(timer);
		
		JSpinner humidity = new JSpinner();
		humidity.setForeground(Color.DARK_GRAY);
		humidity.setBackground(Color.WHITE);
		humidity.setFont(new Font("Arsenal", Font.PLAIN, 18));
		humidity.setBounds(105, 693, 70, 32);
		humidity.setValue(parms.getTemperature());
		add(humidity);
		
		JSpinner temperature = new JSpinner();
		temperature.setForeground(Color.DARK_GRAY);
		temperature.setBackground(Color.WHITE);
		temperature.setFont(new Font("Arsenal", Font.PLAIN, 18));
		temperature.setBounds(320, 693, 70, 32);
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
		label_10.setBackground(Color.WHITE);
		label_10.setForeground(Color.DARK_GRAY);
		label_10.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_10.setBounds(59, 223, 20, 30);
		add(label_10);
		
		JLabel label_11 = new JLabel("G");
		label_11.setBackground(Color.WHITE);
		label_11.setForeground(Color.DARK_GRAY);
		label_11.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_11.setBounds(59, 259, 20, 30);
		add(label_11);
		
		JLabel label_12 = new JLabel("B");
		label_12.setBackground(Color.WHITE);
		label_12.setForeground(Color.DARK_GRAY);
		label_12.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_12.setBounds(59, 295, 20, 30);
		add(label_12);
		
		JLabel label_13 = new JLabel("R");
		label_13.setBackground(Color.WHITE);
		label_13.setForeground(Color.DARK_GRAY);
		label_13.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_13.setBounds(59, 355, 20, 30);
		add(label_13);
		
		JLabel label_14 = new JLabel("G");
		label_14.setBackground(Color.WHITE);
		label_14.setForeground(Color.DARK_GRAY);
		label_14.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_14.setBounds(59, 391, 20, 30);
		add(label_14);
		
		JLabel label_15 = new JLabel("B");
		label_15.setBackground(Color.WHITE);
		label_15.setForeground(Color.DARK_GRAY);
		label_15.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_15.setBounds(59, 427, 20, 30);
		add(label_15);
		
		JLabel label_16 = new JLabel("R");
		label_16.setBackground(Color.WHITE);
		label_16.setForeground(Color.DARK_GRAY);
		label_16.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_16.setBounds(365, 93, 20, 30);
		add(label_16);
		
		JLabel label_17 = new JLabel("G");
		label_17.setBackground(Color.WHITE);
		label_17.setForeground(Color.DARK_GRAY);
		label_17.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_17.setBounds(365, 129, 20, 30);
		add(label_17);
		
		JLabel label_18 = new JLabel("B");
		label_18.setBackground(Color.WHITE);
		label_18.setForeground(Color.DARK_GRAY);
		label_18.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_18.setBounds(365, 165, 20, 30);
		add(label_18);
		
		JLabel label_19 = new JLabel("R");
		label_19.setBackground(Color.WHITE);
		label_19.setForeground(Color.DARK_GRAY);
		label_19.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_19.setBounds(365, 221, 20, 30);
		add(label_19);
		
		JLabel label_20 = new JLabel("G");
		label_20.setBackground(Color.WHITE);
		label_20.setForeground(Color.DARK_GRAY);
		label_20.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_20.setBounds(365, 257, 20, 30);
		add(label_20);
		
		JLabel label_21 = new JLabel("B");
		label_21.setBackground(Color.WHITE);
		label_21.setForeground(Color.DARK_GRAY);
		label_21.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_21.setBounds(365, 293, 20, 30);
		add(label_21);
		
		JLabel label_22 = new JLabel("R");
		label_22.setBackground(Color.WHITE);
		label_22.setForeground(Color.DARK_GRAY);
		label_22.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_22.setBounds(365, 353, 20, 30);
		add(label_22);
		
		JLabel label_23 = new JLabel("G");
		label_23.setBackground(Color.WHITE);
		label_23.setForeground(Color.DARK_GRAY);
		label_23.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_23.setBounds(365, 389, 20, 30);
		add(label_23);
		
		JLabel label_24 = new JLabel("B");
		label_24.setBackground(Color.WHITE);
		label_24.setForeground(Color.DARK_GRAY);
		label_24.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_24.setBounds(365, 425, 20, 30);
		add(label_24);
		
		JLabel lblTimers = new JLabel("Timers");
		lblTimers.setForeground(Color.DARK_GRAY);
		lblTimers.setFont(new Font("Arsenal", Font.BOLD, 16));
		lblTimers.setBackground(Color.WHITE);
		lblTimers.setBounds(12, 534, 51, 25);
		add(lblTimers);
		
		JLabel label_1 = new JLabel("R");
		label_1.setForeground(Color.DARK_GRAY);
		label_1.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(59, 495, 20, 30);
		add(label_1);
		
		JLabel label_2 = new JLabel("G");
		label_2.setForeground(Color.DARK_GRAY);
		label_2.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(59, 531, 20, 30);
		add(label_2);
		
		JLabel label_3 = new JLabel("B");
		label_3.setForeground(Color.DARK_GRAY);
		label_3.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_3.setBackground(Color.WHITE);
		label_3.setBounds(59, 571, 20, 30);
		add(label_3);
		
		starryRedTmrHoursVal = new JTextField();
		starryRedTmrHoursVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryRedTmrHoursVal.setBounds(76, 500, 40, 28);
		add(starryRedTmrHoursVal);
		starryRedTmrHoursVal.setName("starryRedTmrHours");
		starryRedTmrHoursVal.setColumns(10);
		starryRedTmrHoursVal.setText(String.valueOf(parms.getStarryTimers()[Parameters.RED][Parameters.HOURS]));
		starryRedTmrHoursVal.addActionListener(this);
		starryRedTmrHoursVal.addFocusListener(this);
		
		starryGreenTmrHoursVal = new JTextField();
		starryGreenTmrHoursVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryGreenTmrHoursVal.setColumns(10);
		starryGreenTmrHoursVal.setBounds(76, 536, 40, 28);
		add(starryGreenTmrHoursVal);
		starryGreenTmrHoursVal.setName("starryGreenTmrHours");
		starryGreenTmrHoursVal.setText(String.valueOf(parms.getStarryTimers()[Parameters.GREEN][Parameters.HOURS]));
		starryGreenTmrHoursVal.addActionListener(this);
		starryGreenTmrHoursVal.addFocusListener(this);
		
		starryBlueTmrHoursVal = new JTextField();
		starryBlueTmrHoursVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryBlueTmrHoursVal.setColumns(10);
		starryBlueTmrHoursVal.setBounds(76, 572, 40, 28);
		add(starryBlueTmrHoursVal);
		starryBlueTmrHoursVal.setName("starryBlueTmrHours");
		starryBlueTmrHoursVal.setText(String.valueOf(parms.getStarryTimers()[Parameters.BLUE][Parameters.HOURS]));
		starryBlueTmrHoursVal.addActionListener(this);
		starryBlueTmrHoursVal.addFocusListener(this);
		
		starryRedTmrMinsVal = new JTextField();
		starryRedTmrMinsVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryRedTmrMinsVal.setColumns(10);
		starryRedTmrMinsVal.setBounds(128, 500, 40, 28);
		add(starryRedTmrMinsVal);
		starryRedTmrMinsVal.setName("starryRedTmrMins");
		starryRedTmrMinsVal.setText(String.valueOf(parms.getStarryTimers()[Parameters.RED][Parameters.MINS]));
		starryRedTmrMinsVal.addActionListener(this);
		starryRedTmrMinsVal.addFocusListener(this);
		
		starryGreenTmrMinsVal = new JTextField();
		starryGreenTmrMinsVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryGreenTmrMinsVal.setColumns(10);
		starryGreenTmrMinsVal.setBounds(128, 536, 40, 28);
		add(starryGreenTmrMinsVal);
		starryGreenTmrMinsVal.setName("starryGreenTmrMins");
		starryGreenTmrMinsVal.setText(String.valueOf(parms.getStarryTimers()[Parameters.GREEN][Parameters.MINS]));
		starryGreenTmrMinsVal.addActionListener(this);
		starryGreenTmrMinsVal.addFocusListener(this);
		
		starryBlueTmrMinsVal = new JTextField();
		starryBlueTmrMinsVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryBlueTmrMinsVal.setColumns(10);
		starryBlueTmrMinsVal.setBounds(128, 572, 40, 28);
		add(starryBlueTmrMinsVal);
		starryBlueTmrMinsVal.setName("starryBlueTmrMins");
		starryBlueTmrMinsVal.setText(String.valueOf(parms.getStarryTimers()[Parameters.BLUE][Parameters.MINS]));
		starryBlueTmrMinsVal.addActionListener(this);
		starryBlueTmrMinsVal.addFocusListener(this);
		
		starryRedTmrSecsVal = new JTextField();
		starryRedTmrSecsVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryRedTmrSecsVal.setColumns(10);
		starryRedTmrSecsVal.setBounds(180, 500, 40, 28);
		add(starryRedTmrSecsVal);
		starryRedTmrSecsVal.setName("starryRedTmrSecs");
		starryRedTmrSecsVal.setText(String.valueOf(parms.getStarryTimers()[Parameters.RED][Parameters.SECS]));
		starryRedTmrSecsVal.addActionListener(this);
		starryRedTmrSecsVal.addFocusListener(this);
		
		starryGreenTmrSecsVal = new JTextField();
		starryGreenTmrSecsVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryGreenTmrSecsVal.setColumns(10);
		starryGreenTmrSecsVal.setBounds(180, 536, 40, 28);
		add(starryGreenTmrSecsVal);
		starryGreenTmrSecsVal.setName("starryGreenTmrSecs");
		starryGreenTmrSecsVal.setText(String.valueOf(parms.getStarryTimers()[Parameters.GREEN][Parameters.SECS]));
		starryGreenTmrSecsVal.addActionListener(this);
		starryGreenTmrSecsVal.addFocusListener(this);
		
		starryBlueTmrSecsVal = new JTextField();
		starryBlueTmrSecsVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryBlueTmrSecsVal.setColumns(10);
		starryBlueTmrSecsVal.setBounds(180, 572, 40, 28);
		add(starryBlueTmrSecsVal);
		starryBlueTmrSecsVal.setName("starryBlueTmrSecs");
		starryBlueTmrSecsVal.setText(String.valueOf(parms.getStarryTimers()[Parameters.BLUE][Parameters.SECS]));
		starryBlueTmrSecsVal.addActionListener(this);
		starryBlueTmrSecsVal.addFocusListener(this);
		
		starryRedTmrMilsVal = new JTextField();
		starryRedTmrMilsVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryRedTmrMilsVal.setColumns(10);
		starryRedTmrMilsVal.setBounds(233, 500, 40, 28);
		add(starryRedTmrMilsVal);
		starryRedTmrMilsVal.setName("starryRedTmrMils");
		starryRedTmrMilsVal.setText(String.valueOf(parms.getStarryTimers()[Parameters.RED][Parameters.TENTH_OF_MILS]));
		starryRedTmrMilsVal.addActionListener(this);
		starryRedTmrMilsVal.addFocusListener(this);
		
		starryGreenTmrMilsVal = new JTextField();
		starryGreenTmrMilsVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryGreenTmrMilsVal.setColumns(10);
		starryGreenTmrMilsVal.setBounds(233, 536, 40, 28);
		add(starryGreenTmrMilsVal);
		starryGreenTmrMilsVal.setName("starryGreenTmrMils");
		starryGreenTmrMilsVal.setText(String.valueOf(parms.getStarryTimers()[Parameters.GREEN][Parameters.TENTH_OF_MILS]));
		starryGreenTmrMilsVal.addActionListener(this);
		starryGreenTmrMilsVal.addFocusListener(this);
		
		starryBlueTmrMilsVal = new JTextField();
		starryBlueTmrMilsVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryBlueTmrMilsVal.setColumns(10);
		starryBlueTmrMilsVal.setBounds(233, 572, 40, 28);
		add(starryBlueTmrMilsVal);
		starryBlueTmrMilsVal.setName("starryBlueTmrMils");
		starryBlueTmrMilsVal.setText(String.valueOf(parms.getStarryTimers()[Parameters.BLUE][Parameters.TENTH_OF_MILS]));
		starryBlueTmrMilsVal.addActionListener(this);
		starryBlueTmrMilsVal.addFocusListener(this);
		
		JLabel lblHour = new JLabel("Hour");
		lblHour.setForeground(Color.DARK_GRAY);
		lblHour.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lblHour.setBackground(Color.WHITE);
		lblHour.setBounds(76, 469, 38, 30);
		add(lblHour);
		
		JLabel lblMins = new JLabel("Mins");
		lblMins.setForeground(Color.DARK_GRAY);
		lblMins.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lblMins.setBackground(Color.WHITE);
		lblMins.setBounds(128, 469, 38, 30);
		add(lblMins);
		
		JLabel lblSecs = new JLabel("Secs");
		lblSecs.setForeground(Color.DARK_GRAY);
		lblSecs.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lblSecs.setBackground(Color.WHITE);
		lblSecs.setBounds(182, 469, 38, 30);
		add(lblSecs);
		
		JLabel lblMills = new JLabel("Mils");
		lblMills.setForeground(Color.DARK_GRAY);
		lblMills.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lblMills.setBackground(Color.WHITE);
		lblMills.setBounds(235, 471, 38, 30);
		add(lblMills);
		
		JLabel label = new JLabel("R");
		label.setForeground(Color.DARK_GRAY);
		label.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label.setBackground(Color.WHITE);
		label.setBounds(365, 495, 20, 30);
		add(label);
		
		JLabel label_4 = new JLabel("G");
		label_4.setForeground(Color.DARK_GRAY);
		label_4.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_4.setBackground(Color.WHITE);
		label_4.setBounds(365, 531, 20, 30);
		add(label_4);
		
		JLabel label_5 = new JLabel("B");
		label_5.setForeground(Color.DARK_GRAY);
		label_5.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_5.setBackground(Color.WHITE);
		label_5.setBounds(365, 571, 20, 30);
		add(label_5);
		
		lightsRedTmrHoursVal = new JTextField();
		lightsRedTmrHoursVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsRedTmrHoursVal.setColumns(10);
		lightsRedTmrHoursVal.setBounds(382, 500, 40, 28);
		add(lightsRedTmrHoursVal);
		lightsRedTmrHoursVal.setName("lightsRedTmrHoursVal");
		lightsRedTmrHoursVal.setText(String.valueOf(parms.getLightsTimers()[Parameters.RED][Parameters.HOURS]));
		lightsRedTmrHoursVal.addActionListener(this);
		lightsRedTmrHoursVal.addFocusListener(this);
		
		lightsGreenTmrHoursVal = new JTextField();
		lightsGreenTmrHoursVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsGreenTmrHoursVal.setColumns(10);
		lightsGreenTmrHoursVal.setBounds(382, 536, 40, 28);
		add(lightsGreenTmrHoursVal);
		lightsGreenTmrHoursVal.setName("lightsGreenTmrHoursVal");
		lightsGreenTmrHoursVal.setText(String.valueOf(parms.getLightsTimers()[Parameters.GREEN][Parameters.HOURS]));
		lightsGreenTmrHoursVal.addActionListener(this);
		lightsGreenTmrHoursVal.addFocusListener(this);
		
		lightsBlueTmrHoursVal = new JTextField();
		lightsBlueTmrHoursVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsBlueTmrHoursVal.setColumns(10);
		lightsBlueTmrHoursVal.setBounds(382, 572, 40, 28);
		add(lightsBlueTmrHoursVal);
		lightsBlueTmrHoursVal.setName("lightsBlueTmrHoursVal");
		lightsBlueTmrHoursVal.setText(String.valueOf(parms.getLightsTimers()[Parameters.BLUE][Parameters.HOURS]));
		lightsBlueTmrHoursVal.addActionListener(this);
		lightsBlueTmrHoursVal.addFocusListener(this);
		
		lightsRedTmrMinsVal = new JTextField();
		lightsRedTmrMinsVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsRedTmrMinsVal.setColumns(10);
		lightsRedTmrMinsVal.setBounds(434, 500, 40, 28);
		add(lightsRedTmrMinsVal);
		lightsRedTmrMinsVal.setName("lightsRedTmrMinsVal");
		lightsRedTmrMinsVal.setText(String.valueOf(parms.getLightsTimers()[Parameters.RED][Parameters.MINS]));
		lightsRedTmrMinsVal.addActionListener(this);
		lightsRedTmrMinsVal.addFocusListener(this);
		
		lightsGreenTmrMinsVal = new JTextField();
		lightsGreenTmrMinsVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsGreenTmrMinsVal.setColumns(10);
		lightsGreenTmrMinsVal.setBounds(434, 536, 40, 28);
		add(lightsGreenTmrMinsVal);
		lightsGreenTmrMinsVal.setName("lightsGreenTmrMinsVal");
		lightsGreenTmrMinsVal.setText(String.valueOf(parms.getLightsTimers()[Parameters.GREEN][Parameters.MINS]));
		lightsGreenTmrMinsVal.addActionListener(this);
		lightsGreenTmrMinsVal.addFocusListener(this);
		
		lightsBlueTmrMinsVal = new JTextField();
		lightsBlueTmrMinsVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsBlueTmrMinsVal.setColumns(10);
		lightsBlueTmrMinsVal.setBounds(434, 572, 40, 28);
		add(lightsBlueTmrMinsVal);
		lightsBlueTmrMinsVal.setName("lightsBlueTmrMinsVal");
		lightsBlueTmrMinsVal.setText(String.valueOf(parms.getLightsTimers()[Parameters.BLUE][Parameters.MINS]));
		lightsBlueTmrMinsVal.addActionListener(this);
		lightsBlueTmrMinsVal.addFocusListener(this);
		
		lightsRedTmrSecsVal = new JTextField();
		lightsRedTmrSecsVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsRedTmrSecsVal.setColumns(10);
		lightsRedTmrSecsVal.setBounds(486, 500, 40, 28);
		add(lightsRedTmrSecsVal);
		lightsRedTmrSecsVal.setName("lightsRedTmrSecsVal");
		lightsRedTmrSecsVal.setText(String.valueOf(parms.getLightsTimers()[Parameters.RED][Parameters.SECS]));
		lightsRedTmrSecsVal.addActionListener(this);
		lightsRedTmrSecsVal.addFocusListener(this);
		
		lightsGreenTmrSecsVal = new JTextField();
		lightsGreenTmrSecsVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsGreenTmrSecsVal.setColumns(10);
		lightsGreenTmrSecsVal.setBounds(486, 536, 40, 28);
		add(lightsGreenTmrSecsVal);
		lightsGreenTmrSecsVal.setName("lightsGreenTmrSecsVal");
		lightsGreenTmrSecsVal.setText(String.valueOf(parms.getLightsTimers()[Parameters.GREEN][Parameters.SECS]));
		lightsGreenTmrSecsVal.addActionListener(this);
		lightsGreenTmrSecsVal.addFocusListener(this);
		
		lightsBlueTmrSecsVal = new JTextField();
		lightsBlueTmrSecsVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsBlueTmrSecsVal.setColumns(10);
		lightsBlueTmrSecsVal.setBounds(486, 572, 40, 28);
		add(lightsBlueTmrSecsVal);
		lightsBlueTmrSecsVal.setName("lightsBlueTmrSecsVal");
		lightsBlueTmrSecsVal.setText(String.valueOf(parms.getLightsTimers()[Parameters.BLUE][Parameters.SECS]));
		lightsBlueTmrSecsVal.addActionListener(this);
		lightsBlueTmrSecsVal.addFocusListener(this);
		
		lightsRedTmrMilsVal = new JTextField();
		lightsRedTmrMilsVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsRedTmrMilsVal.setColumns(10);
		lightsRedTmrMilsVal.setBounds(539, 500, 40, 28);
		add(lightsRedTmrMilsVal);
		lightsRedTmrMilsVal.setName("lightsRedTmrMilsVal");
		lightsRedTmrMilsVal.setText(String.valueOf(parms.getLightsTimers()[Parameters.RED][Parameters.TENTH_OF_MILS]));
		lightsRedTmrMilsVal.addActionListener(this);
		lightsRedTmrMilsVal.addFocusListener(this);
		
		lightsGreenTmrMilsVal = new JTextField();
		lightsGreenTmrMilsVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsGreenTmrMilsVal.setColumns(10);
		lightsGreenTmrMilsVal.setBounds(539, 536, 40, 28);
		add(lightsGreenTmrMilsVal);
		lightsGreenTmrMilsVal.setName("lightsGreenTmrMilsVal");
		lightsGreenTmrMilsVal.setText(String.valueOf(parms.getLightsTimers()[Parameters.GREEN][Parameters.TENTH_OF_MILS]));
		lightsGreenTmrMilsVal.addActionListener(this);
		lightsGreenTmrMilsVal.addFocusListener(this);
		
		lightsBlueTmrMilsVal = new JTextField();
		lightsBlueTmrMilsVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsBlueTmrMilsVal.setColumns(10);
		lightsBlueTmrMilsVal.setBounds(539, 572, 40, 28);
		add(lightsBlueTmrMilsVal);
		lightsBlueTmrMilsVal.setName("lightsBlueTmrMilsVal");
		lightsBlueTmrMilsVal.setText(String.valueOf(parms.getLightsTimers()[Parameters.BLUE][Parameters.TENTH_OF_MILS]));
		lightsBlueTmrMilsVal.addActionListener(this);
		lightsBlueTmrMilsVal.addFocusListener(this);
		
		JLabel label_6 = new JLabel("Hour");
		label_6.setForeground(Color.DARK_GRAY);
		label_6.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_6.setBackground(Color.WHITE);
		label_6.setBounds(382, 469, 38, 30);
		add(label_6);
		
		JLabel label_7 = new JLabel("Mins");
		label_7.setForeground(Color.DARK_GRAY);
		label_7.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_7.setBackground(Color.WHITE);
		label_7.setBounds(434, 469, 38, 30);
		add(label_7);
		
		JLabel label_8 = new JLabel("Secs");
		label_8.setForeground(Color.DARK_GRAY);
		label_8.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_8.setBackground(Color.WHITE);
		label_8.setBounds(488, 469, 38, 30);
		add(label_8);
		
		JLabel label_9 = new JLabel("Mils");
		label_9.setForeground(Color.DARK_GRAY);
		label_9.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_9.setBackground(Color.WHITE);
		label_9.setBounds(541, 471, 38, 30);
		add(label_9);
		
	}
	
	private Component findComponentByName(String name)
	{
		if (name == null)
			return(null);
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
		if (keyb != null)
		{
			keyb.dispose();
			keyb = null;
		}
		JTextField source = (JTextField)e.getSource();
		Object o = findComponentByName(source.getName().replaceAll("Val", ""));
		if (o.getClass().getName().compareTo("JSlider") == 0)
		{
			JSlider value = (JSlider) o;
			if (value != null)
			{
				value.setValue(Integer.parseInt(source.getText()));
			}
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
			Object o = findComponentByName(source.getName().replaceAll("Val", ""));
			if (o.getClass().getName().compareTo("JSlider") == 0)
			{
				JSlider value = (JSlider) o;
				if (value != null)
				{
					value.setValue(Integer.parseInt(source.getText()));
				}
			}
			if (keyb != null)
				keyb.dispose();
		}
	}	
}
