package com.coffeeshop;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 4/2/17.
 */
@Path("coffees")
@Produces(MediaType.APPLICATION_JSON)
public class CoffeeResource {

    @Inject
    CoffeeRepository coffeeRepository;

    @GET
    public Response getCoffees() {

        List<Coffee> coffees = new ArrayList<>();

        try {
            coffees.addAll(coffeeRepository.retrieveCoffees());
        } catch (SQLException e) {
            return Response.serverError().build();
        }

        return Response.ok(coffees).build();
    }
}
