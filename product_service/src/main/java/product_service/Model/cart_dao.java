package product_service.Model;



public class cart_dao {
	
	
	
private Long id;
	
	private int userid;
	private String itemname;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	@Override
	public String toString() {
		return "cart_dao [id=" + id + ", userid=" + userid + ", itemname=" + itemname + "]";
	}
	public cart_dao(Long id, int userid, String itemname) {
		super();
		this.id = id;
		this.userid = userid;
		this.itemname = itemname;
	}
	public cart_dao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
