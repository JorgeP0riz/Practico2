import java.awt.*;
import java.awt.geom.Line2D;
import java.beans.PropertyChangeEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Arbol implements ICambio {

    private Logger logger = LogManager.getRootLogger();

    private double factorLongitud;
    private double angulo;
    private double ancho;

    public static Color[] colors = {
            new Color(96, 48, 0),
            new Color(96, 48, 0),
            new Color(96, 48, 0),
            new Color(35, 86, 14),
            new Color(35, 86, 14),
            new Color(65, 157, 26)
    };

    public Arbol() {
        //this.setDefaults();

        //logger.info("Valor de angulo usado: " + angulo + " y la longitud del factor: " + factorLongitud);
    }

    public void dibujar(double x1, double y1, double x2, double y2, int n, int maxN, Graphics gc) {

        int idxColor = 0;

        idxColor = 5 - (maxN - n);
        if (idxColor < 0)
            idxColor = 0;

        int stroke = (int) (n * ancho);
        gc.setColor(colors[5 - idxColor]);
        Graphics2D g2 = (Graphics2D) gc;
        g2.setStroke(new BasicStroke(stroke));
        g2.draw(new Line2D.Float((int) x1, (int) y1, (int) x2, (int) y2));

        if (n <= 1)
            return;
/*
        logger.debug("Cálculo de puntos para (" + x1 + ", " + y1 + ") - (" + x2 + ", " + y2 + ")");

 */

        double h = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1)) * factorLongitud;
        double anguloLinea = 0.0;
        if (x2 - x1 == 0.0) {
            if (y2 <= y1)
                anguloLinea = Math.PI / 2;
            else
                anguloLinea = -1.0 * Math.PI / 2;
        } else {
            double tangent_y = y1 - y2;
            double tangent_x = x2 - x1;
            double tangent = tangent_y / tangent_x;
            anguloLinea = Math.atan(tangent);

            if (tangent_x < 0 && tangent_y >= 0)
                anguloLinea = Math.PI + anguloLinea;
            if (tangent_x < 0 && tangent_y < 0)
                anguloLinea = Math.PI + anguloLinea;

            /*logger.info("Tangente: " + tangent_y + " / " + tangent_x + " y angulo = " + Math.toDegrees(anguloLinea));

             */
        }

        double finalAngle = anguloLinea + angulo;
        double finalY = y2 - h * Math.sin(finalAngle);
        double finalX = x2 + h * Math.cos(finalAngle);

        logger.info("rama izquierda: (" + finalX + ", " + finalY + ")");

        dibujar(x2, y2, finalX, finalY, n - 1, maxN, gc);

        finalAngle = anguloLinea - angulo;
        finalY = y2 - h * Math.sin(finalAngle);
        finalX = x2 + h * Math.cos(finalAngle);

        logger.info("rama Derecha: (" + finalX + ", " + finalY + ")");

        dibujar(x2, y2, finalX, finalY, n - 1, maxN, gc);
    }

    public double getFactorLongitud() {
        return factorLongitud;
    }

    public void setFactorLongitud(double factorLongitud) {
        this.factorLongitud = factorLongitud;
    }

    public double getAngulo() {
        return angulo;
    }

    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public void setDefaults() {
        factorLongitud = 0.8;
        angulo = Math.PI / 8.0;
        ancho = 3.0;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
