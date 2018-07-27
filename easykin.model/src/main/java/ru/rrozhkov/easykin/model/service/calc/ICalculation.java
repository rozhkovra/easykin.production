package ru.rrozhkov.easykin.model.service.calc;

import ru.rrozhkov.easykin.core.db.IEntity;
import ru.rrozhkov.easykin.model.fin.IPayable;

public interface ICalculation extends IPayable, IEntity {
	int getId();
	CalculationType getType();
	int getReadingId();
	int getVersion();
}
