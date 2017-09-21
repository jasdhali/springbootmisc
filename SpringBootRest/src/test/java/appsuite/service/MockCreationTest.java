/*package appsuite.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import appsuite.dao.ProductDao;
import appsuite.domain.Product;
import appsuite.exceptions.InsufficientProductsException;

public class MockCreationTest {
	private ProductDao productDao;
    private Product product;
    
    @Before
    public void setupMock() {
        product = mock(Product.class);
        productDao = mock(ProductDao.class);
    }
    @Test
    public void testMockCreation(){
        assertNotNull(product);
        assertNotNull(productDao);
    }

    @Test
    public void testBuy() throws InsufficientProductsException {
        when(productDao.getAvailableProducts(product)).thenReturn(30);
        assertEquals(30,productDao.getAvailableProducts(product));
    }
}
*/