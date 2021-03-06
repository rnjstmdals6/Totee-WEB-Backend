package com.study.totee.api.persistence;

import com.study.totee.api.model.PostEntity;
import com.study.totee.api.model.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, String> {
    Page<PostEntity> findAll(Pageable pageable);
    PostEntity findByPostId(Long postId);
    PostEntity findByPostIdAndUser(Long postId, UserEntity user);
    Page<PostEntity> findAllByStatus(String status, Pageable pageable);
    Page<PostEntity> findAllByCategory_CategoryName(String categoryName, Pageable pageable);
    Page<PostEntity> findAllByCategory_CategoryNameAndStatus(String categoryName, String status, Pageable pageable);
}
