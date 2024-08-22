package com.example.MoviesDemo.dtos.builders;
import com.example.MoviesDemo.entities.User;
import com.example.MoviesDemo.dtos.UserDTO;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Builder
@NoArgsConstructor
public class UserBuilder {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static UserDTO toUserDTO(User user)
    {
        return modelMapper.map(user, UserDTO.class);
    }

    public static User toEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

}