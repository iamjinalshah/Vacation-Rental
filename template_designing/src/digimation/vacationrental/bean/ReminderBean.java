package digimation.vacationrental.bean;

public class ReminderBean {

	private int reminder_id;
	private String details;
	private String date;
	private int user_id;
	private String first_name;
	private String last_name;
	public int getReminder_id() {
		return reminder_id;
	}
	public void setReminder_id(int reminder_id) {
		this.reminder_id = reminder_id;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
}
