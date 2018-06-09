package ru.rrozhkov.easykin.core.ws.process;

import java.util.Collection;

/**
 * Created by rrozhkov on 2/22/2017.
 */

public interface IProcessor {
    void process();
    Collection result();
    boolean isComplete();
}
