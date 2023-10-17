package bitlabs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class DaoImpl implements Dao {
	Connection connection;
	public DaoImpl() {
    	try {
    		
    	//register driver class
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	
    	//establish connection
    	
    	connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject","root","@Bhuvana9535");
    	    	System.out.println("connetion established successfully");
    	}
    	catch(Exception exception) {
    		System.out.println(exception);
    	}
	}
	
    public boolean loginAsAdmin(String username,String password) throws SQLException {
    	PreparedStatement s=connection.prepareStatement("select * from admin where username=? and password=? ");
       	s.setString(1, username);
       	s.setString(2, password);

    	ResultSet rs=s.executeQuery();
    	

       	if(rs.next()) { 
       		System.out.println("login Success");
       		return true;
       	}
       	else { 
       		System.out.println("Username or Password is Wrong");
		    return false;
       	}
   	
   	
    }
    	
    public boolean loginAsUser(String username,String password)throws SQLException {
    	PreparedStatement s=connection.prepareStatement("select * from user where username=? and password=? ");
       	s.setString(1, username);
       	s.setString(2, password);
    	ResultSet rs=s.executeQuery();
    	

       	if(rs.next()) {
       		System.out.println("login Success");
       		return true;
       	}
       	else {
       		System.out.println("user not found,please register as new user or enter valid details");
       		return false;
       	}
    }
    
    public void registerUser(User u) throws SQLException {
    	PreparedStatement pstmt=connection.prepareStatement("insert into user values(?,?,?,?,?,?)");
    	pstmt.setInt(1,u.getUserId());
    	pstmt.setString(2,u.getUserName());
    	pstmt.setString(3,u.getPassword());
    	pstmt.setString(4,u.getEmail());
    	pstmt.setString(5,u.getAddress());
    	pstmt.setLong(6,u.getPhno());
    	
    	int i=pstmt.executeUpdate();
    	if(i>0) {
    		System.out.println("Registered Succesfully");
    	}
    	else { 
    		System.out.println("Try Again");
    	}
    }
    
    public void viewUserAccounts() throws SQLException {
    Statement statement=connection.createStatement();
    ResultSet rs=statement.executeQuery("select * from user");
    while(rs.next()) {
    	System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getLong(6));
    }
    }
    public void deleteUserAccount(int id) throws SQLException {
    	PreparedStatement s=connection.prepareStatement("delete from user where userid="+id+"");
    	s.execute();
    }
    
    public void addNewProduct(Product p) throws SQLException {
    	PreparedStatement pstmt=connection.prepareStatement("insert into product values(?,?,?,?,?,?,?)");
    	pstmt.setInt(1,p.getPid());
    	pstmt.setString(2,p.getPname());
    	pstmt.setDouble(3,p.getPrice());
    	pstmt.setString(4,p.getCategory());
    	pstmt.setString(5,p.getBrand());
    	pstmt.setInt(6,p.getQuantity());
    	pstmt.setString(7,p.getDescripation());

    	int i=pstmt.executeUpdate();
    	if(i>0) {
    		System.out.println(i+" records affected");
    	}
    	else { 
    		System.out.println("Try Again");
    	}
    }
    public void updateProductDetails(String desripation) throws SQLException {
    	PreparedStatement pstmt=connection.prepareStatement("update product set descripation=?");
    	pstmt.setString(1, desripation);
    	int i=pstmt.executeUpdate();
    	if(i>0) {
    		System.out.println(i+" records affected");
    	}
    	else { 
    		System.out.println("Try Again");
    	}
    }
    public void deleteProduct(int pid) throws SQLException {
    	Statement stmt=connection.createStatement();
    	int i=stmt.executeUpdate("delete from product where productid="+pid+"");
    	if(i>0) {
    		System.out.println(i+" records affected");
    	}
    	else { 
    		System.out.println("Try Again");
    	}
    }
    public void viewAllProduct() throws SQLException {
    	Statement stmt=connection.createStatement();
    	ResultSet rs=stmt.executeQuery("select * from product");
    	
    	while(rs.next()) {
           	System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getInt(6)+" "+rs.getString(7));

    	}
    }
   public void viewAllOrders() throws SQLException {
	   Statement stmt=connection.createStatement();
   	ResultSet rs=stmt.executeQuery("select * from orders");
   	
   	while(rs.next()) {
    	System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getInt(5)+" "+rs.getInt(6));

   	}
   }
   public void viewOrderDetails(int oid) throws SQLException {
	   Statement stmt=connection.createStatement();
	   	ResultSet rs=stmt.executeQuery("select * from orders where orderid="+oid+"");
	   	
	   	while(rs.next()) {
	    	System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getInt(5)+" "+rs.getInt(6));

	   	}
   }
   public void updateOrderStatus(int oid,String status) throws SQLException {
	PreparedStatement pstmt=connection.prepareStatement("update orders set orderstatus=? where orderid="+oid+"");
   	pstmt.setString(1, status);
   	int i=pstmt.executeUpdate();
   	if(i>0) {
   		System.out.println(i+" records affected");
   	}
   	else { 
   		System.out.println("Try Again");
   	}
   }


public void searchForProducts(String category) throws SQLException {
	PreparedStatement pstmt=connection.prepareStatement("select * from product where category=?");
   	pstmt.setString(1, category);
   	ResultSet rs=pstmt.executeQuery();
	while(rs.next()) {
       	System.out.println(rs.getString(2));
	}
 }


