package vn.edu.vnua.fita.credit;

public abstract class AbstractSubject {
	private String subjectCode;
	private String subjectName;
	private int credit;

	public abstract float calSubjectMark();

	public float calConversionMark() {
		float subjectMark = calSubjectMark();
		float conversionMark = -1;
		if (subjectMark <= ICreditSubject.LEVER_F) {
			conversionMark = 0;
		} else if (subjectMark <= ICreditSubject.LEVER_D) {
			conversionMark = 1;
		} else if (subjectMark <= ICreditSubject.LEVER_D1) {
			conversionMark = 1.5f;
		} else if (subjectMark <= ICreditSubject.LEVER_C) {
			conversionMark = 2;
		} else if (subjectMark <= ICreditSubject.LEVER_C1) {
			conversionMark = 2.5f;
		} else if (subjectMark <= ICreditSubject.LEVER_B) {
			conversionMark = 3;
		} else if (subjectMark <= ICreditSubject.LEVER_B1) {
			conversionMark = 3.5f;
		} else if (subjectMark <= ICreditSubject.LEVER_A) {
			conversionMark = 4;
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

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String toString() {
		return subjectName + "-" + subjectCode + "-" + credit + "-" + calSubjectMark() + "-" + calConversionMark() + "-"
				+ calGrade();
	}

}
