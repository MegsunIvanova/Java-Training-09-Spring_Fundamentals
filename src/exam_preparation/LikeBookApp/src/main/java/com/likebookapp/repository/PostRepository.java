package com.likebookapp.repository;

import com.likebookapp.model.entity.PostEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
   @EntityGraph(
            value = "postWithLikes",
            attributePaths = "userLikes"
    )
    @Query ("SELECT p FROM PostEntity p " +
            "WHERE p.user.username = :username ")
    List<PostEntity> findAllByUserUsernameWithLikes(String username);

    @EntityGraph(
            value = "postWithLikes",
            attributePaths = "userLikes"
    )
    @Query ("SELECT p FROM PostEntity p " +
            "WHERE p.user.username != :username " +
            "ORDER BY p.user.username ")
    List<PostEntity> findAllByUserUsernameNotWithLikes(String username);

 @EntityGraph(
         value = "postWithLikes",
         attributePaths = "userLikes"
 )

 @Query ("SELECT p FROM PostEntity p " +
         "WHERE p.id = :id ")
 PostEntity findPostWithLikesById(Long id);
}
