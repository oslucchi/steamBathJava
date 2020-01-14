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
	private JTextField fadeTmrAuto;
	private JTextField fadeTmrManual;
	private JTextField fadeLowerBoundRed;
	private JTextField fadeLowerBoundGreen;
	private JTextField fadeLowerBoundBlue;
	
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
		lblStarrysky.setBounds(120, 51, 151, 32);
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
		lblMax.setBounds(12, 259, 51, 15);
		add(lblMax);
		
		JLabel lblSpeed = new JLabel("Speed");
		lblSpeed.setBackground(Color.WHITE);
		lblSpeed.setForeground(Color.DARK_GRAY);
		lblSpeed.setFont(new Font("Arsenal", Font.BOLD, 16));
		lblSpeed.setBounds(12, 394, 72, 25);
		add(lblSpeed);
		
		JLabel lblStarryRed = new JLabel("R");
		lblStarryRed.setBackground(Color.WHITE);
		lblStarryRed.setForeground(Color.DARK_GRAY);
		lblStarryRed.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lblStarryRed.setBounds(84, 95, 20, 30);
		add(lblStarryRed);

		JSlider starryRedMin = new JSlider();
		starryRedMin.setForeground(Color.DARK_GRAY);
		starryRedMin.setBackground(Color.WHITE);
		starryRedMin.setBounds(101, 95, 140, 30);
		starryRedMin.setMinimum(0);
		starryRedMin.setMaximum(255);
		starryRedMin.setName("starryRedMin");
		starryRedMin.setValue(parms.getStarry()[Parameters.RED][Parameters.MIN]);
		starryRedMin.addChangeListener(this);
		add(starryRedMin);
		
		JSlider starryRedMax = new JSlider();
		starryRedMax.setForeground(Color.DARK_GRAY);
		starryRedMax.setBackground(Color.WHITE);
		starryRedMax.setBounds(102, 223, 140, 30);
		starryRedMax.setMinimum(0);
		starryRedMax.setMaximum(255);
		starryRedMax.setName("starryRedMax");
		starryRedMax.setValue(parms.getStarry()[Parameters.RED][Parameters.MAX]);
		starryRedMax.addChangeListener(this);
		add(starryRedMax);
		
		JSlider starryRedSpeed = new JSlider();
		starryRedSpeed.setForeground(Color.DARK_GRAY);
		starryRedSpeed.setBackground(Color.WHITE);
		starryRedSpeed.setBounds(102, 355, 140, 30);
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
		lblGreen.setBounds(84, 131, 20, 30);
		add(lblGreen);
		
		JSlider starryGreenMin = new JSlider();
		starryGreenMin.setForeground(Color.DARK_GRAY);
		starryGreenMin.setBackground(Color.WHITE);
		starryGreenMin.setBounds(102, 131, 140, 30);
		starryGreenMin.setMinimum(0);
		starryGreenMin.setMaximum(255);
		starryGreenMin.setName("starryGreenMin");
		starryGreenMin.setValue(parms.getStarry()[Parameters.GREEN][Parameters.MIN]);
		starryGreenMin.addChangeListener(this);
		add(starryGreenMin);
		
		JSlider starryGreenMax = new JSlider();
		starryGreenMax.setForeground(Color.DARK_GRAY);
		starryGreenMax.setBackground(Color.WHITE);
		starryGreenMax.setBounds(102, 259, 140, 30);
		starryGreenMax.setMinimum(0);
		starryGreenMax.setMaximum(255);
		starryGreenMax.setName("starryGreenMax");
		starryGreenMax.setValue(parms.getStarry()[Parameters.GREEN][Parameters.MAX]);
		starryGreenMax.addChangeListener(this);
		add(starryGreenMax);
		
		JSlider starryGreenSpeed = new JSlider();
		starryGreenSpeed.setForeground(Color.DARK_GRAY);
		starryGreenSpeed.setBackground(Color.WHITE);
		starryGreenSpeed.setBounds(102, 391, 140, 30);
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
		lblBlue.setBounds(84, 167, 20, 30);
		add(lblBlue);
		
		JSlider starryBlueMin = new JSlider();
		starryBlueMin.setForeground(Color.DARK_GRAY);
		starryBlueMin.setBackground(Color.WHITE);
		starryBlueMin.setBounds(102, 167, 140, 30);
		starryBlueMin.setMinimum(0);
		starryBlueMin.setMaximum(255);
		starryBlueMin.setName("starryBlueMin");
		starryBlueMin.setValue(parms.getStarry()[Parameters.BLUE][Parameters.MIN]);
		starryBlueMin.addChangeListener(this);
		add(starryBlueMin);
		
		JSlider starryBlueMax = new JSlider();
		starryBlueMax.setForeground(Color.DARK_GRAY);
		starryBlueMax.setBackground(Color.WHITE);
		starryBlueMax.setBounds(102, 295, 140, 30);
		starryBlueMax.setMinimum(0);
		starryBlueMax.setMaximum(255);
		starryBlueMax.setName("starryBlueMax");
		starryBlueMax.setValue(parms.getStarry()[Parameters.BLUE][Parameters.MAX]);
		starryBlueMax.addChangeListener(this);
		add(starryBlueMax);
		
		JSlider starryBlueSpeed = new JSlider();
		starryBlueSpeed.setForeground(Color.DARK_GRAY);
		starryBlueSpeed.setBackground(Color.WHITE);
		starryBlueSpeed.setBounds(102, 427, 140, 30);
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
		starryRedMinVal.setBounds(243, 93, 40, 34);
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
		starryGreenMinVal.setBounds(243, 129, 40, 34);
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
		starryBlueMinVal.setBounds(243, 165, 40, 34);
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
		starryRedMaxVal.setBounds(243, 221, 40, 34);
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
		starryGreenMaxVal.setBounds(243, 257, 40, 34);
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
		starryBlueMaxVal.setBounds(243, 293, 40, 34);
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
		starryRedSpeedVal.setBounds(243, 353, 50, 34);
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
		starryGreenSpeedVal.setBounds(243, 389, 50, 34);
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
		starryBlueSpeedVal.setBounds(243, 425, 50, 34);
		starryBlueSpeedVal.setText(String.valueOf(parms.getStarry()[Parameters.BLUE][Parameters.SPEED]));
		starryBlueSpeedVal.addActionListener(this);
		starryBlueSpeedVal.addFocusListener(this);
		add(starryBlueSpeedVal);
		
		JLabel lblCabinLights = new JLabel("Cabin lights");
		lblCabinLights.setBackground(Color.WHITE);
		lblCabinLights.setForeground(Color.DARK_GRAY);
		lblCabinLights.setFont(new Font("Arsenal", Font.BOLD, 24));
		lblCabinLights.setBounds(389, 51, 165, 32);
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
				
		JLabel lblVapor = new JLabel("Fade timer");
		lblVapor.setBackground(Color.WHITE);
		lblVapor.setForeground(Color.DARK_GRAY);
		lblVapor.setFont(new Font("Arsenal", Font.BOLD, 24));
		lblVapor.setBounds(228, 613, 157, 32);
		add(lblVapor);
		
		JLabel lblHumidity = new JLabel("Humidity");
		lblHumidity.setBackground(Color.WHITE);
		lblHumidity.setForeground(Color.DARK_GRAY);
		lblHumidity.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lblHumidity.setBounds(28, 778, 88, 32);
		add(lblHumidity);
		
		JLabel lblTemperature = new JLabel("Temperature");
		lblTemperature.setBackground(Color.WHITE);
		lblTemperature.setForeground(Color.DARK_GRAY);
		lblTemperature.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lblTemperature.setBounds(215, 778, 121, 32);
		add(lblTemperature);
		
		JLabel lblNewLabel = new JLabel("%");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Arsenal", Font.PLAIN, 12));
		lblNewLabel.setBounds(175, 785, 35, 15);
		add(lblNewLabel);
		
		JLabel lblC = new JLabel("C°");
		lblC.setBackground(Color.WHITE);
		lblC.setForeground(Color.DARK_GRAY);
		lblC.setFont(new Font("Arsenal", Font.PLAIN, 14));
		lblC.setBounds(389, 785, 28, 15);
		add(lblC);
		
		JLabel lblTimer = new JLabel("Timer");
		lblTimer.setBackground(Color.WHITE);
		lblTimer.setForeground(Color.DARK_GRAY);
		lblTimer.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lblTimer.setBounds(419, 778, 63, 32);
		add(lblTimer);
		
		JLabel lblMin_1 = new JLabel("min");
		lblMin_1.setBackground(Color.WHITE);
		lblMin_1.setForeground(Color.DARK_GRAY);
		lblMin_1.setFont(new Font("Arsenal", Font.PLAIN, 14));
		lblMin_1.setBounds(539, 785, 35, 15);
		add(lblMin_1);
		
		JLabel lblMusic = new JLabel("Music");
		lblMusic.setFont(new Font("Arsenal", Font.BOLD, 24));
		lblMusic.setBounds(255, 830, 81, 32);
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
		timer.setBounds(483, 778, 51, 32);
		timer.setValue(parms.getHumidity());
		timer.setName("timer");
		add(timer);
		
		JSpinner humidity = new JSpinner();
		humidity.setForeground(Color.DARK_GRAY);
		humidity.setBackground(Color.WHITE);
		humidity.setFont(new Font("Arsenal", Font.PLAIN, 18));
		humidity.setBounds(119, 778, 51, 32);
		humidity.setValue(parms.getTemperature());
		humidity.setName("humidity");
		add(humidity);
		
		JSpinner temperature = new JSpinner();
		temperature.setForeground(Color.DARK_GRAY);
		temperature.setBackground(Color.WHITE);
		temperature.setFont(new Font("Arsenal", Font.PLAIN, 18));
		temperature.setBounds(335, 778, 50, 32);
		temperature.setValue(parms.getTimer());
		temperature.setName("temperature");
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

				parms.setStarryTimers(Parameters.RED, Parameters.HOURS, starryRedTmrHoursVal.getText());
				parms.setStarryTimers(Parameters.RED, Parameters.MINS, starryRedTmrMinsVal.getText());
				parms.setStarryTimers(Parameters.RED, Parameters.SECS, starryRedTmrSecsVal.getText());
				parms.setStarryTimers(Parameters.RED, Parameters.TENTH_OF_MILS, starryRedTmrMilsVal.getText());
				parms.setStarryTimers(Parameters.GREEN, Parameters.HOURS, starryGreenTmrHoursVal.getText());
				parms.setStarryTimers(Parameters.GREEN, Parameters.MINS, starryGreenTmrMinsVal.getText());
				parms.setStarryTimers(Parameters.GREEN, Parameters.SECS, starryGreenTmrSecsVal.getText());
				parms.setStarryTimers(Parameters.GREEN, Parameters.TENTH_OF_MILS, starryGreenTmrMilsVal.getText());
				parms.setStarryTimers(Parameters.BLUE, Parameters.HOURS, starryBlueTmrHoursVal.getText());
				parms.setStarryTimers(Parameters.BLUE, Parameters.MINS, starryBlueTmrMinsVal.getText());
				parms.setStarryTimers(Parameters.BLUE, Parameters.SECS, starryBlueTmrSecsVal.getText());
				parms.setStarryTimers(Parameters.BLUE, Parameters.TENTH_OF_MILS, starryBlueTmrMilsVal.getText());
				
				parms.setLightsTimers(Parameters.RED, Parameters.HOURS, lightsRedTmrHoursVal.getText());
				parms.setLightsTimers(Parameters.RED, Parameters.MINS, lightsRedTmrMinsVal.getText());
				parms.setLightsTimers(Parameters.RED, Parameters.SECS, lightsRedTmrSecsVal.getText());
				parms.setLightsTimers(Parameters.RED, Parameters.TENTH_OF_MILS, lightsRedTmrMilsVal.getText());
				parms.setLightsTimers(Parameters.GREEN, Parameters.HOURS, lightsGreenTmrHoursVal.getText());
				parms.setLightsTimers(Parameters.GREEN, Parameters.MINS, lightsGreenTmrMinsVal.getText());
				parms.setLightsTimers(Parameters.GREEN, Parameters.SECS, lightsGreenTmrSecsVal.getText());
				parms.setLightsTimers(Parameters.GREEN, Parameters.TENTH_OF_MILS, lightsGreenTmrMilsVal.getText());
				parms.setLightsTimers(Parameters.BLUE, Parameters.HOURS, lightsBlueTmrHoursVal.getText());
				parms.setLightsTimers(Parameters.BLUE, Parameters.MINS, lightsBlueTmrMinsVal.getText());
				parms.setLightsTimers(Parameters.BLUE, Parameters.SECS, lightsBlueTmrSecsVal.getText());
				parms.setLightsTimers(Parameters.BLUE, Parameters.TENTH_OF_MILS, lightsBlueTmrMilsVal.getText());
				
				parms.setHumidity((int)humidity.getValue());
				parms.setTemperature((int)temperature.getValue());
				parms.setTimer((int)timer.getValue());
				
				parms.setLightsFadeTimers(Parameters.FADETMR_AUTO, fadeTmrAuto.getText());
				parms.setLightsFadeTimers(Parameters.FADETMR_MANUAL, fadeTmrManual.getText());
				
				parms.save();
				if (keyb != null)
					keyb.dispose();
				((JPanel) v.getFrame("sm")).setVisible(true);
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
				((JPanel) v.getFrame("sm")).setVisible(true);
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
		label_10.setBounds(84, 223, 20, 30);
		add(label_10);
		
		JLabel label_11 = new JLabel("G");
		label_11.setBackground(Color.WHITE);
		label_11.setForeground(Color.DARK_GRAY);
		label_11.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_11.setBounds(84, 259, 20, 30);
		add(label_11);
		
		JLabel label_12 = new JLabel("B");
		label_12.setBackground(Color.WHITE);
		label_12.setForeground(Color.DARK_GRAY);
		label_12.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_12.setBounds(84, 295, 20, 30);
		add(label_12);
		
		JLabel label_13 = new JLabel("R");
		label_13.setBackground(Color.WHITE);
		label_13.setForeground(Color.DARK_GRAY);
		label_13.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_13.setBounds(84, 355, 20, 30);
		add(label_13);
		
		JLabel label_14 = new JLabel("G");
		label_14.setBackground(Color.WHITE);
		label_14.setForeground(Color.DARK_GRAY);
		label_14.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_14.setBounds(84, 391, 20, 30);
		add(label_14);
		
		JLabel label_15 = new JLabel("B");
		label_15.setBackground(Color.WHITE);
		label_15.setForeground(Color.DARK_GRAY);
		label_15.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_15.setBounds(84, 427, 20, 30);
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
		lblTimers.setBounds(12, 534, 72, 25);
		add(lblTimers);
		
		JLabel label_1 = new JLabel("R");
		label_1.setForeground(Color.DARK_GRAY);
		label_1.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(84, 495, 20, 30);
		add(label_1);
		
		JLabel label_2 = new JLabel("G");
		label_2.setForeground(Color.DARK_GRAY);
		label_2.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(84, 531, 20, 30);
		add(label_2);
		
		JLabel label_3 = new JLabel("B");
		label_3.setForeground(Color.DARK_GRAY);
		label_3.setFont(new Font("Arsenal", Font.PLAIN, 18));
		label_3.setBackground(Color.WHITE);
		label_3.setBounds(84, 571, 20, 30);
		add(label_3);
		
		starryRedTmrHoursVal = new JTextField();
		starryRedTmrHoursVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryRedTmrHoursVal.setBounds(101, 500, 40, 28);
		starryRedTmrHoursVal.setName("starryRedTmrHours");
		starryRedTmrHoursVal.setColumns(10);
		starryRedTmrHoursVal.setText(String.valueOf(parms.getStarryTimers()[Parameters.RED][Parameters.HOURS]));
		add(starryRedTmrHoursVal);
		starryRedTmrHoursVal.addActionListener(this);
		starryRedTmrHoursVal.addFocusListener(this);
		
		starryGreenTmrHoursVal = new JTextField();
		starryGreenTmrHoursVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryGreenTmrHoursVal.setColumns(10);
		starryGreenTmrHoursVal.setBounds(101, 536, 40, 28);
		starryGreenTmrHoursVal.setName("starryGreenTmrHours");
		starryGreenTmrHoursVal.setText(String.valueOf(parms.getStarryTimers()[Parameters.GREEN][Parameters.HOURS]));
		add(starryGreenTmrHoursVal);
		starryGreenTmrHoursVal.addActionListener(this);
		starryGreenTmrHoursVal.addFocusListener(this);
		
		starryBlueTmrHoursVal = new JTextField();
		starryBlueTmrHoursVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryBlueTmrHoursVal.setColumns(10);
		starryBlueTmrHoursVal.setBounds(101, 572, 40, 28);
		starryBlueTmrHoursVal.setName("starryBlueTmrHours");
		starryBlueTmrHoursVal.setText(String.valueOf(parms.getStarryTimers()[Parameters.BLUE][Parameters.HOURS]));
		add(starryBlueTmrHoursVal);
		starryBlueTmrHoursVal.addActionListener(this);
		starryBlueTmrHoursVal.addFocusListener(this);
		
		starryRedTmrMinsVal = new JTextField();
		starryRedTmrMinsVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryRedTmrMinsVal.setColumns(10);
		starryRedTmrMinsVal.setBounds(153, 500, 40, 28);
		starryRedTmrMinsVal.setName("starryRedTmrMins");
		starryRedTmrMinsVal.setText(String.valueOf(parms.getStarryTimers()[Parameters.RED][Parameters.MINS]));
		add(starryRedTmrMinsVal);
		starryRedTmrMinsVal.addActionListener(this);
		starryRedTmrMinsVal.addFocusListener(this);
		
		starryGreenTmrMinsVal = new JTextField();
		starryGreenTmrMinsVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryGreenTmrMinsVal.setColumns(10);
		starryGreenTmrMinsVal.setBounds(153, 536, 40, 28);
		starryGreenTmrMinsVal.setName("starryGreenTmrMins");
		starryGreenTmrMinsVal.setText(String.valueOf(parms.getStarryTimers()[Parameters.GREEN][Parameters.MINS]));
		add(starryGreenTmrMinsVal);
		starryGreenTmrMinsVal.addActionListener(this);
		starryGreenTmrMinsVal.addFocusListener(this);
		
		starryBlueTmrMinsVal = new JTextField();
		starryBlueTmrMinsVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryBlueTmrMinsVal.setColumns(10);
		starryBlueTmrMinsVal.setBounds(153, 572, 40, 28);
		starryBlueTmrMinsVal.setName("starryBlueTmrMins");
		starryBlueTmrMinsVal.setText(String.valueOf(parms.getStarryTimers()[Parameters.BLUE][Parameters.MINS]));
		add(starryBlueTmrMinsVal);
		starryBlueTmrMinsVal.addActionListener(this);
		starryBlueTmrMinsVal.addFocusListener(this);
		
		starryRedTmrSecsVal = new JTextField();
		starryRedTmrSecsVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryRedTmrSecsVal.setColumns(10);
		starryRedTmrSecsVal.setBounds(205, 500, 40, 28);
		starryRedTmrSecsVal.setName("starryRedTmrSecs");
		starryRedTmrSecsVal.setText(String.valueOf(parms.getStarryTimers()[Parameters.RED][Parameters.SECS]));
		add(starryRedTmrSecsVal);
		starryRedTmrSecsVal.addActionListener(this);
		starryRedTmrSecsVal.addFocusListener(this);
		
		starryGreenTmrSecsVal = new JTextField();
		starryGreenTmrSecsVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryGreenTmrSecsVal.setColumns(10);
		starryGreenTmrSecsVal.setBounds(205, 536, 40, 28);
		starryGreenTmrSecsVal.setName("starryGreenTmrSecs");
		starryGreenTmrSecsVal.setText(String.valueOf(parms.getStarryTimers()[Parameters.GREEN][Parameters.SECS]));
		add(starryGreenTmrSecsVal);
		starryGreenTmrSecsVal.addActionListener(this);
		starryGreenTmrSecsVal.addFocusListener(this);
		
		starryBlueTmrSecsVal = new JTextField();
		starryBlueTmrSecsVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryBlueTmrSecsVal.setColumns(10);
		starryBlueTmrSecsVal.setBounds(205, 572, 40, 28);
		starryBlueTmrSecsVal.setName("starryBlueTmrSecs");
		starryBlueTmrSecsVal.setText(String.valueOf(parms.getStarryTimers()[Parameters.BLUE][Parameters.SECS]));
		add(starryBlueTmrSecsVal);
		starryBlueTmrSecsVal.addActionListener(this);
		starryBlueTmrSecsVal.addFocusListener(this);
		
		starryRedTmrMilsVal = new JTextField();
		starryRedTmrMilsVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryRedTmrMilsVal.setColumns(10);
		starryRedTmrMilsVal.setBounds(258, 500, 40, 28);
		starryRedTmrMilsVal.setName("starryRedTmrMils");
		starryRedTmrMilsVal.setText(String.valueOf(parms.getStarryTimers()[Parameters.RED][Parameters.TENTH_OF_MILS]));
		add(starryRedTmrMilsVal);
		starryRedTmrMilsVal.addActionListener(this);
		starryRedTmrMilsVal.addFocusListener(this);
		
		starryGreenTmrMilsVal = new JTextField();
		starryGreenTmrMilsVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryGreenTmrMilsVal.setColumns(10);
		starryGreenTmrMilsVal.setBounds(258, 536, 40, 28);
		starryGreenTmrMilsVal.setName("starryGreenTmrMils");
		starryGreenTmrMilsVal.setText(String.valueOf(parms.getStarryTimers()[Parameters.GREEN][Parameters.TENTH_OF_MILS]));
		add(starryGreenTmrMilsVal);
		starryGreenTmrMilsVal.addActionListener(this);
		starryGreenTmrMilsVal.addFocusListener(this);
		
		starryBlueTmrMilsVal = new JTextField();
		starryBlueTmrMilsVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryBlueTmrMilsVal.setColumns(10);
		starryBlueTmrMilsVal.setBounds(258, 572, 40, 28);
		starryBlueTmrMilsVal.setName("starryBlueTmrMils");
		starryBlueTmrMilsVal.setText(String.valueOf(parms.getStarryTimers()[Parameters.BLUE][Parameters.TENTH_OF_MILS]));
		add(starryBlueTmrMilsVal);
		starryBlueTmrMilsVal.addActionListener(this);
		starryBlueTmrMilsVal.addFocusListener(this);
		
		JLabel lblHour = new JLabel("Hour");
		lblHour.setForeground(Color.DARK_GRAY);
		lblHour.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lblHour.setBackground(Color.WHITE);
		lblHour.setBounds(101, 469, 38, 30);
		add(lblHour);
		
		JLabel lblMins = new JLabel("Mins");
		lblMins.setForeground(Color.DARK_GRAY);
		lblMins.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lblMins.setBackground(Color.WHITE);
		lblMins.setBounds(153, 469, 38, 30);
		add(lblMins);
		
		JLabel lblSecs = new JLabel("Secs");
		lblSecs.setForeground(Color.DARK_GRAY);
		lblSecs.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lblSecs.setBackground(Color.WHITE);
		lblSecs.setBounds(207, 469, 38, 30);
		add(lblSecs);
		
		JLabel lblMills = new JLabel("Mils");
		lblMills.setForeground(Color.DARK_GRAY);
		lblMills.setFont(new Font("Arsenal", Font.PLAIN, 18));
		lblMills.setBackground(Color.WHITE);
		lblMills.setBounds(260, 471, 38, 30);
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
		lightsRedTmrHoursVal.setName("lightsRedTmrHoursVal");
		lightsRedTmrHoursVal.setText(String.valueOf(parms.getLightsTimers()[Parameters.RED][Parameters.HOURS]));
		add(lightsRedTmrHoursVal);
		lightsRedTmrHoursVal.addActionListener(this);
		lightsRedTmrHoursVal.addFocusListener(this);
		
		lightsGreenTmrHoursVal = new JTextField();
		lightsGreenTmrHoursVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsGreenTmrHoursVal.setColumns(10);
		lightsGreenTmrHoursVal.setBounds(382, 536, 40, 28);
		lightsGreenTmrHoursVal.setName("lightsGreenTmrHoursVal");
		lightsGreenTmrHoursVal.setText(String.valueOf(parms.getLightsTimers()[Parameters.GREEN][Parameters.HOURS]));
		add(lightsGreenTmrHoursVal);
		lightsGreenTmrHoursVal.addActionListener(this);
		lightsGreenTmrHoursVal.addFocusListener(this);
		
		lightsBlueTmrHoursVal = new JTextField();
		lightsBlueTmrHoursVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsBlueTmrHoursVal.setColumns(10);
		lightsBlueTmrHoursVal.setBounds(382, 572, 40, 28);
		lightsBlueTmrHoursVal.setName("lightsBlueTmrHoursVal");
		lightsBlueTmrHoursVal.setText(String.valueOf(parms.getLightsTimers()[Parameters.BLUE][Parameters.HOURS]));
		add(lightsBlueTmrHoursVal);
		lightsBlueTmrHoursVal.addActionListener(this);
		lightsBlueTmrHoursVal.addFocusListener(this);
		
		lightsRedTmrMinsVal = new JTextField();
		lightsRedTmrMinsVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsRedTmrMinsVal.setColumns(10);
		lightsRedTmrMinsVal.setBounds(434, 500, 40, 28);
		lightsRedTmrMinsVal.setName("lightsRedTmrMinsVal");
		lightsRedTmrMinsVal.setText(String.valueOf(parms.getLightsTimers()[Parameters.RED][Parameters.MINS]));
		add(lightsRedTmrMinsVal);
		lightsRedTmrMinsVal.addActionListener(this);
		lightsRedTmrMinsVal.addFocusListener(this);
		
		lightsGreenTmrMinsVal = new JTextField();
		lightsGreenTmrMinsVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsGreenTmrMinsVal.setColumns(10);
		lightsGreenTmrMinsVal.setBounds(434, 536, 40, 28);
		lightsGreenTmrMinsVal.setName("lightsGreenTmrMinsVal");
		lightsGreenTmrMinsVal.setText(String.valueOf(parms.getLightsTimers()[Parameters.GREEN][Parameters.MINS]));
		add(lightsGreenTmrMinsVal);
		lightsGreenTmrMinsVal.addActionListener(this);
		lightsGreenTmrMinsVal.addFocusListener(this);
		
		lightsBlueTmrMinsVal = new JTextField();
		lightsBlueTmrMinsVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsBlueTmrMinsVal.setColumns(10);
		lightsBlueTmrMinsVal.setBounds(434, 572, 40, 28);
		lightsBlueTmrMinsVal.setName("lightsBlueTmrMinsVal");
		lightsBlueTmrMinsVal.setText(String.valueOf(parms.getLightsTimers()[Parameters.BLUE][Parameters.MINS]));
		add(lightsBlueTmrMinsVal);
		lightsBlueTmrMinsVal.addActionListener(this);
		lightsBlueTmrMinsVal.addFocusListener(this);
		
		lightsRedTmrSecsVal = new JTextField();
		lightsRedTmrSecsVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsRedTmrSecsVal.setColumns(10);
		lightsRedTmrSecsVal.setBounds(486, 500, 40, 28);
		lightsRedTmrSecsVal.setName("lightsRedTmrSecsVal");
		lightsRedTmrSecsVal.setText(String.valueOf(parms.getLightsTimers()[Parameters.RED][Parameters.SECS]));
		add(lightsRedTmrSecsVal);
		lightsRedTmrSecsVal.addActionListener(this);
		lightsRedTmrSecsVal.addFocusListener(this);
		
		lightsGreenTmrSecsVal = new JTextField();
		lightsGreenTmrSecsVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsGreenTmrSecsVal.setColumns(10);
		lightsGreenTmrSecsVal.setBounds(486, 536, 40, 28);
		lightsGreenTmrSecsVal.setName("lightsGreenTmrSecsVal");
		lightsGreenTmrSecsVal.setText(String.valueOf(parms.getLightsTimers()[Parameters.GREEN][Parameters.SECS]));
		add(lightsGreenTmrSecsVal);
		lightsGreenTmrSecsVal.addActionListener(this);
		lightsGreenTmrSecsVal.addFocusListener(this);
		
		lightsBlueTmrSecsVal = new JTextField();
		lightsBlueTmrSecsVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsBlueTmrSecsVal.setColumns(10);
		lightsBlueTmrSecsVal.setBounds(486, 572, 40, 28);
		lightsBlueTmrSecsVal.setName("lightsBlueTmrSecsVal");
		lightsBlueTmrSecsVal.setText(String.valueOf(parms.getLightsTimers()[Parameters.BLUE][Parameters.SECS]));
		add(lightsBlueTmrSecsVal);
		lightsBlueTmrSecsVal.addActionListener(this);
		lightsBlueTmrSecsVal.addFocusListener(this);
		
		lightsRedTmrMilsVal = new JTextField();
		lightsRedTmrMilsVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsRedTmrMilsVal.setColumns(10);
		lightsRedTmrMilsVal.setBounds(539, 500, 40, 28);
		lightsRedTmrMilsVal.setName("lightsRedTmrMilsVal");
		lightsRedTmrMilsVal.setText(String.valueOf(parms.getLightsTimers()[Parameters.RED][Parameters.TENTH_OF_MILS]));
		add(lightsRedTmrMilsVal);
		lightsRedTmrMilsVal.addActionListener(this);
		lightsRedTmrMilsVal.addFocusListener(this);
		
		lightsGreenTmrMilsVal = new JTextField();
		lightsGreenTmrMilsVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsGreenTmrMilsVal.setColumns(10);
		lightsGreenTmrMilsVal.setBounds(539, 536, 40, 28);
		lightsGreenTmrMilsVal.setName("lightsGreenTmrMilsVal");
		lightsGreenTmrMilsVal.setText(String.valueOf(parms.getLightsTimers()[Parameters.GREEN][Parameters.TENTH_OF_MILS]));
		add(lightsGreenTmrMilsVal);
		lightsGreenTmrMilsVal.addActionListener(this);
		lightsGreenTmrMilsVal.addFocusListener(this);
		
		lightsBlueTmrMilsVal = new JTextField();
		lightsBlueTmrMilsVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsBlueTmrMilsVal.setColumns(10);
		lightsBlueTmrMilsVal.setBounds(539, 572, 40, 28);
		lightsBlueTmrMilsVal.setName("lightsBlueTmrMilsVal");
		lightsBlueTmrMilsVal.setText(String.valueOf(parms.getLightsTimers()[Parameters.BLUE][Parameters.TENTH_OF_MILS]));
		add(lightsBlueTmrMilsVal);
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
		
		JLabel label_25 = new JLabel("Steam bath");
		label_25.setForeground(Color.DARK_GRAY);
		label_25.setFont(new Font("Dialog", Font.BOLD, 24));
		label_25.setBackground(Color.WHITE);
		label_25.setBounds(228, 734, 157, 32);
		add(label_25);
		
		JLabel lblAutoOn = new JLabel("Auto on");
		lblAutoOn.setForeground(Color.DARK_GRAY);
		lblAutoOn.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblAutoOn.setBackground(Color.WHITE);
		lblAutoOn.setBounds(36, 645, 109, 32);
		add(lblAutoOn);
		
		fadeTmrAuto = new JTextField();
		fadeTmrAuto.setFont(new Font("Dialog", Font.PLAIN, 14));
		fadeTmrAuto.setText("0");
		fadeTmrAuto.setName("fadeTmrAuto");
		fadeTmrAuto.setHorizontalAlignment(SwingConstants.RIGHT);
		fadeTmrAuto.setColumns(10);
		fadeTmrAuto.setBounds(147, 646, 58, 34);
		fadeTmrAuto.setText(String.valueOf(parms.getLightsFadeTimers()[Parameters.FADETMR_AUTO]));
		fadeTmrAuto.addActionListener(this);
		fadeTmrAuto.addFocusListener(this);
		add(fadeTmrAuto);
		
		JLabel lblManualOn = new JLabel("Manual on");
		lblManualOn.setForeground(Color.DARK_GRAY);
		lblManualOn.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblManualOn.setBackground(Color.WHITE);
		lblManualOn.setBounds(36, 689, 109, 32);
		add(lblManualOn);
		
		fadeTmrManual = new JTextField();
		fadeTmrManual.setText("0");
		fadeTmrManual.setName("fadeTmrManual");
		fadeTmrManual.setHorizontalAlignment(SwingConstants.RIGHT);
		fadeTmrManual.setFont(new Font("Dialog", Font.PLAIN, 14));
		fadeTmrManual.setColumns(10);
		fadeTmrManual.setBounds(147, 690, 58, 34);
		fadeTmrManual.setText(String.valueOf(parms.getLightsFadeTimers()[Parameters.FADETMR_MANUAL]));
		fadeTmrManual.addFocusListener(this);
		fadeTmrManual.addActionListener(this);
		fadeTmrManual.addFocusListener(this);
		add(fadeTmrManual);
		
		fadeLowerBoundRed = new JTextField();
		fadeLowerBoundRed.setText("4");
		fadeLowerBoundRed.setName("fadeLowerBoundRed");
		fadeLowerBoundRed.setHorizontalAlignment(SwingConstants.RIGHT);
		fadeLowerBoundRed.setColumns(10);
		fadeLowerBoundRed.setBounds(416, 672, 40, 28);
		fadeLowerBoundRed.addActionListener(this);
		fadeLowerBoundRed.addFocusListener(this);
		add(fadeLowerBoundRed);
		
		fadeLowerBoundGreen = new JTextField();
		fadeLowerBoundGreen.setText("2");
		fadeLowerBoundGreen.setName("fadeLowerBoundGreen");
		fadeLowerBoundGreen.setHorizontalAlignment(SwingConstants.RIGHT);
		fadeLowerBoundGreen.setColumns(10);
		fadeLowerBoundGreen.setBounds(470, 672, 40, 28);
		fadeLowerBoundGreen.addActionListener(this);
		fadeLowerBoundGreen.addFocusListener(this);
		add(fadeLowerBoundGreen);
		
		fadeLowerBoundBlue = new JTextField();
		fadeLowerBoundBlue.setText("8");
		fadeLowerBoundBlue.setName("fadeLowerBoundBlue");
		fadeLowerBoundBlue.setHorizontalAlignment(SwingConstants.RIGHT);
		fadeLowerBoundBlue.setColumns(10);
		fadeLowerBoundBlue.setBounds(524, 672, 40, 28);
		fadeLowerBoundBlue.addActionListener(this);
		fadeLowerBoundBlue.addFocusListener(this);
		add(fadeLowerBoundBlue);
		
		JLabel label_26 = new JLabel("R");
		label_26.setForeground(Color.DARK_GRAY);
		label_26.setFont(new Font("Dialog", Font.PLAIN, 18));
		label_26.setBackground(Color.WHITE);
		label_26.setBounds(426, 645, 20, 30);
		add(label_26);
		
		JLabel label_27 = new JLabel("G");
		label_27.setForeground(Color.DARK_GRAY);
		label_27.setFont(new Font("Dialog", Font.PLAIN, 18));
		label_27.setBackground(Color.WHITE);
		label_27.setBounds(480, 645, 20, 30);
		add(label_27);
		
		JLabel label_28 = new JLabel("B");
		label_28.setForeground(Color.DARK_GRAY);
		label_28.setFont(new Font("Dialog", Font.PLAIN, 18));
		label_28.setBackground(Color.WHITE);
		label_28.setBounds(534, 645, 20, 30);
		add(label_28);
		
		JLabel lblLowerVal = new JLabel("Lower val");
		lblLowerVal.setForeground(Color.DARK_GRAY);
		lblLowerVal.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblLowerVal.setBackground(Color.WHITE);
		lblLowerVal.setBounds(308, 670, 109, 32);
		add(lblLowerVal);
		
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
		this.requestFocus();
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
			if ((o != null) && o.getClass().getName().compareTo("javax.swing.JSlider") == 0)
			{
				JSlider slider = (JSlider) o;
				if (slider != null)
				{
					if (Integer.parseInt(source.getText()) > slider.getMaximum())
						source.setText(String.valueOf(slider.getMaximum()));
					if (Integer.parseInt(source.getText()) < slider.getMinimum())
						source.setText(String.valueOf(slider.getMinimum()));
					slider.setValue(Integer.parseInt(source.getText()));
				}
			}
		}
		if (keyb != null)
		{
			keyb.setVisible(true);
			keyb.dispose();
		}
	}
}
