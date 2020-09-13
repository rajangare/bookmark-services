package com.assignment.port;

import com.assignment.model.UserDto;

import java.util.List;

public interface UserPort {
    UserDto findUserById(Long userId);

    List<UserDto> findAllUsers();

    UserDto saveOrUpdateUser(UserDto UserDto);

    void deleteUser(Long userId);
}