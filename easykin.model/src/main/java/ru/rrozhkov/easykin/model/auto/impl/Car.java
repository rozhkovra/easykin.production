package ru.rrozhkov.easykin.model.auto.impl;

import ru.rrozhkov.easykin.model.auto.Body;
import ru.rrozhkov.easykin.model.auto.Brend;
import ru.rrozhkov.easykin.model.auto.ICar;
import ru.rrozhkov.easykin.model.auto.Model;

public class Car implements ICar{
	private Brend brend;
	private Model model;
	private Body body;
	private int year;
	private double volume;
	public Car(Brend brend, Model model, Body body, int year, double volume) {
		this.brend = brend;
		this.model = model;
		this.body = body;
		this.year = year;
		this.volume = volume;
	}
	public Brend getBrend() {
		return brend;
	}
	public Model getModel() {
		return model;
	}
	public Body getBody() {
		return body;
	}
	public int getYear() {
		return year;
	}
	public double getVolume() {
		return volume;
	}
	@Override
	public String toString() {
		return brend + ", " + model + ", " + body
				+ ", " + year + ", " + volume;
	}
}