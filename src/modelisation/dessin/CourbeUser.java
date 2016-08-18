/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelisation.dessin;

import java.awt.Color;
import java.awt.Point;

import static modelisation.Config.*;
import static modelisation.Modelisation_TP1.panneau;

/**
 *
 * @author amandine
 */
public class CourbeUser extends Courbe {

    private static final CourbeUser INSTANCE = new CourbeUser(Color.black);
    private int abs_max;
    private int abs_min;
    private boolean modif;

    public static CourbeUser getInstance() {
        return INSTANCE;
    }

    private CourbeUser(Color color) {
        super(color);
        abs_max = 0;
        abs_min = DIM_PANNEAU;
    }

    public void majXextremum() {
        for (Point pt : points) {
            int x = pt.x;
            if (x > abs_max) {
                abs_max = x;
            } else if (x < abs_min) {
                abs_min = x;
            }
        }
    }

    public void addNewPoint(Point p) {
        points.add(p);
        modif = true;
        if (DEBUG) {
            System.out.println("ajout point (" + p.x + "," + p.y + ") : OK");
        }
        panneau.repaint();
        majXextremum();
    }

    public void addNewPoint(int x, int y) {
        addNewPoint(new Point(x, y));
    }

    public void removeLastPoint() {
        int nbPoints = points.size();

        if (nbPoints > 0) {
            Point p = points.remove(points.size() - 1);
            modif = true;
            if (DEBUG) {
                System.out.println("suppression dernier point : OK");
            }
            panneau.repaint();
            if ((p.x == abs_max) || (p.x == abs_min)) {
                majXextremum();
            }
        }
    }

    /*      Getters/Setters     */
    public int getAbs_max() {
        return abs_max;
    }

    public int getAbs_min() {
        return abs_min;
    }

    public boolean isModif() {
        return modif;
    }

    public void setModif(boolean modif) {
        this.modif = modif;
    }
    
    public int getNbPoints(){
        return points.size();
    }

}
