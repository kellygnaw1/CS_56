package lab03;

//Kelly Wang 5351010
//Evan Altshule 5233234
public class Course {
	private int studentCapacity = 50;
	private String courseCode;
	private String courseName;
	private int currentEnrollment;
	private Student [] students = new Student[studentCapacity];
	
	public Course(String code, String name){
		this.courseCode = code;
		this.courseName = name;
	}
	public String getCourseCode() {return courseCode;}
	public String getCourseName() {return courseName;}
	public int getCurrentEnrollment() {return currentEnrollment;}
	
	public void addStudent(Student s) throws StudentLimitException, DuplicateStudentException {
		
		if(currentEnrollment == studentCapacity)
			throw new StudentLimitException();
		if(currentEnrollment == 0) {
			students[currentEnrollment]=s;
			currentEnrollment++;
			return;
		}
		if(compareStudents(s, students[currentEnrollment-1]) > 0) {
			students[currentEnrollment++]=s;
			return;
		}
		for(int i = 0; i < currentEnrollment; i++) {
			int result = compareStudents(s, students[i]);
			if(result == 0)
				throw new DuplicateStudentException();
			if(result > 0)
				continue;
			for(int j = currentEnrollment; j>i; j--) {
				students[j]=students[j-1];
			}
			students[i]=s;
			currentEnrollment++;
			break;
		}
	}
	
	private int compareStudents(Student s1, Student s2) {
		String name1 = s1.getLastName()+s1.getFirstName();
		String name2 = s2.getLastName()+s2.getFirstName();
		
		if(!name1.equalsIgnoreCase(name2))
			return name1.compareTo(name2);
		else if(s1.getPerm() < s2.getPerm())
			return -1;
		else if(s1.getPerm() == s2.getPerm())
			return 0;
		return 1;
	}
	
	public void removeStudent(int studentId) throws EmptyStudentListException, StudentNotFoundException {
		
		if(currentEnrollment == 0)
			throw new EmptyStudentListException();
		
		for(int i = 0; i < currentEnrollment; i++) {
			if(students[i].getPerm() == studentId) {
				for(int j = i; j < currentEnrollment-1; j++) {
					students[j] = students[j+1];
				}
				students[currentEnrollment-1]= null;
				currentEnrollment--;
				return;
			}
		}
		throw new StudentNotFoundException();
	}
	
	public void printCourse() {
		System.out.println(courseCode + ": " + courseName);
		System.out.println("Enrolled: " + currentEnrollment);
		for(int i = 0; i < currentEnrollment; i++) {
			students[i].printStudent();
		}

	}
	
	public Student[] getStudents() {
		return students;
	}
	
}
