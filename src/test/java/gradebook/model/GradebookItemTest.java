package gradebook.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GradebookItemTest {

	GradebookItem item;
	GradebookCategory category;
	GradebookCategory category2;
	
	@Before
	public void setUp() throws Exception {
		category = new GradebookCategory("Tests", 0.6);
		category2 = new GradebookCategory("Projects", 0.6);
		item = new GradebookItem("Test1", category, 95);
	}

	@Test
	public void testGetters() {
		assertEquals(category, item.getGradebookCategory());
		assertEquals(95, item.getScore(), 0);
		assertEquals("Test1", item.getName());
	}
	@Test
	public void testSetters() {
		item.setGradebookCategory(category2);
		assertEquals(category2, item.getGradebookCategory());
		item.setScore(70);
		assertEquals(70, item.getScore(), 0);
		item.setName("TestA");
		assertEquals("TestA", item.getName());
	}

}
