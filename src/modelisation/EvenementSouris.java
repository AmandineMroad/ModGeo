/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelisation;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import modelisation.dessin.CourbeUser;

/**
 *
 * @author amandine
 */
public class EvenementSouris extends MouseAdapter {

    CourbeUser courbeUser = CourbeUser.getInstance();

    @Override
    public void mouseClicked(MouseEvent e) {
        //clic gauche: on ajoute le point
        if (e.getButton() == MouseEvent.BUTTON1) {
            courbeUser.addNewPoint(e.getPoint());
        } //clic droit : on retire le dernier point
        else if (e.getButton() == MouseEvent.BUTTON3) {
            courbeUser.removeLastPoint();
        }
    }

}
