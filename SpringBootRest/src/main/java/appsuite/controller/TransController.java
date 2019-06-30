package appsuite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import appsuite.data.jdbc.BooksDao;
import appsuite.domain.Book;
import appsuite.service.AuditLogService;

@RestController
@RequestMapping(value = "/trans")
public class TransController {
	@Autowired
	private AuditLogService auditLogService;
	
	@RequestMapping( name =  "/auditlog/{id}",method=RequestMethod.DELETE, path = "/auditlog/{id}"  )
	public void deleteBookAuditLog(@PathVariable int id) {		
		auditLogService.deleteBookCreateLogId(Long.parseLong(id+""));
	}

	@RequestMapping( name =  "/book/{id}",method=RequestMethod.GET, path = "/book/{id}" , produces = {"application/json"} )
	public Book getBook( ) {
		Book bookBySp  = booksDao.getStudent( 2 );
		return booksDao.getBooksById(1l);
	}
	
	@Autowired
	private BooksDao booksDao;
	
}
