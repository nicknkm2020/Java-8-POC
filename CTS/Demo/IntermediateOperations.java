package CTS.Demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IntermediateOperations {
	
	//filter based on starting string return list
	public static List<String> filterStringStartingWith(List<String> inputList, String startingPattern)
	{
		return inputList.stream().filter(value -> value.startsWith(startingPattern)).collect(Collectors.toList());
	}
	//filter based on ending string return set
	public static Set<String> filterStringEndingWith(List<String> inputList, String endingPattern)
	{
		return inputList.stream().filter(value -> value.endsWith(endingPattern)).collect(Collectors.toSet());
	}
	//sort the string list
	public static List<String> sortListOfStrings(List<String> inputToBeSorted)
	{
		return inputToBeSorted.stream().sorted().collect(Collectors.toList());
	}
	//convert to Map and put values as upper case
	public static Map<String,String> convertToUpperCase(List<String> inputToBeConverted)
	{
		Function<String,String> keyMapper = String::toLowerCase;
		Function<String,String> valueMapper = String::toUpperCase;
		return inputToBeConverted.stream().map(value -> value.toUpperCase()).collect(Collectors.toMap(keyMapper, valueMapper));
	}
	
	public static List<String> convertToUpperCaseAndLimit(List<String> inputToBeConverted)
	{ //performance will change depending upon where limit is applied.
		return inputToBeConverted.stream().map(value -> value.toUpperCase()).limit(2).collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		list.add("Ashwani");
		list.add("Devraj");
		list.add("Ravindra");
		list.add("Arko");
		System.out.println("Starting with A : "+filterStringStartingWith(list, "A"));
		System.out.println("Ending with ra : "+filterStringEndingWith(list, "ra"));
		System.out.println("Sorted in Natural Order : "+sortListOfStrings(list));
		System.out.println("Mapped touppercase : "+convertToUpperCase(list));
		System.out.println("Mapped touppercase with limit : "+convertToUpperCaseAndLimit(list));
		
	}
	
	
	
	

}
