package Phase1;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import java.util.Calendar; 
import java.text.SimpleDateFormat;


/**
 * this class is developed on day-13
 */
public class Sum {

    static Logger log = Logger.getLogger(Sum.class.getName());
   /**
    * this is the main method for the class Sum 
    * @param args
    */
   public static void main(String[] args){
    try{
    FileAppender logFileAppender = new FileAppender(new SimpleLayout(), "C:/Users/anu-d/Desktop/tasks/Phase1/logs/Sum.txt");
    BasicConfigurator.configure(logFileAppender);

     
     log.debug("Hello this is a debug message");
     log.info("Hello this is an info message");
   
        
        System.out.println("Hello this is Sum program. Do you want to continue?");
        boolean temp = true;
        String str1,str2;
        while(temp){
            System.out.println("Type 'yes' to continue or Type 'no' to terminate");
            String x=System.console().readLine();
            switch(x){
                case "yes":
                
                       //take inputs
  
                    System.out.println("Enter a date in formate (dd/mm/yyyy)");
                     str1= System.console().readLine();
  
                    System.out.println("Enter a date in formate (mm/dd/yyyy)");
                     str2=  System.console().readLine();
  
                    //split string into arrays at "/"
                    String s1[] = str1.split("/");
                    String s2[] = str2.split("/");
  
                    //init calander object with current instance 
                    Calendar cal1=  Calendar.getInstance();
                    Calendar cal2 = Calendar.getInstance();
  
                    //set values in cal object from taken input 
                    cal1.set(Integer.parseInt(s1[2]),Integer.parseInt(s1[1]),Integer.parseInt(s1[0]));
                    cal2.set(Integer.parseInt(s2[2]),Integer.parseInt(s2[0]),Integer.parseInt(s2[1]));
  
                    //add 2nd date to the 1st date
                    cal1.add(Calendar.YEAR, cal2.get(Calendar.YEAR));
                    cal1.add(Calendar.MONTH, cal2.get(Calendar.MONTH)); 
                    cal1.add(Calendar.DATE, cal2.get(Calendar.DATE));
  
                    //init date formate as dd-mm-yyyy
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
  
                    //print the added date 
                    System.out.format("%s + %s = %s", str1, str2, sdf.format(cal1.getTime()));
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
 * algorithm for the class Sum
 * START
   * take inputs
   * split string by "/"
   * init calender object cal1 and cal2
   * add cal1 and cal2 in cal1
   * print cal1 in the needed formate
 * END
 *
 */
