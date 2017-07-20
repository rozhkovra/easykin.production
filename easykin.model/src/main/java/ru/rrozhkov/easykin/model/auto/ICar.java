package ru.rrozhkov.easykin.model.auto;

public interface ICar {
	Brend getBrend();
	Model getModel();
	Body getBody();
	int getYear();
	double getVolume();
}