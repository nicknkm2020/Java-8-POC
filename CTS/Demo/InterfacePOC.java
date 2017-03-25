package CTS.Demo;

public class InterfacePOC implements DefaultInterface{

	public static void main(String[] args) {
		System.out.println("Calling static method");
		DefaultInterface.showStaticDefaultMessage(); //calling static method
		
		System.out.println("Calling implemented method");
		new InterfacePOC().showMessage(); //calling implemented method
	}

	@Override
	public void showMessage() {
		System.out.println("message from implemented method. Calling other overloaded methods");	
		showDefaultMessage(); //called DefaultInterface implementation
		showAnotherDefaultMessage(); //called DefaultInterface implementation
	}
}

@FunctionalInterface
interface DefaultInterface {
	
	public void showMessage(); //It can have only one abstract method.
	
	default void showDefaultMessage() { //can add as many default methods
		System.out.println("inside showDefaultMessage");
	}
	
	default void showAnotherDefaultMessage() { //can add as many default methods
		System.out.println("inside showAnotherDefaultMessage");
	}
	
	public static void showStaticDefaultMessage() { //can add as many static methods
		System.out.println("inside showStaticDefaultMessage");
	} 
	
}
