package CTS_Demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimePOC {
	
	public static void main(String[] args) {
		
		LocalDate localDate = LocalDate.now();
		System.out.println("Current Date without time "+localDate);
		
		LocalTime localTime = LocalTime.now();
		System.out.println("Current time without date "+localTime);
		
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("Current Date with time "+localDateTime);
		
		localDateTime = LocalDateTime.of(localDate,localTime);
		System.out.println("Current Date with time from local date and local time"+localDateTime);
		
		localDate = LocalDate.of(localDateTime.getYear(), localDateTime.getMonth(), localDateTime.getDayOfMonth());
		System.out.println("Current Date without time from LocalDateTime "+localDate);
		
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		System.out.println("Current Zoned Date with time "+zonedDateTime);
		
		zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
		System.out.println("Current Zoned Date from LocalDateTime  "+zonedDateTime);
		
	}

}
