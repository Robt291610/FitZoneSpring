package tp.fitzone;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import tp.fitzone.gui.FitZoneForm;

import javax.swing.*;

@SpringBootApplication
public class FitZoneSwing {

    public static void main(String[] args) {
        //Instance spring fabric
        ConfigurableApplicationContext context =
                new SpringApplicationBuilder(FitZoneSwing.class)
                        .headless(false)
                        .web(WebApplicationType.NONE)
                        .run(args);
        //Swing object
        SwingUtilities.invokeLater(() -> {
            FitZoneForm fitZoneForm  = context.getBean(FitZoneForm.class);
            fitZoneForm.setVisible(true);
        });
    }
}
