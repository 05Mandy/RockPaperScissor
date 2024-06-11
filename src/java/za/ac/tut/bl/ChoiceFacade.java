/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.bl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import za.ac.tut.entities.Choice;

/**
 *
 * @author Student
 */
@Stateless
public class ChoiceFacade extends AbstractFacade<Choice> implements ChoiceFacadeLocal {

    @PersistenceContext(unitName = "RockPaperScissorEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ChoiceFacade() {
        super(Choice.class);
    }

    @Override
    public Character generateSign() {

        char[] signs = {'R', 'P', 'S'};
        int index = (int) Math.floor(Math.random() * 3);

        return signs[index];
    }

    @Override
    public String determineOutcome(char playSign, char computerSign) {

        String outcome = "";

        if (playSign == 'R' && computerSign == 'P')
        {
            outcome = "Paper wraps rock. Computer wins";
        } 
        else if (playSign == 'R' && computerSign == 'S') 
        {
            outcome = "Rock crashes scissor. Player wins";
        }
        else if (playSign == 'P' && computerSign == 'R')
        {
            outcome = "Paper wraps rock. Player wins";
        }
        else if (playSign == 'P' && computerSign == 'S')
        {
            outcome = "Scissor cuts paper. Computer wins";
        }
        else if (playSign == 'S' && computerSign == 'P') 
        {
            outcome = "Scissor cuts paper. Player wins";
        }
        else if (playSign == 'S' && computerSign == 'R') 
        {
            outcome = "Rock crashes scisor. Computer wins";
        }else{
            outcome = "Tie";
        }

        return outcome;
    }

}
