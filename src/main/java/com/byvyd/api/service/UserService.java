package com.byvyd.api.service;
import com.byvyd.api.exception.UserNotFoundException;
import com.byvyd.api.model.User;
import com.byvyd.api.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<User>findAll(){
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User findById(String idUser) {
        return userRepository.findById(Long.valueOf(idUser)).orElseThrow(() ->
                new UserNotFoundException(idUser));
    }

    @Transactional(readOnly = false)
    public User create(User userCreate) {
        userRepository.save(userCreate);
        return userCreate;
    }

    @Transactional
    public void delete(String idUser) {
        findById(idUser);
        userRepository.deleteById(Long.valueOf(idUser));
    }

    @Transactional
    public User update(String idUser, User userCreate) {
        User User = findById(idUser);
        User.setNome(userCreate.getNome());
        User.setSobrenome(userCreate.getSobrenome());
        User.setApelido(userCreate.getApelido());
        User.setEmail(userCreate.getEmail());
        User.setSenha(userCreate.getSenha());
        User.setDataNascimento(userCreate.getDataNascimento());
        User.setSexo(userCreate.getSexo());
        userRepository.save(User);
        return User;
    }
}
