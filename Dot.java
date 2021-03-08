package Phase1;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;

import java.awt.*;
import java.awt.event.*;

/**
 * this class is developed on day-19
 */
public class Dot extends Frame{
    static Logger log = Logger.getLogger(Dot.class.getName());

    /**
     * this is the constructor of the class Dot
     */
	Dot(){	
	
		setSize(300,300);
		setVisible(true);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
	}

    /**
     * this is changeColor method 
     * this method accepts integer and changes colour accordingly 
     * 
     * @param n
     * @return
     */
	public Color changeColor(int n){
        Color c = Color.blue;
        
        if(n > 10){
            n = n % 10;    
        }
        
        if(n == 1)
            c = Color.red;
        if(n == 2)
            c = Color.pink;
        if(n == 3)
            c = Color.gray;
        if(n == 4)
            c = Color.orange;
        if(n == 5)
            c = Color.darkGray;
        if(n == 6)
            c = Color.cyan;
        if(n==7)
            c = Color.yellow;
        if(n==8)
            c = Color.black;
        if(n==9)
            c = Color.green;

        return c;
	}

    /**
     * this is dottedLine method
     * it accepts graphics object
     * @param g
     */
	public void dottedLine(Graphics g){
		int i = 20;
		int j = i + 3, temp = 0;
		while(i <= 580 && j <= 460){
			Color color = changeColor(temp);
			g.setColor(color);
			g.drawLine(i, 100, j, 100);
			i= i + 10;
			j = i + 3;
			temp++;
		}
	}

	/**
     * this is paint method 
     * this method accepts graphics object
     */
	public void paint(Graphics g){
		dottedLine(g);
	}

    /**
     * this is the main method for the class Dot
     * @param args
     */
	public static void main(String args[])
	{
        try{
        FileAppender logFileAppender = new FileAppender(new SimpleLayout(), "C:/Users/anu-d/Desktop/tasks/Phase1/logs/Dot.txt");
        BasicConfigurator.configure(logFileAppender);
    
         
         log.debug("Hello this is a debug message");
         log.info("Hello this is an info message");
       
            Dot x=new Dot();
         }catch(Exception e){
             System.out.println("Error ! Program Terminated");
            log.debug(e.toString());
         }
		
	}
}

