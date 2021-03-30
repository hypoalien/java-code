package Phase1;

import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.ConsoleAppender;
import java.io.File;
import java.io.IOException;

/**
 * this class is developed on day-14
 */
public class Files {

  static Logger log = Logger.getLogger(Files.class.getName());

  /**
   * this is the main method for the class Files
   * 
   * @param args
   * 
   */
  public static void main(String args[]) {

    boolean temp = true;
    String option, folder, contents[];
    
    PatternLayout layout = new PatternLayout("%-5p %d{dd MMM yyyy HH:mm:ss} [%t] : %m %n");
    ConsoleAppender consoleAppender = new ConsoleAppender(layout);
    //BasicConfigurator.configure(consoleAppender);

    log.info("Hello this is Files program. Do you want to continue?");
    

    while (temp) {
      try {

        log.info("\n1. Continue\n2. Terminate");
        option = System.console().readLine();
        
        switch (option) {
        case "1" :
          log.info("Enter a folder name or path :");
          folder= System.console().readLine();
          File file = new File("C:/Users/anu-d/Desktop/tasks/Phase1/" + folder);

          // using list() file names are stored in an array
          contents = file.list();
          // prints the array
          log.info("names of all the files and directory:");
          for (String content : contents) {
            log.info(content);
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
        log.info("Oops!, Lets try that again");
        // log.debug(e.toString());
      }
    }

  }
}

/**
 * algorithm for the class Files START init file object with given arguments
 * store contents in contents[] using list() method print the elements of the
 * array contents[] STOP
 */