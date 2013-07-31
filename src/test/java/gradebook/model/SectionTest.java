package gradebook.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SectionTest {

	Student student1;
	Student student2;
	Section section;
	GradebookDB<Student> students;
	
	@Before
	public void setUp() throws Exception {
		
		student1 = new Student("Susan");
		student2 = new Student("Cody");
		students = new GradebookImpl<Student>();
		students.add(student1);
		students.add(student2);
		
		section = new Section(students);
		GradebookDB<Section> sections = new GradebookImpl<Section>();
		sections.add(section);
		
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
	}

	@Test
	public void testAverageScore() {
		assertEquals(75, student1.averageScore(), 0);
		assertEquals(90, student2.averageScore(), 0);
		assertEquals(82.5, section.averageScore(), 0);
		
	}
	
	@Test
	public void testLetterGrade() {
		assertEquals('C', student1.letterGrade());
		assertEquals('A', student2.letterGrade(), 0);
		assertEquals('B', section.letterGrade(), 0);
	}
	
	@Test
	public void testSetStudents(){
		section.setStudents(students);
		assertEquals(students,section.getStudents());
	}

}
