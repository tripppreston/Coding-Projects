/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.vendingmachinewebapp.controller;

import com.tsguild.vendingmachinewebapp.dao.VendingMachineDao;
import com.tsguild.vendingmachinewebapp.dto.Item;
import java.util.List;
import javax.inject.Inject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author apprentice
 */
@Controller
public class HomeController {

    private VendingMachineDao dao;

    @Inject
    public HomeController(VendingMachineDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String displayHome() {
        return "home";
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/items/{id}", method = RequestMethod.PUT)
    public void updateItem(@PathVariable("id") int itemId, @RequestBody Item item) {
        item.setId(itemId);
        dao.updateItem(item);
    }

    @ResponseBody
    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public List<Item> getAllItems() {
        return dao.getAllItems();
    }
//     @ResponseStatus(HttpStatus.NO_CONTENT)
//    @RequestMapping(value = "/items/{id}", method = RequestMethod.PUT)
//    public void removeOneItem(@PathVariable("id") int itemId) {
//        
//        dao.removeOne(itemId);
//    }

}
