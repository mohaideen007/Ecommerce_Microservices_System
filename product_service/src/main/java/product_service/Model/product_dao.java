package product_service.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="product_details")
public class product_dao {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long product_id;


    private String productName;
    
    private int quantity;

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public String getproductName() {
		return productName;
	}

	public void setproductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "product_dao [product_id=" + product_id + ", productName=" + productName + ", quantity=" + quantity
				+ "]";
	}

	public product_dao(Long product_id, String productName, int quantity) {
		super();
		this.product_id = product_id;
		this.productName = productName;
		this.quantity = quantity;
	}

	public product_dao() {
		super();
		// TODO Auto-generated constructor stub
	}

	


    

}
