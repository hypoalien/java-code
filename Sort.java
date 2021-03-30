package Phase1;
public class Sort extends Thread{
    
    //main function
    public static void main(String [] args){
        //init variables
        int count,counter=0;
        try{

            //take input from user, the number of elements and store it in count
        System.out.println("Enter number of elements");
        count= Integer.parseInt(System.console().readLine());

        //dynamically init array with count
        int[] elements =new int[count];

        //taking input from user
        for(counter=0;counter<count;counter++){
            System.out.println("Enter element "+ counter);
            elements[counter]=Integer.parseInt(System.console().readLine());  
        }

        System.out.println("Elements after sorting :");

        for (counter=0;counter<count;counter++){

            //init sort object
            Sort sort = new Sort();

            //set name as elements[counter]
            sort.setName(Integer.toString(elements[counter]));

            //start thread
            sort.start();
        }
        }catch(Exception e){
            System.out.println("Error, Please try again")
        }
        

    }

    //this function runs whenever .start() is called
    public void run(){
        try{
            //sleep 
            Thread.sleep(Integer.parseInt(Thread.currentThread().getName()));
            //display thread name
            System.out.println(Thread.currentThread().getName());
        }
        catch(InterruptedException e){
            System.out.println("error");
        }
    }


}