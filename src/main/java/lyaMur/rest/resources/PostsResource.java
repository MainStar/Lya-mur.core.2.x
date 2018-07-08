package lyaMur.rest.resources;

import javax.imageio.ImageIO;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Path(value = "/create-post")
public class PostsResource {

    @POST
    public void createPost(InputStream io) throws IOException {
        BufferedImage img = ImageIO.read(io);
        ImageIO.write(img, "jpg", new File("resources/images/posts/1.jpg"));
    }
}
