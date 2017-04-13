package fp.itmd523.model;

public class Doctor {

	private String doctor_id;
	private String d_name;
	private String spec;
	private String d_number;
	public Doctor(String doctor_id, String d_name, String spec, String d_number) {
		super();
		this.doctor_id = doctor_id;
		this.d_name = d_name;
		this.spec = spec;
		this.d_number = d_number;
	}
	public String getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(String doctor_id) {
		this.doctor_id = doctor_id;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public String getD_number() {
		return d_number;
	}
	public void setD_number(String d_number) {
		this.d_number = d_number;
	}
	
	
	
	
}
