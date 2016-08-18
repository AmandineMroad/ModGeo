/*
 * Modelisation Geometrique _ TP1
 * Panneau de dessin des courbes
 * 
 * Amandine ROGER _ IRM 2016
 */
package modelisation.dessin;

import static modelisation.Config.*;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JPanel;
import modelisation.algo.Algorithme;
import modelisation.algo.DeCasteljau;

public class Panneau extends JPanel {

    private static final Logger LOGGER = Logger.getLogger("Panneau : ");
    private final CourbeUser courbeUser = CourbeUser.getInstance();
    
    private List<Algorithme> algos ;

    public Panneau() {
        this.algos = new ArrayList<>(NB_ALGO);
        algos.add(new DeCasteljau());
    }
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        LOGGER.info("Appel à paintComponent !");

        if (courbeUser.isModif()) {
            
            Courbe bezier, bspline = null; //FIXME
            Point tmp = null;
            List<Point> points = courbeUser.getPoints();
            
            for (Point p : points) {
                g.setColor(COL_POINT);
                g.drawRect(p.x - 1, p.y - 1, 3, 3);

                g.setColor(COL_USER);
                if (tmp != null) {
                    g.drawLine(tmp.x, tmp.y, p.x, p.y);
                }
                tmp = p;
            }
            if (points.size() > 3) {
                Courbe courbe;
                for (Algorithme algo : algos){
                    courbe = algo.getCourbe();
                    g.setColor(courbe.getColor());
                    Point pt_a = courbe.getPoint(0), pt_b;
                    for (Point point : courbe.getPoints()){
                        g.drawLine(pt_a.x, pt_a.y, point.x, point.y);
                        pt_a = point;
                    }
                }
            }
            courbeUser.setModif(false);
        }

    }
    
}
