package gradebook.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GradebookCategoryTest {
	
	GradebookCategory category;
	GradebookDB<GradebookItem> items;
	
	@Before
	public void setUp() throws Exception {
		items = new GradebookImpl<GradebookItem>();
		category = new GradebookCategory("Test", 0.5);
		items.add(new GradebookItem("Test1", category, 100));
		items.add(new GradebookItem("Test2", category, 0));
		category.setItemList(items);
	}

	@Test
	public void testSettersAndGetters() {
		category.setWeight(0.9);
		assertEquals(0.9, category.getWeight(), 0);
		category.setName("name");
		assertEquals("name", category.getName());
		assertEquals(2 ,category.getNumberItems());
		assertEquals(items, category.getItemList());
	}

}
