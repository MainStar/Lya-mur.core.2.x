package lyaMur.servlets.ServicesServlets;

import lyaMur.model.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TerapyServiceServlet extends HttpServlet {

    private static Service service = new Service("Лаборатория", "resources/images/terapy.jpg",
            "Лаборатория", "Грамотный и индивидуальный подход к каждому животному " +
            "позволяет обнаружить симптомы заболивания у каждого животного.");
    private static List<Service> data = new ArrayList<>();
    static {
        data.add(service);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8;");
        req.setAttribute("post", data);
        req.getRequestDispatcher("resources/pages/Service.html").forward(req, resp);
    }
}
