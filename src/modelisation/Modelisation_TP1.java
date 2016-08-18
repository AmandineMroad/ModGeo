 /*
 * Modelisation Geometrique _ TP1
 * 
 * Amandine ROGER _ IRM 2016
 * Polytech Marseille
 */

package modelisation;

import javax.swing.JFrame;
import modelisation.dessin.Panneau;
import static modelisation.Config.*;

public class Modelisation_TP1 {
    
    public static Panneau panneau = new Panneau();
    
    public static void main(String[] args) {
        //Creation de la fenetre
        JFrame fenetre = new JFrame("Modélisation géométrique _ TP1");
        fenetre.setSize(DIM_PANNEAU, DIM_PANNEAU);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Attachement panneau / fenetre
        fenetre.setContentPane(panneau);

        // Gestion des evenement souris
        panneau.addMouseListener(new EvenementSouris());

        fenetre.setVisible(true);
        
    }
    
}
