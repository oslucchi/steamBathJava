package it.lsoft.steambath;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import it.lsoft.steambath.Commons.Parameters;

import javax.swing.JButton;
import javax.swing.JSpinner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SteambathConfiguration implements ChangeListener, ActionListener, FocusListener {
	Parameters parms = Parameters.getInstance("conf/config.txt");

	private JFrame frame;
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


	/**
	 * Create the application.
	 */
	public SteambathConfiguration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Laksaman", Font.PLAIN, 14));
		frame.setSize(new Dimension(720, 1040));
		frame.setBackground(Color.WHITE);
		frame.setAlwaysOnTop(true);
		frame.setResizable(false);
		frame.setBounds(1200, 0, 720, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	    frame.setUndecorated(true);

		
		JLabel lblStarrysky = new JLabel("Starry sky");
		lblStarrysky.setFont(new Font("Laksaman", Font.BOLD, 24));
		lblStarrysky.setBounds(22, 84, 312, 32);
		frame.getContentPane().add(lblStarrysky);
		
		JLabel lblMin = new JLabel("min");
		lblMin.setFont(new Font("Laksaman", Font.BOLD, 16));
		lblMin.setBounds(182, 114, 35, 15);
		frame.getContentPane().add(lblMin);
		
		JLabel lblMax = new JLabel("MAX");
		lblMax.setFont(new Font("Laksaman", Font.BOLD, 16));
		lblMax.setBounds(370, 114, 35, 15);
		frame.getContentPane().add(lblMax);
		
		JLabel lblSpeed = new JLabel("Speed");
		lblSpeed.setFont(new Font("Laksaman", Font.BOLD, 16));
		lblSpeed.setBounds(552, 114, 51, 15);
		frame.getContentPane().add(lblSpeed);
		
		JLabel lblStarryRed = new JLabel("Red");
		lblStarryRed.setFont(new Font("Laksaman", Font.PLAIN, 18));
		lblStarryRed.setBounds(12, 141, 70, 15);
		frame.getContentPane().add(lblStarryRed);

		JSlider starryRedMin = new JSlider();
		starryRedMin.setBounds(129, 141, 140, 16);
		starryRedMin.setMinimum(0);
		starryRedMin.setMaximum(255);
		starryRedMin.setName("starryRedMin");
		starryRedMin.setValue(parms.getStarry()[Parameters.RED][Parameters.MIN]);
		starryRedMin.addChangeListener(this);
		frame.getContentPane().add(starryRedMin);
		
		JSlider starryRedMax = new JSlider();
		starryRedMax.setBounds(317, 141, 140, 16);
		starryRedMax.setMinimum(0);
		starryRedMax.setMaximum(255);
		starryRedMax.setName("starryRedMax");
		starryRedMax.setValue(parms.getStarry()[Parameters.RED][Parameters.MAX]);
		starryRedMax.addChangeListener(this);
		frame.getContentPane().add(starryRedMax);
		
		JSlider starryRedSpeed = new JSlider();
		starryRedSpeed.setBounds(507, 141, 140, 16);
		starryRedSpeed.setMinimum(50);
		starryRedSpeed.setMaximum(10000);
		starryRedSpeed.setName("starryRedSpeed");
		starryRedSpeed.setValue(parms.getStarry()[Parameters.RED][Parameters.SPEED]);
		starryRedSpeed.addChangeListener(this);
		frame.getContentPane().add(starryRedSpeed);
		
		JLabel lblGreen = new JLabel("Green");
		lblGreen.setFont(new Font("Laksaman", Font.PLAIN, 18));
		lblGreen.setBounds(12, 169, 70, 15);
		frame.getContentPane().add(lblGreen);
		
		JSlider starryGreenMin = new JSlider();
		starryGreenMin.setBounds(129, 169, 140, 16);
		starryGreenMin.setMinimum(0);
		starryGreenMin.setMaximum(255);
		starryGreenMin.setName("starryGreenMin");
		starryGreenMin.setValue(parms.getStarry()[Parameters.GREEN][Parameters.MIN]);
		starryGreenMin.addChangeListener(this);
		frame.getContentPane().add(starryGreenMin);
		
		JSlider starryGreenMax = new JSlider();
		starryGreenMax.setBounds(317, 169, 140, 16);
		starryGreenMax.setMinimum(0);
		starryGreenMax.setMaximum(255);
		starryGreenMax.setName("starryGreenMax");
		starryGreenMax.setValue(parms.getStarry()[Parameters.GREEN][Parameters.MAX]);
		starryGreenMax.addChangeListener(this);
		frame.getContentPane().add(starryGreenMax);
		
		JSlider starryGreenSpeed = new JSlider();
		starryGreenSpeed.setBounds(507, 169, 140, 16);
		starryGreenSpeed.setMinimum(50);
		starryGreenSpeed.setMaximum(10000);
		starryGreenSpeed.setName("starryGreenSpeed");
		starryGreenSpeed.setValue(parms.getStarry()[Parameters.GREEN][Parameters.SPEED]);
		starryGreenSpeed.addChangeListener(this);
		frame.getContentPane().add(starryGreenSpeed);
		
		JLabel lblBlue = new JLabel("Blue");
		lblBlue.setFont(new Font("Laksaman", Font.PLAIN, 18));
		lblBlue.setBounds(12, 196, 70, 15);
		frame.getContentPane().add(lblBlue);
		
		JSlider starryBlueMin = new JSlider();
		starryBlueMin.setBounds(129, 196, 140, 16);
		starryBlueMin.setMinimum(0);
		starryBlueMin.setMaximum(255);
		starryBlueMin.setName("starryBlueMin");
		starryBlueMin.setValue(parms.getStarry()[Parameters.BLUE][Parameters.MIN]);
		starryBlueMin.addChangeListener(this);
		frame.getContentPane().add(starryBlueMin);
		
		JSlider starryBlueMax = new JSlider();
		starryBlueMax.setBounds(317, 196, 140, 16);
		starryBlueMax.setMinimum(0);
		starryBlueMax.setMaximum(255);
		starryBlueMax.setName("starryBlueMax");
		starryBlueMax.setValue(parms.getStarry()[Parameters.BLUE][Parameters.MAX]);
		starryBlueMax.addChangeListener(this);
		frame.getContentPane().add(starryBlueMax);
		
		JSlider starryBlueSpeed = new JSlider();
		starryBlueSpeed.setBounds(507, 196, 140, 16);
		starryBlueSpeed.setMinimum(50);
		starryBlueSpeed.setMaximum(10000);
		starryBlueSpeed.setName("starryBlueSpeed");
		starryBlueSpeed.setValue(parms.getStarry()[Parameters.BLUE][Parameters.SPEED]);
		starryBlueSpeed.addChangeListener(this);
		frame.getContentPane().add(starryBlueSpeed);
		
		starryRedMinVal = new JTextField();
		starryRedMinVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryRedMinVal.setName("starryRedMinVal");
		starryRedMinVal.setFont(new Font("Laksaman", Font.PLAIN, 14));
		starryRedMinVal.setBounds(270, 138, 40, 19);
		starryRedMinVal.setColumns(10);
		starryRedMinVal.setText(String.valueOf(parms.getStarry()[Parameters.RED][Parameters.MIN]));
		starryRedMinVal.addActionListener(this);
		starryRedMinVal.addFocusListener(this);
		frame.getContentPane().add(starryRedMinVal);
		
		starryGreenMinVal = new JTextField();
		starryGreenMinVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryGreenMinVal.setName("starryGreenMinVal");
		starryGreenMinVal.setFont(new Font("Laksaman", Font.PLAIN, 14));
		starryGreenMinVal.setColumns(10);
		starryGreenMinVal.setBounds(270, 168, 40, 19);
		starryGreenMinVal.setText(String.valueOf(parms.getStarry()[Parameters.GREEN][Parameters.MIN]));
		starryGreenMinVal.addActionListener(this);
		starryGreenMinVal.addFocusListener(this);
		frame.getContentPane().add(starryGreenMinVal);
		
		starryBlueMinVal = new JTextField();
		starryBlueMinVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryBlueMinVal.setName("starryBlueMinVal");
		starryBlueMinVal.setFont(new Font("Laksaman", Font.PLAIN, 14));
		starryBlueMinVal.setColumns(10);
		starryBlueMinVal.setBounds(270, 194, 40, 19);
		starryBlueMinVal.setText(String.valueOf(parms.getStarry()[Parameters.BLUE][Parameters.MIN]));
		starryBlueMinVal.addActionListener(this);
		starryBlueMinVal.addFocusListener(this);
		frame.getContentPane().add(starryBlueMinVal);
		
		starryRedMaxVal = new JTextField();
		starryRedMaxVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryRedMaxVal.setName("starryRedMaxVal");
		starryRedMaxVal.setFont(new Font("Laksaman", Font.PLAIN, 14));
		starryRedMaxVal.setColumns(10);
		starryRedMaxVal.setBounds(458, 136, 40, 19);
		starryRedMaxVal.setText(String.valueOf(parms.getStarry()[Parameters.RED][Parameters.MAX]));
		starryRedMaxVal.addActionListener(this);
		starryRedMaxVal.addFocusListener(this);
		frame.getContentPane().add(starryRedMaxVal);
		
		starryGreenMaxVal = new JTextField();
		starryGreenMaxVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryGreenMaxVal.setName("starryGreenMaxVal");
		starryGreenMaxVal.setFont(new Font("Laksaman", Font.PLAIN, 14));
		starryGreenMaxVal.setColumns(10);
		starryGreenMaxVal.setBounds(458, 166, 40, 19);
		starryGreenMaxVal.setText(String.valueOf(parms.getStarry()[Parameters.GREEN][Parameters.MAX]));
		starryGreenMaxVal.addActionListener(this);
		starryGreenMaxVal.addFocusListener(this);
		frame.getContentPane().add(starryGreenMaxVal);
		
		starryBlueMaxVal = new JTextField();
		starryBlueMaxVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryBlueMaxVal.setName("starryBlueMaxVal");
		starryBlueMaxVal.setFont(new Font("Laksaman", Font.PLAIN, 14));
		starryBlueMaxVal.setColumns(10);
		starryBlueMaxVal.setBounds(458, 192, 40, 19);
		starryBlueMaxVal.setText(String.valueOf(parms.getStarry()[Parameters.BLUE][Parameters.MAX]));
		starryBlueMaxVal.addActionListener(this);
		starryBlueMaxVal.addFocusListener(this);
		frame.getContentPane().add(starryBlueMaxVal);
		
		starryRedSpeedVal = new JTextField();
		starryRedSpeedVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryRedSpeedVal.setName("starryRedSpeedVal");
		starryRedSpeedVal.setFont(new Font("Laksaman", Font.PLAIN, 14));
		starryRedSpeedVal.setColumns(10);
		starryRedSpeedVal.setBounds(648, 136, 60, 19);
		starryRedSpeedVal.setText(String.valueOf(parms.getStarry()[Parameters.RED][Parameters.SPEED]));
		starryRedSpeedVal.addActionListener(this);
		starryRedSpeedVal.addFocusListener(this);
		frame.getContentPane().add(starryRedSpeedVal);
		
		starryGreenSpeedVal = new JTextField();
		starryGreenSpeedVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryGreenSpeedVal.setName("starryGreenSpeedVal");
		starryGreenSpeedVal.setFont(new Font("Laksaman", Font.PLAIN, 14));
		starryGreenSpeedVal.setColumns(10);
		starryGreenSpeedVal.setBounds(648, 166, 60, 19);
		starryGreenSpeedVal.setText(String.valueOf(parms.getStarry()[Parameters.GREEN][Parameters.SPEED]));
		starryGreenSpeedVal.addActionListener(this);
		starryGreenSpeedVal.addFocusListener(this);
		frame.getContentPane().add(starryGreenSpeedVal);
		
		starryBlueSpeedVal = new JTextField();
		starryBlueSpeedVal.setHorizontalAlignment(SwingConstants.RIGHT);
		starryBlueSpeedVal.setName("starryBlueSpeedVal");
		starryBlueSpeedVal.setFont(new Font("Laksaman", Font.PLAIN, 14));
		starryBlueSpeedVal.setColumns(10);
		starryBlueSpeedVal.setBounds(648, 192, 60, 19);
		starryBlueSpeedVal.setText(String.valueOf(parms.getStarry()[Parameters.BLUE][Parameters.SPEED]));
		starryBlueSpeedVal.addActionListener(this);
		starryBlueSpeedVal.addFocusListener(this);
		frame.getContentPane().add(starryBlueSpeedVal);
		
		JLabel lblCabinLights = new JLabel("Cabin lights");
		lblCabinLights.setFont(new Font("Laksaman", Font.BOLD, 24));
		lblCabinLights.setBounds(22, 299, 312, 32);
		frame.getContentPane().add(lblCabinLights);
		
		JLabel label_1 = new JLabel("Red");
		label_1.setFont(new Font("Laksaman", Font.PLAIN, 18));
		label_1.setBounds(12, 354, 70, 15);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("min");
		label_2.setFont(new Font("Laksaman", Font.BOLD, 16));
		label_2.setBounds(182, 327, 35, 15);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("MAX");
		label_3.setFont(new Font("Laksaman", Font.BOLD, 16));
		label_3.setBounds(370, 327, 35, 15);
		frame.getContentPane().add(label_3);
		
		JLabel label_6 = new JLabel("Speed");
		label_6.setFont(new Font("Laksaman", Font.BOLD, 16));
		label_6.setBounds(552, 327, 51, 15);
		frame.getContentPane().add(label_6);
		
		JSlider lightsRedMin = new JSlider();
		lightsRedMin.setBounds(129, 354, 140, 16);
		lightsRedMin.setMinimum(0);
		lightsRedMin.setMaximum(255);
		lightsRedMin.setName("lightsRedMin");
		lightsRedMin.setValue(parms.getLights()[Parameters.RED][Parameters.MIN]);
		lightsRedMin.addChangeListener(this);
		frame.getContentPane().add(lightsRedMin);
		
		JSlider lightsRedMax = new JSlider();
		lightsRedMax.setBounds(317, 354, 140, 16);
		lightsRedMax.setMinimum(0);
		lightsRedMax.setMaximum(255);
		lightsRedMax.setName("lightsRedMax");
		lightsRedMax.setValue(parms.getLights()[Parameters.RED][Parameters.MAX]);
		lightsRedMax.addChangeListener(this);
		frame.getContentPane().add(lightsRedMax);
		
		JSlider lightsRedSpeed = new JSlider();
		lightsRedSpeed.setBounds(507, 354, 140, 16);
		lightsRedSpeed.setMinimum(50);
		lightsRedSpeed.setMaximum(10000);
		lightsRedSpeed.setName("lightsRedSpeed");
		lightsRedSpeed.setValue(parms.getLights()[Parameters.RED][Parameters.SPEED]);
		lightsRedSpeed.addChangeListener(this);
		frame.getContentPane().add(lightsRedSpeed);
		
		JLabel label_4 = new JLabel("Green");
		label_4.setFont(new Font("Laksaman", Font.PLAIN, 18));
		label_4.setBounds(12, 382, 70, 15);
		frame.getContentPane().add(label_4);
		
		JSlider lightsGreenMin = new JSlider();
		lightsGreenMin.setBounds(129, 382, 140, 16);
		lightsGreenMin.setMinimum(0);
		lightsGreenMin.setMaximum(255);
		lightsGreenMin.setName("lightsGreenMin");
		lightsGreenMin.setValue(parms.getLights()[Parameters.GREEN][Parameters.MIN]);
		lightsGreenMin.addChangeListener(this);
		frame.getContentPane().add(lightsGreenMin);
		
		JSlider lightsGreenMax = new JSlider();
		lightsGreenMax.setBounds(317, 382, 140, 16);
		lightsGreenMax.setMinimum(0);
		lightsGreenMax.setMaximum(255);
		lightsGreenMax.setName("lightsGreenMax");
		lightsGreenMax.setValue(parms.getLights()[Parameters.GREEN][Parameters.MAX]);
		lightsGreenMax.addChangeListener(this);
		frame.getContentPane().add(lightsGreenMax);
		
		JSlider lightsGreenSpeed = new JSlider();
		lightsGreenSpeed.setBounds(507, 382, 140, 16);
		lightsGreenSpeed.setMinimum(50);
		lightsGreenSpeed.setMaximum(10000);
		lightsGreenSpeed.setName("lightsGreenSpeed");
		lightsGreenSpeed.setValue(parms.getLights()[Parameters.GREEN][Parameters.SPEED]);
		lightsGreenSpeed.addChangeListener(this);
		frame.getContentPane().add(lightsGreenSpeed);
		
		JLabel label_5 = new JLabel("Blue");
		label_5.setFont(new Font("Laksaman", Font.PLAIN, 18));
		label_5.setBounds(12, 409, 70, 15);
		frame.getContentPane().add(label_5);
		
		JSlider lightsBlueMin = new JSlider();
		lightsBlueMin.setBounds(129, 409, 140, 16);
		lightsBlueMin.setMinimum(0);
		lightsBlueMin.setMaximum(255);
		lightsBlueMin.setName("lightsBlueMin");
		lightsBlueMin.setValue(parms.getLights()[Parameters.BLUE][Parameters.MIN]);
		lightsBlueMin.addChangeListener(this);
		frame.getContentPane().add(lightsBlueMin);
		
		JSlider lightsBlueMax = new JSlider();
		lightsBlueMax.setBounds(317, 409, 140, 16);
		lightsBlueMax.setMinimum(0);
		lightsBlueMax.setMaximum(255);
		lightsBlueMax.setName("lightsBlueMax");
		lightsBlueMax.setValue(parms.getLights()[Parameters.BLUE][Parameters.MAX]);
		lightsBlueMax.addChangeListener(this);
		frame.getContentPane().add(lightsBlueMax);
		
		JSlider lightsBlueSpeed = new JSlider();
		lightsBlueSpeed.setBounds(507, 409, 140, 16);
		lightsBlueSpeed.setMinimum(50);
		lightsBlueSpeed.setMaximum(10000);
		lightsBlueSpeed.setName("lightsBlueSpeed");
		lightsBlueSpeed.setValue(parms.getLights()[Parameters.BLUE][Parameters.SPEED]);
		lightsBlueSpeed.addChangeListener(this);
		frame.getContentPane().add(lightsBlueSpeed);
		
		lightsRedMinVal = new JTextField();
		lightsRedMinVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsRedMinVal.setName("lightsRedMinVal");
		lightsRedMinVal.setFont(new Font("Laksaman", Font.PLAIN, 14));
		lightsRedMinVal.setColumns(10);
		lightsRedMinVal.setBounds(270, 351, 40, 19);
		lightsRedMinVal.setText(String.valueOf(parms.getLights()[Parameters.RED][Parameters.MIN]));
		lightsRedMinVal.addActionListener(this);
		lightsRedMinVal.addFocusListener(this);
		frame.getContentPane().add(lightsRedMinVal);
		
		lightsGreenMinVal = new JTextField();
		lightsGreenMinVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsGreenMinVal.setName("lightsGreenMinVal");
		lightsGreenMinVal.setFont(new Font("Laksaman", Font.PLAIN, 14));
		lightsGreenMinVal.setColumns(10);
		lightsGreenMinVal.setBounds(270, 381, 40, 19);
		lightsGreenMinVal.setText(String.valueOf(parms.getLights()[Parameters.GREEN][Parameters.MIN]));
		lightsGreenMinVal.addActionListener(this);
		lightsGreenMinVal.addFocusListener(this);
		frame.getContentPane().add(lightsGreenMinVal);
		
		lightsBlueMinVal = new JTextField();
		lightsBlueMinVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsBlueMinVal.setName("lightsBlueMinVal");
		lightsBlueMinVal.setFont(new Font("Laksaman", Font.PLAIN, 14));
		lightsBlueMinVal.setColumns(10);
		lightsBlueMinVal.setBounds(270, 407, 40, 19);
		lightsBlueMinVal.setText(String.valueOf(parms.getLights()[Parameters.BLUE][Parameters.MIN]));
		lightsBlueMinVal.addActionListener(this);
		lightsBlueMinVal.addFocusListener(this);
		frame.getContentPane().add(lightsBlueMinVal);
		
		lightsRedMaxVal = new JTextField();
		lightsRedMaxVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsRedMaxVal.setName("lightsRedMaxVal");
		lightsRedMaxVal.setFont(new Font("Laksaman", Font.PLAIN, 14));
		lightsRedMaxVal.setColumns(10);
		lightsRedMaxVal.setBounds(458, 349, 40, 19);
		lightsRedMaxVal.setText(String.valueOf(parms.getLights()[Parameters.RED][Parameters.MAX]));
		lightsRedMaxVal.addActionListener(this);
		lightsRedMaxVal.addFocusListener(this);
		frame.getContentPane().add(lightsRedMaxVal);
		
		lightsGreenMaxVal = new JTextField();
		lightsGreenMaxVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsGreenMaxVal.setName("lightsGreenMaxVal");
		lightsGreenMaxVal.setFont(new Font("Laksaman", Font.PLAIN, 14));
		lightsGreenMaxVal.setColumns(10);
		lightsGreenMaxVal.setBounds(458, 379, 40, 19);
		lightsGreenMaxVal.setText(String.valueOf(parms.getLights()[Parameters.GREEN][Parameters.MAX]));
		lightsGreenMaxVal.addActionListener(this);
		lightsGreenMaxVal.addFocusListener(this);
		frame.getContentPane().add(lightsGreenMaxVal);
		
		lightsBlueMaxVal = new JTextField();
		lightsBlueMaxVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsBlueMaxVal.setName("lightsBlueMaxVal");
		lightsBlueMaxVal.setFont(new Font("Laksaman", Font.PLAIN, 14));
		lightsBlueMaxVal.setColumns(10);
		lightsBlueMaxVal.setBounds(458, 405, 40, 19);
		lightsBlueMaxVal.setText(String.valueOf(parms.getLights()[Parameters.BLUE][Parameters.MAX]));
		lightsBlueMaxVal.addActionListener(this);
		lightsBlueMaxVal.addFocusListener(this);
		frame.getContentPane().add(lightsBlueMaxVal);
		
		lightsRedSpeedVal = new JTextField();
		lightsRedSpeedVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsRedSpeedVal.setName("lightsRedSpeedVal");
		lightsRedSpeedVal.setFont(new Font("Laksaman", Font.PLAIN, 14));
		lightsRedSpeedVal.setColumns(10);
		lightsRedSpeedVal.setBounds(648, 349, 60, 19);
		lightsRedSpeedVal.setText(String.valueOf(parms.getLights()[Parameters.RED][Parameters.SPEED]));
		lightsRedSpeedVal.addActionListener(this);
		lightsRedSpeedVal.addFocusListener(this);
		frame.getContentPane().add(lightsRedSpeedVal);
		
		lightsGreenSpeedVal = new JTextField();
		lightsGreenSpeedVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsGreenSpeedVal.setName("lightsGreenSpeedVal");
		lightsGreenSpeedVal.setFont(new Font("Laksaman", Font.PLAIN, 14));
		lightsGreenSpeedVal.setColumns(10);
		lightsGreenSpeedVal.setBounds(648, 379, 60, 19);
		lightsGreenSpeedVal.setText(String.valueOf(parms.getLights()[Parameters.GREEN][Parameters.SPEED]));
		lightsGreenSpeedVal.addActionListener(this);
		lightsGreenSpeedVal.addFocusListener(this);
		frame.getContentPane().add(lightsGreenSpeedVal);
		
		lightsBlueSpeedVal = new JTextField();
		lightsBlueSpeedVal.setHorizontalAlignment(SwingConstants.RIGHT);
		lightsBlueSpeedVal.setName("lightsBlueSpeedVal");
		lightsBlueSpeedVal.setFont(new Font("Laksaman", Font.PLAIN, 14));
		lightsBlueSpeedVal.setColumns(10);
		lightsBlueSpeedVal.setBounds(648, 405, 60, 19);
		lightsBlueSpeedVal.setText(String.valueOf(parms.getLights()[Parameters.BLUE][Parameters.SPEED]));
		lightsBlueSpeedVal.addActionListener(this);
		lightsBlueSpeedVal.addFocusListener(this);
		frame.getContentPane().add(lightsBlueSpeedVal);
		
		JLabel label = new JLabel("0");
		label.setFont(new Font("Laksaman", Font.BOLD, 8));
		label.setBounds(129, 128, 15, 19);
		frame.getContentPane().add(label);
		
		JLabel label_7 = new JLabel("255");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setFont(new Font("Laksaman", Font.BOLD, 8));
		label_7.setBounds(254, 128, 15, 19);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("0");
		label_8.setFont(new Font("Laksaman", Font.BOLD, 8));
		label_8.setBounds(317, 128, 15, 19);
		frame.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("255");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setFont(new Font("Laksaman", Font.BOLD, 8));
		label_9.setBounds(442, 128, 15, 19);
		frame.getContentPane().add(label_9);
		
		JLabel lblms = new JLabel("50ms");
		lblms.setHorizontalAlignment(SwingConstants.LEFT);
		lblms.setFont(new Font("Laksaman", Font.BOLD, 8));
		lblms.setBounds(507, 128, 28, 19);
		frame.getContentPane().add(lblms);
		
		JLabel lbls = new JLabel("10s");
		lbls.setHorizontalAlignment(SwingConstants.RIGHT);
		lbls.setFont(new Font("Laksaman", Font.BOLD, 8));
		lbls.setBounds(632, 128, 15, 19);
		frame.getContentPane().add(lbls);
				
		JLabel lblVapor = new JLabel("Steam bath");
		lblVapor.setFont(new Font("Laksaman", Font.BOLD, 24));
		lblVapor.setBounds(22, 497, 312, 32);
		frame.getContentPane().add(lblVapor);
		
		JLabel lblHumidity = new JLabel("Humidity");
		lblHumidity.setFont(new Font("Laksaman", Font.PLAIN, 18));
		lblHumidity.setBounds(12, 554, 117, 15);
		frame.getContentPane().add(lblHumidity);
		
		JLabel lblTemperature = new JLabel("Temperature");
		lblTemperature.setFont(new Font("Laksaman", Font.PLAIN, 18));
		lblTemperature.setBounds(12, 616, 117, 15);
		frame.getContentPane().add(lblTemperature);
		
		JLabel lblNewLabel = new JLabel("%");
		lblNewLabel.setFont(new Font("Laksaman", Font.BOLD, 14));
		lblNewLabel.setBounds(213, 556, 70, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblC = new JLabel("C°");
		lblC.setFont(new Font("Laksaman", Font.BOLD, 14));
		lblC.setBounds(213, 618, 70, 15);
		frame.getContentPane().add(lblC);
		
		JLabel lblTimer = new JLabel("Timer");
		lblTimer.setFont(new Font("Laksaman", Font.PLAIN, 18));
		lblTimer.setBounds(528, 554, 75, 15);
		frame.getContentPane().add(lblTimer);
		
		JLabel lblMin_1 = new JLabel("min");
		lblMin_1.setFont(new Font("Laksaman", Font.BOLD, 14));
		lblMin_1.setBounds(678, 553, 35, 15);
		frame.getContentPane().add(lblMin_1);
		
		JLabel lblMusic = new JLabel("Music");
		lblMusic.setFont(new Font("Laksaman", Font.BOLD, 24));
		lblMusic.setBounds(22, 679, 312, 32);
		frame.getContentPane().add(lblMusic);
		
		JLabel lblSteamBathConfigration = new JLabel("Steam bath configration");
		lblSteamBathConfigration.setHorizontalAlignment(SwingConstants.CENTER);
		lblSteamBathConfigration.setFont(new Font("Laksaman", Font.BOLD, 24));
		lblSteamBathConfigration.setBounds(199, 12, 312, 32);
		frame.getContentPane().add(lblSteamBathConfigration);
		
		JSpinner timer = new JSpinner();
		timer.setBounds(603, 544, 70, 32);
		timer.setValue(parms.getHumidity());
		frame.getContentPane().add(timer);
		
		JSpinner humidity = new JSpinner();
		humidity.setBounds(129, 547, 70, 32);
		humidity.setValue(parms.getTemperature());
		frame.getContentPane().add(humidity);
		
		JSpinner temperature = new JSpinner();
		temperature.setBounds(129, 609, 70, 32);
		temperature.setValue(parms.getTimer());
		frame.getContentPane().add(temperature);

		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Laksaman", Font.BOLD, 14));
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
			}
		});
		
		frame.getContentPane().add(btnSave);
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		btnCancel.setFont(new Font("Laksaman", Font.BOLD, 14));
		btnCancel.setBounds(507, 982, 117, 25);
		frame.getContentPane().add(btnCancel);		
	}
	
	private Component findComponentByName(String name)
	{
		for (Component item : frame.getContentPane().getComponents())
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
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
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
		}
	}	

	public JFrame getFrame() {
		return frame;
	}
}
