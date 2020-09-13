package com.assignment.bookmark.domain;

import com.assignment.bookmark.mapper.UserMapper;
import com.assignment.entity.UserEntity;
import com.assignment.model.UserDto;
import com.assignment.port.UserPort;
import com.assignment.repository.UserRepository;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserDomain implements UserPort {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDomain.class);

    private final UserRepository UserRepository;

    private final UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @Autowired
    public UserDomain(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    @Override
    public UserDto findUserById(Long userId) {
        Optional<UserEntity> UserEntity = UserRepository.findById(userId);

        return UserEntity.map(mapper::mapUserDetailDto).orElse(null);
    }

    @Override
    public List<UserDto> findAllUsers() {
        Iterable<UserEntity> groupDetailsEntities = UserRepository.findAll();

        return mapper.mapUserDetailsDtoList(StreamSupport.
                stream(groupDetailsEntities.spliterator(), true).collect(Collectors.toList()));

    }

    @Override
    public UserDto saveOrUpdateUser(UserDto UserDto) {
        LOGGER.info("Create bookmark Group Card : ", UserDto);

        return mapper.mapUserDetailDto(UserRepository.save(mapper.mapOneUserDetail(UserDto)));

    }

    @Override
    public void deleteUser(Long userId) {
        UserRepository.deleteById(userId);
    }
}
