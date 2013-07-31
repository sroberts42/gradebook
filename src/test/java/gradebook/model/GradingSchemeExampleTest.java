package gradebook.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GradingSchemeExampleTest {

	GradingSchemeExample example;
	GradebookDB<GradebookItem> items2;
	
	@Before
	public void setUp() throws Exception {
		GradebookDB<GradebookItem> items = new GradebookImpl<GradebookItem>();
		items2 = new GradebookImpl<GradebookItem>();
		GradebookCategory category = new GradebookCategory("test", 0.3);
		category.setItemList(items);
		GradebookCategory category2 = new GradebookCategory("project", 0.5);
		category2.setItemList(items2);
		GradebookCategory category3 = new GradebookCategory("Homework", 0.2);
		category3.setItemList(items2);
		GradebookItem newItem = new GradebookItem("test1", category, 70);
		GradebookItem newItem2 = new GradebookItem("project1", category2, 100);
		GradebookItem newItem3 = new GradebookItem("HW", category3, 90);
		items.add(newItem);
		items2.add(newItem2);
		items2.add(newItem3);
		example = new GradingSchemeExample(items);
		example.addGradingItems(items2);
	}

	@Test
	public void testAverageScore() {
		assertEquals(89.0, example.averageScore(), 0);
	}
	
	@Test
	public void testLetterGrade() {
		assertEquals('B', example.letterGrade());
	}
	
	@Test
	public void testAddedItems() {
		assertTrue(example.addGradingItems((items2)));
	}

}
