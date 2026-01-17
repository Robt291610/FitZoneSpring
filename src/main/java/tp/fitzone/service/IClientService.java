package tp.fitzone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import tp.fitzone.model.Client;

import java.util.List;

@Repository
public interface IClientService {
    public List<Client> listClients();
    public Client getClientById(Integer id);
    public void saveClient(Client client);
    public void deleteClient(Integer id);
}
