package Phase1;

import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.ConsoleAppender;

import java.io.FileNotFoundException;

import java.util.Date;

/**
 * this class is developed on day-11
 */
public class Dates {
    static Logger log = Logger.getLogger(Dates.class.getName());

    /**
     * this is the main method for the class Dates and it executes all date
     * functions
     * 
     * @param args
     */
    public static void main(String[] args) {
        
        //init variables
        String datestring1, datestring2,option;
        boolean temp = true;

        //inti log4j
        PatternLayout layout = new PatternLayout("%-5p %d{dd MMM yyyy HH:mm:ss} [%t] : %m %n");
        ConsoleAppender consoleAppender = new ConsoleAppender(layout);
        //BasicConfigurator.configure(consoleAppender);

        log.info("Hello this is Dates program. Do you want to continue?");
       
        while (temp) {
            try {

                log.info("\n1. Continue\n2. Terminate");
                option = System.console().readLine();
                switch (option) {

                case "1" :
                    log.info("Enter  first date (dd/mm/yyyy)");
                    datestring1=System.console().readLine();

                    log.info("Enter  second date (dd/mm/yyyy)");
                    datestring2 = System.console().readLine();

                    // string is splitted using the "/"
                    String datearray1[] = datestring1.split("/");
                    Date date1 = new Date(Integer.parseInt(datearray1[2]), Integer.parseInt(datearray1[1]),
                            Integer.parseInt(datearray1[0]));
                    // String is converted to int
                    String datearray2[] = datestring2.split("/");
                    Date date2 = new Date(Integer.parseInt(datearray2[2]), Integer.parseInt(datearray2[1]),
                            Integer.parseInt(datearray2[0]));

                    Date date3 = new Date();

                    // print current date
                    log.info("current date  : " + date3);

                    // Check if given dates are equal
                    log.info("Date " + datestring1 + " equals Date " + datestring2 + ": " + date1.equals(date2));

                    // check if date1 is after date2
                    log.info("Date " + datestring1 + " after Date " + datestring2 + " : " + date1.after(date2));

                    // check if date1 is before date2
                    log.info("Date " + datestring1 + " before Date " + datestring2 + ": " + date1.before(date2));
                    
                    //compareTo() returns the value 0 if the argument Date is equal to this Date; a value less than 0 if this Date is before the Date argument; and a value greater than 0 if this Date is after the Date argument
                    if(date1.compareTo(date2)==0){
                        log.info("Date " + datestring1 + " and Date " + datestring2 + "are equal");
                    }if(date1.compareTo(date2)<0){
                        log.info("Date " + datestring1 + " is before the date " + datestring2 );
                    }if(date1.compareTo(date2)>0){
                        log.info("Date " + datestring1 + " is after the date " + datestring2 );
                    }

                    // prints current number of milliseconds since jan 1 1970
                    log.info("Current number of milliseconds since January 1, 1970, 00:00:00 GTM : " + date1.getTime());
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
                log.info("Was that even a date ? Lets try that again");
                // log.debug(e.toString());
            }
        }

    }

}
/**
 * algorithm for dates class START take inputs split with "/" and store it in
 * Date Class print current date call equals() call after() call before() call
 * getTime() STOP
 *
 */
