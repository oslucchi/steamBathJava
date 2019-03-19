package it.lsoft.steambath.Commons;

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
	
	int[][] starry = new int[3][4];
	int[][] lights = new int[3][4];
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

		lights[RED][MIN] = Integer.parseInt(ini.get("lights", "redMin"));
		lights[RED][MAX] = Integer.parseInt(ini.get("lights", "redMax"));
		lights[RED][SPEED] = Integer.parseInt(ini.get("lights", "redSpeed"));
		lights[GREEN][MIN] = Integer.parseInt(ini.get("lights", "greenMin"));
		lights[GREEN][MAX] = Integer.parseInt(ini.get("lights", "greenMax"));
		lights[GREEN][SPEED] = Integer.parseInt(ini.get("lights", "greenSpeed"));
		lights[BLUE][MIN] = Integer.parseInt(ini.get("lights", "blueMin"));
		lights[BLUE][MAX] = Integer.parseInt(ini.get("lights", "blueMax"));
		lights[BLUE][SPEED] = Integer.parseInt(ini.get("lights", "blueSpeed"));

		humidity = Integer.parseInt(ini.get("steamGen", "humidity"));
		temperature = Integer.parseInt(ini.get("steamGen", "temperature"));
		timer = Integer.parseInt(ini.get("steamGen", "timer"));
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

		ini.put("lights", "redMin", lights[RED][MIN]);
		ini.put("lights", "redMax", lights[RED][MAX]);
		ini.put("lights", "redSpeed", lights[RED][SPEED]);
		ini.put("lights", "greenMin", lights[GREEN][MIN]);
		ini.put("lights", "greenMax", lights[GREEN][MAX]);
		ini.put("lights", "greenSpeed", lights[GREEN][SPEED]);
		ini.put("lights", "blueMin", lights[BLUE][MIN]);
		ini.put("lights", "blueMax", lights[BLUE][MAX]);
		ini.put("lights", "blueSpeed", lights[BLUE][SPEED]);

		ini.put("steamGen", "humidity", humidity);
		ini.put("steamGen", "temperature", temperature);
		ini.put("steamGen", "timer", timer);
		
		try 
		{
			ini.store();
			System.out.println(Integer.parseInt(ini.get("lights", "redMin")) + " " + 
							   Integer.parseInt(ini.get("lights", "redMax")) + " " + 
							   Integer.parseInt(ini.get("lights", "redSpeed")));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
