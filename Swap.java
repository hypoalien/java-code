//Note: provides solution without using 3rd variable

package Phase1;

import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.ConsoleAppender;

/**
 * this class is developed on day-08
 */
public class Swap {

	static Logger log = Logger.getLogger(Swap.class.getName());

	/** this is the main function of the class */
	public static void main(String[] args) {

		boolean temp = true;
		String option;
		
		PatternLayout layout = new PatternLayout("%-5p %d{dd MMM yyyy HH:mm:ss} [%t] : %m %n");
        ConsoleAppender consoleAppender = new ConsoleAppender(layout);
        //BasicConfigurator.configure(consoleAppender);

		log.info("Hello this is Swap program. Do you want to continue?");
		
		while (temp) {
			try {

				log.info("\n1. Continue\n2. Terminate");
				option = System.console().readLine();
				switch (option) {
				case "1" :
					// Init scanner object

					log.info("Enter number A : ");

					// take input
					int a = Integer.parseInt(System.console().readLine());

					log.info("Enter number B : ");

					// take input
					int b = Integer.parseInt(System.console().readLine());
					log.info("Value before swaping : A : " + a + " B : " + b);
					// swap without using temp variable
					a = a + b;
					b = a - b;
					a = a - b;

					// output result

					log.info("Value after swaping : A : " + a + " B : " + b);
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
 * algorithm for the class Swap START take input a and b swap without using a
 * 3rd variable print out a and b STOP
 */