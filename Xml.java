package Phase1;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import java.util.ArrayList;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

/**
 * this class is developed on day-20
 */
public class Xml{
    static Logger log = Logger.getLogger(Xml.class.getName());

    /**
     * this is the main method for the class Xml
     * @param args
     */
    public static void main(String args[]){
        try{
        FileAppender logFileAppender = new FileAppender(new SimpleLayout(), "C:/Users/anu-d/Desktop/tasks/Phase1/logs/Xml.txt");
            BasicConfigurator.configure(logFileAppender);
        
             
             log.debug("Hello this is a debug message");
             log.info("Hello this is an info message");

            
            System.out.println("Hello this is XML program. Do you want to continue?");
        boolean temp = true;
        DocumentBuilderFactory factory;
        DocumentBuilder builder;

        Document document;
        Element root;
        NodeList nList;
        String s;

        while(temp){
            System.out.println("Type 'yes' to continue or Type 'no' to terminate");
            String x=System.console().readLine();
            switch(x){
                case "yes":
                    factory = DocumentBuilderFactory.newInstance();
                    builder = factory.newDocumentBuilder();

                    document = builder.parse(new File( "index.xml" ));
                    root = document.getDocumentElement();
                    nList = document.getElementsByTagName("state");

                    System.out.println("Enter the code :");
                    s=System.console().readLine();
                    for (int i = 0; i < nList.getLength(); i++)
                    {
                        Node node = nList.item(i);
                        if (node.getNodeType() == Node.ELEMENT_NODE)
                        {
                            Element eElement = (Element) node;
                        
                                if(eElement.getAttribute("id").equals(s)){
                                    System.out.println("State Name for "+s+":"   + eElement.getElementsByTagName("fullname").item(0).getTextContent());
                                }
                        }
                    
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
* algorithm for the class Xml
* START
    * init a DocumentBuilderFactory object factory
    * init a DocumentBuilder builder object using factory
    * init a nodelist and save all state elements
    * iterate in the nodelist and check if the provided argument is present
    * if true then print the corresponding Full name
* STOP
*/
