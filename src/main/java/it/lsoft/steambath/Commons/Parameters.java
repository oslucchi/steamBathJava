package it.lsoft.steambath.Commons;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.ini4j.Ini;
import org.ini4j.Wini;

/**
 * @author osvaldo
 *
 */
public class Parameters 
{
	static Logger logger = Logger.getLogger(Parameters.class);
	static public final int RED = 0;
	static public final int GREEN = 1;
	static public final int BLUE = 2;
	static public final int MIN = 0;
	static public final int MAX = 1;
	static public final int SPEED = 2;
	static public final int TMR_BYTE_0 = 0;
	static public final int TMR_BYTE_1 = 1;
	static public final int DAYS = 2;
	static public final int HOURS = 3;
	static public final int MINS = 4;
	static public final int SECS = 5;
	static public final int TENTH_OF_MILS= 6;
	
	int[][] starry = new int[3][4];
	int[][] lights = new int[3][4];
	int[][] starryTimers = new int[3][7];
	int[][] lightsTimers = new int[3][7];
	int[] starryManual = new int[3];
	int[] lightsManual = new int[3];
	
	int humidity = 70;
	int temperature = 40;
	int timer = 30;
	
	private static Parameters instance = null;
	private static String confFilePath = null;
	private Ini ini = null;
	
	public static Parameters getInstance(String pConfFilePath) //throws InvalidFileFormatException, IOException
	{
		confFilePath = pConfFilePath;
		if (instance == null)
			instance = new Parameters(confFilePath);
		return instance;
	}
	
	public Parameters rescan() throws IOException
	{
		instance = new Parameters(confFilePath);
		return instance;
	}

