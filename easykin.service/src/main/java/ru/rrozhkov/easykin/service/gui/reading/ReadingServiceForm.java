package ru.rrozhkov.easykin.service.gui.reading;

import ru.rrozhkov.easykin.core.convert.IConverter;
import ru.rrozhkov.easykin.core.gui.Form;
import ru.rrozhkov.easykin.core.gui.IGUIEditor;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.service.calc2.impl.ReadingBuilder;
import ru.rrozhkov.easykin.service.calc2.impl.Service2Builder;
import ru.rrozhkov.easykin.service.calc2.impl.convert.ServiceConverterFactory;
import ru.rrozhkov.easykin.service.service.impl.ReadingService;

import javax.swing.BoxLayout;
import java.awt.Container;

/**
 * Created by rrozhkov on 4/16/2018.
 */
public class ReadingServiceForm extends Form {
    private static final Service2Builder calc2Builder = Service2Builder.instance();
    private static final ReadingBuilder readingBuilder = ReadingBuilder.instance();
    private static final ReadingService readingService = ReadingService.instance();
    private static final ServiceConverterFactory converterFactory = ServiceConverterFactory.instance();
    private static final IConverter<ServiceCalc,IReading> converter = converterFactory.calcReading();

    private IReading reading;
    private ServiceCalc calc;

    public static Form create(IGUIEditor parent, ServiceCalc serviceCalcBean) {
        Form form = new ReadingServiceForm(parent, serviceCalcBean);
        form.fill();
        return form;
    }

    private ReadingServiceForm(IGUIEditor parent, ServiceCalc serviceCalcBean) {
        super(parent);
        if (serviceCalcBean != null) {
            this.calc = serviceCalcBean;
            this.reading = readingBuilder.build(serviceCalcBean.getReadingId(), serviceCalcBean.getDate());
        } else {
            this.calc = (ServiceCalc)calc2Builder.buildNew();
            this.reading = readingBuilder.buildNew();
        }
    }

    @Override
    public void fill() {
        setLayout(guiFactory.boxLayout(this, BoxLayout.Y_AXIS));
        add(guiFactory.labelEmpty());
        add(ReadingServicePanel.create(calc, reading));
        Container buttonPanel = guiFactory.panelEmpty();
        buttonPanel.setLayout(guiFactory.boxLayout(buttonPanel, BoxLayout.X_AXIS));
        if (!calc.isPaid()) {
            buttonPanel.add(getOkButton());
        } else {
            buttonPanel.add(guiFactory.labelEmpty());
        }
        buttonPanel.add(getCancelButton());
        add(buttonPanel);
    }

    @Override
    protected void ok() {
        if(!validateData())
            return;
        readingService.createOrUpdate(reading);
        parent.refresh();
    }
}
