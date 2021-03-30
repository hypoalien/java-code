package Phase1;

import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.ConsoleAppender;

/**
 * this class is developed on day-10
 */
public class Prime {
	static Logger log = Logger.getLogger(Prime.class.getName());

	// Main method
	/**
	 * this is the main method of the class Prime
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		boolean temp = true;
		boolean flag = false;
		String option;
		int prime1=0, prime2=0 , number;

	
		PatternLayout layout = new PatternLayout("%-5p %d{dd MMM yyyy HH:mm:ss} [%t] : %m %n");
        ConsoleAppender consoleAppender = new ConsoleAppender(layout);
        //BasicConfigurator.configure(consoleAppender);

		log.info("Hello this is Prime program. Do you want to continue?");
		

		
		

		while (temp) {
			try {
				flag=false;

				log.info("\n1. Continue\n2. Terminate");
				 option = System.console().readLine();
				switch (option) {
				case "1" :
					log.info("Enter a number :");
					number = Integer.parseInt(System.console().readLine());
					for (int counter = 0; counter < number; counter++) {
						// Check if x is prime
						if (checkPrime(counter)) {

							// check if i-x is prime
							if (checkPrime(number - counter)) {

								// the given number can be expressed as 2 prime numbers x and i-x
								flag = true;
								prime1 = counter;
								prime2 = number - counter;
								break;
							}
						}
					}

					// output statements
					if (flag == true) {
						log.info("The number can be represented as : " + prime1 + " + " + prime2);
					} else {
						log.info("The given number cannot be represented as prime sum of 2 prime numbers");
					}
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

	// Method to check if the given number is prime or not
	/**
	 * this method checks is the given number is prime or not
	 * 
	 * @param i
	 * @return
	 */
	static boolean checkPrime(int number) {
		try{
			boolean flag = true;

		// return false if i ==0 ||i==1
		if (number == 0 || number == 1) {
			flag = false;
			return flag;
		}

		// return true if i==2
		if (number == 2) {
			return flag;
		}

		// checks if prime or not
		for (int counter = 2; counter < (number / 2)+1; counter++) {
			if (number % counter == 0) {
				flag = false;
				break;
			}
		}
		return flag;
		}catch (Exception e){
			log.warn("Number is too big, lets try again!");
			return false;
		}
	}
}

/**
 * algorithm for the class Prime START take input i take x =0 ; x<i check if x
 * is prime if true then check if x-i is prime if true return true else return
 * false print result STOP
 */