package Phase1;

import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.ConsoleAppender;

/**
 * this class is developed on day-13
 */
public class Sum {

    static Logger log = Logger.getLogger(Sum.class.getName());

    /**
     * this is the main method for the class Sum
     * 
     * @param args
     */
    public static void main(String[] args) {

        boolean temp = true;
        String date1, date2,option;
        
        PatternLayout layout = new PatternLayout("%-5p %d{dd MMM yyyy HH:mm:ss} [%t] : %m %n");
        ConsoleAppender consoleAppender = new ConsoleAppender(layout);
        //BasicConfigurator.configure(consoleAppender);

        log.info("Hello this is Sum program. Do you want to continue?");
       

        while (temp) {
            try {

                log.info("\n1. Continue\n2. Terminate");
                option = System.console().readLine();
                switch (option) {
                case "1" :

                    // take inputs

                    log.info("Enter a date in formate (dd/mm/yyyy)");
                    date1 = System.console().readLine();

                    log.info("Enter a date in formate (mm/dd/yyyy)");
                    date2 = System.console().readLine();

                    // split string into arrays at "/"
                    String datearray1[] = date1.split("/");
                    String datearray2[] = date2.split("/");

                    // init calander object with current instance
                    Calendar cal1 = Calendar.getInstance();
                    Calendar cal2 = Calendar.getInstance();

                    // set values in cal object from taken input
                    cal1.set(Integer.parseInt(datearray1[2]), Integer.parseInt(datearray1[1]), Integer.parseInt(datearray1[0]));
                    cal2.set(Integer.parseInt(datearray2[2]), Integer.parseInt(datearray2[0]), Integer.parseInt(datearray2[1]));

                    // add 2nd date to the 1st date
                    cal1.add(Calendar.YEAR, cal2.get(Calendar.YEAR));
                    cal1.add(Calendar.MONTH, cal2.get(Calendar.MONTH));
                    cal1.add(Calendar.DATE, cal2.get(Calendar.DATE));

                    // init date formate as dd-mm-yyyy
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

                    // print the added date
                    System.out.format("%s + %s = %s \n", date1, date2, sdf.format(cal1.getTime()));
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
                log.debug(e.toString());
            }
        }

    }

}

/**
 * algorithm for the class Sum START take inputs split string by "/" init
 * calender object cal1 and cal2 add cal1 and cal2 in cal1 print cal1 in the
 * needed formate END
 *
 */
