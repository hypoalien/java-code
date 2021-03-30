package Phase1;

import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.ConsoleAppender;

/**
 * this class is developed on day-02
 */
public class Hello {
     static Logger log = Logger.getLogger(Hello.class.getName());

    /**
     * this is the main function of the class hello
     * 
     * @param args
     */
    public static void main(String[] args) {

        boolean temp = true;
        String firstName, lastName,option;

        PatternLayout layout = new PatternLayout("%-5p %d{dd MMM yyyy HH:mm:ss} [%t] : %m %n");
        ConsoleAppender consoleAppender = new ConsoleAppender(layout);
        //BasicConfigurator.configure(consoleAppender);

        

        
        log.info("Hello this is Hello program. Do you want to continue?");
      

        while (temp) {
            try {
                log.info("\n1. Continue\n2. Terminate");
                option = System.console().readLine();
                switch (option) {
                case "1" :
                    log.info("Enter first name");
                    firstName = System.console().readLine();

                    log.info("Enter last name");
                    lastName = System.console().readLine();

                    log.info("Hello " + firstName + " " + lastName);
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
                log.info("Error! Program terminated");
                // log.debug(e.toString());
            }
        }

    }
}

/*
 * Algorithm for hello.java START
 * 
 * declare variables firstName and lastName print "Enter your first name " take
 * input to var firstName" print "Enter your last name" take input to var
 * lastName" print "hello"+firstname+lastName STOP
 */