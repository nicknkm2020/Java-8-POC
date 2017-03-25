package CTS.Demo;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class MapAPI {
	
	public static  ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String,String>();
	
	public static void main(String[] args) {
		
		IntStream.range(1, 7).forEach(new IntConsumer() {
			@Override
			public void accept(int value) {
				map.put(String.valueOf("key"+value), String.valueOf(value));
			}
		});
	
		map.forEach((key,value) -> System.out.println("Key:"+key+" value:"+value));
		BiConsumer<? super String, ? super String> consumer = MapAPI::printMapValues;
		System.out.println("Using explicit BiConsumer");
		map.forEach(consumer);
		System.out.println("Using explicit BiConsumer with parallel of 3 executions");
		map.forEach(1,consumer);
		
		Consumer<String> action = string -> System.out.println(string);
		System.out.println("Printing the keys");
		map.forEachKey(1, action);
		System.out.println("Printing the values");
		map.forEachValue(0, action);
		
		
		BiFunction<String, String, String> searchFunction = MapAPI::searchMapValues;
		String searchedResult = map.search(1, searchFunction);
		System.out.println("Search Result "+searchedResult);
	}
	
	public static void printMapValues(String key,String value) {
		System.out.println(" key:"+key+ " value:"+value);
	}
	
	public static String searchMapValues(String key,String value) {
		if(key.equals("key20")) {
			return "found";
		}
		else {
			System.out.println("Did not found..next");
			return null;
		}
	}

}
