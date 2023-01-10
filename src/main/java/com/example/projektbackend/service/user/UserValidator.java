package com.example.projektbackend.service.user;

import com.example.projektbackend.DTO.user.UserDTO;
import com.example.projektbackend.DTO.user.UserEditDTO;
import com.example.projektbackend.execptions.InvalidEditData;
import com.example.projektbackend.execptions.InvalidRegisterData;
import com.example.projektbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserValidator {


    private final UserRepository userRepository;

    private static final String EMAIL_PATTERN = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";


    public void ValidateUser(UserDTO userDTO){


        if(userDTO.getPassword().length() < 8)
            throw new InvalidRegisterData("Minimalna dłguość hasła to 8 znaków");

        if(userDTO.getUsername().length() < 5)
            throw new InvalidRegisterData("Minimalna długość loginu to 5 znaków");

        if(userRepository.existsByUsername(userDTO.getUsername()))
            throw new InvalidRegisterData("Użytkownik o podanej nazwie już istnieje");

        if(userRepository.existsByEmail(userDTO.getEmail()))
            throw new InvalidRegisterData("Email o podanym adresie istnieje ");
    }

    public void ValidateEditUserPassword(UserEditDTO userEditDTO){

        var user = userRepository.findById(userEditDTO.getUser_id());


        if(userEditDTO.getPassword().matches(user.get().getPassword()))
            throw new InvalidEditData("Podane hasło jest identyczne do poprzedniego");

    }
    public void ValidateEditUserEmail(UserEditDTO userEditDTO){

        var user = userRepository.findById(userEditDTO.getUser_id());

        if(userEditDTO.getEmail().matches(user.get().getEmail()))
            throw new InvalidEditData("Podany email jest identyczny");
    }


    public boolean ValidateEmail(String string){
        return string.matches(EMAIL_PATTERN);
    }




}
