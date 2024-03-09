package vn.edu.vnua.fita.credit;

public interface ICreditSubject {
	float LEVER_F = 3.9f;
	float LEVER_D = 4.9f;
	float LEVER_D1 = 5.4f;
	float LEVER_C = 6.4f;
	float LEVER_C1 = 6.9f;
	float LEVER_B = 7.4f;
	float LEVER_B1 = 8.4f;
	float LEVER_A = 10f;

	float calSubjectMark();

	String calGrade();

	float calConversionMark();

	int getCredit();

	String getSubjectCode();

	void setSubjectName(String subjectName);

	void setCredit(int credit);

	void setSubjectCode(String subjectCode);
}
