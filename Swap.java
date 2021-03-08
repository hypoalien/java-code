//Note: provides solution without using 3rd variable


package Phase1;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
/** 
 * this class is developed on day-08
 */
public class Swap {

	static Logger log = Logger.getLogger(Swap.class.getName());
	/** this is the main function of the class  */
	public static void main(String[] args) {
		try{
		FileAppender logFileAppender = new FileAppender(new SimpleLayout(), "C:/Users/anu-d/Desktop/tasks/Phase1/logs/Swap.txt");
		BasicConfigurator.configure(logFileAppender);
	
		 
		 log.debug("Hello this is a debug message");
		 log.info("Hello this is an info message");
	
			System.out.println("Hello this is Swap program. Do you want to continue?");
        boolean temp = true;
        while(temp){
            System.out.println("Type 'yes' to continue or Type 'no' to terminate");
            String x=System.console().readLine();
            switch(x){
                case "yes":
					//Init scanner object
		
					System.out.println("Enter number A : ");
				
					//take input
					int a = Integer.parseInt(System.console().readLine());

					System.out.println("Enter number B : ");
				
					//take input
					int b= Integer.parseInt(System.console().readLine());
					System.out.println("Value before swaping : A : " +a+" B : "+b);
					//swap without using temp variable
					a=a+b;
					b=a-b;
					a=a-b;

					//output result
					
					System.out.println("Value after swaping : A : " +a+" B : "+b);
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

/** algorithm for the class Swap
 * START
	* take input a and b
	* swap without using a 3rd variable
	* print out a and b
 * STOP
*/