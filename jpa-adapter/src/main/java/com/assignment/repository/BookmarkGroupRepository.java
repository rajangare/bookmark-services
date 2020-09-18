package com.assignment.repository;

import com.assignment.entity.BookmarkGroupEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookmarkGroupRepository extends CrudRepository<BookmarkGroupEntity, Long> {

    List<BookmarkGroupEntity> findGroupByGroupName(String groupName);
}
