package bitlabs.jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class App 
{
	public void Shopping(){
    Scanner sc=new Scanner(System.in);
    DaoImpl dao=new DaoImpl();
    char ch = 0;
    do {
    System.out.println(" 1.Login As Admin \n 2.Login As User\n 3.Register as new User\n 4.Exit");
    int choice=0;
    try {
    System.out.println("Enter your choice");
    choice=sc.nextInt();
    }
    catch(Exception e) {
    	System.out.println(e);
    }
    switch(choice) {
    case 1:
    	System.out.println("enter admin username");
    	String id=sc.next();
    	sc.nextLine();
    	System.out.println("enter admin password");
    	String name=sc.nextLine();
    	boolean b=false;
    	try {
    	 b=dao.loginAsAdmin(id,name);
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
    	if(b) {
    		char ch2;
    		do {
    		System.out.println("-----Admin Functionlity-----");
    		System.out.println(" 1.View User Accounts\n 2.Delete User Account\n 3.Add a New Product \n 4.Update Product Details \n 5.Delete a Product \n 6.View All Product\n 7.View All Orders \n 8.View Order Details \n 9.Update Order Status \n");		
    		int choice1=0;
    		try {
    		System.out.println("enter your choice");
    		choice1=sc.nextInt();
    		}
    		catch(Exception e) {
    			System.out.println(e);
    		}
    		switch(choice1) {
    		case 1:
    			
    			try {
					dao.viewUserAccounts();
				}
    			catch (SQLException e) {
					e.printStackTrace();
				}
    			break;
    		case 2:
    			System.out.println("enter user id to delete user");
    			int userid=sc.nextInt();
    			try {
					dao.deleteUserAccount(userid);
				} catch (SQLException e) {
					e.printStackTrace();
				}
    			break;
    		case 3:
    			Product p=new Product();
    			System.out.println("enter product id");
    			int pid=sc.nextInt();
    			p.setPid(pid);
    			sc.nextLine();
    			System.out.println("enter product name");
    			String productname=sc.nextLine();
    			p.setPname(productname);
    			System.out.println("enter product price");
    			double price=sc.nextDouble();
    			p.setPrice(price);
    			sc.nextLine();
    			System.out.println("enter product category");
    			String category=sc.nextLine();
    			p.setCategory(category);
    			System.out.println("enter product brand");
    			String brand=sc.nextLine();
    			p.setBrand(brand);
    			System.out.println("enter product quantity");
    			int quantity=sc.nextInt();
    			p.setQuantity(quantity);
    			sc.nextLine();
    			System.out.println("enter product descripation");
    			String descripation=sc.nextLine();
    			p.setDescripation(descripation);
    			try {
					dao.addNewProduct(p);
				} catch (Exception e) {
					e.printStackTrace();
				}
    		 break;
    		case 4:
    			System.out.println("enter descripation to be updated");
    			sc.nextLine();
    			String descrip=sc.nextLine();
    			try {
					dao.updateProductDetails(descrip);
				} catch (SQLException e) {
					e.printStackTrace();
				}
    			break;
    		case 5:
    			System.out.println("enter product id to be delete");
    			int productid=sc.nextInt();
    			try {
					dao.deleteProduct(productid);
				} catch (SQLException e) {
					e.printStackTrace();
				}
    			break;
    			
    		case 6:
    			try {
					dao.viewAllProduct();
				} catch (SQLException e) {
					e.printStackTrace();
				}
    			break;
    		case 7:
    			try {
					dao.viewAllOrders();
				} catch (SQLException e) {
					e.printStackTrace();
				}
    			break;
    		case 8:
    			System.out.println("enter order id");
    			int oid1=sc.nextInt();
    			try {
					dao.viewOrderDetails(oid1);
				} catch (SQLException e) {
					e.printStackTrace();
				}
    			break;
    			
    		case 9:
    			System.out.println("enter order id");
    			int oid=sc.nextInt();
    			System.out.println("enter order status to be updated as");
    			sc.nextLine();
    			String status=sc.nextLine();
    			try {
					dao.updateOrderStatus(oid,status);
				} catch (SQLException e) {
					e.printStackTrace();
				}
    			break;
    			
    		}
			System.out.println("do you want to continue as admin y/n");
		    ch2=sc.next().charAt(0);
		
		    }while(ch2!='n');  	    	}
    	break;
    case 2:
    	System.out.println("enter username");
    	String username=sc.next();
    	sc.nextLine();
    	System.out.println("enter user password");
    	String password=sc.nextLine();
    	boolean b1=false;
    	try {
    	b1=dao.loginAsUser(username,password);
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
    	if(b1) {
    		char ch1;
    		do {
    		System.out.println("-----User Functionality-----");
    		System.out.println(" 1.Search for Products \n 2.View Product Details \n 3.Add Product to Shopping Cart \n 4.View Shopping Cart \n 5.Update Shopping Cart\n 6.Place Order \n ***User Profile Management***\n 7.Update Username\n 8.Update Password \n 9.Update Email\n 10.Update Address\n 11.Update phone no\n ");
    		 int choice2=0;
    		
    		    try {
    		    System.out.println("Enter your choice");
    		    choice2=sc.nextInt();
    		    }
    		    catch(Exception e) {
    		    	System.out.println(e);
    		    }
    		switch(choice2) {
    		case 1:
    			System.out.println("enter category  to search");
    			sc.nextLine();
    			String category=sc.nextLine();
    			try {
					dao.searchForProducts(category);
				} catch (SQLException e) {
					e.printStackTrace();
				}
    			break;
    		case 2:
    			System.out.println("enter product name  to search");
    			sc.nextLine();
    			String productname=sc.nextLine();
    			try {
					dao.viewProductDetails(productname);
				} catch (SQLException e) {
					e.printStackTrace();
				}
    			break;
    		case 3:
    			ShoppingCart sh=new ShoppingCart();
    			System.out.println("enter user id");
    			int uid=sc.nextInt();
    			sh.setUid(uid);
    			System.out.println("enter product id");
    			int pid=sc.nextInt();
    			sh.setPid(pid);
    			System.out.println("enter quantity");
    			int quantity=sc.nextInt();
    			sh.setQuantity(quantity);
    			try {
					dao.addProductToShoppingCart(sh);
				} catch (SQLException e) {
					e.printStackTrace();
				}
    			break;
    		case 4:
    			try {
					dao.viewShoppingCart();
				} catch (SQLException e) {
					e.printStackTrace();
				}
    			break;
    		case 5:
    			System.out.println("enter quantity value to be updated as");
    			int quntity=sc.nextInt();
    			System.out.println("enter product id");
    			int pid1=sc.nextInt();
    			try {
					dao.updateShoppingCart(pid1,quntity);
				} catch (SQLException e) {
					e.printStackTrace();
				}
    			break;
    		
    		case 6:
    			Order o=new Order();
    			sc.nextLine();
    			String status="pending";
    			o.setOrderstatus(status);
    			System.out.println("enter address");
    			String address=sc.nextLine();
    			o.setAddress(address);
    			System.out.println("enter product id");
    			int pid2=sc.nextInt();
    			o.setPid(pid2);
    			System.out.println("enter user id");
    			int uid1=sc.nextInt();
    			o.setUid(uid1);
    			try {
					dao.placeOrder(o);
				} catch (SQLException e) {
					e.printStackTrace();
				}
    		
    			break;
    		case 7:
    			sc.nextLine();
    			System.out.println("enter new Username");
    			String newusername=sc.nextLine();
    			System.out.println("enter old username");
    			String oldusername=sc.nextLine();
    			System.out.println("enter password");
    			String password1=sc.nextLine();
    			try {
					dao.updateUsername(newusername,oldusername,password1);
				} catch (SQLException e) {
					e.printStackTrace();
				}
    			break;
    		case 8:
    			sc.nextLine();
    			System.out.println("enter new password");
    			String newpassword=sc.nextLine();
    			System.out.println("enter username");
    			String username1=sc.nextLine();
    			System.out.println("enter password");
    			String password2=sc.nextLine();
    			try {
					dao.updatePassword(newpassword, username1, password2);
				} catch (SQLException e) {
					e.printStackTrace();
				}
    			break;
    			
    		case 9:
    			sc.nextLine();
    			System.out.println("enter new email");
    			String newemail=sc.nextLine();
    			System.out.println("enter username");
    			String username2=sc.nextLine();
    			System.out.println("enter password");
    			String password3=sc.nextLine();
    			try {
					dao.updateEmail(newemail, username2, password3);
				} catch (SQLException e) {
					e.printStackTrace();
				}
    			break;
    		case 10:
    			sc.nextLine();
    			System.out.println("enter new address");
    			String newaddress=sc.nextLine();
    			System.out.println("enter username");
    			String username3=sc.nextLine();
    			System.out.println("enter password");
    			String password4=sc.nextLine();
    			try {
					dao.updateAddress(newaddress, username3, password4);
				} catch (SQLException e) {
					e.printStackTrace();
				}
    			break;
    		case 11:
    			sc.nextLine();
    			System.out.println("enter new phone number");
    			long newphoneno=sc.nextLong();
    			System.out.println("enter username");
    			String username4=sc.nextLine();
    			System.out.println("enter password");
    			String password5=sc.nextLine();
    			try {
					dao.updatePhoneNo(newphoneno, username4, password5);
				} catch (SQLException e) {
					e.printStackTrace();
				}
    			break;
    		   }
    			System.out.println("do you want to continue as user y/n");
    		    ch1=sc.next().charAt(0);
    		
    		    }while(ch1!='n');  		
    	     }
    	    break;
    case 3:
    	User u=new User();
    	System.out.println("enter user id");
    	int id1=sc.nextInt();
    	u.setUserId(id1);
    	sc.nextLine();
    	System.out.println("enter username");
    	String username1=sc.nextLine();
    	u.setUserName(username1);
    	System.out.println("enter password");
    	String password1=sc.nextLine();
    	u.setPassword(password1);
    	System.out.println("enter email");
    	String email=sc.nextLine();
    	u.setEmail(email);
    	System.out.println("enter address");
    	String address=sc.nextLine();
    	u.setAddress(address);
    	System.out.println("enter phone number");
    	long phoneno=sc.nextLong();
    	u.setPhno(phoneno);
    	try {
    	dao.registerUser(u);
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
    	
    	break;
    	
    case 4:
    	System.exit(0);
    }
    System.out.println("do you want to continue y/n");
    ch=sc.next().charAt(0);
    }while(ch!='n');
	}
	
}
