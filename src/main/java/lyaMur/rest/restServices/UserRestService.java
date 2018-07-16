package lyaMur.rest.restServices;

import lyaMur.User;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class UserRestService {

    private User user;

    public User readUser(InputStream io) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        user = objectMapper.readValue(io, User.class);
        System.out.println(user);
        return user;
    }
}
