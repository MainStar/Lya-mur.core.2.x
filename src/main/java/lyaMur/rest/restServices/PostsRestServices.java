package lyaMur.rest.restServices;

import lyaMur.dao.daoConnector.DaoPosts;
import lyaMur.dao.services.DAOPostService;
import lyaMur.model.Post;
import org.codehaus.jackson.map.ObjectMapper;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

public class PostsRestServices {

    private Post post;
    private String imageUrl;
    private String imageFormat = ".jpg";
    private int imageNumber = 0;
    private DAOPostService daoPostService = new DAOPostService();

    public String generatePost(InputStream io, String path) throws IOException, InterruptedException, SQLException {
        System.out.println("Saving new post.");
        ObjectMapper objectMapper = new ObjectMapper();
        post = objectMapper.readValue(io, Post.class);
        String imagePath = saveImage(post.getImage(), path);
        if (imagePath != null){
            Post postDao = new Post();
            postDao.setSummary(post.getSummary());
            postDao.setMainPageText(post.getMainPageText());
            postDao.setTextPost(post.getTextPost());
            postDao.setImage("resources/postImages/" + imageNumber + ".jpg");

            daoPostService.savePost(postDao);
            imageNumber++;
            postDao.setImage(imagePath);

            daoPostService.savePost(postDao);
            return "OK";
        }else {
            return null;
        }
    }

    private String saveImage(String io, String path) throws IOException {
        System.out.println("Saving image.");
        imageUrl = path + String.format("/resources/postImages/%s.jpg", imageNumber);
        imageUrl = path + "/WEB-INF/" + imageNumber + imageFormat;
        System.out.println("New image URL: " + path);
        String[] parts = io.split(",");
        String imgString = parts[1];
        byte[] imgBytes;
        BufferedImage image = null;
        BASE64Decoder decoder = new BASE64Decoder();
        imgBytes = decoder.decodeBuffer(imgString);
        ByteArrayInputStream bis = new ByteArrayInputStream(imgBytes);
        image = ImageIO.read(bis);
        bis.close();
        File file = new File(imageUrl);
        file.createNewFile();
        ImageIO.write(image, "jpg", file);
        if (file.exists()){
            return imageUrl;
        }
        return null;
    }
}
