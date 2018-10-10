package ru.rrozhkov.easykin.module.impl.convert;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.convert.IConverter;
import ru.rrozhkov.easykin.core.convert.IEntityConverter;
import ru.rrozhkov.easykin.model.module.IPerson2Module;
import ru.rrozhkov.easykin.model.module.impl.ModuleFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrozhkov on 10.10.2018.
 */
public class Person2ModuleConverter implements IEntityConverter<IPerson2Module> {
    private static final ModuleFactory moduleFactory = ModuleFactory.instance();

    protected Person2ModuleConverter() {
    }

    public String sqlInsert(IPerson2Module module) {
        return new IConverter<IPerson2Module, String>() {
            public String convert(IPerson2Module module) {
                return "INSERT INTO module(id, personid, moduleid) VALUES(" + module.getId()
                        + ", " + module.getPersonId() + ", " + module.getModuleId() + ")";
            }
        }.convert(module);
    }

    public Map<String, Object> map(IPerson2Module module) {
        return new IConverter<IPerson2Module, Map<String, Object>>() {
            public Map<String, Object> convert(IPerson2Module module) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", module.getId());
                map.put("personid", module.getPersonId());
                map.put("moduleid", module.getModuleId());
                return map;
            }
        }.convert(module);
    }

    public String[] stringArr(Collection<IPerson2Module> entries) {
        return new IConverter<Collection<IPerson2Module>, String[]>() {
            public String[] convert(Collection<IPerson2Module> entries) {
                Collection<String> items = CollectionUtil.create();
                for(IPerson2Module module : entries)
                    items.add(String.valueOf(module.getId()));
                return items.toArray(new String[items.size()]);
            }
        }.convert(entries);
    }

    public IPerson2Module entity(ResultSet resultSet) {
        return new IConverter<ResultSet, IPerson2Module>() {
            public IPerson2Module convert(ResultSet result){
                try{
                    return moduleFactory.person2Module(result.getInt("id"), result.getInt("personid"), result.getInt("moduleid"));
                }catch(SQLException e){
                    e.printStackTrace();
                }
                return null;
            }
        }.convert(resultSet);
    }
}