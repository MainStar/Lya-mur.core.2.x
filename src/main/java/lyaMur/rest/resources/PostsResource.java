package lyaMur.rest.resources;

import lyaMur.dao.services.DAOPostService;
import lyaMur.model.Post;
import lyaMur.rest.restServices.PostsRestServices;

import javax.servlet.ServletContext;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Path(value = "/post")
public class PostsResource {

    private PostsRestServices postsService = new PostsRestServices();
    private DAOPostService daoPostService = new DAOPostService();
    private String check;
    private List<Post> postList = new ArrayList<>();
    @Context
    ServletContext context;

    @POST
    @Path(value = "/new")
    @Produces(MediaType.APPLICATION_JSON)
    public Response.ResponseBuilder createPost(InputStream io) throws IOException, InterruptedException, SQLException {
        String dir = context.getRealPath("/");
        check = postsService.generatePost(io, dir);
        if (check != null){
            return Response.ok();
        }
        return Response.status(500);
    }

    @POST
    @Path(value = "/getPosts")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> getPostsForMainPage(){
        postList = daoPostService.getLast50Posts();
        return postList;
    }
}
