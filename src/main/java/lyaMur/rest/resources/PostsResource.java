package lyaMur.rest.resources;

import lyaMur.rest.Post;
import lyaMur.rest.restServices.PostsRestServices;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;

@Path(value = "/create-post")
public class PostsResource {

    private PostsRestServices postsService = new PostsRestServices();
    private Post post;

    @POST
    @Path(value = "/new")
    @Produces(MediaType.APPLICATION_JSON)
    public void createPost(InputStream io) throws IOException, InterruptedException {
        post = postsService.generatePost(io);
        System.out.println(post);
    }
}
