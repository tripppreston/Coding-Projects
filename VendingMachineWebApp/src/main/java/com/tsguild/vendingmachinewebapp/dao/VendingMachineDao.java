/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.vendingmachinewebapp.dao;

import com.tsguild.vendingmachinewebapp.dto.Item;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface VendingMachineDao {
    

    
    public void updateItem(Item item);
    
   
    public List<Item> getAllItems();
    
    public void removeOne(int itemId);
    
}
