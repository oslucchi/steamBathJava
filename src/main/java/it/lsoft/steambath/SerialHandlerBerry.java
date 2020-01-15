package it.lsoft.steambath;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.pi4j.io.serial.Baud;
import com.pi4j.io.serial.DataBits;
import com.pi4j.io.serial.FlowControl;
import com.pi4j.io.serial.Parity;
import com.pi4j.io.serial.Serial;
import com.pi4j.io.serial.SerialConfig;
import com.pi4j.io.serial.SerialDataEvent;
import com.pi4j.io.serial.SerialDataEventListener;
import com.pi4j.io.serial.SerialFactory;
import com.pi4j.io.serial.StopBits;

public class SerialHandlerBerry {
	final static Logger logger = Logger.getLogger(SerialHandlerBerry.class);
    final Serial serial;

	/**
     * This example program supports the following optional command arguments/options:
     *   "--device (device-path)"                   [DEFAULT: /dev/ttyAMA0]
     *   "--baud (baud-rate)"                       [DEFAULT: 38400]
     *   "--data-bits (5|6|7|8)"                    [DEFAULT: 8]
     *   "--parity (none|odd|even)"                 [DEFAULT: none]
     *   "--stop-bits (1|2)"                        [DEFAULT: 1]
     *   "--flow-control (none|hardware|software)"  [DEFAULT: none]
     *
     * @param args
     * @throws InterruptedException
     * @throws IOException
     */
    public SerialHandlerBerry(String devicePath) throws InterruptedException, IOException {
    	// create an instance of the serial communications class
        serial = SerialFactory.createInstance();

        // create and register the serial data listener
        serial.addListener(new SerialDataEventListener() {
            @Override
            public void dataReceived(SerialDataEvent event) {

                // NOTE! - It is extremely important to read the data received from the
                // serial port.  If it does not get read from the receive buffer, the
                // buffer will continue to grow and consume memory.

                // print out the data received to the console
                try {
                	logger.debug("Received from controller:");
					logger.debug("[HEX DATA]   " + event.getHexByteString());
	                logger.debug("[ASCII DATA] " + event.getAsciiString());
                	logger.debug("");
				} 
                catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        try {
            // create serial config object
            SerialConfig config = new SerialConfig();

            // set default serial settings (device, baud rate, flow control, etc)
            //
            // by default, use the DEFAULT com port on the Raspberry Pi (exposed on GPIO header)
            // NOTE: this utility method will determine the default serial port for the
            //       detected platform and board/model.  For all Raspberry Pi models
            //       except the 3B, it will return "/dev/ttyAMA0".  For Raspberry Pi
            //       model 3B may return "/dev/ttyS0" or "/dev/ttyAMA0" depending on
            //       environment configuration.
            config.device(devicePath)
                  .baud(Baud._19200)
                  .dataBits(DataBits._8)
                  .parity(Parity.NONE)
                  .stopBits(StopBits._1)
                  .flowControl(FlowControl.NONE);

            // display connection details
            logger.debug(" Connecting to: " + config.toString());

            // open the default serial device/port with the configuration settings
            serial.open(config);
        }
        catch(IOException ex) {
            logger.error(" ==>> SERIAL SETUP FAILED : " + ex.getMessage());
            return;
        }
    }
    public boolean serialWrite(byte[] cmd)
    {
        // continuous loop to keep the program running until the user terminates the program
        try {
            // write a formatted string to the serial transmit buffer
            serial.write(cmd, 0, cmd[0]);
            return true;
        }
        catch(IllegalStateException | IOException ex){
            ex.printStackTrace();
        }
        return false;
    }
}

