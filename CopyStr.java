package Phase1;

import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.ConsoleAppender;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * this class is developed on day-17
 */
public class CopyStr {
    static Logger log = Logger.getLogger(CopyStr.class.getName());

    /**
     * this is the main function of the class CopyStr
     * 
     * @param args
     */
    public static void main(String[] args) {

        //init variables
        boolean temp = true;
        String filename,option;
        
        //init log4j 
        PatternLayout layout = new PatternLayout("%-5p %d{dd MMM yyyy HH:mm:ss} [%t] : %m %n");
        ConsoleAppender consoleAppender = new ConsoleAppender(layout);
        //BasicConfigurator.configure(consoleAppender);

        log.info("Hello this is Copy String from a file program. Do you want to continue?");
        
        while (temp) {
            try {

                log.info("\n1. Continue\n2. Terminate");
                option = System.console().readLine();

                switch (option) {
                case "1" :
                    log.info("Enter a file name");
                    filename = System.console().readLine();

                    log.info("Contents in the file are :\n\n"+copy(filename));
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
                log.warn("Oops! please recheck the entered filename ");
                // log.debug(e.toString());
            }
        }

    }

    /**
     * this is copy method this method takes in file path as argument this method
     * copies the contents of the file and returns it as a string
     * 
     * @param filename
     * @return
     */
    public static String copy(String filename) {
        String string;

        // String builder class is used for creating mutable strings
        StringBuilder contentBuilder = new StringBuilder();
        try {
            // init buffered reader object
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            
            //readLine() method returns A String containing the contents of the line, not including any line-termination characters, or null if the end of the stream has been reached
            while ((string= bufferedReader.readLine()) != null) {
                contentBuilder.append(string).append("\n");
            }
        } catch (Exception e) {
            log.warn("Oops! please recheck the entered filename ");
        } finally {
            return contentBuilder.toString();
        }

    }
}
