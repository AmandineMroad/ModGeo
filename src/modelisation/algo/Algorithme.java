/**
 * Modelisation Geometrique _ TP1
 * Interface d'algorithmes
 * 
 * @author Amandine ROGER _ IRM 2016 _ Polytech Marseille
 */
package modelisation.algo;


import modelisation.dessin.CourbeUser;
import modelisation.dessin.Courbe;

public abstract class Algorithme {
    
    protected static CourbeUser courbeUser =  CourbeUser.getInstance();
    protected Courbe courbe;
    /**
     * 
     * @return Les points de la courbe calculée selon l'algorithme
     */
    public abstract Courbe getCourbe();

}
