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

        String name;

        try{
            name = request.getParameter("name");
            if(name != ""){
                State state = new State();
                state.setName(name);
                StateDao.save(state);
                response.sendRedirect("/StatesList");
            }
            else{
                response.sendRedirect("/Error1");
            }
        }catch(NullPointerException e){
            response.sendRedirect("/Error1");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/view/addState.jsp").forward(request,response);
    }
}
