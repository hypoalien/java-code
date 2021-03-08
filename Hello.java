package Phase1;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;

/**
 * this class is developed on day-02
 */
public class Hello{
    static Logger log = Logger.getLogger(Hello.class.getName());
    /**
     * this is the main function of the class hello 
     * @param args
     */
     public static void main(String []args){
        try{
        FileAppender logFileAppender = new FileAppender(new SimpleLayout(), "C:/Users/anu-d/Desktop/tasks/Phase1/logs/Hello.txt");
        BasicConfigurator.configure(logFileAppender);
    
         
         log.debug("Hello this is a debug message");
         log.info("Hello this is an info message");


            String firstName,lastName; //declare variables
        System.out.println("Hello this is Hello program. Do you want to continue?");
        boolean temp = true;

        while(temp){
            System.out.println("Type 'yes' to continue or Type 'no' to terminate");
            String x=System.console().readLine();
            switch(x){
                case "yes":
                    System.out.println("Enter first name");
                    firstName=System.console().readLine();

                    System.out.println("Enter last name");
                    lastName=System.console().readLine();

                    System.out.println("Hello "+firstName+" "+lastName);
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
            System.out.println("Error! Program terminated");
            log.debug(e.toString());
        }

    }
}

/*
 * Algorithm for hello.java
 * START
 * 
    * declare variables firstName and lastName
    * print "Enter your first name "
    * take input to var firstName"
    * print "Enter your last name"
    * take input to var lastName"
    * print "hello"+firstname+lastName
 STOP
 */