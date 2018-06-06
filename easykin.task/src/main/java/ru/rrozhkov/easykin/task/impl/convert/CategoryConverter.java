package ru.rrozhkov.easykin.task.impl.convert;

import ru.rrozhkov.easykin.model.category.CategoryFactory;
import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.convert.IConverter;
import ru.rrozhkov.lib.convert.IEntityConverter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrozhkov on 07.05.2018.
 */
public class CategoryConverter implements IEntityConverter<ICategory>{
    final static private CategoryFactory categoryFactory = new CategoryFactory();
    protected CategoryConverter() {
    }

    public String sqlInsert(ICategory category) {
        return new IConverter<ICategory, String>() {
            public String convert(ICategory category) {
                return "INSERT INTO category(id, name) VALUES("+category.getId()+", '"+category.getName()+"')";
            }
        }.convert(category);
    }


    public Map<String, Object> map(ICategory category) {
        return new IConverter<ICategory, Map<String, Object>>() {
            public Map<String, Object> convert(ICategory category) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", category.getId());
                map.put("name", category.getName());
                return map;
            }
        }.convert(category);
    }

    public String[] stringArr(Collection<ICategory> categories) {
        return new IConverter<Collection<ICategory>, String[]>() {
            public String[] convert(Collection<ICategory> categories) {
                Collection<String> items = CollectionUtil.create();
                for(ICategory category : categories)
                    items.add(category.getName());
                return items.toArray(new String[items.size()]);
            }
        }.convert(categories);
    }

    public ICategory entity(ResultSet resultSet) {
        return new IConverter<ResultSet, ICategory>() {
            public ICategory convert(ResultSet result){
                try{
                    return categoryFactory.create(result.getInt("id"), result.getString("name"));
                }catch(SQLException e){
                    e.printStackTrace();
                }
                return null;
            }
        }.convert(resultSet);
    }
}
