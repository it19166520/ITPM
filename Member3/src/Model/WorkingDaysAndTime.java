package Model;

public class WorkingDaysAndTime {

	private int ID;
	private String NumberOfWorkingDays,WorkingDays,WorkingHours,WorkingMinutes;
	
	public WorkingDaysAndTime(int iD, String numberOfWorkingDays, String workingDays, String hour,String minutes) {
		super();
		ID = iD;
		NumberOfWorkingDays = numberOfWorkingDays;
		WorkingDays = workingDays;
		WorkingHours =hour;
		WorkingMinutes=minutes;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNumberOfWorkingDays() {
		return NumberOfWorkingDays;
	}

	public void setNumberOfWorkingDays(String numberOfWorkingDays) {
		NumberOfWorkingDays = numberOfWorkingDays;
	}

	public String getWorkingDays() {
		return WorkingDays;
	}

	public void setWorkingDays(String workingDays) {
		WorkingDays = workingDays;
	}

	public String getWorkingHours() {
		return WorkingHours;
	}

	public void setWorkingHours(String workingHours) {
		WorkingHours = workingHours;
	}

	public String getWorkingMinutes() {
		return WorkingMinutes;
	}

	public void setWorkingMinutes(String workingMinutes) {
		WorkingHours = workingMinutes;
	}


	
}
