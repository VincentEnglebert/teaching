/**
 * 
 */
package log4j;

import org.apache.log4j.PropertyConfigurator;

/**
 * @author UNamur
 *
 */


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
 
public class Main
{
    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());
     
    public static void main(String[] args)
    {
    	
    	 //PropertyConfigurator.configure("log4j2.properties");
    	 
        LOGGER.debug("Debug Message Logged !!");
        LOGGER.info("Info Message Logged !!");
        LOGGER.debug("Another Debug Message !!");
    }
}
