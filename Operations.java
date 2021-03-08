package Phase1;

import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
/**this class is developed on day-03  */
public class Operations {
	static Logger log = Logger.getLogger(Operations.class.getName());
	
	/**
	 * this method checks if the given 2 strings are same or not
	 * @param str1
	 * @param str2
	 * @return
	 */
	static boolean equals(String str1,String str2) {
		//if both strings are unequal in length then return false
		if (length(str1)!=length(str2)) {
			return false;
			}
		//else compare each char of both the strings and return false if unequal
		else {
			char ch1[]=str1.toCharArray();
			char ch2[]=str2.toCharArray();		
			for (int i =0; i<length(str1);i++) {
				if(ch1[i]!=ch2[i]) {
					return false;
				}
			}
		//return true as both the strings are equal
			return true;
		}
	
	}
	
	/**
	 * 	this method concatinates first string to the second string

	 * @param str1
	 * @param str2
	 * @return
	 */
	static String concat(String str1,String str2) {
		//initialize variables 
		char c1[]=str1.toCharArray();
		char c2[]=str2.toCharArray();
		StringBuilder s=new StringBuilder("");//init string builder
		char [] c = new char[c1.length+c2.length];
		
		//Copy all elements in array c1[] starting from index 0 to array c[] starting from index 0 till the index c1.length 
		System.arraycopy(c1,0,c,0,c1.length);
		
		//Copy all elements in array c2[] starting from index 0 to array c[] starting from index c1.length till the index c2.length 
		System.arraycopy(c2,0,c,c1.length,c2.length);
		
		//append the array to the string builder and typecast it to string and return
		return s.append(c).toString();
	}
	
	/**
	 * this method returns the length of the given string
	 * @param str
	 * @return
	 */
	static int length(String str) {
		int i=0;
		char ch[]=str.toCharArray();
		for (char c1:ch) {
			i++; //find length
		}
		//return length
		return i;
	}
	
	/**
	 * **this method replaces a given character with a specified character in the string 
	 * @param s
	 * @param c1
	 * @param c2
	 * @return
	 */
	static String replace(String s ,char c1,char c2) {
		char c[]=s.toCharArray();
		StringBuilder sb = new StringBuilder("");
		int i=0;
		for(char  a : c){
			if(a==c1) {
				c[i]=c2; // replacing the required character in the string 
			}
			i++;
		}
		return sb.append(c).toString();
		
	}

	/**
	 * this method returns the difference of the length
	 * @param s1
	 * @param s2
	 * @return
	 */
	static int compareTo(String s1, String s2) {
		 int i =length(s1)-length(s2);
		 return i;// return the difference of length
		
	}
	
	/**
	 * this method reverses the given string 
	 * @param s1
	 * @return
	 */
	static String reverse(String s1) {
		//init variables
		StringBuilder sb=new StringBuilder("");
		char ch1[]= s1.toCharArray();
		
	for (int i = length(s1)-1;i>-1;i--) {
			sb.append(ch1[i]);
		}
	return sb.toString(); //return reversed string
	}

	/**
	 * this is the main method that takes in the arguments  
	 * @param args
	 */
	public static void main(String[] args) {
		try{
		//BasicConfigurator.configure();
		FileAppender logFileAppender = new FileAppender(new SimpleLayout(), "C:/Users/anu-d/Desktop/tasks/Phase1/logs/Operations.txt");
		BasicConfigurator.configure(logFileAppender);
	
		 
		 log.debug("Hello this is a debug message");
		 log.info("Hello this is an info message");


			System.out.println("Hello this is String Operations program. Do you want to continue?");
        	boolean temp = true;
			while(temp){
				System.out.println("\nType 'yes' to continue or Type 'no' to terminate");
				String x=System.console().readLine();
				switch(x){
					case "yes":
						//taking input for 2 strings 
						System.out.println("Enter a string ");
						String s1 = System.console().readLine();

						System.out.println("Enter a string ");
						String s2 = System.console().readLine();

						//Check if equal()
						if(equals(s1,s2)==true) {
							System.out.println("String "+s1+"and String "+s2+" are equal");
						}else {
							System.out.println("String "+s1+" and String "+s2+" are not equal");
						}
						
						//String concat()
						System.out.println("String Concat : "+concat(s1,s2));
						
						//String length()
						System.out.println("String Length of "+s1+" : "+length(s1));
						System.out.println("String Length of "+s2+" : "+length(s2));
						
						//String reverse()
						System.out.println("Reverse of String "+s1+" : "+reverse(s1));
						System.out.println("Reverse of String "+s2+" : "+reverse(s2));
						
						//String compareTo()
						System.out.println("String "+s1+" Compared to String "+s2+" :"+compareTo(s1,s2));
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

/**
 * Algorithm for Operation.java
 * START
	take inputs s1,s2,
	check if equal
	call concat()
	call length()
	call reverse()
	call compareTo()
STOP
 */