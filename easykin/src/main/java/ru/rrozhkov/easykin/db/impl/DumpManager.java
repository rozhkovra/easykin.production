package ru.rrozhkov.easykin.db.impl;

import ru.rrozhkov.easykin.FilesSettings;
import ru.rrozhkov.easykin.context.MasterDataContext;
import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.category.convert.CategoryInsertConverter;
import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.model.person.impl.convert.PersonInsertConverter;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Status;
import ru.rrozhkov.easykin.model.task.impl.convert.TaskInsertConverter;
import ru.rrozhkov.easykin.model.task.impl.filter.TaskFilterFactory;
import ru.rrozhkov.lib.filter.util.FilterUtil;

import java.io.*;

/**
 * Created by rrozhkov on 6/23/2017.
 */
public class DumpManager {
    public static final String STORAGE = "F:/temp/EasyKin";

    public static void dump(MasterDataContext masterDataContext){
        StringBuilder builder = new StringBuilder();
        CategoryInsertConverter converter = new CategoryInsertConverter();
        for (ICategory category : masterDataContext.categories())
            builder.append(converter.convert(category)+";");
        PersonInsertConverter pConverter = new PersonInsertConverter();
        for (IPerson person : masterDataContext.persons())
            builder.append(pConverter.convert(person)+";");
        TaskInsertConverter tConverter = new TaskInsertConverter();
        for (ITask task : FilterUtil.filter(masterDataContext.tasks(), TaskFilterFactory.status(Status.OPEN)))
            builder.append(tConverter.convert(task)+";");
        writeDump(builder.toString());
    }
    public static void writeDump(String s){
        File sdcard = new File(STORAGE);
        File dumpFile = new File(sdcard, FilesSettings.EASYKIN_DUMP);
        Writer out = null;

        try {
            if(!dumpFile.exists()) {
                dumpFile.mkdirs();
                dumpFile.createNewFile();
            }

            out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(dumpFile), "UTF-8"));
            out.write(s);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (out != null)
                    out.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
