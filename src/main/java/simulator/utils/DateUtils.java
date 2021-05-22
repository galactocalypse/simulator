package simulator.utils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtils {
	
	public static final int MILLIS_PER_SECOND = 1_000;
	
	public static Date add(Date date, TimeUnit timeUnit, long value) {
		return new Date(date.getTime() + timeUnit.toMillis(value));
	}

}
