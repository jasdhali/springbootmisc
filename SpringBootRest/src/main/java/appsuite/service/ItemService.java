package appsuite.service;

import java.util.Collection;

import appsuite.domain.Item;
import appsuite.domain.User;
import appsuite.exceptions.ServiceException;

public interface ItemService {
	public Collection<Item> getItems() throws ServiceException;
	public Item getItem(long id) throws ServiceException;
	public void deleteItem(long id) throws ServiceException;
	public void addItem(Item item) throws ServiceException;
	public void updateItem(Item item) throws ServiceException;
    public Item findByName(String sku) throws ServiceException;
 	boolean exists(Item item) throws ServiceException;
}
