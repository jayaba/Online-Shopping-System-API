package com.example.demo.controller;

import com.example.demo.Service.CartItemService;
import com.example.demo.dto.CartItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartItems")
public class CartItemController {
    private CartItemService cartItemService;

    @Autowired
    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PostMapping
    public void addCartItems(@RequestBody CartItemDto cartItemDto){
        cartItemService.addCartItems(cartItemDto);
    }

    @GetMapping
    public List<CartItemDto> getAll(){
        return cartItemService.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteCartItems(@PathVariable Integer id){
        cartItemService.deleteItems(id);
    }
}
