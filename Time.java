package Phase1;

import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
	/** this class is developed on day-09 */
	public class Time {
		static Logger log = Logger.getLogger(Time.class.getName());
		//Global variables
		int seconds;
		int minutes;
		int hours;
		/**
		 * //Constuructor for Time class
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
		 * @param args
		 */
		public static void main(String[] args) {
			try{
			
			//BasicConfigurator.configure();
			FileAppender logFileAppender = new FileAppender(new SimpleLayout(), "C:/Users/anu-d/Desktop/tasks/Phase1/logs/Time.txt");
			BasicConfigurator.configure(logFileAppender);
		
			 
			 log.debug("Hello this is a debug message");
			 log.info("Hello this is an info message");
			
				System.out.println("Hello this is Time program. Do you want to continue?");
			boolean temp = true;
			int hours,minutes,seconds;
			while(temp){
				
				System.out.println("Type 'yes' to continue or Type 'no' to terminate");
				String x=System.console().readLine();
				switch(x){
					case "yes":
						System.out.println("enter hours :");
						hours= Integer.parseInt(System.console().readLine());
						System.out.println("enter minutes :");
						minutes= Integer.parseInt(System.console().readLine());
						System.out.println("enter seconds :");
						seconds= Integer.parseInt(System.console().readLine());
				
						//invoking Time class with Time(constructor)
						Time start = new Time(hours, minutes, seconds);
				
				
						//Taking inupt from user
						System.out.println("enter hours :");
						hours=Integer.parseInt(System.console().readLine());
						System.out.println("enter minutes :");
					
						minutes= Integer.parseInt(System.console().readLine());
						System.out.println("enter seconds :");
						seconds= Integer.parseInt(System.console().readLine());
				
						//Invoking time class
						Time stop = new Time(hours, minutes, seconds);
						
						//Invoking difference method
						Time diff = difference(start, stop);
						System.out.printf("TIME DIFFERENCE : ");
						System.out.printf(" %d:%d:%d\n", diff.hours, diff.minutes, diff.seconds);
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
		 * this method returns time object after finding the difference
		 * @param start
		 * @param stop
		 * @return
		 */
		public static Time difference(Time start, Time stop)
		{
			Time diff = new Time(0, 0, 0);

			//If stop.seconds is greater convert minute to second 
			if(stop.seconds > start.seconds){
				start.minutes=start.minutes-1;
				start.seconds=start.seconds+60;
			}

			//Calculate the dfference 
			diff.seconds = start.seconds - stop.seconds;

			//If start.seconds is greater convert minute to second 
			if(stop.minutes > start.minutes){
				start.hours=start.hours-1;
				start.minutes=start.minutes+60;
			}
			
			//calculate the difference
			diff.minutes = start.minutes - stop.minutes;
			diff.hours = start.hours - stop.hours;

			//return time object
			return(diff);
		}
	}

/**
 * algorithm for time class
 * START
	* take input start time
	* initialize time object
	* take input stop time
	* initialize time object
	* call difference()
	* print the difference
 * STOP
 */
