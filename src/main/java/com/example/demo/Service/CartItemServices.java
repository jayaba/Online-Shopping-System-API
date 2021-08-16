package com.example.demo.Service;

import com.example.demo.dto.CartItemDto;

import java.util.List;

public interface CartItemServices {
    public void addCartItems(CartItemDto cartItemDto);
    public void deleteItems(Integer id);
    public List<CartItemDto> getAll();
}
