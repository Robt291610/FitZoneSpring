package tp.fitzone.service;

import tp.fitzone.model.Client;

import java.util.List;

public interface IClientService {
    public List<Client> listClients();
    public Client getClientById(Integer id);
    public void saveClient(Client client);
    public void deleteClient(Integer id);
}
