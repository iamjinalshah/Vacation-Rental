package digimation.vacationrental.bean;

public class RDCBean {
	private  int RDC_id;
	private  int res_id;
	private  String cousins_type;
	private  int cousin_id;
	private  String Cousin_name;
	public int getRDC_id() {
		return RDC_id;
	}
	public void setRDC_id(int rDC_id) {
		RDC_id = rDC_id;
	}
	public int getRes_id() {
		return res_id;
	}
	public void setRes_id(int res_id) {
		this.res_id = res_id;
	}
	public String getCousins_type() {
		return cousins_type;
	}
	public void setCousins_type(String cousins_type) {
		this.cousins_type = cousins_type;
	}
	public int getCousin_id() {
		return cousin_id;
	}
	public void setCousin_id(int cousin_id) {
		this.cousin_id = cousin_id;
	}
	public String getCousin_name() {
		return Cousin_name;
	}
	public void setCousin_name(String cousin_name) {
		Cousin_name = cousin_name;
	}
	
	
}
