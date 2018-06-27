package ru.rrozhkov.easykin.fatclient.dump;

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
import ru.rrozhkov.easykin.task.impl.convert.TaskConverterFactory;
import ru.rrozhkov.easykin.task.impl.filter.TaskFilterFactory;
import ru.rrozhkov.easykin.task.service.impl.CategoryService;
import ru.rrozhkov.easykin.core.convert.IEntityConverter;
import ru.rrozhkov.easykin.core.filter.IFilter;
import ru.rrozhkov.easykin.core.filter.util.FilterUtil;

import java.io.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 6/23/2017.
 */
public class DumpManager {
    // TODO extract modules
    final private static String STORAGE = "F:/temp/easykin.production";
    final private static ModuleManager moduleManager = ModuleManager.instance();
    final private static AuthManager authManager = AuthManager.instance();
    final private static TaskConverterFactory taskConverterFactory = TaskConverterFactory.instance();
    final private static PersonConverterFactory personConverterFactory = PersonConverterFactory.instance();
    final private static PaymentConverterFactory paymentConverterFactory = PaymentConverterFactory.instance();
    final private static TaskFilterFactory taskFilterFactory = TaskFilterFactory.instance();
    private static final CategoryService categoryService = CategoryService.instance();

    public void dump(){
        StringBuilder builder = new StringBuilder();
        Collection<ICategory> categories = categoryService.categories();
        IEntityConverter converter = taskConverterFactory.category();
        for (ICategory category : categories) {
            builder.append(converter.sqlInsert(category)).append(";");
        }
        Collection<IPerson> persons = (Collection<IPerson>) moduleManager.invoke(Module.PERSON, "persons");
        converter = personConverterFactory.person();
        for (IPerson person : persons)
            builder.append(converter.sqlInsert(person)).append(";");
        IFilter filter = taskFilterFactory.status(Status.OPEN);
        Collection<ITask> tasks = FilterUtil.filter((Collection<ITask>) moduleManager.invoke(Module.TASK, "tasks"), filter);
        converter = taskConverterFactory.task();
        for (ITask task : tasks)
            builder.append(converter.sqlInsert(task)).append(";");
        Collection<IPayment> payments = (Collection<IPayment>) moduleManager.invoke(Module.FIN, "finance");
        converter = paymentConverterFactory.payment();
        for (IPayment payment : payments)
            builder.append(converter.sqlInsert(payment)).append(";");
        writeDump(builder.toString());
    }
    public void writeDump(String s){
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
