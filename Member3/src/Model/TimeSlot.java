package Model;

public class TimeSlot {

	private int ID;
	private String startTime;
	private String duration;
	private String endTime;
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public TimeSlot(int iD, String startTime, String duration, String endTime) {
		super();
		ID = iD;
		this.startTime = startTime;
		this.duration = duration;
		this.endTime = endTime;
	}
	
	
}
