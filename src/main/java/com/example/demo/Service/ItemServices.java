package com.example.demo.Service;

import com.example.demo.dto.ItemDto;
import com.example.demo.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemServices  {

    public void addItems(ItemDto itemDto);
    public void removeItem(Integer id);
    public List<ItemDto> getAllItems();
}
