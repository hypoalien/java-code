package Phase1;

import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.ConsoleAppender;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * this class is developed in day-12
 */
public class DateFormat {
	static Logger log = Logger.getLogger(DateFormate.class.getName());

	/** this is the main method for the class Dates */
	public static void main(String[] args) {
		//init variables
		boolean temp = true;
		String option,date;

		//init log4j 
		PatternLayout layout = new PatternLayout("%-5p %d{dd MMM yyyy HH:mm:ss} [%t] : %m %n");
		ConsoleAppender consoleAppender = new ConsoleAppender(layout);
		//BasicConfigurator.configure(consoleAppender);

		log.info("Hello this is Date Format program. Do you want to continue?");
		

		while (temp) {

			try {

				log.info("\n1. Continue\n2. Terminate");
				option = System.console().readLine();
				switch (option) {
				case "1" :
					log.info("Enter a date (dd/mm/yyyy)");
					date = System.console().readLine();
					// convert string to integer array with '/'
					String datearray[] = date.split("/");

					// init localdate object with input taken
					LocalDate localdate = LocalDate.of(Integer.parseInt(datearray[2]), Integer.parseInt(datearray[1]),
							Integer.parseInt(datearray[0]));
					log.info("Before formatting: " + localdate);

					// formate and print in dd-MM-yyyy
					DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					log.info("After formatting (dd-mm-yyyy): " + localdate.format(format));

					// format and print in yyyy-MM-dd
					format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					log.info("After formatting (yyyy-MM-dd): " + localdate.format(format));

					// format and print in dd-MM-yyyy
					format = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
					log.info("After formatting (dd-MMM-yyyy): " + localdate.format(format));

					// format and print in MMM-dd-yyyy
					format = DateTimeFormatter.ofPattern("MMM-dd-yyyy");
					log.info("After formatting (dd-MMM-yyyy): " + localdate.format(format));

					// format and print in E,MM dd yyyy
					format = DateTimeFormatter.ofPattern("E,MM dd yyyy");
					log.info("After formatting (E,MM dd yyyy): " + localdate.format(format));
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
				log.warn("Was that even a date ? Please try again.");
				// e.printStackTrace();
			}
		}

	}
}

/**
 * algorithm for the class Dates START take inputs split string using "/"
 *
 * init localdate object print localdate object
 *
 * init datetimeformatter object of pattern dd-MM-yyyy print localdate
 *
 * init datetimeformatter object of pattern yyyy-MM-dd print localdate
 *
 * init datetimeformatter object of pattern dd-MM-yyyy print localdate
 *
 * init datetimeformatter object of pattern MM-dd-yyyy print localdate
 *
 * init datetimeformatter object of pattern E, MM-dd-yyyy print localdate END
 *
 */