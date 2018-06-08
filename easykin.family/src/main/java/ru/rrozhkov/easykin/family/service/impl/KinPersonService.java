package ru.rrozhkov.easykin.family.service.impl;

import ru.rrozhkov.easykin.family.db.impl.KinPersonHandler;
import ru.rrozhkov.easykin.family.impl.filter.KinFilterFactory;
import ru.rrozhkov.easykin.model.family.KinType;
import ru.rrozhkov.lib.filter.IFilter;
import ru.rrozhkov.lib.filter.util.FilterUtil;

import java.util.Collection;

/**
 * Created by rrozhkov on 07.06.2018.
 */
public class KinPersonService {
    private static final KinPersonHandler kinPersonHandler = new KinPersonHandler();

    public static Collection persons() {
        Collection collection = null;
        try {
            collection = kinPersonHandler.select();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return collection;
    }

    public static Collection persons(IFilter filter) {
        return FilterUtil.filter(persons(), filter);
    }
}
