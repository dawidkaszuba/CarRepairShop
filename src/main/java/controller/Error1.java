package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Error1")
public class Error1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf8");
        response.setContentType("text/html");

        response.getWriter().append("<html>\n" +
                "<head>\n" +
                "    <title>Brak danych w bazie</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Wypełnij wszystkie pola lub popraw dane</h1>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n");
    }
}
