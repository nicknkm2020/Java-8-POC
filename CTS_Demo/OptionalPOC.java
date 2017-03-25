package CTS_Demo;

import java.util.Optional;


public class OptionalPOC {
	
	static Optional<String> getOptionalStringValue()
	{
		return Optional.of("OptionalString");
	}
	
	static Optional<String> getOptionalNullValue()
	{
		//Optional.of(null); this will return true on isPresent and null pointer on .get
		return Optional.ofNullable(null);
	}
	
	public static void main(String[] args) {
		
		System.out.println("GetOptional and print ");
		printOptionalValueIfPresent(getOptionalStringValue());
		//System.out.println("GetOptionalNull and print "+getOptionalNullValue().get()); //throw null pointer exception
		System.out.println("GetOptionalNull and print ");
		printOptionalValueIfPresent(getOptionalNullValue());
	}
	
	static void printOptionalValueIfPresent(Optional<String> optional) {
		if(optional.isPresent())
		{
			System.out.println("Found value "+optional.get());
		}else {
			System.out.println("No value is present");
		}
	}

}
