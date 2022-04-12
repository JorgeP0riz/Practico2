import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;

import java.awt.BorderLayout;


public class VentanaArbol extends JFrame {

    private static Logger logger = LogManager.getRootLogger();

    private PanelArbol panel;

    public static void main(String[] args) {
        new VentanaArbol();
    }

    public VentanaArbol() {
        Ventana();
    }

    public void Ventana() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        logger.info("Crea el panel 900x 800");
        panel = new PanelArbol(900, 800);

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel);

        this.setVisible(true);
        this.pack();
    }

}
