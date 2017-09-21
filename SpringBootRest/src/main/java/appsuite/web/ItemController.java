package appsuite.web;

import java.util.Collection;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import appsuite.domain.Item;
import appsuite.exceptions.ServiceException;
import appsuite.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;
	//= new ItemServiceImpl();

	@RequestMapping(value = "/items", method = RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<Collection<Item>> getItems() {
		Collection<Item> items = null;
		try {
			items = itemService.getItems();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RestClientException(ex.getMessage());
		}
		return new ResponseEntity<Collection<Item>>(items, HttpStatus.OK);
	}

	@RequestMapping(value = "/items/{id}", method = RequestMethod.GET)
	public ResponseEntity<Item> getItem(@PathVariable("id") Long id) throws ServiceException {
		Item asset = itemService.getItem(id);
		return new ResponseEntity<Item>(asset, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/items", method = RequestMethod.POST, headers="Accept=application/json")
	public ResponseEntity<Item> addItem(@RequestBody Item item) throws ServiceException {
		 itemService.addItem(item);
		 Item itemCreated = itemService.getItem(item.getId() );
 		 return new ResponseEntity<Item>(itemCreated , HttpStatus.OK);
	}
	
	@RequestMapping(value = "/items", method = RequestMethod.PUT, headers="Accept=application/json")
	public ResponseEntity<Item> updateItem(@RequestBody Item item) throws ServiceException {
		 itemService.updateItem(item);
		 Item itemUpdated = itemService.getItem(item.getId() );
 		 return new ResponseEntity<Item>(itemUpdated , HttpStatus.OK);
	}
	
	private final Logger LOG = Logger.getLogger( "ItemController.class" );

	@RequestMapping(value = "/items/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Long itemId) throws ServiceException {
        LOG.info("Deleting fruit with id: {}=>"+ itemId);
        Item item = itemService.getItem(itemId);
        if ( item == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        itemService.deleteItem( itemId );
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
}