public void viewProductDetails(String productname) throws SQLException {
	PreparedStatement pstmt=connection.prepareStatement("select * from product where productname=?");
   	pstmt.setString(1, productname);
   	ResultSet rs=pstmt.executeQuery();
	while(rs.next()) {
       	System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getInt(6)+" "+rs.getString(7));
	}
}

public void addProductToShoppingCart(ShoppingCart sc ) throws SQLException {
	PreparedStatement pstmt=connection.prepareStatement("insert into shoppingcart(userid,productid,quantity) values(?,?,?)");
	pstmt.setInt(1,sc.getUid());
	pstmt.setInt(2,sc.getPid());
	pstmt.setInt(3,sc.getQuantity());
	int i=pstmt.executeUpdate();
 	if(i>0) {
   		System.out.println(i+" records affected");
   	}
   	else { 
   		System.out.println("Try Again");
   	}
}

public void viewShoppingCart() throws SQLException {
	Statement stmt=connection.createStatement();
	ResultSet rs=stmt.executeQuery(" select sc.userid,username,productname,price,category,brand,sc.quantity,descripation from shoppingcart sc inner join product p on sc.productid=p.productid inner join user u on u.userid=sc.userid;");
	while(rs.next()) {
       	System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getInt(7)+" "+rs.getString(8));
	}
}

public void updateShoppingCart(int pid,int quantity) throws SQLException {
	Statement stmt=connection.createStatement();
	ResultSet rs=stmt.executeQuery("select quantity from product where productid="+pid+"");
	int a=0;
	if(rs.next()) {
		a=rs.getInt(1);	
	}
	
	if(a>=quantity) {
	int i=stmt.executeUpdate("update shoppingcart set quantity="+quantity+"");
	if(i>0) {
   		System.out.println(i+" records affected");
   	}
   	else { 
   		System.out.println("Try Again");
   	}
	}
	else
		System.out.println("quantity is greater then the availabile quantity");
	
}


public void placeOrder(Order od) throws SQLException {
	Statement st=connection.createStatement();
	ResultSet rs=st.executeQuery("select now()");
	String date=" ";
	if(rs.next()) {
	date=rs.getString(1);
	}
	PreparedStatement stmt=connection.prepareStatement("insert into orders(orderdate,orderstatus,address,productid,userid) values(?,?,?,?,?)");
	stmt.setString(1,date);
	stmt.setString(2,od.getOrderstatus());
	stmt.setString(3,od.getAddress());
	stmt.setInt(4,od.getPid());
	stmt.setInt(5,od.getUid());
	int i=stmt.executeUpdate();

	if(i>0) {
   		System.out.println(i+" records affected");
   	}
   	else { 
   		System.out.println("Try Again");
   	}
}

public void removeproductfromShoppingCart(int uid,int pid) throws SQLException {
	PreparedStatement s=connection.prepareStatement("delete from shoppingcart where userid="+uid+" and productid="+pid+"");
	s.execute();
}

public void updateUsername(String newusername,String oldusername,String password) throws SQLException {
	PreparedStatement pstmt=connection.prepareStatement("update user set username=? where username=? and password=?");
	pstmt.setString(1, newusername);
	pstmt.setString(2, oldusername);
	pstmt.setString(3, password);
	int i=pstmt.executeUpdate();
	if(i>0) {
   		System.out.println(i+" records affected");
   	}
   	else { 
   		System.out.println("Try Again");
   	}
}

public void updatePassword(String newpassword,String username, String password) throws SQLException {
	PreparedStatement pstmt=connection.prepareStatement("update user set password=? where username=? and password=?");
	pstmt.setString(1, newpassword);
	pstmt.setString(2, username);
	pstmt.setString(3, password);
	int i=pstmt.executeUpdate();
	if(i>0) {
   		System.out.println(i+" records affected");
   	}
   	else { 
   		System.out.println("Try Again");
   	}	
}

public void updateAddress(String newaddress,String username, String password) throws SQLException {
	PreparedStatement pstmt=connection.prepareStatement("update user set address=? where username=? and password=?");
	pstmt.setString(1, newaddress);
	pstmt.setString(2, username);
	pstmt.setString(3, password);
	int i=pstmt.executeUpdate();
	if(i>0) {
   		System.out.println(i+" records affected");
   	}
   	else { 
   		System.out.println("Try Again");
   	}	
}

public void updateEmail(String newemail,String username, String password) throws SQLException {
	PreparedStatement pstmt=connection.prepareStatement("update user set email=? where username=? and password=?");
	pstmt.setString(1, newemail);
	pstmt.setString(2, username);
	pstmt.setString(3, password);
	int i=pstmt.executeUpdate();
	if(i>0) {
   		System.out.println(i+" records affected");
   	}
   	else { 
   		System.out.println("Try Again");
   	}	
}

public void updatePhoneNo(long phno,String username, String password) throws SQLException {
	PreparedStatement pstmt=connection.prepareStatement("update user set phonenumber=? where username=? and password=?");
	pstmt.setLong(1, phno);
	pstmt.setString(2, username);
	pstmt.setString(3, password);
	int i=pstmt.executeUpdate();
	if(i>0) {
   		System.out.println(i+" records affected");
   	}
   	else { 
   		System.out.println("Try Again");
   	}	
}
}
