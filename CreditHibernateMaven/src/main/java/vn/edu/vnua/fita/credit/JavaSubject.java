package vn.edu.vnua.fita.credit;

public class JavaSubject extends AbstractSubject implements ICreditSubject {
	private float attendanceMark;
	private float midExamMark;
	private float finalExamMark;

	public JavaSubject(float attendanceMark, float midExamMark, float finalExamMark) {
		super();
		this.attendanceMark = attendanceMark;
		this.midExamMark = midExamMark;
		this.finalExamMark = finalExamMark;
	}

	public float calSubjectMark() {
		return (attendanceMark + midExamMark * 4 + finalExamMark * 5) / 10;
	}

	public float getAttendanceMark() {
		return attendanceMark;
	}

	public void setAttendanceMark(float attendanceMark) {
		this.attendanceMark = attendanceMark;
	}

	public float getMidExamMark() {
		return midExamMark;
	}

	public void setMidExamMark(float midExamMark) {
		this.midExamMark = midExamMark;
	}

	public float getFinalExamMark() {
		return finalExamMark;
	}

	public void setFinalExamMark(float finalExamMark) {
		this.finalExamMark = finalExamMark;
	}

	public float calConversionMark(String grade) {
		float conversionMark = -1;
		switch (grade) {
		case "F":
			conversionMark = 0;
			break;
		case "D":
			conversionMark = 1;
			break;
		case "D+":
			conversionMark = 1.5f;
			break;
		case "C":
			conversionMark = 2;
			break;
		case "C+":
			conversionMark = 2.5f;
			break;
		case "B":
			conversionMark = 3;
			break;
		case "B+":
			conversionMark = 3.5f;
			break;
		case "A":
			conversionMark = 4;
			break;
		}
		return conversionMark;
	}

	public String calGrade() {
		float subjectMark = calSubjectMark();
		String grade = null;
		if (subjectMark < 0) {
			grade = "Error";
		} else if (subjectMark <= ICreditSubject.LEVER_F) {
			grade = "F";
		} else if (subjectMark <= ICreditSubject.LEVER_D) {
			grade = "D";
		} else if (subjectMark <= ICreditSubject.LEVER_D1) {
			grade = "D+";
		} else if (subjectMark <= ICreditSubject.LEVER_C) {
			grade = "C";
		} else if (subjectMark <= ICreditSubject.LEVER_C1) {
			grade = "C+";
		} else if (subjectMark <= ICreditSubject.LEVER_B) {
			grade = "B";
		} else if (subjectMark <= ICreditSubject.LEVER_B1) {
			grade = "B+";
		} else if (subjectMark <= ICreditSubject.LEVER_A) {
			grade = "A";
		}
		return grade;
	}
}
