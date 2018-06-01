/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp.controller;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafxapp.JavaFXApp;
import javafxapp.model.BankAccount.BankAccount;
import javafxapp.model.BankUser.BankUser;
import javafxapp.model.Util.EnumHierarchy;
import org.controlsfx.dialog.Dialogs;

/**
 *
 * @author 11.02741-0
 */
public class FXMLCatalogoController implements Initializable {
    
    private final ObservableList<BankUser> clients = FXCollections.observableArrayList();
    private JavaFXApp app = new JavaFXApp();
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private TableView<BankUser> tableBankUser;
    
    @FXML
    private TableColumn<BankUser, String> columnName;
    
    @FXML
    private TableColumn<BankUser, String> columnCpf;
    
    @FXML
    private TableColumn<BankUser, String> columnAccountsNumber;
    
    @FXML
    private TableColumn<BankUser, String> columnHierarchy;
    
    
    @FXML
    private PasswordField passFieldPassword;

    @FXML
    private TextField txtFieldNome;

    @FXML
    private ComboBox<?> comboBoxHierarchy;

    @FXML
    private TextField txtFieldCpf;

    @FXML
    private Button btnNew;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnRemove;

    @FXML
    private Label labelTest;

    @FXML
    private Button btnCleanFields;

    @FXML
    private ComboBox<?> comboBoxAccountSelect;

    @FXML
    private TextArea txtAreaStatements;

    @FXML
    private PasswordField passFieldBalance;

    @FXML
    private TextField txtFieldTransferAccount;

    @FXML
    private TextField txtFieldTransferValue;

    @FXML
    private Button btnDoTranfer;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // ASSERTIONS
        assert tableBankUser != null : "fx:id=\"tableBankUser\" was not injected: check your FXML file 'FXMLCatalogo.fxml'.";
        assert columnName != null : "fx:id=\"columnName\" was not injected: check your FXML file 'FXMLCatalogo.fxml'.";
        assert columnCpf != null : "fx:id=\"columnCpf\" was not injected: check your FXML file 'FXMLCatalogo.fxml'.";
        assert columnAccountsNumber != null : "fx:id=\"columnAccountsNumber\" was not injected: check your FXML file 'FXMLCatalogo.fxml'.";
        assert columnHierarchy != null : "fx:id=\"columnHierarchy\" was not injected: check your FXML file 'FXMLCatalogo.fxml'.";
        assert passFieldPassword != null : "fx:id=\"passFieldPassword\" was not injected: check your FXML file 'FXMLCatalogo.fxml'.";
        assert txtFieldNome != null : "fx:id=\"txtFieldNome\" was not injected: check your FXML file 'FXMLCatalogo.fxml'.";
        assert comboBoxHierarchy != null : "fx:id=\"comboBoxHierarchy\" was not injected: check your FXML file 'FXMLCatalogo.fxml'.";
        assert txtFieldCpf != null : "fx:id=\"txtFieldCpf\" was not injected: check your FXML file 'FXMLCatalogo.fxml'.";
        assert btnNew != null : "fx:id=\"btnNew\" was not injected: check your FXML file 'FXMLCatalogo.fxml'.";
        assert btnEdit != null : "fx:id=\"btnEdit\" was not injected: check your FXML file 'FXMLCatalogo.fxml'.";
        assert btnRemove != null : "fx:id=\"btnRemove\" was not injected: check your FXML file 'FXMLCatalogo.fxml'.";
        assert labelTest != null : "fx:id=\"labelHierarchy\" was not injected: check your FXML file 'FXMLCatalogo.fxml'.";
        assert btnCleanFields != null : "fx:id=\"btnCleanFields\" was not injected: check your FXML file 'FXMLCatalogo.fxml'.";
        assert comboBoxAccountSelect != null : "fx:id=\"comboBoxAccountSelect\" was not injected: check your FXML file 'FXMLCatalogo.fxml'.";
        assert txtAreaStatements != null : "fx:id=\"txtAreaStatements\" was not injected: check your FXML file 'FXMLCatalogo.fxml'.";
        assert passFieldBalance != null : "fx:id=\"passFieldBalance\" was not injected: check your FXML file 'FXMLCatalogo.fxml'.";
        assert txtFieldTransferAccount != null : "fx:id=\"txtFieldTransferAccount\" was not injected: check your FXML file 'FXMLCatalogo.fxml'.";
        assert txtFieldTransferValue != null : "fx:id=\"txtFieldTransferValue\" was not injected: check your FXML file 'FXMLCatalogo.fxml'.";
        assert btnDoTranfer != null : "fx:id=\"btnDoTranfer\" was not injected: check your FXML file 'FXMLCatalogo.fxml'.";

        
        columnName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        columnCpf.setCellValueFactory(cellData -> cellData.getValue().cpfProperty());
        columnAccountsNumber.setCellValueFactory(cellData -> cellData.getValue().numberOfAccountsProperty());
        columnHierarchy.setCellValueFactory(cellData -> cellData.getValue().hierarchyProperty());
        tableBankUser.setItems(getItems());
        tableBankUser.setEditable(true);
        
