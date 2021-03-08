
//note that this method provides n(O) solution 
package Phase1;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import java.util.ArrayList;
/** this class is developed on day-07 */
public class Duplicate {

	static Logger log = Logger.getLogger(Duplicate.class.getName());
	/**
	 * this is main method for the class Duplicate 
	 * @param args
	 */
	public static void main(String[] args) {
		try{
		FileAppender logFileAppender = new FileAppender(new SimpleLayout(), "C:/Users/anu-d/Desktop/tasks/Phase1/logs/Duplicate.txt");
        BasicConfigurator.configure(logFileAppender);
    
         
         log.debug("Hello this is a debug message");
         log.info("Hello this is an info message");
		

			System.out.println("Hello this is Duplicate program. Do you want to continue?");
        boolean temp = true;
        while(temp){
            System.out.println("Type 'yes' to continue or Type 'no' to terminate");
            String x=System.console().readLine();
            switch(x){
                case "yes":
					 //init scanner object
		
					ArrayList<String> arraylist= new ArrayList<String>();

					//take input
					for (int i =0;i<5;i++) {
						System.out.println("Enter an element : ");
						arraylist.add(System.console().readLine());
					}
					//output results
					System.out.println("List before removing dublicates : "+arraylist);
					System.out.println("List after removing dublicates : "+remove(arraylist));
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
	/**
	 * //Method for removing dublicate
	 * @param a
	 * @return
	 */
    
	static ArrayList<String> remove(ArrayList<String> a){
        //Init a new list
		ArrayList<String> arraylist= new ArrayList<String>();
		
        //check if new list contains the string if false add the string
		for (String s : a) {
			if(!arraylist.contains(s)) {
				arraylist.add(s);
			}
		}

        //return arraylist after removing dublicates
		return arraylist;
	}
}
/**
 * algorithm for Dublicate class
 * START
	* initialize arraylist object
	* take inputs
	* call remove()
	* print result
 *STOP
 */