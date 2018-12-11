package ru.rrozhkov.easykin.task.service.impl;

import ru.rrozhkov.easykin.core.db.impl.EntityHandler;
import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.task.db.impl.TaskHandlerFactory;

/**
 * Created by rrozhkov on 06.06.2018.
 */
public class CommentService {
    private static final EntityHandler commentHandler = TaskHandlerFactory.instance().comment();

    private static class Holder {
        private static final CommentService INSTANCE = new CommentService();
    }

    private CommentService() {
    }

    protected static CommentService instance(){
        return Holder.INSTANCE;
    }

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
