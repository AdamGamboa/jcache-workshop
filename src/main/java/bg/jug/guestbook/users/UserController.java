package bg.jug.guestbook.users;

import bg.jug.guestbook.cache.JCache;

import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.annotation.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * @author Ivan St. Ivanov
 */
@Controller
@Path("/user")
public class UserController {

    @Inject
    @JCache
    private UserManager userManager;

    @Inject
    private Models models;

    @GET
    public String getUserProfile(@QueryParam("userName") String userName) {
        models.put("user", userManager.findUserByName(userName));
        return "userProfile.jsp";
    }
}
