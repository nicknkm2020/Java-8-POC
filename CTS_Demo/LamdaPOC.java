package CTS_Demo;

public class LamdaPOC {
	
	public static void main(String[] args) {
	  System.out.println("=== LamdaPOC ===");
     
     // Anonymous Runnable
     Runnable r1 = new Runnable(){
       
       @Override
       public void run(){
         System.out.println("Hello world one!");
       }
     };
     
     // Lambda Runnable
     Runnable r2 = () -> System.out.println("Hello world two from Lambda!");
     
     // Run em!
     r1.run();
     r2.run();
     
   }

}
