package com.assignment.repository;

import com.assignment.entity.BookmarkCardEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkCardRepository extends CrudRepository<BookmarkCardEntity, Long> {

}
