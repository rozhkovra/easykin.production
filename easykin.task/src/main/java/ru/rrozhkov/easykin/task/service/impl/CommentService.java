package ru.rrozhkov.easykin.task.service.impl;

import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.task.db.impl.CommentHandler;

/**
 * Created by rrozhkov on 06.06.2018.
 */
public class CommentService {
    private static final CommentHandler commentHandler = new CommentHandler();

    public int createOrUpdate(IComment comment){
        int commentId = comment.getId();
        try{
            if(comment.getId()==-1)
                commentId = commentHandler.insert(comment);
            else
                commentHandler.update(comment);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return commentId;
    }
}
