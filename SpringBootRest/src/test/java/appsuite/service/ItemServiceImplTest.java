/**
 * 
 */
package appsuite.service;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import appsuite.domain.Item;
import appsuite.exceptions.ServiceException;

/**
 * @author jaspal
 *
 */
public class ItemServiceImplTest {
	private Long TEST_ITEM_ID_1 = new Long(1);
	private Long TEST_ITEM_ID_2 = new Long(1);
	private Long TEST_ITEM_ID_3 = new Long(1);
	
	@Mock	
	private static ItemService itemService;
	
	private List<Item> items = null;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("public static void setUpBeforeClass() throws Exception=========");
		itemService = mock(ItemService.class);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("public static void tearDownAfterClass() throws Exception========");
		itemService = null;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("public void setUp()========");
		items = Arrays.asList(
	            new Item(1, "Item1",20),
	            new Item(2, "Item2",30));
	    
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link appsuite.service.ItemServiceImpl#getItems()}.
	 * @throws ServiceException 
	 */
	@Test
	public final void testGetItems() throws ServiceException {
		when( itemService.getItems()).thenReturn(items);
	    assertNotNull( items );
	    assertEquals("Item1", items.get(0).getSku());
		//fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link appsuite.service.ItemServiceImpl#getItem(java.lang.String)}.
	 * @throws ServiceException 
	 */
	@Test
	public final void testGetItem() throws ServiceException {
		when( itemService.getItem( TEST_ITEM_ID_1)).thenReturn(items.get(0));
		Item item_1 = itemService.getItem( new Long(1) );
		assertNotNull( item_1 );
		assertEquals( "Item1" , item_1.getSku() );
		//fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link appsuite.service.ItemServiceImpl#deleteItem(java.lang.String)}.
	 */
/*	@Test
	public final void testDeleteItem() {
		when( itemService.deleteItem( TEST_ITEM_ID_1)).thenReturn(items.remove(0) );
		//fail("Not yet implemented"); // TODO
	}
*/
}
