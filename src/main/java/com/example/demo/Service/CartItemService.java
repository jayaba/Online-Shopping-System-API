package com.example.demo.Service;

import com.example.demo.dao.CartItemRepository;
import com.example.demo.dao.CartRepository;
import com.example.demo.dao.ItemRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.dto.CartItemDto;
import com.example.demo.entity.Cart;
import com.example.demo.entity.CartItems;
import com.example.demo.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartItemService implements CartItemServices{

    private CartRepository cartRepository;
    private ItemRepository itemRepository;
    private UserRepository userRepository;
    private CartItemRepository cartItemRepository;

    @Autowired
    public CartItemService(CartRepository cartRepository, ItemRepository itemRepository, UserRepository userRepository, CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public void addCartItems(CartItemDto cartItemDto) {
        CartItems cartItems=new CartItems();
       cartItems.setCartItemId(cartItemDto.getCartItemId());
       cartItems.setQuantity(cartItemDto.getQuantity());

        Optional<Cart> cart = cartRepository.findById(cartItemDto.getCartId());
        Optional<Item> item = itemRepository.findById(cartItemDto.getItemId());
        if(cart.isPresent() && item.isPresent()){
            cartItems.setCart(cart.get());
            cartItems.setItem(item.get());
        }
        cartItemRepository.save(cartItems);

    }

    @Override
    public void deleteItems(Integer id) {
        Optional<CartItems> cartItems=cartItemRepository.findById(id);
        if(cartItems.isPresent()){
            cartItemRepository.delete(cartItems.get());
        }
    }

    @Override
    public List<CartItemDto> getAll() {
        List<CartItems> cartItemsList=cartItemRepository.findAll();
        List<CartItemDto> cartItemDtoList=new ArrayList<>();
        for(int i=0;i<cartItemsList.size();i++){
            CartItemDto cartItemDto=new CartItemDto();
            cartItemDto.setCartItemId(cartItemsList.get(i).getCartItemId());
            cartItemDto.setQuantity(cartItemsList.get(i).getQuantity());
            cartItemDtoList.add(cartItemDto);

        }
        return cartItemDtoList;
    }
}
