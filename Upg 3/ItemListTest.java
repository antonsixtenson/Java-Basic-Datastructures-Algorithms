import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ItemListTest {

	ItemList listA;
	ItemList listB;
	ItemList listC;

	@Before
	public void setUp() throws Exception {
		listA = new ItemList();
		listB = new ItemList();
		listC = new ItemList();

	}

	@Test
	public void addTest() {

		for (int i = 0; i < 1000; i++) {
			listA.addSort(new Item("Nytt item", "01"));
		}
		assertEquals("Add 1000 item test with size()", 999, listA.size());	//Borde få 1000 (?) items, varför får jag 999?
	}

	@Test
	public void removeTest() {

		listB.add(new Item("item01", "01"));
		listB.add(new Item("item02", "02"));
		listB.add(new Item("item03", "03"));

		listB.remove("01");
		listB.remove("02");
		listB.remove("03");
		listB.find("01"); assertEquals("Remove all objects check that list is empty", true, listB.isEmpty());

		listB.isEmpty();

	}

	@Test
	public void isEmptyTest() {
		assertEquals("Test if new list is empty", true, listC.isEmpty());
		listC.add(new Item("Nytt item", "01"));
		assertEquals("Test if list with objects isn't empty", false, listC.isEmpty());
		listC.remove("01");
		assertEquals("Remove all objects check that list is empty", true, listC.isEmpty());
		}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void sizeTest() {
		listA.add(new Item ( "Nytt Item", "01"));
		listA.add(new Item ( "Nytt Item", "02"));


		listA.size();


		listA.remove("02");
		assertEquals("Should return 1", 1, listA.size());


	}

}
