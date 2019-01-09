package controller;

import dao.StateDao;
import model.State;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddState")
public class AddState extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
        if(request.getParameter("name") != null);
            State state = new State();
            state.setName(request.getParameter("name"));
            StateDao.save(state);
        }catch(NumberFormatException e){
            response.getWriter().append("Brak nazwy statusu");
        }

        response.sendRedirect("/StatesList");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
