package appsuite.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@AllArgsConstructor
//@Getter
//@Setter
//@NoArgsConstructor
public class AuditLog {
	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "bookid")
	private Long bookId;

	@Column(name = "type")
	private String transactionType;

	public AuditLog(Long id, Long bookId, String transactionType) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.transactionType = transactionType;
	}

	public AuditLog() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
