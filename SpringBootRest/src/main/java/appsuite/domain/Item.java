package appsuite.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * 
 * @author jaspal
 *
 */
@JsonRootName(value = "item")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class Item {
	@JsonProperty(value = "id")
	@Id
	private long id;

	@JsonProperty(value = "sku")
	// @Column(name="SKU")
	private String sku;

	@JsonProperty(value = "reorderQuantity")
	@Column(name = "REORDERQUANTITY")
	private int reorderQuantity;

	public Item() {
		super();
	}

	public Item(long itemId, String sku, int reorderQuantity) {
		super();
		this.id = itemId;
		this.sku = sku;
		this.reorderQuantity = reorderQuantity;
	}

	public Item(String sku) {
		super();
		this.sku = sku;
	}

	public void copyAttributes(Item itemIn) {
		this.sku = itemIn.getSku();
		this.reorderQuantity = itemIn.getReorderQuantity();
	}

	public Long getId() {
		return id;
	}

	public void setItemId(long itemId) {
		this.id = itemId;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String itemSku) {
		this.sku = itemSku;
	}

	public int getReorderQuantity() {
		return reorderQuantity;
	}

	public void setReorderQuantity(int reorderQuantity) {
		this.reorderQuantity = reorderQuantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + reorderQuantity;
		result = prime * result + ((sku == null) ? 0 : sku.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (id != other.id)
			return false;
		if (reorderQuantity != other.reorderQuantity)
			return false;
		if (sku == null) {
			if (other.sku != null)
				return false;
		} else if (!sku.equals(other.sku))
			return false;
		return true;
	}

}