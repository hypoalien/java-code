package Phase1;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
/**
 * this class is developed on day-16
 */
public class Copy { 

    static Logger log = Logger.getLogger(Copy.class.getName());
    /**
     * this is copyPaste method
     * this method copies the contents of one file and pastes it in another file
     * @param a
     * @param b
     */
    public static void copyPaste(File a, File b)
    { 
        //try block as the method read() and close () will throw error which is handled by catch block 
        try { 
            
            //init input and output stream objects
            FileInputStream in = new FileInputStream(a); 
            FileOutputStream out = new FileOutputStream(b); 

            //to store bytes of the file 
            int n; 

            //method read
            while ((n= in.read()) != -1) { 
                out.write(n); 
            } 

            //close streams
            in.close(); 
            out.close(); 
        }

        //catch exception
        catch(Exception e){
            System.out.println("Failed");
            return;
        }
      
        System.out.println("Copied"); 
    } 
    
    /**
     * this is the main method of class Copy
     * @param args
     */
    public static void main(String[] args) 
    {
        try{
        FileAppender logFileAppender = new FileAppender(new SimpleLayout(), "C:/Users/anu-d/Desktop/tasks/Phase1/logs/Copy.txt");
        BasicConfigurator.configure(logFileAppender);
    
         
         log.debug("Hello this is a debug message");
         log.info("Hello this is an info message");
       
            System.out.println("Hello this is Copy program. Do you want to continue?");
            boolean temp = true;
            while(temp){
                System.out.println("Type 'yes' to continue or Type 'no' to terminate");
                String a,b;
                String z=System.console().readLine();
                switch(z){
                    case "yes":
                       try{
                        System.out.println("Enter file name to copy from :");
                        a = System.console().readLine();
                       File x = new File(a); 
                       System.out.println("Enter file name to past in :");
                        b = System.console().readLine();
                       File y = new File(b); 
                       copyPaste(x, y); 
                       }catch(Exception e){
                            System.out.println("Error");
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
 * algorithm for the class Copy
 * START
    * take in arguments and init file objects
    * call copyPaste()
    * END
    *
    * algorithm for the method copyPaste
    * START
    * init object in, out
    * copy contents of in and write to out
    * close in , out
    * return
 *STOP
 */