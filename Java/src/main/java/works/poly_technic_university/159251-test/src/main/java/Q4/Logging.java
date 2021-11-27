package Q4;

import org.apache.log4j.*;

import java.io.*;


/**
 * Q4
 * @author add name here
 * @id add ID here
 */


public class Logging {



    public static void main(String[] args){
        Logger logger = Logger.getLogger(Logging.class);
        logger.debug("debug 2");
        logger.fatal("big issue 1");
        logger.info("info 2");
        logger.debug("debug 3");
        logger.fatal("big issue");
        logger.error("error 1");
        logger.error("error 2");
    }

}
