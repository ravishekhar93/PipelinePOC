package daoLayer.utility;

import java.util.Calendar;
import java.util.Date;

public class TimeWindow {

	private Date startDate;
	private Date endDate;
	public static final int SHORT = 30;
	public static final int MEDIUM = 45;
	public static final int LONG = 90;
	
	public TimeWindow(Date startDate, int duration, boolean backward) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);

		if(backward) {
			this.endDate = startDate;
			cal.add(Calendar.DATE, -duration);
			this.startDate= cal.getTime();
		}else {
			this.startDate = startDate;
			cal.add(Calendar.DATE, duration);
			this.endDate= cal.getTime();
		}
	}
	
	public TimeWindow(Date startDate, Date endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
