package ru.rrozhkov.easykin.module.impl.convert;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.convert.IConverter;
import ru.rrozhkov.easykin.core.convert.IEntityConverter;
import ru.rrozhkov.easykin.model.module.IModule;
import ru.rrozhkov.easykin.model.module.impl.ModuleFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrozhkov on 10.10.2018.
 */
public class ModuleConverter implements IEntityConverter<IModule> {
    private static final ModuleFactory moduleFactory = ModuleFactory.instance();

    protected ModuleConverter() {
    }

    public String sqlInsert(IModule module) {
        return new IConverter<IModule, String>() {
            public String convert(IModule module) {
                return "INSERT INTO module(id, name) VALUES(" + module.getId()
                        + ", '" + module.getName() + "')";
            }
        }.convert(module);
    }

    public Map<String, Object> map(IModule module) {
        return new IConverter<IModule, Map<String, Object>>() {
            public Map<String, Object> convert(IModule module) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", module.getId());
                map.put("name", module.getName());
                return map;
            }
        }.convert(module);
    }

    public String[] stringArr(Collection<IModule> entries) {
        return new IConverter<Collection<IModule>, String[]>() {
            public String[] convert(Collection<IModule> entries) {
                Collection<String> items = CollectionUtil.create();
                for(IModule module : entries)
                    items.add(module.getName());
                return items.toArray(new String[items.size()]);
            }
        }.convert(entries);
    }

    public IModule entity(ResultSet resultSet) {
        return new IConverter<ResultSet, IModule>() {
            public IModule convert(ResultSet result){
                try{
                    return moduleFactory.module(result.getInt("id"), result.getString("name"));
                }catch(SQLException e){
                    e.printStackTrace();
                }
                return null;
            }
        }.convert(resultSet);
    }
}