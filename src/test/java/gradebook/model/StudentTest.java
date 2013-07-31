package gradebook.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StudentTest {

	Student student;
	
	@Before
	public void setUp() throws Exception {
		student = new Student("Susan");
		GradebookDB<GradebookItem> items = new GradebookImpl<GradebookItem>();
		GradebookDB<GradebookItem> items2 = new GradebookImpl<GradebookItem>();
		
		GradebookCategory category = new GradebookCategory("test", 0.5);
		GradebookCategory category2 = new GradebookCategory("project", 0.5);
		
		GradebookItem newItem = new GradebookItem("test1", category, 80);
		GradebookItem newItem2 = new GradebookItem("project1", category2, 70);
		items.add(newItem);
		items2.add(newItem2);
		
		student.setScores(items);
		student.setScores(items2);
		category.setItemList(items);
		category2.setItemList(items2);
	}

	@Test
	public void testScores() {
		assertEquals(75.0, student.averageScore(), 0);
	}
	
	@Test
	public void testLetterGrade() {
		assertEquals(student.letterGrade(), 'C');
	}
	
	@Test
	public void testFailureOfInvalidInput() {
		assertFalse(student.setScores(new GradebookImpl()));
	}

}
