package ru.rrozhkov.lib.ws.process.impl;


import ru.rrozhkov.lib.ws.process.IProcessor;

/**
 * Created by rrozhkov on 2/22/2017.
 */
public abstract class Processor implements IProcessor {
    protected String namespace;
    protected String url;
    protected boolean complete = false;

    public Processor(String namespace, String url) {
        this.namespace = namespace;
        this.url = url;
    }

    public void setComplete(boolean complete){
        this.complete = complete;
    }

    public boolean isComplete() {
        return complete;
    }
}
