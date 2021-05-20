package Model;

public class RoomCannotBeReserved {
	private int ID;
	private String Room, StartTime, EndTime, Day;
	
	
	public RoomCannotBeReserved(int iD, String room, String startTime, String endTime,String day) {
		super();
		ID = iD;
		Room = room;
		StartTime = startTime;
		EndTime = endTime;
		Day=day;
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getRoom() {
		return Room;
	}


	public void setRoom(String room) {
		Room = room;
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


	public String getDay() {
		return Day;
	}


	public void setDay(String day) {
		Day = day;
	}
	
	
}
