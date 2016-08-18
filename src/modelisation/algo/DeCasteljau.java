/**
 * Modelisation Geometrique _ TP1
 * Courbe de Bézier avec l'algorithme de DeCasteljau
 * 
 * @author Amandine ROGER _ IRM 2016 _ Polytech Marseille
 * @see Algorithme
 */
package modelisation.algo;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import static modelisation.Config.*;
import modelisation.dessin.Courbe;

public class DeCasteljau extends Algorithme {

    @Override
    public Courbe getCourbe() {
        
        List<Point> pts = new ArrayList<>();
        this.courbe = new Courbe(COL_BEZIER, pts);

        int abs_min = courbeUser.getAbs_min();
        int abs_max = courbeUser.getAbs_max();
        
        if (DEBUG) {
            System.out.println("Appel à courbeBezier()");
        }

        for (int t = abs_min, i = 0; t < abs_max; t++, i++) {
            Point p;
            p = calculPointBezier(t, abs_min, abs_max);
            pts.add(i, p);
        }
        List<Point> tmp = courbeUser.getPoints();
        pts.add(tmp.get(tmp.size() - 1));

        return courbe;
    }

    /**
     * Calcul de C(t)
     *
     * @param t
     * @param a abscisse min
     * @param b abscisse max
     * @return le point C(t);
     */
    public Point calculPointBezier(int t, int a, int b) {
        //paramétrage
        double u = ((double) t - (double) a);
        u = u / ((double) b - (double) a);
        double unMoinsU = 1 - u;

        Point p;
        int nbPoints = courbeUser.getNbPoints();

        ArrayList<Point> vect = new ArrayList<>(courbeUser.getPoints());
        int i, j;
        for (i = 1; i < nbPoints; i++) {
            for (j = 0; j < nbPoints - i; j++) {
                p = new Point();
                p.x = (int) (unMoinsU * vect.get(j).x + u * vect.get(j + 1).x);
                p.y = (int) (unMoinsU * vect.get(j).y + u * vect.get(j + 1).y);
                vect.set(j, p);
            }
            vect.remove(j);
        }

        p = vect.get(0);

        return p;

    }

}
