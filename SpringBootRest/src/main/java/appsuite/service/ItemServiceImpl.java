package appsuite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import appsuite.data.repository.ItemRepository;
import appsuite.domain.Item;
import appsuite.domain.User;
import appsuite.exceptions.ServiceException;
import appsuite.util.ItemDatabase;
import appsuite.util.ItemDatabaseImpl;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	ItemRepository itemRepository;
	
	//@Autowired
	private ItemDatabase itemDatabase=new ItemDatabaseImpl();

	public List<Item> getItems() throws ServiceException {
		return itemRepository.findAll();
		//return itemDatabase.getItems();
	}

	public Item getItem(long id) throws ServiceException {
		/*
		 * Stream<Item> element = data.stream().filter( it ->
		 * it.getItemId().equals(id) ); return element.findFirst();
		 */
		return itemRepository.findOne(id);
	}
	
	public void deleteItem(long id) throws ServiceException{
		itemRepository.delete( id );
	}
	
	public void addItem(Item item) throws ServiceException{
		
		itemRepository.save( item );
		
	}
	
	public void updateItem(Item item) throws ServiceException{
		/*Item existintItem = getItem(item.getId() );
		if( existintItem==null) throw new ServiceException("Item with id "+ item.getId() +" does not exist.");
		existintItem.copyAttributes( item );*/
		itemRepository.save( item );
		//itemDatabase.createItem(item);
	}
	
	
    @Override
	public boolean exists(Item item) throws ServiceException{
        return findByName(item.getSku()) != null;
	}
	
    @Override
    public Item findByName(String sku) throws ServiceException{
        for (Item item : getItems()){
            if (item.getSku().equals( sku )){
                return item;
            }
        }
        return null;
    }
	
}