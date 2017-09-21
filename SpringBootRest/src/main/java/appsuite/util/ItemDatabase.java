package appsuite.util;

import java.util.Collection;

import appsuite.domain.Item;
import appsuite.exceptions.ServiceException;


public interface ItemDatabase {
	public void createItem(Item item) throws ServiceException;

	public Item getItemById(Long id) throws ServiceException;

	public void updateItem(Item item) throws ServiceException;

	public void deleteItem(Long id) throws ServiceException;

	public Collection<Item> getItems() throws ServiceException;
}
