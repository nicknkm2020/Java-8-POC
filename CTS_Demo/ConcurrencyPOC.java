package CTS_Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConcurrencyPOC {
	
	public static void main(String[] args) {
		
		List<Integer> intList = new ArrayList<Integer>(){{
			add(1);
			add(10);
			add(5);
			add(15);
		}};
		Integer [] intArray = new Integer [intList.size()];
		intArray = intList.toArray(intArray);
		System.out.println("Before sort ");
		printValues(intArray);
		Arrays.parallelSort( intArray , ( x, y ) -> ((Integer) x).compareTo( (Integer) y ) );
		System.out.println("After sort ");
		printValues(intArray);
		
		//List with parallel streams
		List<Integer> list = new ArrayList<Integer>() {{
			
			add(1);
			add(2);
			add(3);
			add(4);
			add(5);
		}};
		
		Consumer<Integer> consumeIntegerData = data -> { System.out.println(data); } ;
		
		list.parallelStream().forEach(consumeIntegerData);
		System.out.println("Sequential ");
		list.stream().forEach(consumeIntegerData);
	}
	
	static void printValues(Integer [] intArray)
	{
		Arrays.stream(intArray).forEach(value -> System.out.println(value));
	}

}