	private Parameters(String pConfFilePath) // throws InvalidFileFormatException, IOException
	{
	    // Inizializza la libreria di log
		// PropertyConfigurator.configure("/Watering.ini");
		
	    // Leggere i Parametri con cui gira questa istanza dell'applicazione
		try 
		{
			ini = new Wini(getClass().getResourceAsStream(confFilePath));
		}
		catch (IOException e) 
		{
			logger.fatal("Exception " + e.getMessage() + " on Params Ini. Aborting");
			System.exit(-1);
		}
		
		starry[RED][MIN] = Integer.parseInt(ini.get("starry", "redMin"));
		starry[RED][MAX] = Integer.parseInt(ini.get("starry", "redMax"));
		starry[RED][SPEED] = Integer.parseInt(ini.get("starry", "redSpeed"));
		starry[GREEN][MIN] = Integer.parseInt(ini.get("starry", "greenMin"));
		starry[GREEN][MAX] = Integer.parseInt(ini.get("starry", "greenMax"));
		starry[GREEN][SPEED] = Integer.parseInt(ini.get("starry", "greenSpeed"));
		starry[BLUE][MIN] = Integer.parseInt(ini.get("starry", "blueMin"));
		starry[BLUE][MAX] = Integer.parseInt(ini.get("starry", "blueMax"));
		starry[BLUE][SPEED] = Integer.parseInt(ini.get("starry", "blueSpeed"));
		starryTimers[RED][DAYS] = Integer.parseInt(ini.get("starry", "redTmrDays"));
		starryTimers[RED][HOURS] = Integer.parseInt(ini.get("starry", "redTmrHours"));
		starryTimers[RED][MINS] = Integer.parseInt(ini.get("starry", "redTmrMins"));
		starryTimers[RED][SECS] = Integer.parseInt(ini.get("starry", "redTmrSecs"));
		starryTimers[RED][TENTH_OF_MILS] = Integer.parseInt(ini.get("starry", "redTmrTenthMils"));
		starryTimers[GREEN][DAYS] = Integer.parseInt(ini.get("starry", "greenTmrDays"));
		starryTimers[GREEN][HOURS] = Integer.parseInt(ini.get("starry", "greenTmrHours"));
		starryTimers[GREEN][MINS] = Integer.parseInt(ini.get("starry", "greenTmrMins"));
		starryTimers[GREEN][SECS] = Integer.parseInt(ini.get("starry", "greenTmrSecs"));
		starryTimers[GREEN][TENTH_OF_MILS] = Integer.parseInt(ini.get("starry", "greenTmrTenthMils"));
		starryTimers[BLUE][DAYS] = Integer.parseInt(ini.get("starry", "blueTmrDays"));
		starryTimers[BLUE][HOURS] = Integer.parseInt(ini.get("starry", "blueTmrHours"));
		starryTimers[BLUE][MINS] = Integer.parseInt(ini.get("starry", "blueTmrMins"));
		starryTimers[BLUE][SECS] = Integer.parseInt(ini.get("starry", "blueTmrSecs"));
		starryTimers[BLUE][TENTH_OF_MILS] = Integer.parseInt(ini.get("starry", "blueTmrTenthMils"));

		lights[RED][MIN] = Integer.parseInt(ini.get("lights", "redMin"));
		lights[RED][MAX] = Integer.parseInt(ini.get("lights", "redMax"));
		lights[RED][SPEED] = Integer.parseInt(ini.get("lights", "redSpeed"));
		lights[GREEN][MIN] = Integer.parseInt(ini.get("lights", "greenMin"));
		lights[GREEN][MAX] = Integer.parseInt(ini.get("lights", "greenMax"));
		lights[GREEN][SPEED] = Integer.parseInt(ini.get("lights", "greenSpeed"));
		lights[BLUE][MIN] = Integer.parseInt(ini.get("lights", "blueMin"));
		lights[BLUE][MAX] = Integer.parseInt(ini.get("lights", "blueMax"));
		lights[BLUE][SPEED] = Integer.parseInt(ini.get("lights", "blueSpeed"));
		lightsTimers[RED][DAYS] = Integer.parseInt(ini.get("lights", "redTmrDays"));
		lightsTimers[RED][HOURS] = Integer.parseInt(ini.get("lights", "redTmrHours"));
		lightsTimers[RED][MINS] = Integer.parseInt(ini.get("lights", "redTmrMins"));
		lightsTimers[RED][SECS] = Integer.parseInt(ini.get("lights", "redTmrSecs"));
		lightsTimers[RED][TENTH_OF_MILS] = Integer.parseInt(ini.get("lights", "redTmrTenthMils"));
		lightsTimers[GREEN][DAYS] = Integer.parseInt(ini.get("lights", "greenTmrDays"));
		lightsTimers[GREEN][HOURS] = Integer.parseInt(ini.get("lights", "greenTmrHours"));
		lightsTimers[GREEN][MINS] = Integer.parseInt(ini.get("lights", "greenTmrMins"));
		lightsTimers[GREEN][SECS] = Integer.parseInt(ini.get("lights", "greenTmrSecs"));
		lightsTimers[GREEN][TENTH_OF_MILS] = Integer.parseInt(ini.get("lights", "greenTmrTenthMils"));
		lightsTimers[BLUE][DAYS] = Integer.parseInt(ini.get("lights", "blueTmrDays"));
		lightsTimers[BLUE][HOURS] = Integer.parseInt(ini.get("lights", "blueTmrHours"));
		lightsTimers[BLUE][MINS] = Integer.parseInt(ini.get("lights", "blueTmrMins"));
		lightsTimers[BLUE][SECS] = Integer.parseInt(ini.get("lights", "blueTmrSecs"));
		lightsTimers[BLUE][TENTH_OF_MILS] = Integer.parseInt(ini.get("lights", "blueTmrTenthMils"));

		starryManual[RED] = Integer.parseInt(ini.get("manual", "starryManRedVal"));
		starryManual[GREEN] = Integer.parseInt(ini.get("manual", "starryManGreenVal"));
		starryManual[BLUE] = Integer.parseInt(ini.get("manual", "starryManBlueVal"));
		lightsManual[RED] = Integer.parseInt(ini.get("manual", "lightsManRedVal"));
		lightsManual[GREEN] = Integer.parseInt(ini.get("manual", "lightsManGreenVal"));
		lightsManual[BLUE] = Integer.parseInt(ini.get("manual", "lightsManBlueVal"));
				

		setTimers();
		
		humidity = Integer.parseInt(ini.get("steamGen", "humidity"));
		temperature = Integer.parseInt(ini.get("steamGen", "temperature"));
		timer = Integer.parseInt(ini.get("steamGen", "timer"));
	}

