package Phase1;

import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.ConsoleAppender;

/** this class is developed on day-09 */
public class Time {
	static Logger log = Logger.getLogger(Time.class.getName());
	// Global variables
	int seconds;
	int minutes;
	int hours;

	/**
	 * //Constuructor for Time class
	 * 
	 * @param hours
	 * @param minutes
	 * @param seconds
	 */
	public Time(int hours, int minutes, int seconds) {
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	/**
	 * this is the main class for the class Time
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		//init vars
		boolean temp = true;
		int hours, minutes, seconds;
		String option;

		//init log4j 
		PatternLayout layout = new PatternLayout("%-5p %d{dd MMM yyyy HH:mm:ss} [%t] : %m %n");
        ConsoleAppender consoleAppender = new ConsoleAppender(layout);
        //BasicConfigurator.configure(consoleAppender);

		log.info("Hello this is Time program. Do you want to continue?");
		
		while (temp) {
			try {

				log.info("\n1. Continue\n2. Terminate");
				option= System.console().readLine();
				switch (option) {
				case "1" :
					log.info("enter hours :");
					hours = Integer.parseInt(System.console().readLine());
					log.info("enter minutes :");
					minutes = Integer.parseInt(System.console().readLine());
					log.info("enter seconds :");
					seconds = Integer.parseInt(System.console().readLine());

					// invoking Time class with Time(constructor)
					Time start = new Time(hours, minutes, seconds);

					// Taking inupt from user
					log.info("enter hours :");
					hours = Integer.parseInt(System.console().readLine());
					log.info("enter minutes :");

					minutes = Integer.parseInt(System.console().readLine());
					log.info("enter seconds :");
					seconds = Integer.parseInt(System.console().readLine());

					// Invoking time class
					Time stop = new Time(hours, minutes, seconds);

					// Invoking difference method
					Time diff = difference(start, stop);
					System.out.printf("TIME DIFFERENCE : ");
					System.out.printf(" %d:%d:%d\n", diff.hours, diff.minutes, diff.seconds);
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

	/**
	 * this method returns time object after finding the difference
	 * 
	 * @param start
	 * @param stop
	 * @return
	 */
	public static Time difference(Time start, Time stop) {
		Time diff = new Time(0, 0, 0);

		// If stop.seconds is greater convert minute to second
		if (stop.seconds > start.seconds) {
			start.minutes = start.minutes - 1;
			start.seconds = start.seconds + 60;
		}

		// Calculate the dfference
		diff.seconds = start.seconds - stop.seconds;

		// If start.seconds is greater convert minute to second
		if (stop.minutes > start.minutes) {
			start.hours = start.hours - 1;
			start.minutes = start.minutes + 60;
		}

		// calculate the difference
		diff.minutes = start.minutes - stop.minutes;
		diff.hours = start.hours - stop.hours;

		// return time object
		return (diff);
	}
}

/**
 * algorithm for time class START take input start time initialize time object
 * take input stop time initialize time object call difference() print the
 * difference STOP
 */
