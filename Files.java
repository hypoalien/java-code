package Phase1;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import java.io.File;
import java.io.IOException;

/**
 * this class is developed on day-14 
 */
public class Files {

  static Logger log = Logger.getLogger(Files.class.getName());
   /**
    * this is the main method for the class Files
    * @param args
    * 
    */
   public static void main(String args[])  {
    try{
    FileAppender logFileAppender = new FileAppender(new SimpleLayout(), "C:/Users/anu-d/Desktop/tasks/Phase1/logs/Files.txt");
    BasicConfigurator.configure(logFileAppender);
    
         
         log.debug("Hello this is a debug message");
         log.info("Hello this is an info message");

      System.out.println("Hello this is Files program. Do you want to continue?");
      boolean temp = true;
      while(temp){
          System.out.println("Type 'yes' to continue or Type 'no' to terminate");
          String x=System.console().readLine();
          String s;
          switch(x){
              case "yes":
             System.out.println("Enter a folder name or path :");
             s=System.console().readLine();
              File file = new File("C:/Users/anu-d/Desktop/"+s); 

              //using list() file names are stored in an array
              String contents[] = file.list();
              //prints the array
              System.out.println("names of all the files and directory:");
              for(int i=0; i<contents.length; i++) {
                 System.out.println(contents[i]);
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
 * algorithm for the class Files
 * START
   * init file object with given arguments
   * store contents in contents[] using list() method
   * print the elements of the array contents[]
 * STOP
 */