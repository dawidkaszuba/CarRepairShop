package controller;


import dao.StateDao;
import model.State;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/EditState")
public class EditState extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        State state = new State();

        if(request.getParameter("id") != null){
            state.setId(Integer.parseInt(request.getParameter("id")));
        }else{
            response.getWriter().append("Brak id.Uzupełnij wszystkie pola");
        }
        if(request.getParameter("name") != null){
            state.setName(request.getParameter("name"));
        }else{
            response.getWriter().append("Brak name.Uzupełnij wszystkie pola");
        }

        StateDao.save(state);

        response.sendRedirect("/StatesList");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("id") != null){

                State state = StateDao.findById(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("state", state);
                getServletContext().getRequestDispatcher("/WEB-INF/view/editstate.jsp").forward(request,response);


        }else{
            response.getWriter().append("Brak danych");
        }

    }
}
