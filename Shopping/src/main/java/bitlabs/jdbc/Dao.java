package bitlabs.jdbc;

import java.sql.SQLException;

public interface Dao {
public boolean loginAsAdmin(String username, String password) throws SQLException;
public void registerUser(User u)throws SQLException;
public boolean loginAsUser(String username,String password)throws SQLException;

// Admin Functionalities

public void viewUserAccounts()throws SQLException;
public void deleteUserAccount(int id)throws SQLException;
public void addNewProduct(Product p)throws SQLException;
public void updateProductDetails(String descrip)throws SQLException;
public void deleteProduct(int pid)throws SQLException;
public void viewAllProduct()throws SQLException;
public void viewAllOrders()throws SQLException;
public void viewOrderDetails(int oid)throws SQLException;
public void updateOrderStatus(int oid,String status)throws SQLException;

// User Functionalities 

public void searchForProducts(String category)throws SQLException;
public void viewProductDetails(String productname)throws SQLException;
public void addProductToShoppingCart(ShoppingCart sc)throws SQLException;
public void viewShoppingCart()throws SQLException;
public void removeproductfromShoppingCart(int uid,int pid)throws SQLException;
public void updateShoppingCart(int pid,int quantity)throws SQLException;
public void placeOrder(Order o)throws SQLException;
public void updateUsername(String newusername,String oldusername, String password)throws SQLException;
public void updatePassword(String newpassword,String username, String password)throws SQLException;
public void updateAddress(String newaddress,String username, String password)throws SQLException;
public void updateEmail(String Email,String username, String password)throws SQLException;
public void updatePhoneNo(long phno,String username, String password)throws SQLException;

}

