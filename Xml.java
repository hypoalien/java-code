package Phase1;

import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.ConsoleAppender;

import java.util.ArrayList;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

/**
 * this class is developed on day-20
 */
public class Xml {
    static Logger log = Logger.getLogger(Xml.class.getName());

    /**
     * this is the main method for the class Xml
     * 
     * @param args
     */
    public static void main(String args[]) {

        
        PatternLayout layout = new PatternLayout("%-5p %d{dd MMM yyyy HH:mm:ss} [%t] : %m %n");
        ConsoleAppender consoleAppender = new ConsoleAppender(layout);
        //BasicConfigurator.configure(consoleAppender);

        log.info("Hello this is XML program. Do you want to continue?");
        //init variables
        boolean temp = true;
        String option,code;

        //init class objects
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document document;
        Element root;
        NodeList nodelist;
        

        while (temp) {
            try {

                log.info("\n1. Continue\n2. Terminate");
                option = System.console().readLine();
                switch (option) {
                case "1" :
                    //creat instances
                    factory = DocumentBuilderFactory.newInstance();
                    builder = factory.newDocumentBuilder();

                    //fetch file and parse
                    document = builder.parse(new File("index.xml"));
                    root = document.getDocumentElement();
                    nodelist = document.getElementsByTagName("state");

                    //take Code as input
                    log.info("Enter the code :");
                    code = System.console().readLine();

                    for (int counter = 0; counter < nodelist.getLength(); counter++) {
                        Node node = nodelist.item(counter);
                        if (node.getNodeType() == Node.ELEMENT_NODE) {
                            Element element = (Element) node;

                            if (element.getAttribute("id").equals(code)) {
                                log.info("State Name for " + code + ": "
                                        + element.getElementsByTagName("fullname").item(0).getTextContent());
                            }
                        }

                    }
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
                //log.debug(e.toString());
            }
        }

    }
}

/**
 * algorithm for the class Xml START init a DocumentBuilderFactory object
 * factory init a DocumentBuilder builder object using factory init a nodelist
 * and save all state elements iterate in the nodelist and check if the provided
 * argument is present if true then print the corresponding Full name STOP
 */
