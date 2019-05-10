package lab03;

//Kelly Wang 5351010
//Evan Altshule 5233234
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import static org.junit.Assert.assertArrayEquals;

public class ClassRosterTester {
	private RosterManager rm;
	private Course c1 = new Course("CS56", "Advanced Applications Programming");
	private Course c2 = new Course("CS48", "Computer Science Project");
	private Course c3 = new Course("CS130A", "Data Structures Algorithm");
	
	@Before
	public void executeBeforeEachTest() {
		System.out.println("@Before: shown before each test");
	}
	
	@Test 
	public void testAddCourse() throws CourseLimitException, DuplicateCourseException{
		rm = new RosterManager();
		rm.addCourse(c1);
		rm.addCourse(c2);
		rm.addCourse(c3);
		Course[] courses = rm.getCourses();
		Course[] expected = {c1, c2, c3, null, null, null, null, null, null, null};
		assertArrayEquals(expected, courses);
	}
	
	@Test (expected = DuplicateCourseException.class)
	public void testDuplicateCourseException()throws CourseLimitException, DuplicateCourseException{
		rm = new RosterManager();
		rm.addCourse(c1);//1
		rm.addCourse(c2);//2
		rm.addCourse(c3);//3
		rm.addCourse(new Course("cs56", "Advanced Applications Programming"));//4
	}
	
	@Test (expected = CourseLimitException.class)
	public void testCourseLimitException() throws CourseLimitException, DuplicateCourseException{
		rm = new RosterManager();
		rm.addCourse(c1);//1
		rm.addCourse(c2);//2
		rm.addCourse(c3);//3
		rm.addCourse(new Course("4", "a"));
		rm.addCourse(new Course("5", "b"));
		rm.addCourse(new Course("6", "c"));
		rm.addCourse(new Course("7", "d"));
		rm.addCourse(new Course("8", "e"));
		rm.addCourse(new Course("9", "f"));
		rm.addCourse(new Course("10", "g"));
		rm.addCourse(new Course("11", "h"));
		
	}
	
	@Test 
	public void testDeleteCourse() throws CourseLimitException, DuplicateCourseException, CourseNotFoundException, EmptyCourseListException {
		rm = new RosterManager();
		rm.addCourse(c1);
		rm.addCourse(c2);
		rm.addCourse(c3);
		rm.deleteCourse("CS48");
		rm.deleteCourse("CS56");
		rm.deleteCourse("CS130A");
		
		Course[] courses = rm.getCourses();
		assertArrayEquals(new Course[10], courses);
	}
	
	@Test (expected = CourseNotFoundException.class)
	public void testCourseNotFoundException() throws CourseLimitException, DuplicateCourseException, EmptyCourseListException, CourseNotFoundException{
		rm = new RosterManager();
		rm.addCourse(c1);
		rm.deleteCourse("CS48");
	}
	
	@Test(expected = EmptyCourseListException.class)
	public void testEmptyCourseListException() throws EmptyCourseListException, CourseNotFoundException{
		rm = new RosterManager();
		rm.deleteCourse("CS48");
	}
	
	@Test
	public void testAddStudent() throws StudentLimitException, DuplicateStudentException, CourseNotFoundException, CourseLimitException, DuplicateCourseException {
		rm = new RosterManager();
		rm.addCourse(c1);
		Student s1 = new Student("Kelly", "Wang", 5351010);
		rm.addStudent("CS56", s1);
		Student[]students = rm.getCourses()[0].getStudents();
		Student[]expected = new Student[50];
		expected[0]=s1;
		assertArrayEquals(expected, students);
		
		//test order 
		Student s2 = new Student("Kelly", "Wang", 4341010);
		rm.addStudent("CS56", s2);
		Student s3 = new Student("Palash", "Garg", 2021010);
		rm.addStudent("CS56", s3);
		Student s4 = new Student ("Ashley", "Wang", 6031987);
		rm.addStudent("CS56", s4);
		
		expected[0]=s3;
		expected[1]=s4;
		expected[2]=s2;
		expected[3]=s1;
		students = rm.getCourses()[0].getStudents();
		assertArrayEquals(expected, students);
	}
	@Test
	public void testRemoveStudent() throws DuplicateStudentException, StudentLimitException, CourseNotFoundException, DuplicateCourseException, CourseLimitException, StudentNotFoundException, EmptyStudentListException{
		rm = new RosterManager();
		rm.addCourse(c1);
		Student s1 = new Student("Kelly", "Wang", 5351010);
		Student s2 = new Student("Kelly", "Wang", 4341010);
		Student s3 = new Student("Palash", "Garg", 2021010);
		Student s4 = new Student ("Ashley", "Wang", 6031987);
		rm.addStudent("CS56", s1);
		rm.addStudent("CS56", s2);
		rm.addStudent("CS56", s3);
		rm.addStudent("CS56", s4);
		rm.deleteStudent(5351010, "CS56");
		rm.deleteStudent(4341010, "CS56");
		rm.deleteStudent(2021010, "CS56");
		rm.deleteStudent(6031987, "CS56");
		Student[]students = rm.getCourses()[0].getStudents();
		Student[]expected = new Student[50];
		assertArrayEquals(expected, students);
	}
	
