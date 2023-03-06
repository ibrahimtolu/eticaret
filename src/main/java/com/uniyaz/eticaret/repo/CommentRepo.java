package com.uniyaz.eticaret.repo;

import com.uniyaz.eticaret.converter.CommentConvertor;
import com.uniyaz.eticaret.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepo extends JpaRepository<Comment,Long> {

    @Query("select comment.commentId as id, comment.comment as comments, comment.parentID as parentID, " +
            "comment.user.userName as userName" +
            " from Comment comment " +
            "left join comment.products product where product.id=:productId")
    Optional<List<CommentConvertor>> getAllCommentsByProductId(@Param("productId") Long productId);

    
}
