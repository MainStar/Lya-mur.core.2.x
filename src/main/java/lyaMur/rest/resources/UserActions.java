package lyaMur.rest.resources;

import lyaMur.User;
import lyaMur.dao.services.DAOUserService;
import lyaMur.rest.restServices.UserRestService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

@Path(value = "/validation")
public class UserActions {

    private UserRestService userRestService = new UserRestService();
    private DAOUserService daoUserService = new DAOUserService();
    private User user;
    private String validation;

    @POST
    @Path(value = "/user")
    @Produces(MediaType.TEXT_PLAIN)
    public String checkAuthorization(InputStream io) throws IOException, SQLException {
        user = userRestService.readUser(io);
        validation = daoUserService.verifyUser(user.getName(), user.getPassword());
        System.out.println(validation);
        return validation;
    }

}
