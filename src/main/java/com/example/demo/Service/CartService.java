package com.example.demo.Service;

import com.example.demo.dao.CartItemRepository;
import com.example.demo.dao.CartRepository;
import com.example.demo.dao.ItemRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.dto.CartDto;
import com.example.demo.dto.CartItemDto;
import com.example.demo.entity.Cart;
import com.example.demo.entity.CartItems;
import com.example.demo.entity.Item;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService implements CartServices {

    private CartRepository cartRepository;
    private ItemRepository itemRepository;
    private UserRepository userRepository;
    private CartItemRepository cartItemRepository;
    @Autowired
    public CartService(CartRepository cartRepository, ItemRepository itemRepository,UserRepository userRepository,CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.itemRepository = itemRepository;
        this.userRepository=userRepository;
        this.cartItemRepository=cartItemRepository;
    }




    @Override
    public void addToCart(CartDto cartDto) {
        Cart cart=new Cart();
        cart.setCartId(cartDto.getCartId());
        cart.setTotal(cartDto.getTotal());
        cartRepository.save(cart);
//        CartItemDto cartItemDto=new CartItemDto();
//        CartItems cartItems=new CartItems();
//        Item item=itemRepository.getById(cartItemDto.getCartItemId());
//        cartItems.setCart(cart);
//        cartItems.setItem(item);
//        cartItems.setCartItemId(cartDto.getCartId());
       // cartItems.setQuantity(cartDto.get);


    }



    @Override
    public void RemoveFromCart(Integer id) {
        CartDto cartDto=new CartDto();
        Optional<Cart> cart=cartRepository.findById(cartDto.getCartId());

        if(cart.isPresent()){

            cartRepository.delete(cart.get());
        }
    }

    @Override
    public List<CartDto> getAll() {
        List<Cart> cartList=cartRepository.findAll();
        List<CartDto> cartDtoList=new ArrayList<>();
        for(int i=0;i<cartList.size();i++){
            CartDto cartDto=new CartDto();
            cartDto.setCartId(cartList.get(i).getCartId());
            cartDto.setTotal(cartList.get(i).getTotal());
            cartDtoList.add(cartDto);
        }
        return  cartDtoList;
    }

    @Override
    public void addItemsToCart(CartItemDto cartItemDto) {
        CartItems cartItems=new CartItems();
        //Cart cart=userRepository.getById(cartItemDto.getCart
        Item item=itemRepository.getById(cartItemDto.getCartItemId());
       // cartItems.setCart(cart);
        cartItems.setCartItemId(cartItemDto.getCartItemId());
        cartItems.setQuantity(cartItemDto.getQuantity());
        cartItems.setItem(item);
        CartItems cartItems1=cartItemRepository.save(cartItems);
        itemRepository.save(item);
    }
}
