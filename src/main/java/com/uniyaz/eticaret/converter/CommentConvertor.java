package com.uniyaz.eticaret.converter;

import com.uniyaz.eticaret.entity.User;

public interface CommentConvertor {
    Long getCommentId();

    String getComment();

    Long getParentID();


    String getUserName();

    String getUserId();

}
