/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import Models.*;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Marco
 */
@Path("users")
public class UsersResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UsersResource
     */
    public UsersResource() {
    }

    /**
     * Retrieves representation of an instance of webservice.UsersResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        return "PetsFriend";
    }

   @GET
   @Produces(MediaType.APPLICATION_JSON)
   @Path("/list/{dni}")
    public String listUsers(@PathParam("dni") String dni) {
        User  users = new User();
        User user = new User();
        user.setDni(dni);
        UserEntity userEntity = new UserEntity();
        users = userEntity.getUserListByDNI(user);
     
        Gson gson = new  Gson();
       
        return gson.toJson(users);
    }
    
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   @Path("/login/{name}/{password}")
    public String loginUsers(@PathParam("name") String name, @PathParam("password") String password) {
        User  users = new User();
        User user = new User();
        user.setUser_name(name);
        user.setPassword(password);
        
        UserEntity userEntity = new UserEntity();
        users = userEntity.getUserLogin(user);
     
        Gson gson = new  Gson();
       
        return gson.toJson(users);
    }  
    
    
    /**
     * PUT method for updating or creating an instance of UsersResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
