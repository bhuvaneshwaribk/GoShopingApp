package bitlabs.jdbc;

public class Order {

	private int orderId;
	private String orderDate;
	private String Orderstatus;
	private int uid;
	private int pid;
	private String address ;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderstatus() {
		return Orderstatus;
	}
	public void setOrderstatus(String orderstatus) {
		Orderstatus = orderstatus;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
