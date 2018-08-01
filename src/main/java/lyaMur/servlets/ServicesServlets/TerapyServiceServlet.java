package lyaMur.servlets.ServicesServlets;

import lyaMur.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TerapyServiceServlet extends HttpServlet {

    private Service service = new Service("Лаборатория", "resources/images/terapy.jpg",
            "Лаборатория", "Грамотный и индивидуальный подход к каждому животному " +
            "позволяет обнаружить симптомы заболивания у каждого животного.");
    private List<Service> data = new ArrayList<>();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        data.add(service);
        resp.setContentType("text/html;charset=UTF-8;");
        req.setAttribute("post", data);
        req.getRequestDispatcher("resources/pages/Services.html").forward(req, resp);
    }
}
