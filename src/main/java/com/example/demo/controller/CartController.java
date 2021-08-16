package com.example.demo.controller;

import com.example.demo.Service.CartService;
import com.example.demo.dto.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cart")
public class CartController {

    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public void addCart(@RequestBody CartDto cartDto){
        cartService.addToCart(cartDto);
    }

    @GetMapping
    public List<CartDto> getAll(){
        return  cartService.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable Integer id){
        cartService.RemoveFromCart(id);
    }
}
