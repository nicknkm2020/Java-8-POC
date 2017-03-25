package CTS.Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Streams {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<String> oldStyle(List<String> inputList)
	{
		
		List<String> outputList = new ArrayList<>();
		for(String t: inputList){
		  if(t.startsWith("A")){
			  outputList.add(t);
		  }
		}
		Collections.sort(outputList,getReverseComparator());
		
		List<String> finalList = new ArrayList<>();
		for(String t: outputList){
			finalList.add(t.toLowerCase());
		}
		
		return finalList;
	}
	
	public static Comparator<String> getReverseComparator()
	{
		return new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				return str2.compareTo(str1);
			}
		};
	}
	
	public static List<String> usingStreams(List<String> inputList)
	{
		return  inputList.stream()
			                .filter(t -> t.startsWith("A"))
			                .sorted(getReverseComparator())
			                .map(String::toLowerCase)
			                .collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		
		Consumer<List<String>> consumeStrings = new Consumer<List<String>>() {
			@Override
			public void accept(List<String> t) {
				System.out.println(t);
			}
		};
		
		Consumer<List<String>> changeToUpper = consumeStrings.andThen(new Consumer<List<String>>() {
			@Override
			public void accept(List<String> t) {
				t.stream().forEach(string -> System.out.println(string.toUpperCase()) );
			}
		});
		
		consumeStrings.accept(Streams.usingStreams(Arrays.asList("A","Apple","Arko","Ball")));	
		changeToUpper.accept(Streams.usingStreams(Arrays.asList("A","Apple","Ball")));
	}
}
