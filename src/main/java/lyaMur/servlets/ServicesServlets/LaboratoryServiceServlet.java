package lyaMur.servlets.ServicesServlets;

import lyaMur.Post;
import lyaMur.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LaboratoryServiceServlet extends HttpServlet {

    private Post post = new Post("Лаборатория", "Лаборатория", "Одним из найболее эфективных этапов " +
            "\tобследования Вашего питомца является лабораторные иследования, что позволяет " +
            "максимально точно и быстро поставить диагноз.");
    private List<Post> data = new ArrayList<>();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        data.add(post);
        resp.setContentType("text/html;charset=UTF-8;");
        req.setAttribute("post", data);
        req.getRequestDispatcher("resources/pages/Services.html").forward(req, resp);
    }
}
