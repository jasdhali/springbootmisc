package com.spring.rest.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "book_rental")
//@NamedQuery(name="Book.findByPrice",query="select name,author,price from Book b where b.price=?1")
public class BookRental implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "TRANS_ID")
	long tranId;

	@Column(name = "Book_Id")
	String name;

	@Column(name = "Rent_Ts")
	Date dateRental;
	@Column(name = "renter")
	String renter;

	public BookRental() {
		super();
	}

	public BookRental(long tranId, String name, Date dateRental, String renter) {
		super();
		this.tranId = tranId;
		this.name = name;
		this.dateRental = dateRental;
		this.renter = renter;
	}

	public long getTranId() {
		return tranId;
	}

	public void setTranId(long tranId) {
		this.tranId = tranId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateRental() {
		return dateRental;
	}

	public void setDateRental(Date dateRental) {
		this.dateRental = dateRental;
	}

	public String getRenter() {
		return renter;
	}

	public void setRenter(String renter) {
		this.renter = renter;
	}

}
