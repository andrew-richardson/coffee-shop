package com.coffeeshop;

import com.coffeeshop.bean.Coffee;
import com.coffeeshop.service.CoffeeService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

/**
 * Created by andrew on 4/2/17.
 */
public class CoffeeMenuController implements Serializable{

    @Inject
    private CoffeeService service;
    private List<Coffee> coffees;

    @PostConstruct
    public void init() {
        coffees = service.retrieveCoffees();
    }

    public List<Coffee> getCoffees() {
        return coffees;
    }

    public void setCoffees(List<Coffee> coffees) {
        this.coffees = coffees;
    }
}
