package com.uniyaz.eticaret.repo;

import com.uniyaz.eticaret.converter.CommentConvertor;
import com.uniyaz.eticaret.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepo extends JpaRepository<Comment,Long> {

    @Query("select comments.commentId as commentId, comments.comment as comment, comments.parentID as parentID, " +
            "comments.user.userId as userId,comments.user.userName as userName" +
            " from Comment comments " +
            "left join comments.products product where product.id=:productId")
    Optional<List<CommentConvertor>> getAllCommentsByProductId(@Param("productId") Long productId);

}
