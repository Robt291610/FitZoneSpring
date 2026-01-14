package tp.fitzone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tp.fitzone.service.IClientService;

import java.util.Scanner;

@SpringBootApplication
/*Command Line Runner will help to run the app as an console application*/
public class FitZoneApplication implements CommandLineRunner {
    @Autowired
    private IClientService clientService;

    //Line separator works fine on every operating system and can be used with logger
    String nl = System.lineSeparator();

    /*
    * This class will be used to send data or information to the console
    * so going to be used in tests.
    * for example, you can send a message to the console as below*/
    private static final Logger logger = LoggerFactory.getLogger(FitZoneApplication.class);

    public static void main(String[] args) {
        //Begin
        logger.info("Initializing application");

        //This represents your program
        SpringApplication.run(FitZoneApplication.class, args);

        //Finish
        logger.info("Finishing Application");
    }

    @Override
    public void run(String... args) throws Exception {
        fitZoneApp();
    }

    private void fitZoneApp() {

        //Variables
        var scanner = new Scanner(System.in);
        var exit = false;

        logger.info(nl + "***Fit Zone Application***" + nl);

        while (!exit) {
            var option = showMenu(scanner);
            exit = executeOptions(scanner, option);
            logger.info("");
        }


    }

    private boolean executeOptions(Scanner scanner, Object option) {
        return  false;
    }

    private Object showMenu(Scanner scanner) {
        logger.info("""
                Select an option:
                1. get all clients
                2. get client by id
                3. post client
                4. put client by id
                5. remove client by id
                6. exit
                Select an option:
                """);
        return Integer.parseInt(scanner.nextLine());
    }
}
