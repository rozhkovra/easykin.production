package ru.rrozhkov.easykin.family.service.impl;

import ru.rrozhkov.easykin.family.db.impl.KinPersonHandler;
import ru.rrozhkov.easykin.core.filter.IFilter;
import ru.rrozhkov.easykin.core.filter.util.FilterUtil;
import ru.rrozhkov.easykin.family.impl.filter.KinFilterFactory;
import ru.rrozhkov.easykin.model.family.KinType;

import java.util.Collection;

/**
 * Created by rrozhkov on 07.06.2018.
 */
public class KinPersonService {
    private static final KinPersonHandler kinPersonHandler = KinPersonHandler.instance();
    private static final KinFilterFactory kinFilterFactory = KinFilterFactory.instance();

    public static class KinPersonServiceHolder {
        public static final KinPersonService INSTANCE = new KinPersonService();
    }

    public static KinPersonService instance(){
        return KinPersonServiceHolder.INSTANCE;
    }

    public static Collection persons() {
        Collection collection = null;
        try {
            collection = kinPersonHandler.select();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return collection;
    }

    public static Collection kids() {
        IFilter filter = kinFilterFactory.create(new KinType[]{KinType.SUN, KinType.DAUGHTER});
        return persons(filter);
    }

    private static Collection persons(IFilter filter) {
        return FilterUtil.filter(persons(), filter);
    }
}
