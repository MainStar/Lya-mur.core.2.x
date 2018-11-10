package lyaMur.dao.daoConnector;

import lyaMur.model.Post;
import lyaMur.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoPosts {

    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;

    private static List<Post> postList = new ArrayList<>();

    public static void connectToPosts() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://tt62008f7lbsry1x:kueqt32c8snffxff@lt80glfe2gj8p5n2.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/hytxwnavkj1qz6g4");
        System.out.println("Connection to Table 'Posts' is OK");
    }

    public static void createTablePosts(){
        try {
            statement = connection.createStatement();
            System.out.println("Table Posts is created!");
        } catch (SQLException e) {
            System.out.println("Error with creating table Posts");
        }
    }

    public static void createPost(Post post) throws SQLException {
        statement.executeUpdate("INSERT INTO posts (summary, mainPageText, textPost, imagePath) VALUES('" + post.getSummary() + "', '" + post.getMainPageText() + "', '" + post.getTextPost() + "', '"
        + post.getImage() + "');");
        System.out.println("New post was created!");
    }

    public static List<Post> getPostByID(String id) {
        postList.clear();
        try {
            resultSet = statement.executeQuery("SELECT * FROM posts WHERE id=" + id);
            System.out.println("Getting post by ID = " + id);
            while (resultSet.next()){
                Post post = new Post();
                post.setId(resultSet.getString("id"));
                post.setSummary(resultSet.getString("summary"));
                post.setMainPageText(resultSet.getString("mainPageText"));
                post.setTextPost(resultSet.getString("textPost"));
                post.setImage(resultSet.getString("imagePath"));
                postList.add(post);
                System.out.println(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postList;
    }

    public static List<Post> getLast50Posts() throws SQLException {
        postList.clear();
        resultSet = statement.executeQuery("SELECT * FROM " + "posts LIMIT 50");
        System.out.println("Getting last 50 posts for main page");
        while (resultSet.next()){
            Post post = new Post();
            post.setId(resultSet.getString("id"));
            post.setSummary(resultSet.getString("summary"));
            post.setMainPageText(resultSet.getString("mainPageText"));
            post.setTextPost(resultSet.getString("textPost"));
            post.setImage(resultSet.getString("imagePath"));
            postList.add(post);
            System.out.println(post);
        }
        return postList;
    }
}
