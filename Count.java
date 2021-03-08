package Phase1;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import java.util.HashMap;
/**this class is developed on day-06 */
public class Count {
	static Logger log = Logger.getLogger(Count.class.getName());

	/**
	 * this is the main function for the class Count 
	 * @param args
	 */
	public static void main(String[] args) {
		try{

		FileAppender logFileAppender = new FileAppender(new SimpleLayout(), "C:/Users/anu-d/Desktop/tasks/Phase1/logs/Count.txt");
		BasicConfigurator.configure(logFileAppender);
	
		 
		 log.debug("Hello this is a debug message");
		 log.info("Hello this is an info message");
		

			
			System.out.println("Hello this is Count program. Do you want to continue?");
        boolean temp = true;
        while(temp){
            System.out.println("Type 'yes' to continue or Type 'no' to terminate");
            String x=System.console().readLine();
            switch(x){
                case "yes":
					//take input from user
					System.out.println("Enter a sentence");
					String string = System.console().readLine();

					//init hashmap object
					HashMap<Integer, String> h = new HashMap<>();

					//split the string into words and store it in a array
					String word[]= string.split(" ");

					//convert the array to hashmap
					int i =0;
					for (String s: word) {
						h.put(i, s);
						i++;
					}

					//print the size of hashmap using size() method
					System.out.println("No of words in the above sentence is : "+h.size());
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
			log.debug(e.toString());
		}
		
		
	}
}
/** algorithm for count class
 * START
	* take inputs
	* split the string with " " and store it in an array
	* count the size of array
	* print count
 * END
 *
 */
