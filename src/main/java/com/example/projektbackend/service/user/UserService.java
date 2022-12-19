package com.example.projektbackend.service.user;

import com.example.projektbackend.DTO.user.UserDTO;
import com.example.projektbackend.execptions.InvalidRegisterData;
import com.example.projektbackend.model.User;
import com.example.projektbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserValidator userValidator;
    private final ModelMapper mapper;

    public UUID CreateUser(UserDTO userDTO) {
        var id = UUID.randomUUID();
        var userAdd = mapper.map(userDTO, User.class);

        userValidator.ValidateUser(userDTO);
        if(!userValidator.ValidateEmail(userDTO.getEmail())) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Zły pattern kolego");
        userAdd.setUser_id(id);
        userAdd.setPassword(new BCryptPasswordEncoder().encode(userAdd.getPassword()));
        userRepository.save(userAdd);

        return id;
    }

    public void ChangePassword(UserDTO userDTO){

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

    public UserDTO GetUserByUsername(String username){
        var user = userRepository.findByUsername(username);
        return mapper.map(user, UserDTO.class);
    }

    public void DeleteUserById(UUID user_id){
        userRepository.deleteById(user_id);
    }
}
