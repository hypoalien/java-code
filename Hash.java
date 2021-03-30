package Phase1;

import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.ConsoleAppender;

import java.util.HashMap;
import java.util.Map;

/** this class is developed on day-04 */
public class Hash {
    static Logger log = Logger.getLogger(Hash.class.getName());

    /**
     * this method is used to put stings in an hashmap
     * 
     * @param hashMap
     */
    public static void put(HashMap<String, String> hashMap) {
       

        for (int counter = 0; counter < 3; counter++) {
            log.info("Enter key : ");
            String key = System.console().readLine();
            log.info("Enter value : ");
            String value = System.console().readLine();
            hashMap.put(key, value);
        }
        log.info("Hashmap : " + hashMap);
    }

    /**
     * this method is used to get stings in an hashmap
     * 
     * @param hashMap
     */
    public static void get(HashMap<String, String> hashMap) {

        log.info("Enter a key to GET : ");
        String key = System.console().readLine();
        log.info(hashMap.get(key));
    }

    /**
     * this method is used to remove stings in an hashmap
     * 
     * @param hashMap
     */
    public static void remove(HashMap<String, String> hashMap) {

        log.info("Enter a key REMOVE : ");
        String key = System.console().readLine();
        
        log.info("Removed : " + hashMap.remove(key));
        hashMap.remove(key);
        log.info("After removing : " + hashMap);
    }

    /**
     * this method is used to check if the given hashmap contains key
     * 
     * @param hashMap
     */
    public static void containsKey(HashMap<String, String> hashMap) {

        log.info("Enter a key (IF KEY EXISTS) : ");
        String key = System.console().readLine();
        log.info(hashMap.containsKey(key));
    }

    /**
     * this method is used to check if the given hashmap contains value
     * 
     * @param hashMap
     */
    public static void containsValue(HashMap<String, String> hashMap) {

        log.info("Enter an value (CONTAINS VALUE): ");
        String value = System.console().readLine();
        log.info(hashMap.containsValue(value));
    }

    /**
     * **this method is used to clear a hashmap
     * 
     * @param hashMap
     */
    public static void clear(HashMap<String, String> hashMap) {

        hashMap.clear();
        log.info("After Clearing : " + hashMap);

    }

    /**
     * this method is used to display elemnets in an hashmap
     * 
     * @param hashMap
     */
    public static void displayElements(HashMap<String, String> hashMap) {
        log.info("DISPLAYING ELEMENTS");
        for (Map.Entry<String, String> map : hashMap.entrySet()) {
            log.info(map.getKey() + " " + map.getValue());
        }
    }

    /**
     * this method is used to find the size of an hashmap
     * 
     * @param hashMap
     */
    public static void size(HashMap<String, String> hashMap) {
        log.info("Size of HashMap : " + hashMap.size());
    }

    /**
     * this is main method of the class Hash
     * 
     * @param args
     */
    public static void main(String[] args) {

        boolean temp = true;
        String option;
      
        PatternLayout layout = new PatternLayout("%-5p %d{dd MMM yyyy HH:mm:ss} [%t] : %m %n");
        ConsoleAppender consoleAppender = new ConsoleAppender(layout);
        //BasicConfigurator.configure(consoleAppender);

        log.info("Hello this is hash program. Do you want to continue?");
        
        while (temp) {
            try {

                log.info("\n1. Continue\n2. Terminate");
                option = System.console().readLine();
                switch (option) {
                case "1" :
                    // init hash object
                    HashMap<String, String> hashmap = new HashMap<>();

                   
                    put(hashmap);
                    get(hashmap);
                    remove(hashmap);
                    containsKey(hashmap);
                    containsValue(hashmap);
                    size(hashmap);
                    displayElements(hashmap);
                    clear(hashmap);
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
                // log.debug(e.toString());
            }
        }
    }
}

/**
 * algorithm for hash map functions START initialize an empty hash opject call
 * put() call get() call remove() call containsKey() call containsValue() call
 * Size() call displayElements() call clear() STOP
 */