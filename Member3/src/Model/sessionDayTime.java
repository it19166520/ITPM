package Model;

public class sessionDayTime {
	private String SessionId, startingTime, enddingTime, day;
	
	
	public sessionDayTime( String sessionId, String StartingTime, String EnddingTime,String Day) {
		super();
		SessionId = sessionId;
		startingTime = StartingTime;
		enddingTime = EnddingTime;
		day=Day;
	}


	public String getSessionId() {
		return SessionId;
	}


	public void setSessionId(String sessionId) {
		SessionId = sessionId;
	}


	public String getStartingTime() {
		return startingTime;
	}


	public void setStartingTime(String startingTime) {
		this.startingTime = startingTime;
	}


	public String getEnddingTime() {
		return enddingTime;
	}


	public void setEnddingTime(String enddingTime) {
		this.enddingTime = enddingTime;
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	
	
	
}
