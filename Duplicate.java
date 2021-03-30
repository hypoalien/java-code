
//note that this method provides n(O) solution 
package Phase1;

import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.ConsoleAppender;
import java.util.ArrayList;

/** this class is developed on day-07 */
public class Duplicate {

	static Logger log = Logger.getLogger(Duplicate.class.getName());

	/**
	 * this is main method for the class Duplicate
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		boolean temp = true;
		int counter=0;
		String option;
		ArrayList<String> arraylist = new ArrayList<String>();

		PatternLayout layout = new PatternLayout("%-5p %d{dd MMM yyyy HH:mm:ss} [%t] : %m %n");
		ConsoleAppender consoleAppender = new ConsoleAppender(layout);
		//BasicConfigurator.configure(consoleAppender);

		log.info("Hello this is Duplicate program. Do you want to continue?");
	

		while (temp) {
			try {

				log.info("\n1. Continue\n2. Terminate");
				option = System.console().readLine();
				switch (option) {
				case "1" :
				
					for (counter=0;counter<5;counter++) {
						log.info("Enter element "+(counter+1)+"/5"+" :");
						arraylist.add(System.console().readLine());
					}
					// output results
					log.info("List before removing dublicates : " + arraylist);
					log.info("List after removing dublicates : " + remove(arraylist));
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
				// log.debug(e.toString());
			}
		}

	}

	/**
	 * //Method for removing dublicate
	 * 
	 * @param a
	 * @return
	 */

	static ArrayList<String> remove(ArrayList<String> arraylist1) {
		// Init a new list
		ArrayList<String> arraylist2 = new ArrayList<String>();

		// check if new list contains the string if false add the string
		for (String string : arraylist1) {
			if (!arraylist2.contains(string)) {
				arraylist2.add(string);
			}
		}

		// return arraylist after removing dublicates
		return arraylist2;
	}
}
/**
 * algorithm for Dublicate class START initialize arraylist object take inputs
 * call remove() print result STOP
 */