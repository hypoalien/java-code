package Phase1;

import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.ConsoleAppender;
import java.util.HashMap;

/** this class is developed on day-06 */
public class Count {
	static Logger log = Logger.getLogger(Count.class.getName());

	/**
	 * this is the main function for the class Count
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		//inti variables
		boolean temp = true;
		String option,sentence;
		int count=0;

		//inti log4J
		PatternLayout layout = new PatternLayout("%-5p %d{dd MMM yyyy HH:mm:ss} [%t] : %m %n");
		ConsoleAppender consoleAppender = new ConsoleAppender(layout);
		//BasicConfigurator.configure(consoleAppender);

		log.info("Hello this is Count program. Do you want to continue?");
		

		while (temp) {
			try {

				log.info("\n1. Continue\n2. Terminate");
				 option = System.console().readLine();
				switch (option) {
				case "1" :
					// take input from user
					log.info("Enter a sentence");
					sentence = System.console().readLine();	

					// split the string into words and store it in a array
					String words[] = sentence.split(" ");

					// count the number of words
					for (String word : words) {
						count++;
					}

					// print the size of hashmap using size() method
					log.info("No of words in the above sentence is : " + count);
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
				log.warn("Error! Forgot the count ");
				// log.debug(e.toString());
			}

		}

	}
}
/**
 * algorithm for count class START take inputs split the string with " " and
 * store it in an array count the size of array print count END
 *
 */
