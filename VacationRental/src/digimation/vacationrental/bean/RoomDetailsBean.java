package digimation.vacationrental.bean;

public class RoomDetailsBean {
	
	private int room_id;
	private boolean isavailable;
	private int rtype_id;
	private String type_name;
	private int hotel_id;
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	public boolean getisIsavailable() {
		return isavailable;
	}
	public void setIsavailable(boolean isavailable) {
		this.isavailable = isavailable;
	}
	public int getRtype_id() {
		return rtype_id;
	}
	public void setRtype_id(int rtype_id) {
		this.rtype_id = rtype_id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public int getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}
	

}

