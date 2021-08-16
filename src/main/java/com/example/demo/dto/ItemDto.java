package com.example.demo.dto;

import java.util.List;

public class ItemDto {
    private Integer itemId;
    private String itemName;
    private Double price;
    private List<CartItemDto> cartItemDto;
    public ItemDto() {
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<CartItemDto> getCartItemDto() {
        return cartItemDto;
    }

    public void setCartItemDto(List<CartItemDto> cartItemDto) {
        this.cartItemDto = cartItemDto;
    }
}
