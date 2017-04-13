# Advance-DataBase-management-

1. Introduction
Some of the time you run over little issues where you to require counsel doctor about your medical issues or for the closest ones and take after their medicines. doctor online will give you the force of direct connection between doctor of your decision as and when required for your little issues. Utilizing this web applications, patients will ready to fill online frame in only few moments before entering to the virtual office room. It will likewise empower you to transfer your lab results, for example, x-beam duplicates, wellbeing history and so forth which can be seen by your alluded doctor. Currently, under manual framework, you need to first hold up in line to take arrangement for the specialists and sit tight for your opportunity to have meet with them and talk about on your wellbeing problems. As you need to give your data and different reports commonly at better places, for example, the prescription store which is again a weight of conveying archives. You must be available physically at the specialist's lodge. Patients need to visit on one more day of after a few hours to take their wellbeing reports which includes additional care individual with patients at whatever time.
We are implementing a web application for doctors having a clinic to manage and schedule the patient appointments as well as to track a patient history in more efficient manner. The web application will allow a patient to register on a web portal before scheduling an appointment. Patient will have a patient id hence through this he or she can able to book an appointment with a doctor and able to see his/her previous medical history (like doctor’s suggestions in previous appointment, recommended medicines etc.). Patient has an option to cancel the scheduled appointment before particular time limit. All the user data will be stored in database with necessary normalization of data tables. The user database will include user details (like mail id, phone number, appointment date etc.)
For Doctor, the web application will allow to see the patient history by using patient’s unique id number. This data will be retrieved from database. Doctor can update the contents like prescription, recommended medicines and add any suggestions or comments. This information will be updated in corresponding fields of database. This would be a work flow of our web application.
 
2. Plans/Requirement Analysis
	The software must allow input of patient data from the patient and the Doctor.
	The software must request username and password for access to data, only after authentication the system will allow access.
	The software must require high levels of error correction.
	The software must allow browsing by the Doctor of historical medical information of his/her patients only.
	The software must retrieve, update, and store data from multiple input.
	The software must allow patient to view their own medical record online allowing changes only to phone number and Weight(as it is a variable).
	The software must retrieve and sort medical record information and allow for screen for the doctor to view so as he can provide detail diagnostics.
 
3. Database Design
Based on the Requirements system will involve the use of a lot of information, some which will be needed several times and the most appropriate form of storage of this data is in a database. This will allow data to be saved from input to the system and retrieved to be used by the system. We required a Fairly Simplistic and easy to use Database. Wherein the Security is maintained but can be worked on using a server.
We have chosen the MySQL database for storing Data Cause of below reasons. MySQL is free open source social database administration framework. MySQL is the most famous open source database because of its elite. It can also handle large amounts of data and provides security through user authorisation and access privileges. Database design is also relatively simple in MySQL, which may be an advantage in this project as more time could be spent on designing and developing the actual application. 

ER Diagram

 
Normalization
To check the ER Diagram if it meets the 3 NF form.
The ERD meets the 3NF and BCNF as the designed Table doesn’t have any transitive dependency. Below are the tables.
Patient Table
PatientID	PName	Lname	Gender	DOB	Mobile	Blood_Group	Weight
P001	John	Adams	Male	11/14/1975	3124567891	A+	85Kg
P002	Linda	Hayden	Female	10/25/1980	3126897998	AB+	60Kg

Doctor Table
DoctorID	Dname	Specilization	Number
D001	Ray	General Physician	3124567895

Appointment Table
PatientID	DoctorID	Appointment Date	Time	Purpose
P001	D001	11/20/2016	11:30,	Head Ache
P001	D001	11/29/2016	12:30	Heavy Head
P002	D001	11/20/2016	11:30,	Head Ache
P002	D001	11/29/2016	12:30	Heavy Head
P002	D001	11/29/2016	12:30	Heavy Head

Prescription Table
PatientID	DoctorID	Prescription	Comments	Prescription date
P001	D001	 	Migrane Check	11/20/2016
P001	D001	 	Migrane Check	11/29/2016
P002	D001	 	Migrane Check	11/20/2016
P002	D001	 	Migrane Check	11/29/2016
P002	D001	 	Migrane Check	11/29/2016


4. Application Design
In order to have the Project implemented we did some research on the Programing Language to be used which fits the client requirements. We have chosen Java as it is a very popular language it can run on many platforms including Windows and Linux. Also, Java has many additional libraries available for it, which may be advantageous in this project. A JDBC for MySQL is available so integrating a Java program with MySQL was possible. We have used JAVAFX as this is the latest technology for any GUI applications. By Using this we can make the application very user friendly and which meets the Client Requirements.
 
5. Conclusions and Future Work
5.1. Conclusions
	Clinic Management System presents an innovative solution to resolving the challenges for patients to access primary health care services
	It allows the Patient to Book an Online Appointment with the Doctor.
	The patient can view the Medications provided to him by having a look at the history where the detailed prescription is made available for patient view. 

5.2. Limitations
	Managing the payment is a limitation here. As there is no scope for managing the consultation fees of the doctor. 
	In case we are planning to implement the uploading of the Tests (X-rays, blood tests etc.) then doctor needs to have hardware (scanners, printers also if required). 
	Managing Medical representatives appointments’ order to do publicity of their company's medicines they also need to have appointments with the doctor.
6.3. Potential Improvements or Future Work
	We can have a list of all the medicines from medicine dictionary so that a drop down list is provided and doctor can choose from that list the medicine he wants to prescribe to the patient.
	We can also introduce another actor (Pharmacy shop owner) where in the on entering the Patient id of that patient he will get a  view showing his name and the medicines that are prescribed by the doctor. So, that patient does not have to remember the name of the medicine while going to purchase one. Then it would totally become paperless.
