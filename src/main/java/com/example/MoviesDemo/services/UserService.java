package com.example.MoviesDemo.services;

import com.example.MoviesDemo.dtos.UserDTO;
import com.example.MoviesDemo.dtos.builders.UserBuilder;
import com.example.MoviesDemo.entities.User;
import com.example.MoviesDemo.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Builder
@AllArgsConstructor
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    public final UserRepository userRepository;

    private ModelMapper modelMapper;


    public List<UserDTO> findUsers() {
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(UserBuilder::toUserDTO)
                .collect(Collectors.toList());
    }

    public User insert(UserDTO userDTO)
    {
        User newUser = UserBuilder.toEntity(userDTO);
        newUser = userRepository.save(newUser);
        LOGGER.info("User inserted");
        return newUser;
    }

    public void deleteUser(UUID id){
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            LOGGER.error("Userul nu exista");
        }
        userRepository.deleteById(id);
        LOGGER.info("User sters");
    }


    public UserDTO updateUser(UserDTO userDTO, UUID id){
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            LOGGER.error("nu avem acest user");
        }
        User existingUser = userRepository.findById(userDTO.getId()).get();
        if(userDTO.getPassword()!=null && !userDTO.getPassword().isEmpty()){
            existingUser.setPassword(userDTO.getPassword());
        }
        existingUser.setRole(userDTO.getRole());
        existingUser.setEmail(userDTO.getEmail());
        //existingUser.setPassword(userDTO.getPassword());
        existingUser.setFirstName(userDTO.getFirstName());
        existingUser.setLastName(userDTO.getLastName());
        existingUser.setPhoneNumber(userDTO.getPhoneNumber());
        existingUser.setDateOfBirth(userDTO.getDateOfBirth());
        User updatedUser = userRepository.save(existingUser);
        LOGGER.info("user actualizat");
        return UserBuilder.toUserDTO(updatedUser);
    }


}
