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

@Component
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
    private DefaultTableModel model; // handle table objects

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
    }

    private void initForm(){
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,500);
        setLocationRelativeTo(null); //center view
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        this.model = new DefaultTableModel(0, 4);
        String[] headers = new String[] {"ID","Name","LastName","Membership"};
        this.model.setColumnIdentifiers(headers);
        this.clientTable = new JTable(this.model);
        listClients();
    }

    /*
    * This will fill the fields on the table, but it can be used to refresh the table*/
    private void listClients(){
        this.model.setRowCount(0);
        var client = this.clientService.listClients();
        client.forEach(person -> {
            Object[] clientRow = {
                    person.getId(),
                    person.getName(),
                    person.getLastName(),
                    person.getMembership()
            };
            this.model.addRow(clientRow);
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
        var client = new Client();
        client.setName(name);
        client.setLastName(lastName);
        client.setMembership(membership);
        clientService.saveClient(client);
        clearForm();
        listClients();
    }

    private void loadClickedClient(){
        var row = clientTable.getSelectedRow();
        if(row != -1){
            var id = clientTable.getModel().getValueAt(row,0).toString();//Continue

        }
    }

    private void clearForm() {
        nameText.setText("");
        lastNameText.setText("");
        membershipText.setText("");
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}

