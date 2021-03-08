package Phase1;
import java.io.File;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import java.io.IOException;
/**
 * this class is developed on day-15
 */
public class Rename {
    static Logger log = Logger.getLogger(Rename.class.getName());
   //declaring function which handels IOExcetion using "throws" keyword
   /**
    * this is the main method of the class Rename
    * @param args
    * @throws IOException
    */
   public static void main(String args[]) {
    try{
    FileAppender logFileAppender = new FileAppender(new SimpleLayout(), "C:/Users/anu-d/Desktop/tasks/Phase1/logs/Rename.txt");
    BasicConfigurator.configure(logFileAppender);

     
     log.debug("Hello this is a debug message");
     log.info("Hello this is an info message");


        System.out.println("Hello this is Rename program. Do you want to continue?");
        boolean temp = true;
        File old,newname;
        String s;
        while(temp){
            System.out.println("Type 'yes' to continue or Type 'no' to terminate");
            String x=System.console().readLine();
            switch(x){
                case "yes":
                 System.out.println("Enter a folder path :");
                 s=System.console().readLine();
                 File file = new File("C:/Users/anu-d/Desktop/tasks/day-15/"+s); 
  
                 //store names in an array
                 String names[] = file.list();
              
                 for(int i=0; i<names.length; i++) {
                    System.out.println(names[i]);
                    old =  new File("C:/Users/anu-d/Desktop/tasks/day-15/"+s+"/"+names[i]); 
                    newname = new File("C:/Users/anu-d/Desktop/tasks/day-15/"+s+"/"+"ENH"+names[i]+i+".txt"); 
  
                    //rename returns false in case of exception and error
                 if (old.renameTo(newname))  
                       System.out.println("done");         
                 else 
                       System.out.println("failed");    
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
}

/**
 * algorithm for the class Rename
 * START
   * init file object with given arguments
   * store the list of files in names[]
   * iterate through names[] and change each file name by appending ENH
   in the front and a number at the end
   * print done if true
   * print failed if false
 * STOP
 */
      
