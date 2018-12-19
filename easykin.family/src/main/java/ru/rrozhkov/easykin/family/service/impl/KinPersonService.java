package ru.rrozhkov.easykin.family.service.impl;

import ru.rrozhkov.easykin.core.filter.IFilter;
import ru.rrozhkov.easykin.core.filter.util.FilterUtil;
import ru.rrozhkov.easykin.core.service.impl.EntityService;
import ru.rrozhkov.easykin.family.db.impl.KinPersonHandler;
import ru.rrozhkov.easykin.family.impl.filter.KinFilterFactory;
import ru.rrozhkov.easykin.model.family.KinType;

import java.util.Collection;

/**
 * Created by rrozhkov on 07.06.2018.
 */
public class KinPersonService extends EntityService {
    private static final KinFilterFactory kinFilterFactory = KinFilterFactory.instance();

    private static class Holder {
        private static final KinPersonService INSTANCE = new KinPersonService();
    }

    private KinPersonService() {
        super(KinPersonHandler.instance());
    }

    public static KinPersonService instance(){
        return Holder.INSTANCE;
    }

    public Collection persons() {
        Collection collection = null;
        try {
            collection = findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return collection;
    }

    public Collection kids() {
        IFilter filter = kinFilterFactory.create(new KinType[]{KinType.SUN, KinType.DAUGHTER});
        return persons(filter);
    }

    private Collection persons(IFilter filter) {
        return FilterUtil.filter(persons(), filter);
    }
}
