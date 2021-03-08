package Phase1;
import java.io.IOException;
import java.sql.SQLException;
import java.io.*;  
import java.util.*;

import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;

/**this class is developed on day-01  */
public class Calculator{
     static Logger log = Logger.getLogger(Calculator.class.getName());
    /**this is the main funtion for the class Calculator*/
     public static void main (String[] args){

          
          try{
               //BasicConfigurator.configure();
           FileAppender logFileAppender = new FileAppender(new SimpleLayout(), "C:/Users/anu-d/Desktop/tasks/Phase1/logs/calculator.txt");
		 BasicConfigurator.configure(logFileAppender);
     
          
          log.debug("Hello this is a debug message");
          log.info("Hello this is an info message");
               System.out.println("Hello this is Calculator program. Do you want to continue?");
               boolean temp = true;
               while (temp){
                   
                    System.out.println("Type 'yes' to continue or Type 'no' to terminate");
                    String x=System.console().readLine();
     
                    switch(x){
     
                         case "yes":
                              double result=0;
                              System.out.println("enter number a : ");
          
                              double firstDigit=Double.parseDouble(System.console().readLine());
                              System.out.println("enter operator ('+','-','*','/') : ");
                    
                              String operator = System.console().readLine();
                    
                              System.out.println("enter number b : ");
                              double secondDigit=Double.parseDouble(System.console().readLine());
                              
                              switch (operator){
                                   case "+" :
                                   result=firstDigit+secondDigit;
                                   break;
                              
                              case "-" :
                                   result=firstDigit-secondDigit;
                                   break;
                              case "*" :
                                   result=firstDigit*secondDigit;
                                   break;
                              case "/" :
                                   result=firstDigit/secondDigit;
                                   break;
                              case "%" :
                                   result=firstDigit%secondDigit;
                                   break;    
                              default :
                                   System.out.println("Please enter operators +,-,*,/,% only");
                                   break;
                              }
                              
                              System.out.println(firstDigit+ " "+operator+" "+secondDigit+ " = "+result);
                              break;
          
                         case "no":
                              System.out.println("program Ended");
                              temp=false;
                              break;
          
                         default :
                              System.out.println("Please enter 'yes' or 'no' only");
                              break;
                         
          
                    }
                         
               }
          }catch(Exception e){
               System.out.println("Error ! Program terminated");
               log.debug(e.toString());
          }
         

     }
}

/*
Algorithm for calculator
START
     declare variables 1st digit, 2nd digit ,result and operator
     read inputs for 1st and 2nd digits
     read input for operator
     if operator == +
     result = add 1st and 2nd digit
     if operator == -
     result subtract 1st and 2nd digit
     if operator == +
     result = multiply 1st and 2nd digit
     if operator == +
     result =divide 1st and 2nd digit
     if operator != any of the above
     result = print "enter right operator "
     print result
STOP
*/