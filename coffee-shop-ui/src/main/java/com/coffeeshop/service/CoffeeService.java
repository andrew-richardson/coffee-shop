package com.coffeeshop.service;

import com.coffeeshop.bean.Coffee;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by andrew on 4/2/17.
 */
public class CoffeeService {
    private static final String CLASS_NAME = CoffeeService.class.getName();
    private static final Logger LOG = Logger.getLogger(CLASS_NAME);

    public List<Coffee> retrieveCoffees() {
        List<Coffee> coffees = new ArrayList<>();

        try {
            Client client = ClientBuilder.newClient();

            Response response = client.target("http://coffee-shop-service:8080/coffee-shop/v1/coffees")
                    .request()
                    .accept(MediaType.APPLICATION_JSON)
                    .get();

            if (response != null && response.getStatus() == 200) {
                coffees.addAll(response.readEntity(List.class));
            } else if (response != null) {
                LOG.logp(Level.SEVERE, CLASS_NAME, "retrieveCoffees", "Unable to retrieve coffees from service. Status = " + response.getStatus());
            } else {
                LOG.logp(Level.SEVERE, CLASS_NAME, "retrieveCoffees", "Unable to retrieve coffees from service.");
            }
        } catch (Exception e) {
            LOG.logp(Level.SEVERE, CLASS_NAME, "retrieveCoffees", "Unable to retrieve coffees from service.", e);
        }

        return coffees;
    }
}
