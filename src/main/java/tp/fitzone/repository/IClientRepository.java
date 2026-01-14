package tp.fitzone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.fitzone.model.Client;

import java.util.List;


public interface IClientRepository extends JpaRepository<Client,Integer> {
    List<Client> id(Integer id);
}
