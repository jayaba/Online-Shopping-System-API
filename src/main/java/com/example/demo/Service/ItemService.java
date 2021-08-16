package com.example.demo.Service;

import com.example.demo.dao.ItemRepository;
import com.example.demo.dto.ItemDto;
import com.example.demo.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService implements ItemServices{


    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void addItems(ItemDto itemDto) {
        Item item=new Item();
        item.setItemId(itemDto.getItemId());
        item.setItemName(itemDto.getItemName());
        item.setPrice(itemDto.getPrice());
        itemRepository.save(item);
    }

    @Override
    public void removeItem(Integer id) {

        Optional<Item> item=itemRepository.findById(id);
        if(item.isPresent()){
            itemRepository.delete(item.get());
        }else{
            System.out.println("item not deleted");
        }
    }

    @Override
    public List<ItemDto> getAllItems() {
        List<Item> itemList=itemRepository.findAll();
        List<ItemDto> itemDtoList=new ArrayList<>();
        for(int i=0;i<itemList.size();i++){
            ItemDto itemDto=new ItemDto();
            itemDto.setItemId(itemList.get(i).getItemId());
            itemDto.setItemName(itemList.get(i).getItemName());
            itemDto.setPrice(itemList.get(i).getPrice());
            //itemDto.setCartItemDto(itemList.get(i).getC);
            itemDtoList.add(itemDto);
        }
return itemDtoList;
    }
}
