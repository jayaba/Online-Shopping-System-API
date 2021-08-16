package com.example.demo.Service;

import com.example.demo.dto.CartDto;
import com.example.demo.dto.CartItemDto;

import java.util.List;

public interface CartServices {
    public void addToCart(CartDto cartDto);
    public void RemoveFromCart(Integer id);
    public List<CartDto> getAll();
    public void addItemsToCart(CartItemDto cartItemDto);
}
