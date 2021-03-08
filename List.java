
package Phase1;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;

import java.util.ArrayList;

/**this class is developed on day-05 */
public class List{
	static Logger log = Logger.getLogger(List.class.getName());
    
    /**
	 * Method for adding elements to list
	 * @param list
	 */
	public static void add(ArrayList<String> list){
	    for (int i =0;i<3;i++){
	        System.out.println("Enter a String to add : ");
	        list.add(System.console().readLine());
	    }
    	System.out.println("After Adding elements : "+list);    

	}

    /**
	 * Method for finding if the list is empty
	 * @param list
	 */
	public static void isEmpty(ArrayList<String> list){
		System.out.println("Is list empty : "+list.isEmpty());
	}

    /**
	 * Method for finding index of  element in a list 
	 * @param list
	 */
	public static void indexOf(ArrayList<String> list){
		System.out.print("Enter a string to find index : ");
		String string = System.console().readLine();
		System.out.println("Index of "+string+" : " +list.indexOf(string));
	}

    /**
	 * Method to set value of certain index
	 * @param list
	 */
	public static void set(ArrayList<String> list){
	    System.out.println("Enter index to set value: ");
	    int i = Integer.parseInt(System.console().readLine());
	    System.out.println("Enter String to set value : ");
	    String string = System.console().readLine();
	    list.set(i,string);
	    System.out.println("Added "+string+" at index : "+i);
	    System.out.println("After setting : "+list);
	    
	}
	/**
	 * Method for contains 
     * Returns true if found 
     * Returns false if not found
	 * @param list
	 */
   static void contains(ArrayList<String> list){
	    System.out.println("enter element to find (returns false if not found): ");
	    String string = System.console().readLine();
	    System.out.println(list.contains(string));
	}

	/**
	 *  Method to remove an element
	 * @param list
	 */
	static void remove(ArrayList<String> list ){
	    System.out.println("Enter a index REMOVE : ");
	    int n = Integer.parseInt(System.console().readLine());
	    list.remove(n);
	    System.out.println("After removing : " + list);
	}
	/**
	 * Method to find the size of element
	 * @param list
	 */
  	static void size(ArrayList<String> list){
		System.out.println("Size of list : "+list.size());
		System.out.println("End of program");               // since this method is called at the end of the program "End of program is printed"
	}

	/**
	 * Main method of the class List
	 * @param args
	 */
	public static void main(String[] args) {
		try{
		//BasicConfigurator.configure();
		FileAppender logFileAppender = new FileAppender(new SimpleLayout(), "C:/Users/anu-d/Desktop/tasks/Phase1/logs/List.txt");
		BasicConfigurator.configure(logFileAppender);
	
		 
		 log.debug("Hello this is a debug message");
		 log.info("Hello this is an info message");

	
			System.out.println("Hello this is List program. Do you want to continue?");
        boolean temp = true;
        while(temp){
            System.out.println("Type 'yes' to continue or Type 'no' to terminate");
            String x=System.console().readLine();
            switch(x){
                case "yes":
					ArrayList<String>  list=new ArrayList<String>();
			
					add(list);
					isEmpty(list);
					indexOf(list);
					set(list);
					contains(list);
					remove(list);
					size(list);
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

/** algorithm for List functions
 * START
	* initialize an empty arraylist
	* call add()
	* call isEmpty()
	* call indexOf()
	* call Set()
	* call remove()
	* call size()
 *STOP
 *
 */
