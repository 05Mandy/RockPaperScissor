/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.bl.ChoiceFacadeLocal;

/**
 *
 * @author Student
 */
public class RockPaperScissorServlet extends HttpServlet {

    @EJB
    ChoiceFacadeLocal cfl;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userChoice = request.getParameter("choice");
        Character choice = userChoice.charAt(0);

        char computerChoice = cfl.generateSign();

        //get outcome
        String outcome = cfl.determineOutcome(choice, computerChoice);
        
        request.setAttribute("outcome", outcome);
        request.setAttribute("playerChoice", choice);
        request.setAttribute("computerChoice", computerChoice);

        //foward data
        RequestDispatcher disp = request.getRequestDispatcher("choice_outcome.jsp");
        disp.forward(request, response);
    }
}
