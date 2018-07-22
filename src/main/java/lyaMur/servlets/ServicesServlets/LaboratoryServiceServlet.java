package lyaMur.servlets.ServicesServlets;

import lyaMur.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class LaboratoryServiceServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Object> pageVeriable = new HashMap<>();
        pageVeriable.put("serviceTopick", "Лаборатория");
        pageVeriable.put("serviceInfo", "Одним из найболее эфективных этапов " +
                "\tобследования Вашего питомца является лабораторные иследования, что позволяет " +
                "максимально точно и быстро поставить диагноз.");
        resp.getWriter().println(PageGenerator.instance().getPage("Services.html", pageVeriable));
    }
}
