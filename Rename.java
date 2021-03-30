package Phase1;

import java.io.File;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.ConsoleAppender;
import java.io.IOException;


/**
 * this class is developed on day-15
 */
public class Rename {
    static Logger log = Logger.getLogger(Rename.class.getName());

   
    /**
     * this is the main method of the class Rename
     * 
     * @param args
     * @throws IOException
     */
    public static void main(String args[]) {

        boolean temp = true;
        File oldname, newname;
        String option,folder;

        
        PatternLayout layout = new PatternLayout("%-5p %d{dd MMM yyyy HH:mm:ss} [%t] : %m %n");
        ConsoleAppender consoleAppender = new ConsoleAppender(layout);
        //BasicConfigurator.configure(consoleAppender);

        log.info("Hello this is Rename program. Do you want to continue?");
       

        while (temp) {
            try {

                log.info("\n1. Continue\n2. Terminate");
                option = System.console().readLine();
                switch (option) {
                case "1" :
                    log.info("Enter a folder path :");
                    folder = System.console().readLine();
                    File file = new File("C:/Users/anu-d/Desktop/tasks/Phase1/" + folder);

                    // store names in an array
                    String names[] = file.list();

                    for (int i = 0; i < names.length; i++) {
                        log.info(names[i]);
                        oldname = new File("C:/Users/anu-d/Desktop/tasks/Phase1/" + folder + "/" + names[i]);
                        newname = new File(
                                "C:/Users/anu-d/Desktop/tasks/Phase1/" + folder + "/" + "ENH" + names[i] + i + ".txt");

                        // rename returns false in case of exception and error
                        if (oldname.renameTo(newname))
                            log.info("done");
                        else
                            log.info("failed");
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
                log.info("Error! Program Terminated");
                //log.debug(e.toString());
            }
        }

    }
}

/**
 * algorithm for the class Rename START init file object with given arguments
 * store the list of files in names[] iterate through names[] and change each
 * file name by appending ENH in the front and a number at the end print done if
 * true print failed if false STOP
 */