	public void setTimers()
	{
		if (starryTimers[RED][DAYS] != 0)
		{
			starryTimers[RED][TMR_BYTE_0] = (byte) (3<<6);
			starryTimers[RED][TMR_BYTE_0] |= (starryTimers[RED][DAYS] & 0b00111110);
			starryTimers[RED][TMR_BYTE_1] = (byte) ((starryTimers[RED][DAYS] & 0b00000001) << 7);
			starryTimers[RED][TMR_BYTE_1] |= (starryTimers[RED][HOURS] & 0b01111111);
		}
		else if (starryTimers[RED][HOURS] != 0)
		{
			starryTimers[RED][TMR_BYTE_0] = (byte) (2<<6);
			starryTimers[RED][TMR_BYTE_0] |= (starryTimers[RED][HOURS] & 0b00111110);
			starryTimers[RED][TMR_BYTE_1] = (byte) ((starryTimers[RED][HOURS] & 0b00000001) << 7);
			starryTimers[RED][TMR_BYTE_1] |= (starryTimers[RED][MINS] & 0b01111111);
		}
		else if (starryTimers[RED][MINS] != 0)
		{
			starryTimers[RED][TMR_BYTE_0] = (byte) (1<<6);
			starryTimers[RED][TMR_BYTE_0] |= (starryTimers[RED][MINS] & 0b00111110);
			starryTimers[RED][TMR_BYTE_1] = (byte) ((starryTimers[RED][MINS] & 0b00000001) << 7);
			starryTimers[RED][TMR_BYTE_1] |= (starryTimers[RED][SECS] & 0b01111111);
		}
		else
		{
			starryTimers[RED][TMR_BYTE_0] = (byte) (starryTimers[RED][SECS] & 0b00111110);
			starryTimers[RED][TMR_BYTE_1] = (byte) ((starryTimers[RED][SECS] & 0b00000001) << 7);
			starryTimers[RED][TMR_BYTE_1] |= ((starryTimers[RED][TENTH_OF_MILS] / 10) & 0b01111111);
		}

		if (starryTimers[GREEN][DAYS] != 0)
		{
			starryTimers[GREEN][TMR_BYTE_0] = (byte) (3<<6);
			starryTimers[GREEN][TMR_BYTE_0] |= (starryTimers[GREEN][DAYS] & 0b00111110);
			starryTimers[GREEN][TMR_BYTE_1] = (byte) ((starryTimers[GREEN][DAYS] & 0b00000001) << 7);
			starryTimers[GREEN][TMR_BYTE_1] |= (starryTimers[GREEN][HOURS] & 0b01111111);
		}
		else if (starryTimers[GREEN][HOURS] != 0)
		{
			starryTimers[GREEN][TMR_BYTE_0] = (byte) (2<<6);
			starryTimers[GREEN][TMR_BYTE_0] |= (starryTimers[GREEN][HOURS] & 0b00111110);
			starryTimers[GREEN][TMR_BYTE_1] = (byte) ((starryTimers[GREEN][HOURS] & 0b00000001) << 7);
			starryTimers[GREEN][TMR_BYTE_1] |= (starryTimers[GREEN][MINS] & 0b01111111);
		}
		else if (starryTimers[GREEN][MINS] != 0)
		{
			starryTimers[GREEN][TMR_BYTE_0] = (byte) (1<<6);
			starryTimers[GREEN][TMR_BYTE_0] |= (starryTimers[GREEN][MINS] & 0b00111110);
			starryTimers[GREEN][TMR_BYTE_1] = (byte) ((starryTimers[GREEN][MINS] & 0b00000001) << 7);
			starryTimers[GREEN][TMR_BYTE_1] |= (starryTimers[GREEN][SECS] & 0b01111111);
		}
		else
		{
			starryTimers[GREEN][TMR_BYTE_0] = (byte) (starryTimers[GREEN][SECS] & 0b00111110);
			starryTimers[GREEN][TMR_BYTE_1] = (byte) ((starryTimers[GREEN][SECS] & 0b00000001) << 7);
			starryTimers[GREEN][TMR_BYTE_1] |= ((starryTimers[GREEN][TENTH_OF_MILS] / 10) & 0b01111111);
		}

		if (starryTimers[BLUE][DAYS] != 0)
		{
			starryTimers[BLUE][TMR_BYTE_0] = (byte) (3<<6);
			starryTimers[BLUE][TMR_BYTE_0] |= (starryTimers[BLUE][DAYS] & 0b00111110);
			starryTimers[BLUE][TMR_BYTE_1] = (byte) ((starryTimers[BLUE][DAYS] & 0b00000001) << 7);
			starryTimers[BLUE][TMR_BYTE_1] |= (starryTimers[BLUE][HOURS] & 0b01111111);
		}
		else if (starryTimers[BLUE][HOURS] != 0)
		{
			starryTimers[BLUE][TMR_BYTE_0] = (byte) (2<<6);
			starryTimers[BLUE][TMR_BYTE_0] |= (starryTimers[BLUE][HOURS] & 0b00111110);
			starryTimers[BLUE][TMR_BYTE_1] = (byte) ((starryTimers[BLUE][HOURS] & 0b00000001) << 7);
			starryTimers[BLUE][TMR_BYTE_1] |= (starryTimers[BLUE][MINS] & 0b01111111);
		}
		else if (starryTimers[BLUE][MINS] != 0)
		{
			starryTimers[BLUE][TMR_BYTE_0] = (byte) (1<<6);
			starryTimers[BLUE][TMR_BYTE_0] |= (starryTimers[BLUE][MINS] & 0b00111110);
			starryTimers[BLUE][TMR_BYTE_1] = (byte) ((starryTimers[BLUE][MINS] & 0b00000001) << 7);
			starryTimers[BLUE][TMR_BYTE_1] |= (starryTimers[BLUE][SECS] & 0b01111111);
		}
		else
		{
			starryTimers[BLUE][TMR_BYTE_0] = (byte) (starryTimers[BLUE][SECS] & 0b00111110);
			starryTimers[BLUE][TMR_BYTE_1] = (byte) ((starryTimers[BLUE][SECS] & 0b00000001) << 7);
			starryTimers[BLUE][TMR_BYTE_1] |= ((starryTimers[BLUE][TENTH_OF_MILS] / 10) & 0b01111111);
		}

		if (lightsTimers[RED][DAYS] != 0)
		{
			lightsTimers[RED][TMR_BYTE_0] = (byte) (3<<6);
			lightsTimers[RED][TMR_BYTE_0] |= (lightsTimers[RED][DAYS] & 0b00111110);
			lightsTimers[RED][TMR_BYTE_1] = (byte) ((lightsTimers[RED][DAYS] & 0b00000001) << 7);
			lightsTimers[RED][TMR_BYTE_1] |= (lightsTimers[RED][HOURS] & 0b01111111);
		}
		else if (lightsTimers[RED][HOURS] != 0)
		{
			lightsTimers[RED][TMR_BYTE_0] = (byte) (2<<6);
			lightsTimers[RED][TMR_BYTE_0] |= (lightsTimers[RED][HOURS] & 0b00111110);
			lightsTimers[RED][TMR_BYTE_1] = (byte) ((lightsTimers[RED][HOURS] & 0b00000001) << 7);
			lightsTimers[RED][TMR_BYTE_1] |= (lightsTimers[RED][MINS] & 0b01111111);
		}
		else if (lightsTimers[RED][MINS] != 0)
		{
			lightsTimers[RED][TMR_BYTE_0] = (byte) (1<<6);
			lightsTimers[RED][TMR_BYTE_0] |= (lightsTimers[RED][MINS] & 0b00111110);
			lightsTimers[RED][TMR_BYTE_1] = (byte) ((lightsTimers[RED][MINS] & 0b00000001) << 7);
			lightsTimers[RED][TMR_BYTE_1] |= (lightsTimers[RED][SECS] & 0b01111111);
		}
		else
		{
			lightsTimers[RED][TMR_BYTE_0] = (byte) (lightsTimers[RED][SECS] & 0b00111110);
			lightsTimers[RED][TMR_BYTE_1] = (byte) ((lightsTimers[RED][SECS] & 0b00000001) << 7);
			lightsTimers[RED][TMR_BYTE_1] = ((lightsTimers[RED][TENTH_OF_MILS] / 10) & 0b01111111);
		}

		if (lightsTimers[GREEN][DAYS] != 0)
		{
			lightsTimers[GREEN][TMR_BYTE_0] = (byte) (3<<6);
			lightsTimers[GREEN][TMR_BYTE_0] |= (lightsTimers[GREEN][DAYS] & 0b00111110);
			lightsTimers[GREEN][TMR_BYTE_1] = (byte) ((lightsTimers[GREEN][DAYS] & 0b00000001) << 7);
			lightsTimers[GREEN][TMR_BYTE_1] |= (lightsTimers[GREEN][HOURS] & 0b01111111);
		}
		else if (lightsTimers[GREEN][HOURS] != 0)
		{
			lightsTimers[GREEN][TMR_BYTE_0] = (byte) (2<<6);
			lightsTimers[GREEN][TMR_BYTE_0] |= (lightsTimers[GREEN][HOURS] & 0b00111110);
			lightsTimers[GREEN][TMR_BYTE_1] = (byte) ((lightsTimers[GREEN][HOURS] & 0b00000001) << 7);
			lightsTimers[GREEN][TMR_BYTE_1] |= (lightsTimers[GREEN][MINS] & 0b01111111);
		}
		else if (lightsTimers[GREEN][MINS] != 0)
		{
			lightsTimers[GREEN][TMR_BYTE_0] = (byte) (1<<6);
			lightsTimers[GREEN][TMR_BYTE_0] |= (lightsTimers[GREEN][MINS] & 0b00111110);
			lightsTimers[GREEN][TMR_BYTE_1] = (byte) ((lightsTimers[GREEN][MINS] & 0b00000001) << 7);
			lightsTimers[GREEN][TMR_BYTE_1] |= (lightsTimers[GREEN][SECS] & 0b01111111);
		}
		else
		{
			lightsTimers[GREEN][TMR_BYTE_0] = (byte) (lightsTimers[GREEN][SECS] & 0b00111110);
			lightsTimers[GREEN][TMR_BYTE_1] = (byte) ((lightsTimers[GREEN][SECS] & 0b00000001) << 7);
			lightsTimers[GREEN][TMR_BYTE_1] = ((lightsTimers[GREEN][TENTH_OF_MILS] / 10) & 0b01111111);
		}

		if (lightsTimers[BLUE][DAYS] != 0)
		{
			lightsTimers[BLUE][TMR_BYTE_0] = (byte) (3<<6);
			lightsTimers[BLUE][TMR_BYTE_0] |= (lightsTimers[BLUE][DAYS] & 0b00111110);
			lightsTimers[BLUE][TMR_BYTE_1] = (byte) ((lightsTimers[BLUE][DAYS] & 0b00000001) << 7);
			lightsTimers[BLUE][TMR_BYTE_1] |= (lightsTimers[BLUE][HOURS] & 0b01111111);
		}
		else if (lightsTimers[BLUE][HOURS] != 0)
		{
			lightsTimers[BLUE][TMR_BYTE_0] = (byte) (2<<6);
			lightsTimers[BLUE][TMR_BYTE_0] |= (lightsTimers[BLUE][HOURS] & 0b00111110);
			lightsTimers[BLUE][TMR_BYTE_1] = (byte) ((lightsTimers[BLUE][HOURS] & 0b00000001) << 7);
			lightsTimers[BLUE][TMR_BYTE_1] |= (lightsTimers[BLUE][MINS] & 0b01111111);
		}
		else if (lightsTimers[BLUE][MINS] != 0)
		{
			lightsTimers[BLUE][TMR_BYTE_0] = (byte) (1<<6);
			lightsTimers[BLUE][TMR_BYTE_0] |= (lightsTimers[BLUE][MINS] & 0b00111110);
			lightsTimers[BLUE][TMR_BYTE_1] = (byte) ((lightsTimers[BLUE][MINS] & 0b00000001) << 7);
			lightsTimers[BLUE][TMR_BYTE_1] |= (lightsTimers[BLUE][SECS] & 0b01111111);
		}
		else
		{
			lightsTimers[BLUE][TMR_BYTE_0] = (byte) (lightsTimers[BLUE][SECS] & 0b00111110);
			lightsTimers[BLUE][TMR_BYTE_1] = (byte) ((lightsTimers[BLUE][SECS] & 0b00000001) << 7);
			lightsTimers[BLUE][TMR_BYTE_1] = ((lightsTimers[BLUE][TENTH_OF_MILS] / 10) & 0b01111111);
		}
	}
	
