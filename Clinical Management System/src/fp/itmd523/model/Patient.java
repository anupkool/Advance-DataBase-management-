package fp.itmd523.model;

public class Patient {

	private String patient_id;
	private String f_name;
	private String l_name;
	private String gender;
	private String dob;
	private String e_mail;
	private String mobile;
	private String blood_group;
	private String weight;
	
	public Patient() {
		// TODO Auto-generated constructor stub
	}
	


	public Patient(String patient_id, String f_name, String l_name, String gender, String dob, String e_mail,
			String mobile, String blood_group, String weight) {
		this.patient_id = patient_id;
		this.f_name = f_name;
		this.l_name = l_name;
		this.gender = gender;
		this.dob = dob;
		this.e_mail = e_mail;
		this.mobile = mobile;
		this.blood_group = blood_group;
		this.weight = weight;
	}



	public String getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getBlood_group() {
		return blood_group;
	}

	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}


	
	

}
