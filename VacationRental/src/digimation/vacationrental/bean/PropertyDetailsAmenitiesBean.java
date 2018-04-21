package digimation.vacationrental.bean;

public class PropertyDetailsAmenitiesBean {

	
	private int PDA_id;
	private int property_id;
	private int amenities_id;
	private String amenities_name;
	
	public int getPDA_id() {
		return PDA_id;
	}
	public void setPDA_id(int pDA_id) {
		PDA_id = pDA_id;
	}
	public int getProperty_id() {
		return property_id;
	}
	public void setProperty_id(int property_id) {
		this.property_id = property_id;
	}
	public int getAmenities_id() {
		return amenities_id;
	}
	public void setAmenities_id(int amenities_id) {
		this.amenities_id = amenities_id;
	}
	public String getAmenities_name() {
		return amenities_name;
	}
	public void setAmenities_name(String amenities_name) {
		this.amenities_name = amenities_name;
	}
	
	
}
