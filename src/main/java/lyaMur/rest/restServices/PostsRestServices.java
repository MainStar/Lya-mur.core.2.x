package lyaMur.rest.restServices;

import lyaMur.rest.Post;
import org.codehaus.jackson.map.ObjectMapper;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class PostsRestServices {

    private Post post;
    private String imageUrl = "resources/images/posts/";
    private String imageFormat = ".jpg";

    public Post generatePost(InputStream io) throws IOException, InterruptedException {
        System.out.println("Saving new post.");
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("OLOLO");
        post = objectMapper.readValue(io, Post.class);
        System.out.println(post);
        saveImage(post.getImage());
        System.out.println("OLOLOLOLO 3");
        return post;
    }

    private String saveImage(String io) throws IOException {
        String imageName = null;
        System.out.println("Saving image.");
        String[] parts = io.split(",");
        String imgString = parts[1];
        byte[] imgBytes;
        BufferedImage image = null;
        BASE64Decoder decoder = new BASE64Decoder();
        imgBytes = decoder.decodeBuffer(imgString);
        ByteArrayInputStream bis = new ByteArrayInputStream(imgBytes);
        image = ImageIO.read(bis);
        bis.close();
        File file = new File(imageUrl + "1" + imageFormat);
        ImageIO.write(image, "jpg", file);
        return imageName;
    }
}
