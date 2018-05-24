package ru.rrozhkov.easykin.db.impl;

import ru.rrozhkov.easykin.FilesSettings;
import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Status;
import ru.rrozhkov.easykin.module.Module;
import ru.rrozhkov.easykin.module.ModuleManager;
import ru.rrozhkov.easykin.payment.impl.convert.PaymentConverterFactory;
import ru.rrozhkov.easykin.person.auth.AuthManager;
import ru.rrozhkov.easykin.person.impl.convert.PersonConverterFactory;
import ru.rrozhkov.easykin.task.db.impl.CategoryHandler;
import ru.rrozhkov.easykin.task.impl.convert.TaskConverterFactory;
import ru.rrozhkov.easykin.task.impl.filter.TaskFilterFactory;
import ru.rrozhkov.lib.filter.util.FilterUtil;

import java.io.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 6/23/2017.
 */
public class DumpManager {
    public static final String STORAGE = "F:/temp/EasyKin";

    public static void dump(){
        StringBuilder builder = new StringBuilder();
        try {
            for (ICategory category : CategoryHandler.select())
                builder.append(TaskConverterFactory.category().sqlInsert(category)+";");
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (IPerson person : (Collection<IPerson>) ModuleManager.invoke(Module.PERSON, "persons"))
            builder.append(PersonConverterFactory.person().sqlInsert(person)+";");
        for (ITask task : FilterUtil.filter((Collection<ITask>) ModuleManager.invoke(Module.TASK, "tasks", AuthManager.instance().signedPerson()), TaskFilterFactory.status(Status.OPEN)))
            builder.append(TaskConverterFactory.task().sqlInsert(task)+";");
        for (IPayment payment : (Collection<IPayment>) ModuleManager.invoke(Module.FIN, "finance"))
            builder.append(PaymentConverterFactory.payment().sqlInsert(payment)+";");
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