	public int[][] getStarry() {
		return starry;
	}

	public void setStarry(int[][] starry) {
		this.starry = starry;
	}

	public void setStarryElement(int color, int type, int value)
	{
		this.starry[color][type] = value;
	}
	
	public int[][] getLights() {
		return lights;
	}

	public int[][] getLightsTimers() {
		return lightsTimers;
	}

	public int[][] getStarryTimers() {
		return starryTimers;
	}
	
	public String[] getStarryTimersAsString()
	{
		String retVal[] = new String[3];
		retVal[RED] = new String();
		for(int i = 7; i >= 6; i--)
		{
			retVal[RED] += (((starryTimers[RED][TMR_BYTE_0] & (1 << i)) == 0) ? "0" : "1");
		}
		retVal[RED] += " ";
		for(int i = 5; i >= 0; i--)
		{
			retVal[RED] += (((starryTimers[RED][TMR_BYTE_0] & (1 << i)) == 0) ? "0" : "1");
		}
		retVal[RED] += (((starryTimers[RED][TMR_BYTE_1] & (1 << 7)) == 0) ? "0" : "1");
		retVal[RED] += " ";
		for(int i = 6; i >= 0; i--)
		{
			retVal[RED] += (((starryTimers[RED][TMR_BYTE_1] & (1 << i)) == 0) ? "0" : "1");
		}

		retVal[GREEN] = new String();
		for(int i = 7; i >= 6; i--)
		{
			retVal[GREEN] += (((starryTimers[GREEN][TMR_BYTE_0] & (1 << i)) == 0) ? "0" : "1");
		}
		retVal[GREEN] += " ";
		for(int i = 5; i >= 0; i--)
		{
			retVal[GREEN] += (((starryTimers[GREEN][TMR_BYTE_0] & (1 << i)) == 0) ? "0" : "1");
		}
		retVal[GREEN] += (((starryTimers[GREEN][TMR_BYTE_1] & (1 << 7)) == 0) ? "0" : "1");
		retVal[GREEN] += " ";
		for(int i = 6; i >= 0; i--)
		{
			retVal[GREEN] += (((starryTimers[GREEN][TMR_BYTE_1] & (1 << i)) == 0) ? "0" : "1");
		}

		retVal[BLUE] = new String();
		for(int i = 7; i >= 6; i--)
		{
			retVal[BLUE] += (((starryTimers[BLUE][TMR_BYTE_0] & (1 << i)) == 0) ? "0" : "1");
		}
		retVal[BLUE] += " ";
		for(int i = 5; i >= 0; i--)
		{
			retVal[BLUE] += (((starryTimers[BLUE][TMR_BYTE_0] & (1 << i)) == 0) ? "0" : "1");
		}
		retVal[BLUE] += (((starryTimers[BLUE][TMR_BYTE_1] & (1 << 7)) == 0) ? "0" : "1");
		retVal[BLUE] += " ";
		for(int i = 6; i >= 0; i--)
		{
			retVal[BLUE] += (((starryTimers[BLUE][TMR_BYTE_1] & (1 << i)) == 0) ? "0" : "1");
		}
		return retVal;
	}
	
