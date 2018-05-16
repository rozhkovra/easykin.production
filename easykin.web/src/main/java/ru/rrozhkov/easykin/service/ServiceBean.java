package ru.rrozhkov.easykin.service;

import ru.rrozhkov.easykin.model.fin.Money;

import java.util.Date;

/**
 * Created by rrozhkov on 14.05.2018.
 */
public class ServiceBean {
    private int num;
    private String name;
    private Date date;
    private Money water;
    private Money hotWater;
    private Money electricity;
    private Money gaz;
    private Money heating;
    private Money antenna;
    private Money intercom;
    private Money house;
    private Money repair;
    private Money itog;
    private Money noPaid;
    private String tdStyle;
    private String serviceClass;

    public ServiceBean(int num, String name, Date date, Money water, Money hotWater,
                       Money electricity, Money gaz, Money heating, Money antenna,
                       Money intercom, Money house, Money repair, Money itog, Money noPaid,
                       String tdStyle, String serviceClass) {
        this.num = num;
        this.name = name;
        this.date = date;
        this.water = water;
        this.hotWater = hotWater;
        this.electricity = electricity;
        this.gaz = gaz;
        this.heating = heating;
        this.antenna = antenna;
        this.intercom = intercom;
        this.house = house;
        this.repair = repair;
        this.itog = itog;
        this.noPaid = noPaid;
        this.tdStyle = tdStyle;
        this.serviceClass = serviceClass;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Money getWater() {
        return water;
    }

    public void setWater(Money water) {
        this.water = water;
    }

    public Money getHotWater() {
        return hotWater;
    }

    public void setHotWater(Money hotWater) {
        this.hotWater = hotWater;
    }

    public Money getElectricity() {
        return electricity;
    }

    public void setElectricity(Money electricity) {
        this.electricity = electricity;
    }

    public Money getGaz() {
        return gaz;
    }

    public void setGaz(Money gaz) {
        this.gaz = gaz;
    }

    public Money getHeating() {
        return heating;
    }

    public void setHeating(Money heating) {
        this.heating = heating;
    }

    public Money getAntenna() {
        return antenna;
    }

    public void setAntenna(Money antenna) {
        this.antenna = antenna;
    }

    public Money getIntercom() {
        return intercom;
    }

    public void setIntercom(Money intercom) {
        this.intercom = intercom;
    }

    public Money getHouse() {
        return house;
    }

    public void setHouse(Money house) {
        this.house = house;
    }

    public Money getRepair() {
        return repair;
    }

    public void setRepair(Money repair) {
        this.repair = repair;
    }

    public Money getItog() {
        return itog;
    }

    public void setItog(Money itog) {
        this.itog = itog;
    }

    public Money getNoPaid() {
        return noPaid;
    }

    public void setNoPaid(Money noPaid) {
        this.noPaid = noPaid;
    }

    public String getTdStyle() {
        return tdStyle;
    }

    public void setTdStyle(String tdStyle) {
        this.tdStyle = tdStyle;
    }

    public String getServiceClass() {
        return serviceClass;
    }

    public void setServiceClass(String serviceClass) {
        this.serviceClass = serviceClass;
    }
}
