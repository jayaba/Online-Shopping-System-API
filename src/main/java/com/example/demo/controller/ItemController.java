package com.example.demo.controller;

import com.example.demo.Service.ItemService;
import com.example.demo.dto.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public void addItems(@RequestBody ItemDto itemDto){
        itemService.addItems(itemDto);
    }

    @GetMapping
    public List<ItemDto> getAllItems(){
        return itemService.getAllItems();
    }

    @DeleteMapping("/{id}")
    public void deleteItems(@PathVariable Integer id){
        itemService.removeItem(id);
    }

}
