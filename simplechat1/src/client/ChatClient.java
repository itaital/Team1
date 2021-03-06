/* This file contains material supporting section 3.7 of the textbook: */
/* "Object Oriented Software Engineering" and is issued under the open-source */
/* license found at www.lloseng.com */

package client;
import java.io.IOException;
import common.ChatIF;
import entity.Message;
import ocsf.client.AbstractClient;

/**
 * This class overrides some of the methods defined in the abstract
 * superclass in order to give more functionality to the client.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;
 * @author Fran&ccedil;ois B&eacute;langer
 * @version July 2000
 */
public class ChatClient extends AbstractClient
{
  //Instance variables **********************************************
  
  /**
  * The interface type variable.  It allows the implementation of 
   * the display method in the client.
   */
  ChatIF clientUI; 

  
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the chat client.
   *
   * @param host - The server to connect to.
   * @param port - The port number to connect on.
   * @param clientUI - The interface type variable.
   */
  public ChatClient(String host, int port, ChatIF clientUI) 
    throws IOException 
  {
    super(host, port); 		/* Call the superclass constructor */
    this.clientUI = clientUI;
    openConnection();
  }

  
  //Instance methods ************************************************
    
  /**
   * This method handles all data that comes in from the server.
   * get option= string that define which msg it is
   * @param msg - The message from the server.
   */
  public void handleMessageFromServer(Object msg) 
  {
	  if(((Message)msg).getOption().compareTo("Add new account") ==0)
		  clientUI.addAccount(msg);
	  if(((Message)msg).getOption().compareTo("get all customers have FULLPRICE in this store") ==0)
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("get all products in DB") ==0)
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("Add User To Combo Box From DB") == 0)
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("get store ID of specific store worker") == 0)
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("get all order of specific store with status APPROVED") == 0)
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("UserStatus") ==0)
		  clientUI.sendUser(msg);
	  else if(((Message)msg).getOption().compareTo("Add new complaint") ==0)
		  clientUI.addComplaint(msg);	  
	  else if(((Message)msg).getOption().compareTo("get all the survey") ==0)
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("get all stores from DB") ==0)
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("Update customer account") ==0)
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("insert order to DB") ==0)
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("get all products in sale from DB") ==0)
		  clientUI.displayUI(msg);	
	  else if(((Message)msg).getOption().compareTo("Get all orders for this customer") ==0)
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("get all products in order") ==0)
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("Get all complaints numbers for this customer service worker") ==0)
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("Get complaint details") ==0)
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("Get order details") ==0)
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("Store manager want store number") ==0)
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("Get all orders numbers for this customer can cancel") ==0)
  			clientUI.displayUI(msg); 	  	  	  
	  else if(((Message)msg).getOption().compareTo("Store Manager - Take The Orders Of Specific Store") == 0) 		  
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("Store Manager - Take The Complaints Of Specific Store") == 0) 
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("Store Manager - Take the Revenue Of Specific Quarter Of Specific Store") == 0) 
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("Store Manager - Take The Date Of All the Report Of Specific Store") == 0) 
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("Store Manager - Take The Surveys Of Specific Store In Specific Quarter") == 0) 
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("Store Manager - Want To Store Number And Address Of The Store") == 0) 
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("Company Manager - Add Store To Combo Box From DB") == 0) 
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("Company Manager - Take The Orders Of Specific Store") == 0) 
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("Company Manager - Take The Complaints Of Specific Store") == 0) 
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("Company Manager - Take the Revenue Of Specific Quarter Of Specific Store") == 0) 
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("Comapny Manager - Take The Date Of All the Report Of Specific Store") == 0) 
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("Company Manager - Take The Surveys Of Specific Store In Specific Quarter") == 0) 
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("Company Manager - Compare Between Two Different Quarter") == 0) 
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("Customer - Want To Take His Order") == 0) 
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("Customer - Want To Take His Complaints") == 0) 
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("Customer - Want To Take His Account Details") == 0) 
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("Customer - Check If To The Customer There Have Account") == 0) 
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("succed!") == 0) 
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("Error your date not between start and end date of the survey") == 0) 
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("The storeId is not correct") == 0) 
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("customer twice") == 0) 
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("date between error") == 0) 
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("error store have survey") == 0) 
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("succes survey") == 0) 
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("get all the customerId") == 0)
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("get info survey") == 0)
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("add surveyConclusion") == 0)
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("Test - Give - Me The Size Of Order_Table") == 0)
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("Test - Bring Me The Order That I Add To Table - For Test") == 0)
		  clientUI.displayUI(msg);
	  else if(((Message)msg).getOption().compareTo("Test - Update - The Order Table , Product In Order Table , Account Table") == 0)
		  clientUI.displayUI(msg);
  }

  /**
   * This method handles all data coming from the UI            
   *
   * @param message - The message from the UI.    
   */
  public void handleMessageFromClientUI(Object message )  
  {
    try
    {
    	sendToServer(message);
    }
    catch(IOException e)
    {
      clientUI.display
        ("Could not send message to server.  Terminating client.");
      quit();
    }
  }
  
  /**
   * This method terminates the client.
   */
  public void quit()
  {
    try
    {
      closeConnection();
    }
    catch(IOException e) {}
    System.exit(0);
  }
}

