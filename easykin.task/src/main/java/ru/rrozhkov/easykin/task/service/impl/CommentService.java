package ru.rrozhkov.easykin.task.service.impl;

import ru.rrozhkov.easykin.core.service.impl.EntityService;
import ru.rrozhkov.easykin.task.db.impl.TaskHandlerFactory;

/**
 * Created by rrozhkov on 06.06.2018.
 */
public class CommentService extends EntityService{
    private static class Holder {
        private static final CommentService INSTANCE = new CommentService();
    }

    private CommentService() {
        super(TaskHandlerFactory.instance().comment());
    }

    static CommentService instance(){
        return Holder.INSTANCE;
    }
}
