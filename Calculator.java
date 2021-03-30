package Phase1;



import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.PatternLayout;

/**
 * this class is developed on day-01
 * 
 */
public class Calculator {
     static Logger log = Logger.getLogger(Calculator.class.getName());

     /** this is the main funtion for the class Calculator */
     public static void main(String[] args) {
          // init variables
          boolean temp = true;
          double result=0, firstDigit, secondDigit;
          String option, operator, operation=null;

          // init log4j config
          PatternLayout layout = new PatternLayout("%-5p %d{dd MMM yyyy HH:mm:ss} [%t] : %m %n");
          ConsoleAppender consoleAppender = new ConsoleAppender(layout);
          //BasicConfigurator.configure(consoleAppender);

          log.info("Hello User this is Calculator program. Do you want to continue?");

          while (temp) {
               try {

                    log.info("\n1. Continue\n2. Terminate");
                    option = System.console().readLine();

                    switch (option) {

                    case "1" :

                         log.info("enter number a : ");
                         firstDigit = Double.parseDouble(System.console().readLine());

                         log.info("enter number b : ");
                         secondDigit = Double.parseDouble(System.console().readLine());
                         
                         log.info("Choose an option :\n1. Sum\n2. Difference\n3. Product\n4. Quotient\n5. Modular\n  ");
                         operator = System.console().readLine();

                         switch (operator) {
                         case "1":
                              result = firstDigit + secondDigit;
                              operation = "+";
                              break;

                         case "2":
                              result = firstDigit - secondDigit;
                              operation = "-";
                              break;
                         case "3":
                              result = firstDigit * secondDigit;
                              operation = "*";
                              break;
                         case "4":
                              result = firstDigit / secondDigit;
                              operation = "/";
                              break;
                         case "5":
                              result = firstDigit % secondDigit;
                              operation = "%";
                              break;
                         default:
                              log.info("Please Choose from given options only");
                              firstDigit=0;
                              operation =" ";
                              secondDigit=0;
                              result=0;
                              break;
                              
                         }

                         log.info(firstDigit + " " + operation + " " + secondDigit + " = " + result);
                         break;

                    case "2" :
                         log.info("program Ended");
                         temp = false;
                         break;

                    default:
                         log.info("Please enter from  the given values only");
                         break;

                    }

               } catch (NumberFormatException e) {
                    log.warn("Oops, what was that ! Please provide right inputs");
                    //log.warn(e.printStackTrace);

               }
          }
     }
}