	@Test (expected = DuplicateStudentException.class)
	public void testDuplicateStudentException() throws DuplicateStudentException, StudentLimitException, CourseNotFoundException, DuplicateCourseException, CourseLimitException{
		rm = new RosterManager();
		rm.addCourse(c1);
		Student s1 = new Student("Kelly", "Wang", 5351010);
		rm.addStudent("CS56", s1);
		rm.addStudent("CS56", s1);
		
	}
	
	@Test (expected = StudentLimitException.class)
	public void testStudentLimitException() throws DuplicateStudentException, StudentLimitException, CourseNotFoundException, DuplicateCourseException, CourseLimitException {
		rm = new RosterManager();
		rm.addCourse(c1);
		for(int i = 0; i < 50; i++)
			rm.addStudent("CS56", new Student("Kelly", "Wang", i+1));
		rm.addStudent("CS56", new Student("Kelly", "Wang", 5351010));
	}
	
	@Test (expected = CourseNotFoundException.class)
	public void testCourseNotFoundStudentAddException() throws DuplicateStudentException, StudentLimitException, CourseNotFoundException, DuplicateCourseException, CourseLimitException{
		rm = new RosterManager();
		rm.addStudent("CS56", new Student("Kelly", "Wang", 5351010));
		rm.addCourse(c1);
		rm.addStudent("CS130A", new Student("Kelly", "Wang", 5351010));	
	}
	@Test (expected = CourseNotFoundException.class)
	public void testCourseNotFoundStudentDeleteException() throws DuplicateStudentException, StudentLimitException, CourseNotFoundException, DuplicateCourseException, CourseLimitException, StudentNotFoundException, EmptyStudentListException{
		rm = new RosterManager();
		rm.addCourse(c1);
		rm.addStudent("CS56", new Student("Kelly", "Wang", 5351010));
		rm.deleteStudent(5351010, "CS130A");
	}
	
	@Test (expected = EmptyStudentListException.class)
	public void testEmptyStudentListException() throws DuplicateStudentException, StudentLimitException, CourseNotFoundException, DuplicateCourseException, CourseLimitException, StudentNotFoundException, EmptyStudentListException{
		rm = new RosterManager();
		rm.addCourse(c1);
		rm.deleteStudent(5351010, "CS56");
	}
	
	@Test (expected = StudentNotFoundException.class)
	public void testStudentNotFoundException() throws DuplicateStudentException, StudentLimitException, CourseNotFoundException, DuplicateCourseException, CourseLimitException, StudentNotFoundException, EmptyStudentListException{
	rm = new RosterManager();
	rm.addCourse(c1);
	rm.addStudent("CS56", new Student("Kelly", "Wang", 5351010));
	rm.deleteStudent(4341010, "CS56");
	
	}
	
	@After
	public void executeAfterTest() {
		System.out.println("@After: shown after every test");
	}
	
	@AfterClass
	public static void executeAfterAllTests() {
		System.out.println("@AfterClass: shown once after all tests");
	}
	
	@BeforeClass
	public static void executeBeforeAllTests() {
		System.out.println("@BeforeClass: shown once before all tests");
	}
	
}
