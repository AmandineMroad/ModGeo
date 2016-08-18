/**
 * Modelisation Geometrique _ TP1
 * Objet Courbe
 * 
 * @author Amandine ROGER _ IRM 2016 _ Polytech Marseille
 * @see Algorithme
 */
package modelisation.dessin;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Courbe {
    protected final Color color;
    protected List<Point> points;
    
    public Courbe(Color color){
        this(color, new ArrayList<Point>());
    }
    
    public Courbe(Color color, List<Point> points){
        this.points = points;
        this.color = color;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public Color getColor() {
        return color;
    }
    
    public Point getPoint(int i){
        return points.get(i);
    }
}
