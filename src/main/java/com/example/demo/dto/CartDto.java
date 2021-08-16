package com.example.demo.dto;

import org.apache.catalina.LifecycleState;

import java.util.List;

public class CartDto {
    private Integer cartId;
    private Double total;
    private UserDto userDto;
    private List<CartItemDto> cartItemDto;

    public CartDto() {
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public List<CartItemDto> getCartItemDto() {
        return cartItemDto;
    }

    public void setCartItemDto(List<CartItemDto> cartItemDto) {
        this.cartItemDto = cartItemDto;
    }
}
