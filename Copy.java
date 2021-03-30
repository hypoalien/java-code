package Phase1;

import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.ConsoleAppender;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * this class is developed on day-16
 */
public class Copy {

    static Logger log = Logger.getLogger(Copy.class.getName());

    /**
     * this is the main method of class Copy
     * 
     * @param args
     */
    public static void main(String[] args) {

        //initializing variables
        boolean temp = true;
        String source, destination,option;
        
        //initializing log4j 
        PatternLayout layout = new PatternLayout("%-5p %d{dd MMM yyyy HH:mm:ss} [%t] : %m %n");
        ConsoleAppender consoleAppender = new ConsoleAppender(layout);
        //BasicConfigurator.configure(consoleAppender);

        log.info("Hello this is Copy program. Do you want to continue?");
        
        while (temp) {
            try {

                log.info("\n1. Continue\n2. Terminate");
                option = System.console().readLine();

                switch (option) {
                case "1" :

                    try {
                        //input file name to copy from
                        log.info("Enter file name to copy from :");
                        source = System.console().readLine();
                         File sourceFile = new File(source);


                        //input file name to paste in 
                        log.info("Enter file name to paste in :");
                        destination = System.console().readLine();
                        File destinationFile = new File(destination);

                        copyPaste(sourceFile, destinationFile);

                    } catch (Exception e) {
                        log.info("Oops lets try that again");
                    }
                    break;

                case "2" :
                    log.info("program ended");
                    temp = false;
                    break;

                default:
                    log.info("Please enter from  the given values only");
                    break;
                }

            } catch (Exception e) {
                log.warn("Error ! Please provide right inputs");
                // log.debug(e.toString());
            }

        }

    }

    /**
     * this is copyPaste method this method copies the contents of one file and
     * pastes it in another file
     * 
     * @param a
     * @param b
     */
    public static void copyPaste(File source, File destination) {
        // try block as the method read() and close () will throw error which is handled
        // by catch block

        // to store bytes of the file
        int bytes;
        try {

            // init input and output stream objects
            FileInputStream in = new FileInputStream(source);
            FileOutputStream out = new FileOutputStream(destination);

            

            // method read() will return the next byte of data, or -1 if the end of the file is reached.
            while ((bytes= in.read()) != -1) {
                out.write(bytes);
            }

            // close streams
            in.close();
            out.close();
        }

        // catch exception
        catch (Exception e) {
            log.info("Failed");
            return;
        }

        log.info("Copied");
    }
}

