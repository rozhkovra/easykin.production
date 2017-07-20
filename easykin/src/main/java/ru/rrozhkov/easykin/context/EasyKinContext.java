package ru.rrozhkov.easykin.context;

/**
 * Created by rrozhkov on 3/21/2017.
 */
public class EasyKinContext implements IContext {
    private MasterDataContext masterDataContext;

    public MasterDataContext masterData(){
        if(masterDataContext==null){
            masterDataContext = new MasterDataContext();
        }
        return masterDataContext;
    }

    public void init() {
        masterData().init();
    }
}
