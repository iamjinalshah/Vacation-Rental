package digimation.vacationrental.bean;

public class GLDetailsBean {
	
	private int language_id;
	private int tourguide_id;
	private String tourguide_name;
	private int GL_id;
	private String gl_name;
	
	public int getLanguage_id() {
		return language_id;
	}
	public void setLanguage_id(int language_id) {
		this.language_id = language_id;
	}
	public int getTourguide_id() {
		return tourguide_id;
	}
	public void setTourguide_id(int tourguide_id) {
		this.tourguide_id = tourguide_id;
	}
	public int getGL_id() {
		return GL_id;
	}
	public void setGL_id(int gL_id) {
		GL_id = gL_id;
	}
	public String getGl_name() {
		return gl_name;
	}
	public void setGl_name(String gl_name) {
		this.gl_name = gl_name;
	}
	public String getTourguide_name() {
		return tourguide_name;
	}
	public void setTourguide_name(String tourguide_name) {
		this.tourguide_name = tourguide_name;
	}
	
}
