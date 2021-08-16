package com.example.demo.dao;

import com.example.demo.entity.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository  extends JpaRepository<CartItems,Integer> {
}
