package com.byvyd.api.controller;

import com.byvyd.api.controller.dto.UserDTO;
import com.byvyd.api.controller.mapper.UserMapper;
import com.byvyd.api.model.User;
import com.byvyd.api.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(tags = "User Controller")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/findAll")
    @ApiOperation("Find all")
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> userList = userService.findAll();
        List<UserDTO> result = userMapper.toUserDTOList(userList);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/findById/{idUser}")
    @ApiOperation("Find By Id")
    public ResponseEntity<UserDTO> findById(@PathVariable String idUser){
        User user = userService.findById(idUser);
        UserDTO result = userMapper.toUserDTO(user);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{idUser}")
    @ApiOperation("Delete")
    public ResponseEntity delete(@PathVariable String idUser){
        userService.delete(idUser);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/create")
    @ApiOperation("Create")
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO dto){
        var userCreate = userMapper.toUser(dto);
        var user = userService.create(userCreate);
        var result = userMapper.toUserDTO(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/update/{idUser}")
    @ApiOperation("Update")
    public ResponseEntity<UserDTO> update(@PathVariable String idUser, @RequestBody UserDTO dto){
        var userCreate = userMapper.toUser(dto);
        var user = userService.update(idUser, userCreate);
        var result = userMapper.toUserDTO(user);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
