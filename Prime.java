package Phase1;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
/** 
 * this class is developed on day-10
 */
public class Prime {
	static Logger log = Logger.getLogger(Prime.class.getName());
	
	//Main method
	/**
	 * this is the main method of the class Prime
	 * @param args
	 */
	public static void main (String [] args) {
		try{
		FileAppender logFileAppender = new FileAppender(new SimpleLayout(), "C:/Users/anu-d/Desktop/tasks/Phase1/logs/Prime.txt");
		BasicConfigurator.configure(logFileAppender);
	
		 
		 log.debug("Hello this is a debug message");
		 log.info("Hello this is an info message");
		
   
				System.out.println("Hello this is Prime program. Do you want to continue?");
			boolean temp = true;
			
			
				//Initialize variables
				boolean flag =false;
				int p1=0,p2=0,i;
        while(temp){
            System.out.println("Type 'yes' to continue or Type 'no' to terminate");
            String z=System.console().readLine();
            switch(z){
                case "yes":
					System.out.println("Enter a number :");
					i = Integer.parseInt(System.console().readLine());
					for(int x=0;x<i;x++) {
						//Check if x is prime
						if(checkPrime(x)) {
							
							//check if i-x is prime 
							if(checkPrime(i-x)) {
								
								//the given number can be expressed as 2 prime numbers x and i-x
								flag =true;
								p1=x;
								p2=i-x;
								break;
							}
						}
					}
					
					//output statements
					if(flag==true) {
						System.out.println("The number can be represented as : "+p1+" + "+p2);
					}else {
						System.out.println("The given number cannot be represented as prime sum of 2 prime numbers");
					}
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
	
	//Method to check if the given number is prime or not
	/**
	 * this method checks is the given number is prime or not
	 * @param i
	 * @return
	 */
	static  boolean checkPrime(int i) {
		boolean flag = true; 
		
		//return false if i ==0 ||i==1
		if(i==0 ||i==1) {
			flag= false;
			return flag;
		}
		
		//return true if i==2
		if(i==2) {
			return flag;
		}
		
		//checks if prime or not
		for (int x=2;x<i/2;x++) {
			if (i%x==0) {
				flag=false;
				break;
			}
		}
		return flag ;
	}
}

/**
 * algorithm for the class Prime
 * START
	* take input i
	* take x =0 ; x<i
	* check if x is prime
	* if true then check if x-i is prime
	* if true return true
	* else return false
	* print result
 STOP
 */