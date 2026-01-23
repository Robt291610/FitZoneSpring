package tp.fitzone.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.primefaces.PrimeFaces;
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
    @Autowired
    private PrimeFaces primefaces;

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

    //save a client to the database
    public void saveClient(){
        logger.info("Saving client " + this.selectedClient);
        if(this.selectedClient.getId() == null){
            this.clientService.saveClient(this.selectedClient);
            this.clients.add(this.selectedClient);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Client added"));
        }

        //Modify client
        else{
            this.clientService.saveClient(this.selectedClient);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Client updated"));
        }
        //Hide window
        PrimeFaces.current().executeScript("PF('clientModalWindow').hide()");
        //update table using ajax
        PrimeFaces.current().ajax().update("client-form:messages",
                "client-form:client-table");
        //reset selected client object
        this.selectedClient = null;
    }

    public void deleteClient(){
        logger.info("Deleting client " + this.selectedClient);
        this.clientService.deleteClient(this.selectedClient.getId());
        this.clients.remove(this.selectedClient);
        this.selectedClient = null;
        //message
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Client deleted"));

        PrimeFaces.current().ajax().update("form-clients:messages",
                "client-form:client-table");

    }

}
