package Phase1;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import java.time.*;
import java.time.format.DateTimeFormatter;
/**
 * this class is developed in day-12
 */
public class DateFormate {
	static Logger log = Logger.getLogger(DateFormate.class.getName());

	/**this is the main method for the class Dates */
	public static void main (String[] args) {
		try{
		FileAppender logFileAppender = new FileAppender(new SimpleLayout(), "C:/Users/anu-d/Desktop/tasks/Phase1/logs/DatesFormate.txt");
		BasicConfigurator.configure(logFileAppender);
	
		 
		 log.debug("Hello this is a debug message");
		 log.info("Hello this is an info message");

			System.out.println("Hello this is Date Formate program. Do you want to continue?");
        boolean temp = true;
		String s;
        while(temp){
            System.out.println("Type 'yes' to continue or Type 'no' to terminate");
            String x=System.console().readLine();
            switch(x){
                case "yes":
					System.out.println("Enter a date (dd/mm/yyyy)");
					s=System.console().readLine();
					//convert string to integer array with '/'
					String str1[] = s.split("/");
					
					//init localdate object with input taken
					LocalDate localdate= LocalDate.of(Integer.parseInt(str1[2]), Integer.parseInt(str1[1]), Integer.parseInt(str1[0]));
					System.out.println("Before formatting: " + localdate);
					
					//formate and print in dd-MM-yyyy
					DateTimeFormatter formate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					System.out.println("After formatting (dd-mm-yyyy): " + localdate.format(formate));
					
					//formate and print in yyyy-MM-dd
					formate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					System.out.println("After formatting (yyyy-MM-dd): " + localdate.format(formate));
					
					//formate and print in dd-MM-yyyy
					formate = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
					System.out.println("After formatting (dd-MMM-yyyy): " + localdate.format(formate));
					
					//formate and print in MMM-dd-yyyy
					formate = DateTimeFormatter.ofPattern("MMM-dd-yyyy");
					System.out.println("After formatting (dd-MMM-yyyy): " + localdate.format(formate));
					
					//formate and print in E,MM dd yyyy
					formate = DateTimeFormatter.ofPattern("E,MM dd yyyy");
					System.out.println("After formatting (E,MM dd yyyy): " + localdate.format(formate));
					break;

                case "no" :
                    System.out.println("program ended");
                    temp=false;
                    break;

                default: 
                    System.out.println("Please enter 'yes' or 'no' only");
                    break;
                }
        }
     
        }catch(Exception e){
            System.out.println("Error! Program Terminated");
			e.printStackTrace();
        }
		
		
		
	}
}

/**
 * algorithm for the class Dates
 * START
	* take inputs
	* split string using "/"
	*
	* init localdate object
	* print localdate object
	*
	* init datetimeformatter object of pattern dd-MM-yyyy
	* print localdate
	*
	* init datetimeformatter object of pattern yyyy-MM-dd
	* print localdate
	*
	* init datetimeformatter object of pattern dd-MM-yyyy
	* print localdate
	*
	* init datetimeformatter object of pattern MM-dd-yyyy
	* print localdate
	*
	* init datetimeformatter object of pattern E, MM-dd-yyyy
	* print localdate
 * END
 *
 */