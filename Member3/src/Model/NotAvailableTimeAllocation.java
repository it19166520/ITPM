package Model;

public class NotAvailableTimeAllocation {

	private int ID;
	private String StartTime,EndTime,Lecturer,Group,SubGroup,SessionID,Day;
	
	
	public NotAvailableTimeAllocation(int iD, String startTime, String endTime, String lecturer, String group,
			String subGroup, String sessionID, String day) {
		super();
		ID = iD;
		StartTime = startTime;
		EndTime = endTime;
		Lecturer = lecturer;
		Group = group;
		SubGroup = subGroup;
		SessionID = sessionID;
		Day = day;
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getStartTime() {
		return StartTime;
	}


	public void setStartTime(String startTime) {
		StartTime = startTime;
	}


	public String getEndTime() {
		return EndTime;
	}


	public void setEndTime(String endTime) {
		EndTime = endTime;
	}


	public String getLecturer() {
		return Lecturer;
	}


	public void setLecturer(String lecturer) {
		Lecturer = lecturer;
	}


	public String getGroup() {
		return Group;
	}


	public void setGroup(String group) {
		Group = group;
	}


	public String getSubGroup() {
		return SubGroup;
	}


	public void setSubGroup(String subGroup) {
		SubGroup = subGroup;
	}


	public String getSessionID() {
		return SessionID;
	}


	public void setSessionID(String sessionID) {
		SessionID = sessionID;
	}


	public String getDay() {
		return Day;
	}


	public void setDay(String day) {
		Day = day;
	}
	
	
}
