package tp.fitzone.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import tp.fitzone.model.Client;
import tp.fitzone.service.IClientService;
import java.util.List;
import org.slf4j.Logger;

@Component
@Data
@ViewScoped
public class IndexController {

    @Autowired
    IClientService clientService;
    private List<Client> clients;
    private Client selectedClient;
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    //After the class instance exec this
    @PostConstruct
    public void init(){
        loadData();
    }

    public void loadData(){
        this.clients = this.clientService.listClients();
        this.clients.forEach(client -> logger.info(client.toString()));
    }

    public void addClient(){
        this.selectedClient = new Client();
    }
}
