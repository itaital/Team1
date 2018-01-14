package controller;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;
import boundery.StoreManagerUI;
import boundery.UserUI;
import entity.Message;
import entity.Store;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StoreManagerReportController implements Initializable {

	private QuarterlyRevenueReportController quarterlyRevenueReportController;
	private OrderReportController orderReportController;
	private CustomerComplaintStatusReportController customerComplaintStatusReportController;
	private SatisfactionReportController satisfactionReportController;

	private Message msg;
	private static int itemIndex = 0; /* This Variable Need for the the Case - that we not choose any Store from the ComboBox , so we take the Store that in Index 0 By Default - Store 1 */
	private int temp_Store_Id;
	private Date temp_Date_Quarter_Report;
	
	ObservableList<String> storeList;
	ObservableList<Date> DateList;
	
/* -------------------------  For The First Window Of Report ----------------------------------- */	
	
	@FXML
	private ComboBox<String> cmbStores;  				    /* ComboBox With List Of Stores */
	
	@FXML
    private ComboBox<Date> cmbReports;
	
	@FXML
	private Button btnQuarterlyRevenueReport = null;        /* Button Of Quarterly Revenue Report */
	
	@FXML
	private Button btnOrderReport = null; 			 	    /* Button Of Order Report */

	@FXML
	private Button btnCustomerComplaintStatusReport = null; /* Button Of Customer Complaint Status Report */
	
	@FXML
	private Button btnSatisfactionReport = null;            /* Button Of Satisfaction Report */
	
	@FXML
	private Button btnClose = null;
	
/* --------------------------------  The Report About Quarterly Revenue ----------------------------------- */	
	
	public void QuarterlyRevenueReport(ActionEvent event) throws Exception        /* With this Method we Hide the GUI of the 'Report' and Show the GUI of the Quarterly Revenue Report that we Choose */
	{
		((Node)event.getSource()).getScene().getWindow().hide();    			  /* Hiding primary window */
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/controller/QuarterlyRevenueReportForm.fxml").openStream());
		
		QuarterlyRevenueReportController quarterlyRevenueReportController = loader.getController();
		quarterlyRevenueReportController.loadStore(StoreManagerUI.stores.get(getItemIndex())); 
		
		Scene scene = new Scene(root);			
		primaryStage.setScene(scene);		
		primaryStage.show();
	}
	
/* --------------------------------  The Report About Order ----------------------------------- */	
	
	public void OrderReport(ActionEvent event) throws Exception        /* With this Method we Hide the GUI of the 'Report' and Show the GUI of the Order Report that we Choose */
	{
		((Node)event.getSource()).getScene().getWindow().hide();       /* Hiding primary window */
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/controller/OrderReportForm.fxml").openStream());
		
		OrderReportController orderReportController = loader.getController();
		orderReportController.loadStore(StoreManagerUI.stores.get(getItemIndex()));
		
		Scene scene = new Scene(root);			
		primaryStage.setScene(scene);		
		primaryStage.show();
	}
	
/* --------------------------------  The Report About Complaint ----------------------------------- */
	
	public void CustomerComplaintStatusReport(ActionEvent event) throws Exception        /* With this Method we Hide the GUI of the 'Report' and Show the GUI of the Customer Complaint Status Report that we Choose */
	{
		((Node)event.getSource()).getScene().getWindow().hide();    					 /* Hiding primary window */
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/controller/CustomerComplaintStatusReportForm.fxml").openStream());
		
		CustomerComplaintStatusReportController customerComplaintStatusReportController = loader.getController();
		customerComplaintStatusReportController.loadStore(StoreManagerUI.stores.get(getItemIndex()));
		
		Scene scene = new Scene(root);			
		primaryStage.setScene(scene);		
		primaryStage.show();
	}
	
/* --------------------------------  The Report About Satisfaction ----------------------------------- */
	
	public void SatisfactionReport(ActionEvent event) throws Exception        /* With this Method we Hide the GUI of the 'Report' and Show the GUI of the Satisfaction Report that we Choose */
	{
		((Node)event.getSource()).getScene().getWindow().hide();    		  /* Hiding primary window */
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/controller/SatisfactionReportForm.fxml").openStream());
		
		SatisfactionReportController satisfactionReportController = loader.getController();
		satisfactionReportController.loadStore(StoreManagerUI.stores.get(getItemIndex()));
		
		Scene scene = new Scene(root);			
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
/* -------------------------- Taking Store From The Combo Box of Store ------------------------------------ */	
	
	public int getItemIndex()                                   	/* With this Method we Take User from the List of the Users at the ComboBox */
	{
		if(cmbStores.getSelectionModel().getSelectedIndex() == -1)
			return itemIndex;
	
		return cmbStores.getSelectionModel().getSelectedIndex();
	}
	
/* -------------------------- Taking Date From The Combo Box of Store ------------------------------------ */	
	
	public int getItemIndexFromDateComboBox()                                   	/* With this Method we Take User from the List of the Users at the ComboBox */
	{
		if(cmbReports.getSelectionModel().getSelectedIndex() == -1)
			return itemIndex;
	
		return cmbReports.getSelectionModel().getSelectedIndex();
	}
	
/* --------------------------------- Loading Store To the Text Fields ------------------------------------------------- */	
	
	public void loadStoreToRevenueReport(Store store) 					/* Loading Store */
	{
		this.quarterlyRevenueReportController.loadStore(store);
	}
	
	public void loadStoreToOrderReport(Store store) 					/* Loading Store */
	{
		this.orderReportController.loadStore(store);
	}
	
	public void loadStoreToSaticfactionReport(Store store) 				/* Loading Store */
	{
		this.satisfactionReportController.loadStore(store);
	}
	
	public void loadStoreToCustomerComplaintStatusReport(Store store) 	/* Loading Store */
	{
		this.customerComplaintStatusReportController.loadStore(store);
	}
	
/* --------------------------------- Close the Store Manager Report Window ------------------------------------------------- */	 	
	
	public void closeStoreManagerReportWindow(ActionEvent event) throws Exception   
	{ 
		StoreManagerUI.stores.clear();
		((Node)event.getSource()).getScene().getWindow().hide(); 	 /* Hiding primary window */
		Stage primaryStage = new Stage();						 	 /* Object present window with graphics elements */
		FXMLLoader loader = new FXMLLoader(); 					 	 /* Load object */
		Pane root = loader.load(getClass().getResource("/controller/StoreManagerOptions.fxml").openStream());
		
		Scene scene = new Scene(root);			
		primaryStage.setScene(scene);		
		primaryStage.show();										   /* show catalog frame window */
	}

/* ----------------------------------------- Set The Combo Box Of Stores ----------------------------------- */	
	
	public void setStoresComboBox()    								/* In this Method we Set the Stores at the ComboBox */
	{ 				
		ArrayList<String> temp_Stores_ID_And_Address_List = new ArrayList<String>();	
		
		for(Store s: StoreManagerUI.stores)
		{
			temp_Stores_ID_And_Address_List.add(String.valueOf(s.getStoreId()) + " ---> " + s.getStore_Address());
		}
		
		storeList = FXCollections.observableArrayList(temp_Stores_ID_And_Address_List);
		cmbStores.setItems(storeList);
	}

/* ----------------------------------------- Set The Combo Box Of All the Date Of the Report Of Specific Store ----------------------------------- */		
	
	public void set_Dates_Of_Report_At_ComboBox()      								/* In this Method we Set the Stores at the ComboBox */
	{ 				
		ArrayList<Date> Date_Of_Report = new ArrayList<Date>();	
		
		for(int i = 0 ; i < StoreManagerUI.Dates.size() ; i++)
		{
			Date_Of_Report.add(StoreManagerUI.Dates.get(i));
		}
		
		DateList = FXCollections.observableArrayList(Date_Of_Report);
		cmbReports.setItems(DateList);
	}	
	
/* -------------------------------- The Button Of The Store That You Choose ------------------------------- */		
	
	public void Click_On_Your_Store_Choise(ActionEvent event) throws Exception
	{
		temp_Store_Id = StoreManagerUI.stores.get(getItemIndex()).getStoreId();
		msg = new Message(temp_Store_Id, "Store Manager - Take The Date Of All the Report Of Specific Store");
		UserUI.myClient.accept(msg);
		while(StoreManagerUI.Dates.size() == 0);
		Thread.sleep(200);
		set_Dates_Of_Report_At_ComboBox();
	}
	
/* -------------------------------- The Button Of The Report That We Choose ------------------------------- */			
	
	public void Click_On_Your_Quarter_Report(ActionEvent event) throws Exception
	{
		
		/* ---------------------- For The Revenue Report ---------------------------*/
		temp_Date_Quarter_Report = StoreManagerUI.Dates.get(getItemIndexFromDateComboBox());
		ArrayList<Object> Store_Id_And_Date_Of_Report = new ArrayList<Object>();
		Store_Id_And_Date_Of_Report.add(temp_Store_Id);
		Store_Id_And_Date_Of_Report.add(temp_Date_Quarter_Report);
		msg = new Message(Store_Id_And_Date_Of_Report,"Store Manager - Take the Revenue Of Specific Quarter Of Specific Store");
		UserUI.myClient.accept(msg);
		while(StoreManagerUI.Total_Revenue_In_Specific_Quarter_And_Number_Of_Order_In_Specific_Quarter.size() == 0);
		Thread.sleep(200);
		StoreManagerUI.Help_To_Transfer_Object_At_Revenue_Report.clear();
		StoreManagerUI.Help_To_Transfer_Object_At_Revenue_Report.add(StoreManagerUI.Total_Revenue_In_Specific_Quarter_And_Number_Of_Order_In_Specific_Quarter.get(0));
		StoreManagerUI.Help_To_Transfer_Object_At_Revenue_Report.add(StoreManagerUI.Total_Revenue_In_Specific_Quarter_And_Number_Of_Order_In_Specific_Quarter.get(1));
		StoreManagerUI.Help_To_Transfer_Object_At_Revenue_Report.add(temp_Date_Quarter_Report);
		
		/* ----------------------- For The Order Report -----------------------------*/
		
		StoreManagerUI.Help_To_Transfer_Object_At_Order_Report.clear();
		StoreManagerUI.Help_To_Transfer_Object_At_Order_Report.add(Store_Id_And_Date_Of_Report.get(0));  /* The Store_Id */
		StoreManagerUI.Help_To_Transfer_Object_At_Order_Report.add(Store_Id_And_Date_Of_Report.get(1));  /* The Date Of the Report */
		
		/* ----------------------- For The Complaint Report -----------------------------*/
		
		StoreManagerUI.Help_To_Transfer_Object_At_Complaint_Report.clear();
		StoreManagerUI.Help_To_Transfer_Object_At_Complaint_Report.add(Store_Id_And_Date_Of_Report.get(0));  /* The Store_Id */
		StoreManagerUI.Help_To_Transfer_Object_At_Complaint_Report.add(Store_Id_And_Date_Of_Report.get(1));  /* The Date Of the Report */
		
		/* ----------------------- For The Satisfaction Report -----------------------------*/
		
		StoreManagerUI.Help_To_Transfer_Object_At_Satisfaction_Report.clear();
		StoreManagerUI.Help_To_Transfer_Object_At_Satisfaction_Report.add(Store_Id_And_Date_Of_Report.get(0));  /* The Store_Id */
		StoreManagerUI.Help_To_Transfer_Object_At_Satisfaction_Report.add(Store_Id_And_Date_Of_Report.get(1));  /* The Date Of the Report */
	}
	
/* -------------------------------- Initialized The ComboBox In the First Window - Report GUI ------------------------------- */	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		ArrayList<Store> stores = new ArrayList<Store>();           /* For the First Connection With The DB the ArrayList Of stores Is Empty */
		msg = new Message(stores, "Store Manager - Add Store To Combo Box From DB");
		UserUI.myClient.accept(msg);
		while(StoreManagerUI.stores.size() == 0);
		try 
		{
			Thread.sleep(200);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		setStoresComboBox();
		
/**		/* ----------------- Update All the Revenue Of All The Store At The DB ------------------*/
/**		
/**		for(int i = 0 ; i < StoreManagerUI.stores.size() ; i++)
/**		{
/**			stores.add(StoreManagerUI.stores.get(i));
/**		}
/**		
/**		msg = new Message(stores,"Store Manager - Update The Total Revenue Of All the Store");
/**		StoreManagerUI.myClient.accept(msg);	
/**	}  
**/	
	 }
/* ------------------------------------------------------------------------------------------------------------------- */
	
}