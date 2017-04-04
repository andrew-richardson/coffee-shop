package com.coffeeshop;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by andrew on 4/2/17.
 */
public class CoffeeRepository {

    private static final String CLASS_NAME = CoffeeRepository.class.getName();
    private static final Logger LOG = Logger.getLogger(CLASS_NAME);

    @Resource(lookup = "java:/global/env/datasource/coffeeshopDS")
    DataSource ds;

    String SQL_GET_COFFEES = "select id,name,price from coffee_shop.coffee";

    public List<Coffee> retrieveCoffees() throws SQLException {
        List<Coffee> coffees = new ArrayList<>();

        try(Connection conn = ds.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(SQL_GET_COFFEES);
            ResultSet rs = stmt.executeQuery();

            while(rs != null && rs.next()) {
                Coffee newCoffee = new Coffee();
                newCoffee.setId(rs.getObject(1,UUID.class));
                newCoffee.setName(rs.getString(2));
                newCoffee.setPrice(rs.getBigDecimal(3));
                coffees.add(newCoffee);
            }
        } catch (SQLException sqlException) {
            LOG.logp(Level.SEVERE,CLASS_NAME,"retrieveCoffees","Unable to retrieve coffees from repository.",sqlException);
            throw sqlException;
        }

        return coffees;
    }
}
