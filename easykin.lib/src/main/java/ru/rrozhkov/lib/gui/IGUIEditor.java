package ru.rrozhkov.lib.gui;

/**
 * Created by rrozhkov on 2/14/2017.
 */
public interface IGUIEditor {
    int CODE_OK = 1;
    int CODE_CANCEL = 2;
    void edit(Object obj);
    void add();
    void closeEditor(int code);
    void refresh();
}