	public void setLights(int[][] lights) {
		this.lights = lights;
	}

	public void setLightsElement(int color, int type, int value)
	{
		this.lights[color][type] = value;
	}
	
	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		this.timer = timer;
	}

	public void save()
	{
		ini.put("starry", "redMin", starry[RED][MIN]);
		ini.put("starry", "redMax", starry[RED][MAX]);
		ini.put("starry", "redSpeed", starry[RED][SPEED]);
		ini.put("starry", "greenMin", starry[GREEN][MIN]);
		ini.put("starry", "greenMax", starry[GREEN][MAX]);
		ini.put("starry", "greenSpeed", starry[GREEN][SPEED]);
		ini.put("starry", "blueMin", starry[BLUE][MIN]);
		ini.put("starry", "blueMax", starry[BLUE][MAX]);
		ini.put("starry", "blueSpeed", starry[BLUE][SPEED]);
		ini.put("starry", "redTmrHours", starryTimers[RED][HOURS]);
		ini.put("starry", "redTmrMins", starryTimers[RED][MINS]);
		ini.put("starry", "redTmrSecs", starryTimers[RED][SECS]);
		ini.put("starry", "redTmrMils", starryTimers[RED][TENTH_OF_MILS]);
		ini.put("starry", "greenTmrHours", starryTimers[GREEN][HOURS]);
		ini.put("starry", "greenTmrMins", starryTimers[GREEN][MINS]);
		ini.put("starry", "greenTmrSecs", starryTimers[GREEN][SECS]);
		ini.put("starry", "greenTmrMils", starryTimers[GREEN][TENTH_OF_MILS]);
		ini.put("starry", "blueTmrHours", starryTimers[BLUE][HOURS]);
		ini.put("starry", "blueTmrMins", starryTimers[BLUE][MINS]);
		ini.put("starry", "blueTmrSecs", starryTimers[BLUE][SECS]);
		ini.put("starry", "blueTmrMils", starryTimers[BLUE][TENTH_OF_MILS]);

		ini.put("lights", "redMin", lights[RED][MIN]);
		ini.put("lights", "redMax", lights[RED][MAX]);
		ini.put("lights", "redSpeed", lights[RED][SPEED]);
		ini.put("lights", "greenMin", lights[GREEN][MIN]);
		ini.put("lights", "greenMax", lights[GREEN][MAX]);
		ini.put("lights", "greenSpeed", lights[GREEN][SPEED]);
		ini.put("lights", "blueMin", lights[BLUE][MIN]);
		ini.put("lights", "blueMax", lights[BLUE][MAX]);
		ini.put("lights", "blueSpeed", lights[BLUE][SPEED]);
		ini.put("lights", "redTmrHours", lightsTimers[RED][HOURS]);
		ini.put("lights", "redTmrMins", lightsTimers[RED][MINS]);
		ini.put("lights", "redTmrSecs", lightsTimers[RED][SECS]);
		ini.put("lights", "redTmrMils", lightsTimers[RED][TENTH_OF_MILS]);
		ini.put("lights", "greenTmrHours", lightsTimers[GREEN][HOURS]);
		ini.put("lights", "greenTmrMins", lightsTimers[GREEN][MINS]);
		ini.put("lights", "greenTmrSecs", lightsTimers[GREEN][SECS]);
		ini.put("lights", "greenTmrMils", lightsTimers[GREEN][TENTH_OF_MILS]);
		ini.put("lights", "blueTmrHours", lightsTimers[BLUE][HOURS]);
		ini.put("lights", "blueTmrMins", lightsTimers[BLUE][MINS]);
		ini.put("lights", "blueTmrSecs", lightsTimers[BLUE][SECS]);
		ini.put("lights", "blueTmrMils", lightsTimers[BLUE][TENTH_OF_MILS]);

		ini.put("manual", "starryManRedVal", starryManual[RED]);
		ini.put("manual", "starryManGreenVal", starryManual[GREEN]);
		ini.put("manual", "starryManBlueVal", starryManual[BLUE]);
		ini.put("manual", "lightsManRedVal", lightsManual[RED]);
		ini.put("manual", "lightsManGreenVal", lightsManual[GREEN]);
		ini.put("manual", "lightsManBlueVal", lightsManual[BLUE]);

		setTimers();

		ini.put("steamGen", "humidity", humidity);
		ini.put("steamGen", "temperature", temperature);
		ini.put("steamGen", "timer", timer);
		try 
		{
			ini.store(new FileWriter(getClass().getResource(confFilePath).getPath()));
			System.out.println(Integer.parseInt(ini.get("lights", "redMin")) + " " + 
							   Integer.parseInt(ini.get("lights", "redMax")) + " " + 
							   Integer.parseInt(ini.get("lights", "redSpeed")));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void setStarryTimers(int color, int item, String value) {
		this.starryTimers[color][item] = Integer.parseInt(value);
	}

	public void setLightsTimers(int color, int item, String value) {
		this.lightsTimers [color][item] = Integer.parseInt(value);
	}

	public int[] getStarryManual() {
		return starryManual;
	}

	public void setStarryManual(int[] starryManual) {
		this.starryManual = starryManual;
	}

	public int[] getLightsManual() {
		return lightsManual;
	}

	public void setLightsManual(int[] lightsManual) {
		this.lightsManual = lightsManual;
	}
	
	
}
