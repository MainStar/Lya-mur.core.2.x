package lyaMur.servlets;

import lyaMur.dao.daoConnector.DaoPosts;
import lyaMur.model.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/getPost")
public class PostServlet extends HttpServlet {

    public PostServlet() {
        super();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String postId = req.getParameter("postId");
        Map<String,String> pageVeriables = new HashMap<>();
        List<Post> postList = DaoPosts.getPostByID(postId);
        resp.setContentType("text/html;charset=UTF-8;");
        req.setAttribute("post", postList);
        req.getRequestDispatcher("resources/pages/dashboard.html").forward(req, resp);
    }
}
