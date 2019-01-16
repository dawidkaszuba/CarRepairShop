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

        String name;
        int id;

        try{
            name = request.getParameter("name");
            id = Integer.parseInt(request.getParameter("id"));
            if(!(name.equals("w naprawie"))) {
                if (name != "" && !(name.equals("w naprawie"))) {
                    State state = new State();
                    state.setId(id);
                    state.setName(name);
                    StateDao.save(state);
                    response.sendRedirect("/StatesList");
                } else {
                    response.sendRedirect("/Error1");
                }
            }else{
                response.sendRedirect("/Error2");
            }
        }catch(NullPointerException e){
            response.sendRedirect("/Error1");
        }

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
