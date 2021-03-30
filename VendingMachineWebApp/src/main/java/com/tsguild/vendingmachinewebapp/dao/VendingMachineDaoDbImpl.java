/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.vendingmachinewebapp.dao;

import com.tsguild.vendingmachinewebapp.dto.Item;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author apprentice
 */
public class VendingMachineDaoDbImpl implements VendingMachineDao {

    private static final String SQL_UPDATE_ITEM
            = "UPDATE Items SET item_name = ?, number_available = , price=? WHERE id = ?";
    private static final String SQL_REMOVE_ONE_ITEM
            = "UPDATE Items SET item_name -= 1 WHERE id = ?";
    private static final String SQL_GET_ALL_ITEMS
            = "SELECT * FROM Items WHERE number_available > 0";
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void updateItem(Item item) {
        jdbcTemplate.update(SQL_UPDATE_ITEM,
                item.getName(),
                item.getNumberAvailable(),
                item.getPrice(),
                item.getId()
        );
    }

    @Override
    public List<Item> getAllItems() {
        return jdbcTemplate.query(SQL_GET_ALL_ITEMS, new ItemMapper());
    }

    @Override
    public void removeOne(int itemId) {
        jdbcTemplate.update(SQL_REMOVE_ONE_ITEM,
                  itemId  
                );
    }

    private static final class ItemMapper implements RowMapper<Item> {

        @Override
        public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
            Item item = new Item();
            item.setId(rs.getInt("id"));
            item.setName(rs.getString("item_name"));
            item.setPrice(rs.getDouble("price"));
            item.setNumberAvailable(rs.getInt("number_available"));
            return item;
        }
    }
}
