package lab03;
//Kelly Wang 5351010
//Evan Altshule 5233234
import java.util.Scanner;
public class RosterManager {
	private int maxCourses = 10; 
	private int currentCourses; 
	private Course [] courses = new Course[maxCourses]; 
	
	public void run() {
		String courseCode, courseName, firstName, lastName;
		int perm;
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Class Roster Manager!" + "\nSelect an action based on the following menu:");
		ClassRosterUI.printMenu();
		
		while (true) {
			String choice = ClassRosterUI.getCommand();
			try {
				switch(choice) {
				case "ac":
						System.out.println("Enter Course Code: ");
						courseCode = input.nextLine();
						System.out.println("Enter Course Name: ");
						courseName = input.nextLine();
						addCourse(new Course(courseCode, courseName));
						break;
						
				case "dc":
						System.out.println("Enter Course Code: ");
						courseCode = input.nextLine();
						deleteCourse(courseCode);
						break;
						
				case "as":
						System.out.println("Enter Course Code: ");
						courseCode = input.nextLine();
						System.out.println("Enter student's first name: ");
						firstName = input.nextLine();
						System.out.println("Enter student's last name: ");
						lastName = input.nextLine();
						while(true) {
							System.out.println("Enter student's PERM: ");
							perm = Integer.parseInt(input.nextLine());
							if(perm > 0)
								break;
							System.out.println("Please enter a valid PERM");
						}
						addStudent(courseCode, new Student(firstName, lastName, perm));
						break;
						
				case "ds":
						System.out.println("Enter student's perm: ");
						perm = Integer.parseInt(input.nextLine());
						System.out.println("Enter Course Code: ");
						courseCode = input.nextLine();
						deleteStudent(perm, courseCode);
						break;
						
				case "p":
						printRoster();
						break;
						
				case "q":
					System.out.println("Quitting Roster Manager...");
					try {
						Thread.sleep(1000);
					}
					catch(InterruptedException ex) {
						Thread.currentThread().interrupt();
					}
					System.out.println("Thank you!");
					input.close();
					return;
				}
			}
			catch(CourseLimitException e) {
				System.out.println("ERROR: Course limit has been met!");
			}
			catch(CourseNotFoundException e) {
				System.out.println("ERROR: Course not found!");
			}
			catch(DuplicateCourseException e) {
				System.out.println("ERROR: Course already exists in list!");
			}
			catch(DuplicateStudentException e) {
				System.out.println("ERROR: Student already exists in list!");
			}
			catch(EmptyCourseListException e) {
				System.out.println("ERROR: Course list is empty!");
			}
			catch(EmptyStudentListException e) {
				System.out.println("ERROR: Student list is empty!");
			}
			catch(StudentLimitException e) {
				System.out.println("ERROR: Student limit has been met!");
			}
			catch(StudentNotFoundException e) {
				System.out.println("ERROR: Student not found!");
			}
		}
	}
	
	public void addCourse(Course c) throws DuplicateCourseException, CourseLimitException  {
		
		if(currentCourses == maxCourses)
			throw new CourseLimitException();
		for(int i = 0; i < currentCourses; i++) {
			if(courses[i].getCourseCode().equalsIgnoreCase(c.getCourseCode()))
				throw new DuplicateCourseException();
		}
		courses[currentCourses] = c;
		currentCourses++;
	}
	
	public void deleteCourse(String courseCode) throws CourseNotFoundException, EmptyCourseListException {
		
		if(currentCourses == 0)
			throw new EmptyCourseListException();
		
		for(int i = 0; i < currentCourses; i++) {
			if(courses[i].getCourseCode().equalsIgnoreCase(courseCode)) {
				for(int j = i; j < currentCourses-1; j++) {
					courses[j] = courses[j+1];
				}
				courses[currentCourses-1] = null;
				currentCourses--;
				return;
			}
		}
		throw new CourseNotFoundException();
		
	}
	
	public void addStudent(String courseCode, Student s) throws StudentLimitException, DuplicateStudentException, CourseNotFoundException {
		
		for(int i = 0; i < currentCourses; i++) {
			if(courses[i].getCourseCode().equalsIgnoreCase(courseCode)) {
				courses[i].addStudent(s);
				return;
			}
		}
		throw new CourseNotFoundException();
	}
	
	public void deleteStudent(int id, String courseCode) throws EmptyStudentListException, StudentNotFoundException, CourseNotFoundException {
		
		for(int i = 0; i < currentCourses; i++) {
			if(courses[i].getCourseCode().equalsIgnoreCase(courseCode)) {
				courses[i].removeStudent(id);
				return;
			}
		}
		throw new CourseNotFoundException();
	}
	
	private void printRoster() {
		System.out.println("********************");
		for(int i = 0; i < currentCourses; i++) {
			courses[i].printCourse();
		}
		System.out.println("********************");	
	}
	
	public Course[] getCourses() {
		return courses;
	}
	
	
}
