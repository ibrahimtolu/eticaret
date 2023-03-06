package com.uniyaz.eticaret.controller;

import com.uniyaz.eticaret.converter.CommentConvertor;
import com.uniyaz.eticaret.converter.UserConverter;
import com.uniyaz.eticaret.entity.Comment;
import com.uniyaz.eticaret.entity.User;
import com.uniyaz.eticaret.service.CommentService;
import com.uniyaz.eticaret.service.LoginControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/comment")
@CrossOrigin(origins = "*")
public class CommentController {

    @Autowired
    CommentService commentService;


    @PostMapping(path = "/save")
    ResponseEntity saveComment(@RequestBody Comment comment){



        return null;
    }
    @GetMapping(path = "/getComment/{id}")
    ResponseEntity getCommentFindByProductId(@PathVariable Long id){

        Optional<List<CommentConvertor>> allCommentsByProductId = commentService.getAllCommentsByProductId(id);

        return new ResponseEntity(allCommentsByProductId,HttpStatus.ACCEPTED);
    }
}