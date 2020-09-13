package com.assignment.bookmark.domain;

import com.assignment.bookmark.mapper.BookmarkGroupMapper;
import com.assignment.entity.BookmarkGroupEntity;
import com.assignment.model.BookmarkGroupDto;
import com.assignment.port.BookmarkGroupPort;
import com.assignment.repository.BookmarkGroupRepository;
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
public class BookmarkGroupDomain implements BookmarkGroupPort {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookmarkGroupDomain.class);

    private final BookmarkGroupRepository bookmarkGroupRepository;

    private final BookmarkGroupMapper mapper = Mappers.getMapper(BookmarkGroupMapper.class);

    @Autowired
    public BookmarkGroupDomain(BookmarkGroupRepository bookmarkGroupRepository) {
        this.bookmarkGroupRepository = bookmarkGroupRepository;
    }

    @Override
    public BookmarkGroupDto findCardGroupById(Long cardGroupId) {
        Optional<BookmarkGroupEntity> cardGroupEntity = bookmarkGroupRepository.findById(cardGroupId);

        return cardGroupEntity.map(mapper::mapGroupDetailDto).orElse(null);
    }

    @Override
    public List<BookmarkGroupDto> findAllCardGroups() {
        Iterable<BookmarkGroupEntity> groupDetailsEntities = bookmarkGroupRepository.findAll();

        return mapper.mapGroupDetailsDtoList(StreamSupport.
                stream(groupDetailsEntities.spliterator(), true).collect(Collectors.toList()));

    }

    @Override
    public BookmarkGroupDto saveOrUpdateCardGroup(BookmarkGroupDto bookmarkGroupDto) {
        LOGGER.info("Create bookmark Group Card : ", bookmarkGroupDto);

        return mapper.mapGroupDetailDto(bookmarkGroupRepository.save(mapper.mapOneGroupDetail(bookmarkGroupDto)));

    }

    @Override
    public void deleteCardGroup(Long cardGroupId) {
        bookmarkGroupRepository.deleteById(cardGroupId);
    }
}
