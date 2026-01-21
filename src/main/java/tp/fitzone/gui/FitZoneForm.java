package tp.fitzone.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tp.fitzone.model.Client;
import tp.fitzone.service.ClientService;
import tp.fitzone.service.IClientService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//@Component
public class FitZoneForm extends JFrame{
    private JPanel mainPanel;
    private JTable clientTable;
    private JTextField nameText;
    private JTextField lastNameText;
    private JTextField membershipText;
    private JButton saveButton;
    private JButton deleteButton;
    private JButton clearButton;
    IClientService clientService;
    private DefaultTableModel tableModel; // handle table objects
    private Integer idClient;

    @Autowired
    public FitZoneForm(ClientService clientService){
        this.clientService = clientService;
        initForm();
        saveButton.addActionListener(e -> saveClient());
        clientTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                loadClickedClient();
            }
        });
        deleteButton.addActionListener(e -> deleteClient());
        clearButton.addActionListener(e -> clearForm());
    }

    private void initForm(){
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,500);
        setLocationRelativeTo(null); //center view
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        //Allow row selection
        //this.model = new DefaultTableModel(0, 4);

        //Avoid modify cell values
        this.tableModel = new DefaultTableModel(0,4){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };


        String[] headers = new String[] {"ID","Name","LastName","Membership"};
        this.tableModel.setColumnIdentifiers(headers);
        this.clientTable = new JTable(this.tableModel);

        //Restrict select more than one client by using Ctrl
        this.clientTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        listClients();
    }

    /*
    * This will fill the fields on the table, but it can be used to refresh the table*/
    private void listClients(){
        this.tableModel.setRowCount(0);
        var client = this.clientService.listClients();
        client.forEach(person -> {
            Object[] clientRow = {
                    person.getId(),
                    person.getName(),
                    person.getLastName(),
                    person.getMembership()
            };
            this.tableModel.addRow(clientRow);
        });
    }

    private void saveClient() {
        /*This code makes ure the data is provided for that field
        * the same goes for the other one, Last name for this case can be null*/
        if(nameText.getText().equals("")){
            showMessage("provides the name");
            nameText.requestFocusInWindow();
            return;
        }
        if(membershipText.getText().equals("")){
            showMessage("provides the membership");
            membershipText.requestFocusInWindow();
            return;
        }

        //Get form values even if they are null
        var name =  nameText.getText();
        var lastName = membershipText.getText();
        var membership = Integer.parseInt(membershipText.getText());
        var client = new Client(this.idClient, name, lastName, membership);
        /*client.setId(idClient);
        client.setName(name);
        client.setLastName(lastName);
        client.setMembership(membership);*/
        clientService.saveClient(client);
        if(this.idClient == null)
            showMessage("The client was added");
        else
            showMessage("The client was updated");

        clearForm();
        listClients();
    }

    private void deleteClient() {
        //Your code
        /*if(this.idClient == null){
            showMessage("Select a client first");
        }
        else{
            clientService.deleteClient(this.idClient);
            showMessage("The client was removed");
        }
        clearForm();
        listClients();*/
        var row = clientTable.getSelectedRow();
        if(row != -1){
            var idClientStr = clientTable.getModel().getValueAt(row, 0).toString();
            this.idClient = Integer.parseInt(idClientStr);
            var client = new Client();
            client.setId(idClient);
            clientService.deleteClient(idClient);
            showMessage("The client with id:" + idClient+ " was removed");
            clearForm();
            listClients();
        }

    }

    private void loadClickedClient(){
        var row = clientTable.getSelectedRow();
        if(row != -1){
            var id = clientTable.getModel().getValueAt(row,0).toString();
            this.idClient = Integer.parseInt(id);
            var name = clientTable.getModel().getValueAt(row,1).toString();
            this.nameText.setText(name);
            var lastName = clientTable.getModel().getValueAt(row,2).toString();
            this.lastNameText.setText(lastName);
            var membership = clientTable.getModel().getValueAt(row,3).toString();
            this.membershipText.setText(membership);
        }
    }

    private void clearForm() {
        nameText.setText("");
        lastNameText.setText("");
        membershipText.setText("");
        this.idClient = null;
        //Unselect the row
        this.clientTable.getSelectionModel().clearSelection();
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}

