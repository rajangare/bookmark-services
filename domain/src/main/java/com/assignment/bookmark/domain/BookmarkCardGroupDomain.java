package com.assignment.bookmark.domain;

import com.assignment.bookmark.mapper.BookmarkCardGroupMapper;
import com.assignment.entity.BookmarkCardEntity;
import com.assignment.entity.BookmarkCardGroupEntity;
import com.assignment.model.BookmarkCardGroupDto;
import com.assignment.port.BookmarkCardGroupPort;
import com.assignment.repository.BookmarkCardGroupRepository;
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
public class BookmarkCardGroupDomain implements BookmarkCardGroupPort {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookmarkCardGroupDomain.class);

    private final BookmarkCardGroupRepository bookmarkCardGroupRepository;

    private final BookmarkCardGroupMapper mapper = Mappers.getMapper(BookmarkCardGroupMapper.class);

    @Autowired
    public BookmarkCardGroupDomain(BookmarkCardGroupRepository bookmarkCardGroupRepository) {
        this.bookmarkCardGroupRepository = bookmarkCardGroupRepository;
    }

    @Override
    public BookmarkCardGroupDto findCardGroupById(Long cardGroupId) {
        Optional<BookmarkCardGroupEntity> cardGroupEntity = bookmarkCardGroupRepository.findById(cardGroupId);

        return cardGroupEntity.map(mapper::mapGroupDetailDto).orElse(null);
    }

    @Override
    public List<BookmarkCardGroupDto> findAllCardGroups() {
        Iterable<BookmarkCardGroupEntity> groupDetailsEntities = bookmarkCardGroupRepository.findAll();

        return mapper.mapGroupDetailsDtoList(StreamSupport.
                stream(groupDetailsEntities.spliterator(), true).collect(Collectors.toList()));

    }

    @Override
    public BookmarkCardGroupDto saveOrUpdateCardGroup(BookmarkCardGroupDto bookmarkCardGroupDto) {
        LOGGER.info("Create bookmark Group Card : ", bookmarkCardGroupDto);

        return mapper.mapGroupDetailDto(bookmarkCardGroupRepository.save(mapper.mapOneGroupDetail(bookmarkCardGroupDto)));

    }

    @Override
    public void deleteCardGroup(Long cardGroupId) {
        bookmarkCardGroupRepository.deleteById(cardGroupId);
    }
}
