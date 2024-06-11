/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.bl;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.entities.Choice;

/**
 *
 * @author Student
 */
@Local
public interface ChoiceFacadeLocal {

    void create(Choice choice);

    void edit(Choice choice);

    void remove(Choice choice);

    Choice find(Object id);

    List<Choice> findAll();

    List<Choice> findRange(int[] range);

    int count();
    
    Character generateSign();
    
    String determineOutcome(char playSign, char computerSign);
    
}
