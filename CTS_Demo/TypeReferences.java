package CTS_Demo;

import java.util.function.Function;

public class TypeReferences {
	
	public static void main(String[] args) {
		
		//Constructor references
		Function<String, String> stringConstructor = String::new;
		System.out.println(" stringConstructor apply1 "+stringConstructor.apply("string1"));
		System.out.println(" stringConstructor apply2 "+stringConstructor.apply("string2"));
				
		//Method References, non null params can be given
		Function<String, String> stringMethod = String::toUpperCase;
		System.out.println(" stringMethod apply1 "+stringMethod.apply("string1"));
		System.out.println(" stringMethod apply2 "+stringMethod.apply("string2"));
				
	}

}
