package com.uniyaz.eticaret.controller;

import com.uniyaz.eticaret.converter.CommentConvertor;
import com.uniyaz.eticaret.entity.Comment;
import com.uniyaz.eticaret.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/auth/comment")
@CrossOrigin(origins = "*")
public class CommentController {

    @Autowired
    CommentService commentService;


    @PostMapping(path = "/save")
    ResponseEntity saveComment(@RequestBody Comment comment){
        boolean status = commentService.saveComment(comment);

        if(status)
            return new ResponseEntity(status,HttpStatus.ACCEPTED);


        return new ResponseEntity(status,HttpStatus.BAD_REQUEST);
    }
    @GetMapping(path = "/getComment/{id}")
    ResponseEntity getCommentFindByProductId(@PathVariable Long id){

        Optional<List<CommentConvertor>> allCommentsByProductId = commentService.getAllCommentsByProductId(id);

        return new ResponseEntity(allCommentsByProductId,HttpStatus.ACCEPTED);
    }
}