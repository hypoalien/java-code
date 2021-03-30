package Phase1;

import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.ConsoleAppender;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/**
 * this class is developed on day-19
 */
public class Dot extends Frame {
    static Logger log = Logger.getLogger(Dot.class.getName());

      /**
     * this is the main method for the class Dot
     * 
     * @param args
     */
    public static void main(String args[]) {

        String option;
        boolean temp = true;

        PatternLayout layout = new PatternLayout("%-5p %d{dd MMM yyyy HH:mm:ss} [%t] : %m %n");
        ConsoleAppender consoleAppender = new ConsoleAppender(layout);
        //BasicConfigurator.configure(consoleAppender);

        log.info("Hello this is Dotted line program. Do you want to continue?");
        
        while(temp){
            try {
            log.info("\n1. Continue\n2. Terminate");
            option= System.console().readLine();
            switch(option){
                case "1" :
                Dot x = new Dot();
                break;
                case "2" :
                log.info("Program terminated");
                temp=false;
                break;

            }
           

            } catch (Exception e) {
                log.info("Error ! Program Terminated");
                // log.debug(e.toString());
            }
        }
        

    }   

    /**
     * this is the constructor of the class Dot
     */
    Dot() {

        setSize(300, 300);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });

    }

    /**
     * this is changeColor method this method accepts integer and changes colour
     * accordingly
     * 
     * @param n
     * @return
     */
    public Color changeColor() {
        
        Color c;
        int n ;
        Random random= new Random();
         n = random.nextInt(5);
         log.info(n);
        if (n==0)
            c = Color.blue;

        if (n == 1)
            c = Color.red;
            
        if (n == 2)
            c = Color.pink;
            
        if (n == 3)
            c = Color.gray;
           
        if (n == 4)
            c = Color.orange;
        else
            c =Color.black;
        return c;    

        
    }

    /**
     * this is dottedLine method it accepts graphics object
     * 
     * @param g
     */
    public void dottedLine(Graphics g) {
    
        int i=8;
        int j = 4;
        int temp =1;
        while (i <= 300 && j <= 300) {
            Color color = changeColor();
            g.setColor(color);
            g.drawLine(i, 100, j, 100);
            i = i + 8;
            j = i + 4;
            
        }
    }

    /**
     * this is paint method this method accepts graphics object
     */
    public void paint(Graphics g) {
        dottedLine(g);
    }

  
}
