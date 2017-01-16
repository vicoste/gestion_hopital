/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author vicoste
 */
public class AgentAccueil extends Personnel{
    
    public AgentAccueil(String nom, String prenom, String mdp) {
        super(nom, prenom, mdp);
    }

    @Override
    public boolean isMedecin() {
        return false;
    }


    
}
