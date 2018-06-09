/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import javafx.scene.input.MouseEvent;
import javafxapp.JavaFXApp;
import javafxapp.model.BankAccount.BankAccount;
import javafxapp.model.BankUser.BankUser;
import javafxapp.model.Util.EnumAccountType;
import javafxapp.model.Util.EnumHierarchy;

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
    private ComboBox<String> comboBoxHierarchy;

    @FXML
    private ComboBox<String> comboBoxAccountSelect;

    @FXML
    private Button btnNew;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnCleanFields;
    
    @FXML
    private Button btnDoTransfer;

    @FXML
    private Button btnAddOrRemoveAccount;
    
    @FXML
    private Label labelInfo;
    
    @FXML
    private Label labelAccountNumber;

    @FXML
    private TextField txtFieldNome;

    @FXML
    private TextField txtFieldCpf;
    
    @FXML
    private TextField txtFieldBalance;

    @FXML
    private TextField txtFieldTransferAccount;

    @FXML
    private TextField txtFieldTransferValue;
    
    @FXML
    private TextArea txtAreaStatements;


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
        assert labelInfo != null : "fx:id=\"labelInfo\" was not injected: check your FXML file 'FXMLCatalogo.fxml'.";
        assert btnCleanFields != null : "fx:id=\"btnCleanFields\" was not injected: check your FXML file 'FXMLCatalogo.fxml'.";
        assert comboBoxAccountSelect != null : "fx:id=\"comboBoxAccountSelect\" was not injected: check your FXML file 'FXMLCatalogo.fxml'.";
        assert txtAreaStatements != null : "fx:id=\"txtAreaStatements\" was not injected: check your FXML file 'FXMLCatalogo.fxml'.";
        assert txtFieldTransferAccount != null : "fx:id=\"txtFieldTransferAccount\" was not injected: check your FXML file 'FXMLCatalogo.fxml'.";
        assert txtFieldTransferValue != null : "fx:id=\"txtFieldTransferValue\" was not injected: check your FXML file 'FXMLCatalogo.fxml'.";
        assert btnDoTransfer != null : "fx:id=\"btnDoTransfer\" was not injected: check your FXML file 'FXMLCatalogo.fxml'.";
        assert txtFieldBalance != null : "fx:id=\"txtFieldBalance\" was not injected: check your FXML file 'FXMLCatalogo.fxml'.";
        assert labelAccountNumber != null : "fx:id=\"lblAccountNumber\" was not injected: check your FXML file 'FXMLCatalogo.fxml'.";
        assert btnAddOrRemoveAccount != null : "fx:id=\"btnAddOrRemoveAccount\" was not injected: check your FXML file 'FXMLCatalogo.fxml'.";

        
        columnName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        columnCpf.setCellValueFactory(cellData -> cellData.getValue().cpfProperty());
        columnAccountsNumber.setCellValueFactory(cellData -> cellData.getValue().numberOfAccountsProperty());
        columnHierarchy.setCellValueFactory(cellData -> cellData.getValue().hierarchyProperty());
        tableBankUser.setItems(getItems());
        tableBankUser.setEditable(true);
        
        inflateDetailsInitial();
        
        tableBankUser.setRowFactory(tv -> {
            TableRow<BankUser> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                
                if (event.getClickCount() == 1 && (! row.isEmpty()) && 
                        MouseButton.PRIMARY.equals(event.getButton())) {
                    BankUser rowUser = row.getItem();
                    System.out.println("One click on: "+rowUser.getName());
                                        
                    this.inflateDetails(tableBankUser.getSelectionModel().getSelectedItem());
                }
                
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    BankUser rowUser = row.getItem();
                    System.out.println("Double click on: " + rowUser.getName());
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
    
    
    @FXML
    void handleAddOrRemoveAccount(MouseEvent event) {
        
        boolean hasAccount = false;
        BankUser user = tableBankUser.getSelectionModel().getSelectedItem();
        BankAccount account = new BankAccount();
        
        if(user != null) {
            for(BankAccount accountIterator : user.getAccountList()) {
                if(accountIterator.toString().equals(comboBoxAccountSelect.getValue())) {
                    hasAccount = true;
                    account = accountIterator;
                    break;
                }
            }

            if(hasAccount == true) {
                labelInfo.setText("Cliente já possui esse tipo de conta.");
                labelAccountNumber.setText(account.getAccountNumber());
            } else {
                account = new BankAccount(
                        this.createAccountNumber(),
                        comboBoxAccountSelect.getSelectionModel().getSelectedIndex(),
                        0.0);
                user.addAccount(account);
                clients.set(
                        tableBankUser.getSelectionModel().getSelectedIndex(),
                        user);
                labelAccountNumber.setText(account.getAccountNumber());
                labelInfo.setText("Conta criada com sucesso.");
            }
        } else {
            labelInfo.setText("ERRO: Nenhum Item Selecionado");
        }
    }
    
    
    @FXML
    void handleComboBoxAccountSelect(ActionEvent event) {
        BankUser user = tableBankUser.getSelectionModel().getSelectedItem();
        
        if(user != null) {
        
            for(BankAccount account : user.getAccountList()) {
                if(account.toString().equals(comboBoxAccountSelect.getValue())) {
                    labelAccountNumber.setText(account.getAccountNumber());
                    this.inflateStatements(user);
                } else {
                    labelAccountNumber.setText("");
                }
            }
        } else {
            labelInfo.setText("ERRO: Nenhum Item Selecionado");
        }
    }
    
    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeletePerson() {
        int selectedIndex = tableBankUser.getSelectionModel().getSelectedIndex();

        System.out.println("SELECTTED ITEM> " + selectedIndex);
        if(selectedIndex >= 0) {
            tableBankUser.getItems().remove(selectedIndex);
        } else {
            labelInfo.setText("ERRO: Nenhum Item Selecionado");
        }
    }


    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new person.
     */
    @FXML
    private void handleNewPerson() {
        Integer userHierarchy = 0, accountType = 0;
        Double balance = 0.00;
        String userName, userCpf, userPassword, accountNumber;
        
        accountNumber = this.createAccountNumber();
        userName = txtFieldNome.getText();
        userCpf = txtFieldCpf.getText();
        userPassword = passFieldPassword.getText();
        userHierarchy = comboBoxHierarchy.getSelectionModel().getSelectedIndex();
        accountType = Integer.valueOf(comboBoxAccountSelect.getSelectionModel().getSelectedIndex());

        clients.add(new BankUser(userName, userCpf, userHierarchy, userPassword, accountNumber, accountType, balance));
    }


    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected person.
     */
    @FXML
    private void handleEditPerson() {
        BankUser selectedUser = tableBankUser.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            clients.set(
                    tableBankUser.getSelectionModel().getSelectedIndex(),
                    selectedUser);
        } else {
            labelInfo.setText("ERRO: Nenhum Item Selecionado");
        }
    }


    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected person.
     */
    @FXML
    private void handleCleanFields() {
        txtFieldNome.clear();
        txtFieldCpf.clear();

        ObservableList<String> options = FXCollections.observableArrayList(
            EnumHierarchy.CLIENT.toString(),
            EnumHierarchy.EMPLOYEE.toString(),
            EnumHierarchy.MANAGER.toString()
        );
        comboBoxHierarchy.getItems().addAll(options);

        ObservableList<String> options2 = FXCollections.observableArrayList(
            EnumAccountType.CORRENTE.toString(),
            EnumAccountType.POUPANCA.toString(),
            EnumAccountType.DI.toString(),
            EnumAccountType.TESOURO.toString()
        );
        comboBoxAccountSelect.getItems().addAll(options2);

        txtFieldNome.clear();
        txtFieldCpf.clear();
        passFieldPassword.clear();
        txtAreaStatements.clear();
        txtFieldBalance.clear();
        txtFieldTransferAccount.clear();
        txtFieldTransferValue.clear();

        labelInfo.setText("Utilize 'Editar', 'Remover', 'Limpar Campos' e 'Novo' para editar a lista de clientes.");
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected person.
     */
    @FXML
    private void doTransfer() {
        String accountInputed = txtFieldTransferAccount.getText();
        Double valueInputed = Double.parseDouble(txtFieldTransferValue.getText()); //TODO: Validate
        int IndexCounter = 0;

        for(BankUser user : tableBankUser.getItems()) {
            for(BankAccount account : user.getAccountList()) { 
                if(account.getAccountNumber().equals(accountInputed)) {
                    user.deposit(accountInputed, valueInputed);
                    clients.set(IndexCounter, user);
                    break;
                }
            }
            IndexCounter++;
        }
    }


    private void inflateDetailsInitial() {
    
            ObservableList<String> options = FXCollections.observableArrayList(
                EnumHierarchy.CLIENT.toString(),
                EnumHierarchy.EMPLOYEE.toString(),
                EnumHierarchy.MANAGER.toString()
            );
            comboBoxHierarchy.getItems().addAll(options);

            ObservableList<String> options2 = FXCollections.observableArrayList(
                EnumAccountType.CORRENTE.toString(),
                EnumAccountType.POUPANCA.toString(),
                EnumAccountType.DI.toString(),
                EnumAccountType.TESOURO.toString()
            );
            comboBoxAccountSelect.getItems().addAll(options2);
        
        if(!tableBankUser.getItems().isEmpty()) {
            labelInfo.setText("Utilize os botões 'Editar', 'Remover', 'Limpar Campos' e 'Novo' \n para editar a lista de clientes.");

        } else {
            labelInfo.setText("Lista vazia.");
        }
    }


    private void inflateDetails(BankUser user) {

        txtFieldNome.setText(user.getName());
        txtFieldCpf.setText(user.getCpf());
        passFieldPassword.setText(user.getPassword());

        ObservableList<String> options = FXCollections.observableArrayList(
            user.getHierarchyAsString()
        );
        comboBoxHierarchy.setValue(options.get(0));

        ObservableList<String> options2 = FXCollections.observableArrayList(
            user.getAccountList().get(0).toString()
        );
        comboBoxAccountSelect.setValue(options2.get(0));
        labelAccountNumber.setText(user.getAccountList().get(0).getAccountNumber());

        this.inflateStatements(user);

        labelInfo.setText(user.getHierarchyAsString());
    }

    private void inflateStatements(BankUser user) {
        Double balance = 0.00;
        
        txtAreaStatements.clear();
        for(BankAccount account: user.getAccountList()) {
            if(account.toString().equals(comboBoxAccountSelect.getValue())) {
                for(Double statement : account.getExtract()) {
                    txtAreaStatements.appendText(statement.toString() + "\n");
                    balance += statement;
                }
            }
        }
        txtFieldBalance.setText(balance.toString());
    }

    private String createAccountNumber() {
        
        int numberMax = 0;
        String accountNumber;
        for(BankUser user : tableBankUser.getItems()) {
            for(BankAccount account : user.getAccountList()) {
                if(Integer.valueOf(account.getAccountNumber()) > numberMax) {
                    numberMax = Integer.valueOf(account.getAccountNumber());
                }
            }
        }
        accountNumber = String.format("%4s", String.valueOf(numberMax + 1));
        return accountNumber.replaceAll(" ", "0");
    }
}
