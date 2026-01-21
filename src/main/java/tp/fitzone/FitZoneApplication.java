package tp.fitzone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tp.fitzone.model.Client;
import tp.fitzone.service.IClientService;

import java.util.List;
import java.util.Scanner;

//@SpringBootApplication
/*Command Line Runner will help to run the app as a console application*/
public class FitZoneApplication implements CommandLineRunner {
//    @Autowired
//    private IClientService clientService;
//
//    //Line separator works fine on every operating system and can be used with logger
//    String nl = System.lineSeparator();
//
//    /*
//    * This class will be used to send data or information to the console
//    * so going to be used in tests.
//    * for example, you can send a message to the console as below*/
//    private static final Logger logger = LoggerFactory.getLogger(FitZoneApplication.class);
//
//    public static void main(String[] args) {
//        //Begin
//        logger.info("Initializing application");
//
//        //This represents your program
//        SpringApplication.run(FitZoneApplication.class, args);
//
//        //Finish
//        logger.info("Finishing Application");
//    }
//
    @Override
    public void run(String... args) throws Exception {
//        fitZoneApp();
    }
//
//    private void fitZoneApp() {
//
//        //Variables
//        var scanner = new Scanner(System.in);
//        var exit = false;
//
//        logger.info(nl + "***Fit Zone Application***" + nl);
//
//        while (!exit) {
//            var option = showMenu(scanner);
//            exit = executeOptions(scanner, option);
//            logger.info("");
//        }
//
//
//    }
//
//    private boolean executeOptions(Scanner scanner, int option) {
//        var exit = false;
//        switch (option) {
//            case 1 -> {
//                logger.info(nl + "***Client List***" + nl);
//                logger.info("Id");
//                List<Client> clients = clientService.listClients();
//                clients.forEach(client -> logger.info(nl + client + nl));
//
//            }
//            case 2 -> {
//                logger.info(nl + "***Get client by id***" + nl);
//                var idClient = Integer.parseInt(scanner.nextLine());
//                Client client  = clientService.getClientById(idClient);
//                if(client != null)
//                    logger.info(nl + "Found client" + client + nl);
//                else
//                    logger.info(nl + "Client not found" + nl);
//
//            }
//            case 3 -> {
//                logger.info(nl + "***Post client***" + nl);
//                logger.info("Name: ");
//                var name = scanner.nextLine();
//                logger.info("Lastname: ");
//                var lastName = scanner.nextLine();
//                logger.info("Membership: ");
//                var membership = Integer.parseInt(scanner.nextLine());
//                var client = new Client();
//                client.setName(name);
//                client.setLastName(lastName);
//                client.setMembership(membership);
//                clientService.saveClient(client);
//                logger.info(nl + "***Saved Client***" + nl);
//            }
//            case 4 -> {
//                logger.info(nl + "***Put client***" + nl);
//                logger.info("Client id: ");
//                var id = Integer.parseInt(scanner.nextLine());
//                Client client = clientService.getClientById(id);
//                if(client != null){
//                    logger.info("Name: ");
//                    var name = scanner.nextLine();
//                    logger.info("Lastname: ");
//                    var lastName = scanner.nextLine();
//                    logger.info("Membership: ");
//                    var membership = Integer.parseInt(scanner.nextLine());
//                    client.setName(name);
//                    client.setLastName(lastName);
//                    client.setMembership(membership);
//                    clientService.saveClient(client);
//                    logger.info(nl + "***Saved Client***" + nl + nl);
//                }
//                else {
//                    logger.info(nl + "***Client not found" + nl);
//                }
//
//            }
//            case 5 -> {
//                logger.info(nl + "***Delete client***" + nl);
//                logger.info("Client id: ");
//                var id = Integer.parseInt(scanner.nextLine());
//                Client client = clientService.getClientById(id);
//                if(client != null){
//                    clientService.deleteClient(id);
//                    logger.info("The client was deleted" + nl + nl);
//                }
//                else{
//                    logger.info(nl + "***Client not found" + nl);
//                }
//            }
//            case 6 -> {
//                logger.info(nl + "***Good bye" + nl + nl);
//                exit = true;
//            }
//            default -> {
//                logger.info(nl + "***Invalid option" + nl);
//            }
//
//        }
//        return false;
//    }
//
//    private int showMenu(Scanner scanner) {
//        logger.info("""
//                Select an option:
//                1. get all clients
//                2. get client by id
//                3. post client
//                4. put client by id
//                5. remove client by id
//                6. exit
//                Select an option:
//                """);
//        return Integer.parseInt(scanner.nextLine());
//    }
}
