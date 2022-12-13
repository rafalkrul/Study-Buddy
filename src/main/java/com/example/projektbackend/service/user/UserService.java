package com.example.projektbackend.service.user;

import com.example.projektbackend.DTO.UserDTO;
import com.example.projektbackend.model.User;
import com.example.projektbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
import java.util.UUID;

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

    public void deleteUserById(UUID user_id){
        userRepository.deleteById(user_id);
    }
}
