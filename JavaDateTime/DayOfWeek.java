import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;


public class DayOfWeek {

	public static void main(String[] args) {
		
		//old style
		Calendar calander = Calendar.getInstance();
		
		calander.set(2021, 02, 11);
		
		Date date = calander.getTime();
		DateFormat formatter = new SimpleDateFormat("EEEE");
		
		System.out.println(formatter.format(date).toUpperCase());
    
		//java 8
		LocalDate dateJava8 = LocalDate.of(2021, 02, 11);
		System.out.println(dateJava8.getDayOfWeek().toString());

	}

}
