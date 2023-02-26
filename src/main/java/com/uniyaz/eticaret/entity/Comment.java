package com.uniyaz.eticaret.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "userId")
    @org.hibernate.annotations.ForeignKey(name = "fk_comment_user")
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    private Long childID;


    @Override
    public Long getId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getChildID() {
        return childID;
    }

    public void setChildID(Long childID) {
        this.childID = childID;
    }
}
