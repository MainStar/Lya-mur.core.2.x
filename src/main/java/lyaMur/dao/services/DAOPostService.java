package lyaMur.dao.services;

import lyaMur.dao.daoConnector.DaoPosts;
import lyaMur.model.Post;

import java.sql.SQLException;
import java.util.List;

public class DAOPostService {

    private DaoPosts daoPosts = new DaoPosts();

    public void savePost(Post post) throws SQLException {
        daoPosts.connectToPosts();
        daoPosts.createTablePosts();
        daoPosts.createPost(post);
    }

    public List<Post> getLast50Posts(){
        try {
            daoPosts.connectToPosts();
            daoPosts.createTablePosts();
            return daoPosts.getLast50Posts();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
