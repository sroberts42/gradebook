package gradebook.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CourseTest {

	Course course;
	Student student1;
	Student student2;
	
	@Before
	public void setUp() throws Exception {
		
		student1 = new Student("Susan");
		student2 = new Student("Cody");
		GradebookDB<Student> students = new GradebookImpl<Student>();
		students.add(student1);
		students.add(student2);
		
		GradebookDB<Course> courses = new GradebookImpl<Course>();
		courses.add(new Course("CS", 1331, "Intro", new GradebookImpl<Course>()));
		course = new Course("CS", 2340, "Objects and Design", courses);
		
		Section section = new Section(students);
		GradebookDB<Section> sections = new GradebookImpl<Section>();
		sections.add(section);
		
		Class newClass = new Class(course, "Fall", sections);
		GradebookDB<Class> classes = new GradebookImpl<Class>();
		classes.add(newClass);
		course.addClasses(classes);
		
		GradebookDB<GradebookItem> items = new GradebookImpl<GradebookItem>();
		GradebookDB<GradebookItem> items2 = new GradebookImpl<GradebookItem>();
		GradebookCategory category = new GradebookCategory("test", 0.5);
		category.setItemList(items);
		GradebookCategory category2 = new GradebookCategory("project", 0.5);
		category2.setItemList(items2);
		
		GradebookItem newItem = new GradebookItem("test1", category, 80);
		GradebookItem newItem2 = new GradebookItem("project1", category2, 70);
		
		GradebookItem newItem3 = new GradebookItem("test1", category, 90);
		GradebookItem newItem4 = new GradebookItem("project1", category2, 90);
		
		items.add(newItem);
		items.add(newItem2);
		student1.setScores(items);
		
		items2.add(newItem3);
		items2.add(newItem4);
		student2.setScores(items2);
		
		course.findLetterGrade();
	}

	@Test
	public void testAverages() {
		assertEquals(75.0, student1.averageScore(), 0);
		assertEquals(90, student2.averageScore(), 0);
		assertEquals(82.5, course.averageScore(), 0);
	}
	
	@Test
	public void testLetterGrades() {
		assertEquals('C', student1.letterGrade());
		assertEquals('A', student2.letterGrade());
		assertEquals('B', course.letterGrade());
	}
	
	@Test
	public void testGettersAndSetters() {
		assertEquals("Objects and Design", course.getCourseName());
		assertEquals(2340, course.getCourseNumber());
		assertFalse(course.getPrerequisites().equals(new GradebookImpl()));
		assertEquals("CS", course.getSubject());
	}

}
