package com.assignment.bookmark.domain;

import com.assignment.bookmark.helper.UrlShorterHelper;
import com.assignment.bookmark.mapper.BookmarkCardMapper;
import com.assignment.entity.BookmarkCardEntity;
import com.assignment.model.BookmarkCardDto;
import com.assignment.port.BookmarkCardPort;
import com.assignment.repository.BookmarkCardRepository;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookmarkCardDomain implements BookmarkCardPort {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookmarkCardDomain.class);

    private final BookmarkCardRepository bookmarkCardRepository;

    private final UrlShorterHelper urlShorterHelper;

    private final BookmarkCardMapper mapper = Mappers.getMapper(BookmarkCardMapper.class);

    public BookmarkCardDomain(BookmarkCardRepository bookmarkCardRepository, UrlShorterHelper urlShorterHelper) {
        this.bookmarkCardRepository = bookmarkCardRepository;
        this.urlShorterHelper = urlShorterHelper;
    }

    @Override
    public BookmarkCardDto findBookmarkCardById(Long cardId) {
        Optional<BookmarkCardEntity> cardDetailsEntity = bookmarkCardRepository.findById(cardId);

        return cardDetailsEntity.map(mapper::mapCardDetailDto).orElse(null);
    }

    @Override
    public List<BookmarkCardDto> findAllBookmarkCards() {
        Iterable<BookmarkCardEntity> cardDetailsEntities = bookmarkCardRepository.findAll();

        if(cardDetailsEntities == null) {
            return Collections.EMPTY_LIST;
        }

        return mapper.mapCardDetailsDtoList(StreamSupport.
                stream(cardDetailsEntities.spliterator(), true).collect(Collectors.toList()));
    }

    @Override
    public BookmarkCardDto saveOrUpdateBookmarkCard(BookmarkCardDto bookmarkCardDto) {
        LOGGER.info("Create bookmark card : ", bookmarkCardDto);

        BookmarkCardEntity entity = mapper.mapOneCardDetail(bookmarkCardDto);
        mapper.mapToEntityExtraInformation(bookmarkCardDto, entity);

        if(entity.getId() == 0 | entity.getId() == null) {
            entity.setCreationDate(LocalDateTime.now());
        } else {
            entity.setModifiedDate(LocalDateTime.now());
        }

        if(entity.getGroupDetail() == null) {
            entity.setExpiryDate(null);
        }

        entity = bookmarkCardRepository.save(entity);

        bookmarkCardDto = mapper.mapCardDetailDto(entity);
        mapper.mapToDtoExtraInformation(entity, bookmarkCardDto);

        return bookmarkCardDto;
    }

    @Override
    public void deleteBookmarkCard(Long cardId) {
        bookmarkCardRepository.deleteById(cardId);
    }
}