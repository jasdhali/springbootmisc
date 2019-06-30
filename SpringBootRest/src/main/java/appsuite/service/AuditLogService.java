package appsuite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import appsuite.data.repository.AuditLogRepository;
import appsuite.data.repository.BookRepository;
import appsuite.domain.AuditLog;
import appsuite.domain.Book;

@Service
@Transactional
public class AuditLogService {
		@Autowired
		private BookRepository bookRepository;
		@Autowired
		private AuditLogRepository auditLogRepository;
		
		public void deleteBookCreateLog(Book book,AuditLog auditLog) {
			bookRepository.delete(book);
			auditLogRepository.save(auditLog);
		}
		public void deleteBookCreateLogId(Long bookId) {
			bookRepository.delete(bookId);
			
			AuditLog al = new AuditLog(1L,bookId,"DELDEL");
			
			auditLogRepository.save( al );
		}

}
