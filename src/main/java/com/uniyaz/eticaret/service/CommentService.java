package com.uniyaz.eticaret.service;

import com.uniyaz.eticaret.converter.CommentConvertor;
import com.uniyaz.eticaret.entity.Comment;
import com.uniyaz.eticaret.repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    CommentRepo commentRepo;

    public Optional<List<CommentConvertor>> getAllCommentsByProductId(Long productId){

        Optional<List<CommentConvertor>> allCommentById = commentRepo.getAllCommentsByProductId(productId);
        return allCommentById;
    }

}
