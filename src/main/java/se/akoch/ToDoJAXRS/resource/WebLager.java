package se.akoch.ToDoJAXRS.resource;

import org.springframework.stereotype.Component;
import se.akoch.ToDoJAXRS.model.User;
import se.akoch.ToDoJAXRS.service.ServiceLager;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.Status.*;
import static se.akoch.ToDoJAXRS.resource.parser.UserParser.fromTextString;
import static se.akoch.ToDoJAXRS.resource.parser.UserParser.toTextString;

@Component
@Path("users")
public class WebLager {
    private final ServiceLager serviceLager;

    public WebLager(ServiceLager serviceLager) {
        this.serviceLager = serviceLager;
    }

    @POST
    @Consumes("text/plain")
    public Response createUser(String text) {
        User user = serviceLager.createUser(fromTextString(text));
        return Response.status(CREATED).header("Location", "users/" + user.getId()).build();
    }

    @GET
    @Path("{id}")
    public Response getUser(@PathParam("id") Long id) {
        return serviceLager.getUser(id)
                .map(c -> Response.ok(toTextString(c)))
                .orElse(Response.status(NOT_FOUND))
                .build();
    }

    @GET
    public List<User> getAllUsers(@QueryParam("limit") @DefaultValue("5") int limit,
                                 @QueryParam("sort") @DefaultValue("asc") String sort) {
        return serviceLager.getAllUsers(limit, sort.equals("desc"));
    }

    @PUT
    @Path("{id}")
    public void updateUser(@PathParam("id") Long id,  User user) {
        // if (id == customer.getId()) ... else BAD_REQUEST
        serviceLager.updateUser(user);
    }

    @DELETE
    @Path("{id}")
    public Response deleteUser(@PathParam("id") Long id) {
        return serviceLager.deleteUser(id)
                .map(c -> Response.status(NO_CONTENT))
                .orElse(Response.status(NOT_FOUND))
                .build();
    }

}
