package lyaMur.servlets;
import lyaMur.dao.daoConnector.DaoPosts;
import lyaMur.dao.daoConnector.DaoUser;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class MainServlet extends HttpServlet {

    private int i = 0;
    private DaoPosts daoPosts = new DaoPosts();
    private DaoUser daoUser = new DaoUser();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> pageVeriable = new HashMap<String, String>();
        pageVeriable.put("name", "Vladislav");
        /*resp.getWriter().println(PageGenerator.instance().getPage("index.html", pageVeriable));*/
        req.getRequestDispatcher("resources/pages/index.html").forward(req, resp);
    }
}
