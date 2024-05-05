package Health_products;

import java.util.Scanner;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
              Scanner sc=new Scanner(System.in);
              try {
            	  System.out.println("1.Admin page");
            	  System.out.println("2.Login page");
            	  
            	  System.out.println("enter the option");
            	  int opt=sc.nextInt();
            	
            	  Health_products hp=new Health_products();
            	 
            	  if(opt==1) {
            		  System.out.println("Admin page");
                	  System.out.println("enter the username");
                	  String username=sc.next();
                	  System.out.println("Enter a password");
                	  String password=sc.next();
            	  if(hp.admin(username, password)) {
            		  
            		  while(true) {
      
            			  
            			  System.out.println("----Welcome to Admin page----");
            			  System.out.println("1.Add new Health products");
            			  System.out.println("2.view Health products");
            			  System.out.println("3.Update Health products");
            			  System.out.println("4.Delete products");
            			  System.out.println("5.Logout");
            			  int op=sc.nextInt();
            			  
            			  if(op ==1) {
            				  System.out.println("Enter the products name");
            				  String name=sc.next();
            				  System.out.println("Enter the type");
            				  String type=sc.next();
            				  System.out.println("Enter the Quantity ");
            				  int quan =sc.nextInt();
            				  System.out.println("Enter the price ");
            				  int price=sc.nextInt();
            				  System.out.println("Enter the uses");
            				  String use =sc.next();
            				  if(hp.insert(name,type,quan,price,use)>0) {
            					  System.out.println("inserted");
            				  }}
            			  else if(op ==2) {
            				 hp.view(); 
            			  }else if(op==3) {
            				System.out.println("Enter the name");
            				String name=sc.next();
            				System.out.println("Enter the quantity");
            				int quan =sc.nextInt();
            				System.out.println("Enter the price");
            				int price =sc.nextInt();
            				if(hp.update( name , quan,price)>0) {
            					System.out.println("Updated successfully");
            				}else {
            					System.out.println("not updated");
            				}
            				
            			  }else if(op==4) {
            				  System.out.println("enter a serial no");
            				  int sno=sc.nextInt();
            				  if(hp.delete(sno)>0) {
            					  System.out.println("Deleted successfully");
            				  }
            			  }else if(op==5) {
            				  hp.cclose();
            				  System.out.println("Logout successfully");
            				  break;
            			  }else {
            				  System.out.println("Invalid username and password");
            				  hp.cclose();
            			  }}
            		  
            	  }
            	  }else if(opt==2) {
            		  System.out.println("Enter the username");
            		  String username=sc.next();
            		  System.out.println("Enter the password");
            		  String password=sc.next();
            		  System.out.println("--welcome to loginuser--");
            		  logindetails l=new logindetails();
            		  l.view();
            		  
            		  
            		  
            		  
            		  
            	  }
              }catch(ClassNotFoundException | SQLException e) {
            	  System.out.println(e);
              }

	}

}
