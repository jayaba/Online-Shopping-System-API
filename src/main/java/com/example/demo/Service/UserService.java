package com.example.demo.Service;

import com.example.demo.dao.CartRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.dto.CartDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.Cart;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServices {

    UserRepository userRepository;
    CartRepository cartRepository;

    @Autowired
    public UserService(UserRepository userRepository, CartRepository cartRepository) {
        this.userRepository = userRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public void addUser(UserDto userDto){
        User user=new User();
        Cart cart=new Cart();
        user.setUserId(userDto.getUserId());
        user.setName(userDto.getName());
        cart.setTotal(0.00);
        user.setPhoneNumber(userDto.getPhoneNumber());
        Cart cart1=cartRepository.save(cart);
        user.setCart(cart1);
        userRepository.save(user);

    }

    @Override
    public List<UserDto> getAllUsers(){
        List<User> userList=userRepository.findAll();
        List<UserDto>  userDtoList=new ArrayList<>();
        List<CartDto> cartDtoList=new ArrayList<>();
        CartDto cartDto=new CartDto();
        User user=new User();
        for(int i=0;i<userList.size();i++){
            UserDto userDto=new UserDto();
            userDto.setUserId(userList.get(i).getUserId());
            userDto.setName(userList.get(i).getName());

            userDto.setPhoneNumber(userList.get(i).getPhoneNumber());

          userDtoList.add(userDto);
        }
return userDtoList;
    }

    @Override
    public void updateUser(UserDto userDto){
        Optional<User> user=userRepository.findById(userDto.getUserId());
        //Cart cart = userRepository.findById(userDto.getUserId()).get().();
        if(user.isPresent()){
            User user1=new User();
            user1.setUserId(userDto.getUserId());
            user1.setName(userDto.getName());
            user1.setPhoneNumber(userDto.getPhoneNumber());
            userRepository.save(user1);
        }
    }
    @Override
    public void deleteUser(Integer id){
        Optional<User> user=userRepository.findById(id);
        if(user.isPresent()){
            userRepository.delete(user.get());
        }
    }
}
