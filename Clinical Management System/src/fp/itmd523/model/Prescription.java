package fp.itmd523.model;

public class Prescription {

	private String patient_id;
	private String doctor_id;
	private String prescription;
	private String comments;
	private String prescription_date;
	
	public Prescription(String patient_id, String doctor_id, String prescription, String comments,
			String prescription_date) {
		super();
		this.patient_id = patient_id;
		this.doctor_id = doctor_id;
		this.prescription = prescription;
		this.comments = comments;
		this.prescription_date = prescription_date;
	}

	public String getPatient_id() {
		return patient_id;
	}

	public String getDoctor_id() {
		return doctor_id;
	}

	public String getPrescription() {
		return prescription;
	}

	public String getComments() {
		return comments;
	}

	public String getPrescription_date() {
		return prescription_date;
	}

	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}

	public void setDoctor_id(String doctor_id) {
		this.doctor_id = doctor_id;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public void setPrescription_date(String prescription_date) {
		this.prescription_date = prescription_date;
	}
	
	
	
}
