package Phase1;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import java.util.Date;

/**
 * this class is developed on day-11
 */
public class Dates{
    static Logger log = Logger.getLogger(Dates.class.getName());

    
    /**
     * this is the main method for the class Dates and it executes all date functions 
     * @param args
     */
    public static void main(String[] args){
        try{
        FileAppender logFileAppender = new FileAppender(new SimpleLayout(), "C:/Users/anu-d/Desktop/tasks/Phase1/logs/Dates.txt");
        BasicConfigurator.configure(logFileAppender);
    
         
         log.debug("Hello this is a debug message");
         log.info("Hello this is an info message");
      
            System.out.println("Hello this is Dates program. Do you want to continue?");
            String s,s1;
            boolean temp = true;
            while(temp){
                System.out.println("Type 'yes' to continue or Type 'no' to terminate");
                String x=System.console().readLine();
                switch(x){
                    case "yes":
                        System.out.println("Enter a date (dd/mm/yyyy)");
                        s= System.console().readLine();
    
                        System.out.println("Enter a date (dd/mm/yyyy)");
                        s1= System.console().readLine();
                     //string is splitted using the "/"
                        String str1[] = s.split("/"); 
                        Date d = new Date(Integer.parseInt(str1[2]), Integer.parseInt(str1[1]), Integer.parseInt(str1[0])); 
                        //String is converted to int
                        String str2[] = s1.split("/");
                        Date d1 = new Date(Integer.parseInt(str2[2]), Integer.parseInt(str2[1]), Integer.parseInt(str2[0]));
    
                        Date date = new Date();
    
                        //print current date
                        System.out.println("current date  : "+date);
    
                        
                        //Check if given dates are equal
                        System.out.println("Date "+s+" equals Date "+s1 +":" +d.equals(d1));  
    
    
                        //check if d is after d1
                        System.out.println("Date "+s+" after Date "+s1+ " :" +d.after(d1));  
    
                        //check if d is before d1
                        System.out.println("Date "+s+" before Date "+s1+ ": " +d.before(d1));
    
                        //prints current number of milliseconds since jan 1 1970
                        System.out.println("Current number of milliseconds since January 1, 1970, 00:00:00 GTM : "+d.getTime());    
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
 * algorithm for dates class
 * START
    * take inputs
    * split with "/" and store it in Date Class
    * print current date
    * call equals()
    * call after()
    * call before()
    * call getTime()
 *STOP
 *
 */
