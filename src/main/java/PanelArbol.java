import javax.swing.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class PanelArbol extends JPanel implements MouseListener {

    private Logger logger = LogManager.getRootLogger();
    Arbol rama = new Arbol();
    Arbol arbol = new Arbol();
    ArrayList<Point> listaRamas = new ArrayList<>();
    ArrayList<Point> listaArboles = new ArrayList<>();

    private int nmrRamas = 0;

    //private static final long serialVersionUID = 1L;
    // private Graphics g;

    private int w;
    private int h;

    private PropertyChangeSupport cambios;

    public PanelArbol(int Ancho, int Alto) {
        w = Ancho;
        this.addMouseListener(this);
        h = Alto;
    }

    public Dimension getPreferredSize() {
        return new Dimension(w, h);
    }

    /*public void addICambio(ICambio cambio){
        cambios.addPropertyChangeListener(cambio);
    }

    public void notificar(int valorAnteriorY, int valorY){
        cambios.firePropertyChange("Posicion",valorAnteriorY,valorY);
    }*/

    /**
     * Este metodo se encarga de dibujar los arboles
     *
     * @param g la que dibuja en el JPanel
     * @retun el paisaje y los arboles dependiendo de la distacia
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        dibujarCielo(g);
        dibujarTierra(g);

        for (Point at : this.listaRamas) {
            double posicionY = at.getY();

            if (at.getY() > 100 && at.getY() <= 300) {
                //rama.setDefaults();
                rama.setAncho(1.0);
                rama.setFactorLongitud(0.75);
                rama.setAngulo(Math.PI / 7.0);
                rama.dibujar(at.getX() + 0, at.getY() + 0, at.getX() + 0, at.getY() - 30, nmrRamas, 10, g);
                System.out.println("[Accion] secuencias en X: " + at.getX() + " en Y: " + at.getY());
            }
            if (at.getY() > 300 && at.getY() <= 500) {

                rama.setAncho(1.0);
                rama.setFactorLongitud(0.75);
                rama.setAngulo(Math.PI / 7.0);
                rama.dibujar(at.getX() + 0, at.getY() + 0, at.getX() + 0, at.getY() - 60, nmrRamas, 10, g);
                System.out.println("[Accion] secuencias en X: " + at.getX() + " en Y: " + at.getY());
            }
            if (at.getY() > 500 && at.getY() <= 700) {

                rama.setAncho(1.0);
                rama.setFactorLongitud(0.75);
                rama.setAngulo(Math.PI / 7.0);
                rama.dibujar(at.getX() + 0, at.getY() + 0, at.getX() + 0, at.getY() - 80, nmrRamas, 10, g);
                System.out.println("[Accion] secuencias en X: " + at.getX() + " en Y: " + at.getY());
            }
            if (at.getY() > 700 && at.getY() <= 900) {

                rama.setAncho(1.0);
                rama.setFactorLongitud(0.75);
                rama.setAngulo(Math.PI / 7.0);
                rama.dibujar(at.getX() + 0, at.getY() + 0, at.getX() + 0, at.getY() - 100, nmrRamas, 10, g);
                System.out.println("[Accion] secuencias en X: " + at.getX() + " en Y: " + at.getY());
                //this.notificar((int) posicionY, (int) at.getY());
            }

        }
        for (Point ta : this.listaArboles) {
            double posicionY = ta.getY();
            if (ta.getY() > 100 && ta.getY() <= 300) {
                //arbol.setDefaults();
                arbol.setAncho(3.0);
                arbol.setFactorLongitud(0.75);
                arbol.setAngulo(Math.PI / 7.0);
                arbol.dibujar(ta.getX() + 0, ta.getY() + 0, ta.getX() + 0, ta.getY() - 20, 8, 10, g);
                System.out.println("[Accion] Arbol en X: " + ta.getX() + " en Y: " + ta.getY());
            }
            if (ta.getY() > 300 && ta.getY() <= 500) {

                arbol.setAncho(3.0);
                arbol.setFactorLongitud(0.75);
                arbol.setAngulo(Math.PI / 7.0);
                arbol.dibujar(ta.getX() + 0, ta.getY() + 0, ta.getX() + 0, ta.getY() - 40, 8, 10, g);
                System.out.println("[Accion] Arbol en X: " + ta.getX() + " en Y: " + ta.getY());
            }
            if (ta.getY() > 500 && ta.getY() <= 700) {

                arbol.setAncho(3.0);
                arbol.setFactorLongitud(0.75);
                arbol.setAngulo(Math.PI / 7.0);
                arbol.dibujar(ta.getX() + 0, ta.getY() + 0, ta.getX() + 0, ta.getY() - 60, 8, 10, g);
                System.out.println("[Accion] Arbol en X: " + ta.getX() + " en Y: " + ta.getY());
            }
            if (ta.getY() > 700 && ta.getY() <= 900) {

                arbol.setAncho(3.0);
                arbol.setFactorLongitud(0.75);
                arbol.setAngulo(Math.PI / 7.0);
                arbol.dibujar(ta.getX() + 0, ta.getY() + 0, ta.getX() + 0, ta.getY() - 80, 8, 10, g);
                System.out.println("[Accion] Arbol en X: " + ta.getX() + " en Y: " + ta.getY());
            }
        }
    }


    public void dibujarTierra(Graphics g) {
        g.setColor(new Color(0, 255, 0));
        g.fillRect(0, 100, w, h - 100);
        logger.info("Dibuja la tierra");
    }

    public void dibujarCielo(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect(0, 0, w, 100);
        logger.info("Dibuja el cielo");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == 1) {
            nmrRamas = 0;
            try {
                nmrRamas = Integer.parseInt(JOptionPane.showInputDialog("Escriba el numero de se secuencias"));
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "debe ingresar un numero entero");
            }
            Point auxPoint = new Point(e.getX(), e.getY());
            this.listaRamas.add(auxPoint);
            this.repaint();
        }
        if (e.getButton() == 3) {
            Point auxPoint = new Point(e.getX(), e.getY());
            this.listaArboles.add(auxPoint);
            this.repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
