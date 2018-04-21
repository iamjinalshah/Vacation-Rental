package digimation.vacationrental.bean;

public class RestaurantPhotoBean {

	private int restaurantphoto_id;
	private String photo_name;
	private boolean isvisible;
	private boolean iscoverpage;
	private int restaurant_id;
	private String restaurant_name;
	public int getRestaurantphoto_id() {
		return restaurantphoto_id;
	}
	public void setRestaurantphoto_id(int restaurantphoto_id) {
		this.restaurantphoto_id = restaurantphoto_id;
	}
	public String getPhoto_name() {
		return photo_name;
	}
	public void setPhoto_name(String photo_name) {
		this.photo_name = photo_name;
	}
	public boolean getisIsvisible() {
		return isvisible;
	}
	public void setIsvisible(boolean isvisible) {
		this.isvisible = isvisible;
	}
	public boolean getisIscoverpage() {
		return iscoverpage;
	}
	public void setIscoverpage(boolean iscoverpage) {
		this.iscoverpage = iscoverpage;
	}
	public int getRestaurant_id() {
		return restaurant_id;
	}
	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	public String getRestaurant_name() {
		return restaurant_name;
	}
	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}
	
	
}
