
package Phase1;

import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.ConsoleAppender;

import java.util.ArrayList;

/** this class is developed on day-05 */
public class List {
	static Logger log = Logger.getLogger(List.class.getName());

	/**
	 * Method for adding elements to list
	 * 
	 * @param list
	 */
	public static void add(ArrayList<String> list) {
		for (int counter = 0; counter < 3; counter++) {
			log.info("Enter an element to add : ");
			list.add(System.console().readLine());
		}
		log.info("After Adding elements : " + list);

	}

	/**
	 * Method for finding if the list is empty
	 * 
	 * @param list
	 */
	public static void isEmpty(ArrayList<String> list) {
		log.info("Is list empty : " + list.isEmpty());
	}

	/**
	 * Method for finding index of element in a list
	 * 
	 * @param list
	 */
	public static void indexOf(ArrayList<String> list) {
		System.out.print("Enter an element to find index : ");
		String string = System.console().readLine();
		log.info("Index of " + string + " : " + (list.indexOf(string)+1));
	}

	/**
	 * Method to set value of certain index
	 * 
	 * @param list
	 */
	public static void set(ArrayList<String> list) {
		log.info("Enter index to set value: ");
		int index = Integer.parseInt(System.console().readLine())-1;
		log.info("Enter element to set value : ");
		String element = System.console().readLine();
		list.set(index, element);
		log.info("Added " + element + " at index : " + index);
		log.info("After setting : " + list);

	}

	/**
	 * Method for contains Returns true if found Returns false if not found
	 * 
	 * @param list
	 */
	static void contains(ArrayList<String> list) {
		log.info("enter element to find (returns false if not found): ");
		String string = System.console().readLine();
		log.info(list.contains(string));
	}

	/**
	 * Method to remove an element
	 * 
	 * @param list
	 */
	static void remove(ArrayList<String> list) {
		log.info("Enter a index REMOVE : ");
		int index = Integer.parseInt(System.console().readLine())-1;
		list.remove(index);
		log.info("After removing : " + list);
	}

	/**
	 * Method to find the size of element
	 * 
	 * @param list
	 */
	static void size(ArrayList<String> list) {
		log.info("Size of list : " + list.size());
		log.info("End of program"); // since this method is called at the end of the program "End of program is
									// printed"
	}

	/**
	 * Main method of the class List
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		boolean temp = true;
		String option;
		ArrayList<String> list = new ArrayList<String>();

		PatternLayout layout = new PatternLayout("%-5p %d{dd MMM yyyy HH:mm:ss} [%t] : %m %n");
        ConsoleAppender consoleAppender = new ConsoleAppender(layout);
        //BasicConfigurator.configure(consoleAppender);
		

		log.info("Hello this is List program. Do you want to continue?");
		

		while (temp) {
			try {

				log.info("\n1. Continue\n2. Terminate");
				option= System.console().readLine();
				switch (option) {
				case "1" :
					

					add(list);
					isEmpty(list);
					indexOf(list);
					set(list);
					contains(list);
					remove(list);
					size(list);
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
				log.info("Error! Lets do it again");
				//log.debug(e.toString());
			}
		}

	}
}

/**
 * algorithm for List functions START initialize an empty arraylist call add()
 * call isEmpty() call indexOf() call Set() call remove() call size() STOP
 *
 */
