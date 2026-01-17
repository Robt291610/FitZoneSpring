package tp.fitzone.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tp.fitzone.service.ClientService;
import tp.fitzone.service.IClientService;

import javax.swing.*;

@Component
public class FitZoneForm extends JFrame{
    private JPanel mainPanel;
    IClientService clientService;

    @Autowired
    public FitZoneForm(ClientService clientService){
        this.clientService = clientService;
        initForm();
    }

    private void initForm(){
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,700);
        setLocationRelativeTo(null); //center view
    }
}
