package Phase1;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;

import java.util.HashMap;
import java.util.Map;

/**this class is developed on day-04 */
public class Hash {
    static Logger log = Logger.getLogger(Hash.class.getName());
	
	/**
     * this method is used to put stings in an hashmap 
     * @param hashMap
     */
    public static void put(HashMap<Integer,String> hashMap){
    	
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter Integer : ");
            Integer x = Integer.parseInt(System.console().readLine());
            System.out.println("Enter String : ");
            String y = System.console().readLine();
            hashMap.put(x, y);					
        }
        System.out.println("Hashmap : "+hashMap);
    }
    
  /**
   * this method is used to get stings in an hashmap
   * @param hashMap
   */
   public static void get(HashMap<Integer,String> hashMap){
    	
        System.out.println("Enter a index to GET : ");
        int n = Integer.parseInt(System.console().readLine());
        System.out.println(hashMap.get(n));	 						
    }
    
    /**
     * this method is used to remove stings in an hashmap 
     * @param hashMap
     */
   public static void remove(HashMap<Integer,String> hashMap){
    	
        System.out.println("Enter a index REMOVE : ");
        int n = Integer.parseInt(System.console().readLine());
        hashMap.remove(n);
        System.out.println("After removing : " + hashMap);
    }
    
    /**
     * this method is used to check if the given hashmap contains key 
     * @param hashMap
     */
   public static void containsKey(HashMap<Integer,String> hashMap){
    	
        System.out.println("Enter a index (IF KEY EXISTS) : ");
        int n = Integer.parseInt(System.console().readLine());
        System.out.println(hashMap.containsKey(n));   				 	
    }

    /**
     * this method is used to check if the given hashmap contains value 
     * @param hashMap
     */
   public static void containsValue(HashMap<Integer,String> hashMap){
    	
        System.out.println("Enter a value (CONTAINS VALUE): ");
        String s = System.console().readLine();
        System.out.println(hashMap.containsValue(s));
    }
    
    /**
     * **this method is used to clear a hashmap
     * @param hashMap
     */
   public static void clear(HashMap<Integer,String> hashMap){
    	
        hashMap.clear();  
        System.out.println("After Clearing : "+hashMap);

    }
    
    /**
     * this method is used to display elemnets in an hashmap
     * @param hashMap
     */
   public static void displayElements(HashMap<Integer,String> hashMap){
    	System.out.println("DISPLAYING ELEMENTS");
        for (Map.Entry<Integer, String> m : hashMap.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());			
        }
    }
    
    /**
     * this method is used to find the size of an hashmap 
     * @param hashMap
     */
   public static void size(HashMap<Integer,String> hashMap){
    	 System.out.println("Size of HashMap : "+hashMap.size());    					
    }

    /**
     * this is main method of the class Hash 
     * @param args
     */
    public static void main(String[] args) {
        try{
        FileAppender logFileAppender = new FileAppender(new SimpleLayout(), "C:/Users/anu-d/Desktop/tasks/Phase1/logs/Hash.txt");
            BasicConfigurator.configure(logFileAppender);
        
             
             log.debug("Hello this is a debug message");
             log.info("Hello this is an info message");

            
            System.out.println("Hello this is hash program. Do you want to continue?");
            boolean temp = true;
            while(temp){
                System.out.println("Type 'yes' to continue or Type 'no' to terminate");
                String x=System.console().readLine();
                switch(x){
                    case "yes":
                        //init hash object
                        HashMap<Integer, String> h = new HashMap<>();
                        
                        //calling methods with the above object as arguments
                        put(h);	
                        get(h);
                        remove(h);
                        containsKey(h);
                        containsValue(h);
                        size(h);
                        displayElements(h);
                        clear(h);
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

/**
 * algorithm for hash map functions
 * START
    * initialize an empty hash opject
    * call put()
    * call get()
    * call remove()
    * call containsKey()
    * call containsValue()
    * call Size()
    * call displayElements()
    * call clear()
 * STOP
 */