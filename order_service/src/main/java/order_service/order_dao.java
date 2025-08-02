package order_service;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class order_dao {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private int userId;

	private String itemname;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public order_dao(int userId, String itemname) {
        this.userId = userId;
        this.itemname = itemname;
    }

    @Override
    public String toString() {
        return "order_dao [userId=" + userId + ", itemname=" + itemname + "]";
    }

    public order_dao() {
        super();
        // 

}
}
