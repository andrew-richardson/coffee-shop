package com.coffeeshop;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import java.io.Serializable;

/**
 * Created by andrew on 4/2/17.
 */
@ManagedBean(name = "menu")
@RequestScoped
public class MenuController implements Serializable {

    @Inject
    private CoffeeMenuController coffeemenu;

    public CoffeeMenuController getCoffeemenu() {
        return coffeemenu;
    }
}
