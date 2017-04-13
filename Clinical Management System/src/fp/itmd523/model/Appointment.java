package fp.itmd523.model;

public class Appointment {

	private String patient_id;
	private String doctor_id;
	private String appmt_dt;
	private String time;
	private String purpose;
	
	public Appointment(String patient_id, String doctor_id, String appmt_dt, String time, String purpose) {
		super();
		this.patient_id = patient_id;
		this.doctor_id = doctor_id;
		this.appmt_dt = appmt_dt;
		this.time = time;
		this.purpose = purpose;
	}

	public String getPatient_id() {
		return patient_id;
	}

	public String getDoctor_id() {
		return doctor_id;
	}

	public String getAppmt_dt() {
		return appmt_dt;
	}

	public String getTime() {
		return time;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}

	public void setDoctor_id(String doctor_id) {
		this.doctor_id = doctor_id;
	}

	public void setAppmt_dt(String appmt_dt) {
		this.appmt_dt = appmt_dt;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
	
	
}
