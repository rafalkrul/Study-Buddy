package com.example.projektbackend.service.user;

import com.example.projektbackend.DTO.user.UserDTO;
import com.example.projektbackend.model.User;
import com.example.projektbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final ModelMapper mapper;

    public UUID CreateUser(UserDTO userDTO) {
        var id = UUID.randomUUID();
        var userAdd = mapper.map(userDTO, User.class);

        userAdd.setUser_id(id);
        userRepository.save(userAdd);

        return id;
    }

    public UserDTO GetUserById(UUID user_id){

        var user = userRepository.findById(user_id);

        return mapper.map(user, UserDTO.class);
    }

    public List<UserDTO> GetAllUsers(){
        return userRepository.findAll().stream()
                .map(user -> mapper.map(user,UserDTO.class))
                .collect(Collectors.toList());
    }

    public void DeleteUserById(UUID user_id){
        userRepository.deleteById(user_id);
    }
}