        txtFieldNome.setText(tableBankUser.getColumns().get(0).getCellData(0).toString());
        txtFieldCpf.setText(tableBankUser.getColumns().get(1).getCellData(0).toString());
        labelTest.setText(tableBankUser.getColumns().get(3).getCellData(0).toString());
        
        tableBankUser.setRowFactory(tv -> {
            TableRow<BankUser> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                
                if (event.getClickCount() == 1 && (! row.isEmpty()) && MouseButton.PRIMARY.equals(event.getButton())) {
                    BankUser rowUser = row.getItem();
                    System.out.println("One click on: "+rowUser.getName());
                    System.out.println("/t"+rowUser.accountNumberProperty());
                    
                    txtFieldNome.setText(tableBankUser.getSelectionModel().getSelectedItem().getName());
                    txtFieldCpf.setText(tableBankUser.getSelectionModel().getSelectedItem().getCpf());
                    labelTest.setText(tableBankUser.getSelectionModel().getSelectedItem().getHierarchyAsString());
                }
                
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    BankUser rowUser = row.getItem();
                    System.out.println("Double click on: "+rowUser.getName());
                }
            });
            return row ;
        });
        
    }    
    
    public ObservableList<BankUser> getItems() {
        clients.add(new BankUser("Henrique 1", "123.456.789-01", 0, "password", new BankAccount("0001", 0, 0.0)));
        clients.add(new BankUser("Henrique 2", "123.456.789-02", 1, "password", "0002", 0, 1800.0));
        clients.add(new BankUser("Henrique 3", "123.456.789-03", 2, "password", "0003", 0, 10000.0));
        clients.add(new BankUser("Henrique 4", "123.456.789-04", 0, "password", "0004", 0, 1000.0));
        clients.add(new BankUser("Henrique 5", "123.456.789-05", 1, "password", "0005", 0, 100.0));
        clients.add(new BankUser("Henrique 6", "123.456.789-06", 2, "password", "0006", 0, 500000.0));
        clients.add(new BankUser("Henrique 7", "123.456.789-08", 0, "password", "0007", 0, 800.0));
        clients.add(new BankUser("Henrique 8", "123.456.789-08", 1, "password", "0008", 0, 8000.0));
        clients.add(new BankUser("Henrique 9", "123.456.789-09", 2, "password", "0009", 0, 900.0));
        clients.add(new BankUser("Henrique 10", "123.456.789-10", 0, "password", "0010", 0, 600.0));
        clients.add(new BankUser("Henrique 11", "123.456.789-11", 1, "password", "0011", 0, 2367.0));
        clients.add(new BankUser("Henrique 12", "123.456.789-12", 1, "password", "0012", 2, 2367.0));
        
//        clients.sort();
        
        return clients;
    }    
    
    
	/**
	 * Called when the user clicks on the delete button.
	 */
	@FXML
	private void handleDeletePerson() {
		int selectedIndex = tableBankUser.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			tableBankUser.getItems().remove(selectedIndex);
		} else {
			// Nothing selected.
			Dialogs.create()
		        .title("No Selection")
		        .masthead("No Person Selected")
		        .message("Please select a person in the table.")
		        .showWarning();
		}
	}
	
	/**
	 * Called when the user clicks the new button. Opens a dialog to edit
	 * details for a new person.
	 */
	@FXML
	private void handleNewPerson() {
            System.out.println("TO IMPLEMENT...");
//		BankUser tempUser = new BankUser();
//		boolean okClicked = mainApp.showPersonEditDialog(tempUser);
//		if (okClicked) {
//			mainApp.getPersonData().add(tempUser);
//		}
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit
	 * details for the selected person.
	 */
	@FXML
	private void handleEditPerson() {
		BankUser selectedUser = tableBankUser.getSelectionModel().getSelectedItem();
		if (selectedUser != null) {
			boolean okClicked = app.showPersonEditDialog(selectedUser);
			if (okClicked) {
				inflateDetails(selectedUser);
			}

		} else {
			// Nothing selected.
			Dialogs.create()
				.title("No Selection")
				.masthead("No Person Selected")
				.message("Please select a person in the table.")
				.showWarning();
		}
	}
        
        
	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit
	 * details for the selected person.
	 */
	@FXML
	private void handleCleanFields() {
            System.out.println("TO IMPLEMENT...");
	}
    
        private void inflateDetails(BankUser user) {
            
        }
}
