package appsuite.service;

import appsuite.dao.ProductDao;
import appsuite.domain.Product;
import appsuite.exceptions.InsufficientProductsException;

public class ProductService {
	
	private ProductDao productDao;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	public boolean buy(Product product, int orderedQuantity) throws InsufficientProductsException {
		boolean transactionStatus=false;
		int availableQuantity = productDao.getAvailableProducts(product);
		if (orderedQuantity > availableQuantity) {
			throw new InsufficientProductsException();
		}
		productDao.orderProduct(product, orderedQuantity);
		transactionStatus=true;
		return transactionStatus;
	}
}
