package com.byvyd.api.controller.mapper;

import com.byvyd.api.controller.dto.UserCreateDTO;
import com.byvyd.api.controller.dto.UserDTO;
import com.byvyd.api.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public UserDTO toUserDTO(User user){
        return MODEL_MAPPER.map(user, UserDTO.class);
    }

    public List<UserDTO> toUserDTOList(List<User> userList) {
        return userList.stream().map(this::toUserDTO).collect(Collectors.toList());
    }

    public User toUser(UserDTO dto) {
        return MODEL_MAPPER.map(dto, User.class);
    }

    public User toUserCreate(UserCreateDTO dto) {
        return MODEL_MAPPER.map(dto, User.class);
    }
}
