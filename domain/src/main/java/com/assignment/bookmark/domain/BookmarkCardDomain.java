package com.assignment.bookmark.domain;

import com.assignment.bookmark.mapper.BookmarkCardMapper;
import com.assignment.entity.BookmarkCardEntity;
import com.assignment.model.BookmarkCardDto;
import com.assignment.port.BookmarkCardPort;
import com.assignment.repository.BookmarkCardRepository;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookmarkCardDomain implements BookmarkCardPort {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookmarkCardDomain.class);

    private final BookmarkCardRepository bookmarkCardRepository;

    private final BookmarkCardMapper mapper = Mappers.getMapper(BookmarkCardMapper.class);

    public BookmarkCardDomain(BookmarkCardRepository bookmarkCardRepository) {
        this.bookmarkCardRepository = bookmarkCardRepository;
    }

    @Override
    public BookmarkCardDto findBookmarkCardById(Long cardId) {
        Optional<BookmarkCardEntity> cardDetailsEntity = bookmarkCardRepository.findById(cardId);

        return cardDetailsEntity.map(mapper::mapCardDetailDto).orElse(null);
    }

    @Override
    public List<BookmarkCardDto> findAllBookmarkCards() {
        Iterable<BookmarkCardEntity> cardDetailsEntities = bookmarkCardRepository.findAll();

        return mapper.mapCardDetailsDtoList(StreamSupport.
                stream(cardDetailsEntities.spliterator(), true).collect(Collectors.toList()));
    }

    @Override
    public BookmarkCardDto saveOrUpdateBookmarkCard(BookmarkCardDto bookmarkCardDto) {
        LOGGER.info("Create bookmark card : ", bookmarkCardDto);

        return mapper.mapCardDetailDto(bookmarkCardRepository.save(mapper.mapOneCardDetail(bookmarkCardDto)));
    }

    @Override
    public void deleteBookmarkCard(Long cardId) {
        bookmarkCardRepository.deleteById(cardId);
    }
}