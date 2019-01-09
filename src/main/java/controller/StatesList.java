package controller;

import dao.StateDao;
import model.State;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/StatesList")
public class StatesList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<State> states = StateDao.findAll();
        request.setAttribute("states", states);
        getServletContext().getRequestDispatcher("/WEB-INF/view/stateslist.jsp").forward(request,response);

    }
}
