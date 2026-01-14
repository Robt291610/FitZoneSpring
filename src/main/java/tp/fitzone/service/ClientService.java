package tp.fitzone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp.fitzone.model.Client;
import tp.fitzone.repository.IClientRepository;

import java.util.List;

@Service
public class ClientService implements IClientService {

    @Autowired
    private IClientRepository clientRepository;

    @Override
    public List<Client> listClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Integer id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void deleteClient(Integer id) {
        clientRepository.deleteById(id);
    }
}
