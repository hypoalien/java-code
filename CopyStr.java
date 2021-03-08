package Phase1; 
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import java.io.BufferedReader;
import java.io.FileReader;
/**
 * this class is developed on day-17
 */
public class CopyStr 
{
    static Logger log = Logger.getLogger(CopyStr.class.getName());
    /**
     * this is the main function of the class CopyStr
     * @param args
     */
    public static void main(String[] args) 
    {
        try{
        FileAppender logFileAppender = new FileAppender(new SimpleLayout(), "C:/Users/anu-d/Desktop/tasks/Phase1/logs/CopyStr.txt");
        BasicConfigurator.configure(logFileAppender);
    
         
         log.debug("Hello this is a debug message");
         log.info("Hello this is an info message");
     
            System.out.println("Hello this is Copy String program. Do you want to continue?");
            boolean temp = true;
            String filepath;
            while(temp){
    
                System.out.println("Type 'yes' to continue or Type 'no' to terminate");
                String x=System.console().readLine();
                
                switch(x){
                    case "yes":
                        System.out.println("Enter a file name");
                        filepath=System.console().readLine();
    
                        System.out.println( copy(filepath));
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
     * this is copy method 
     * this method takes in file path as argument 
     * this method copies the contents of the file and returns it as a string 
     * @param filePath
     * @return
     */
    public static String copy(String filePath) 
    {   
        //String builder class is used for creating mutable strings
        StringBuilder contentBuilder = new StringBuilder();
        try 
        {
            //init buffered reader object
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String s;
            while ((s = br.readLine()) != null) 
            {
                contentBuilder.append(s).append("\n");
            }
        } 
        catch (Exception e) 
        {
           System.out.println("Error");
        }
        finally{
             return contentBuilder.toString();
        }
       
    }
}
/**
 * algorithm for the class CopyStr
 * START
 * take in arguments
 * print (Copy())
 * STOP
 *
 * algorithm for method copy()
 * START
 * init StringBuilder object contentBuilder
 * init BufferedReader object br
 * contentBuilder.append(s)
 * return contentBuilder.toString();
 * STOP
 *
 */