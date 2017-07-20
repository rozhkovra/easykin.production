package ru.rrozhkov.easykin.ws;

import ru.rrozhkov.easykin.ws.auth.EasyKinAuthService;
import ru.rrozhkov.easykin.ws.task.EasyKinTaskService;

import javax.xml.ws.Endpoint;

public class EasyKinPublisher {
	public static void main(String[] args){
		String ip = "172.31.46.6";
		System.out.println("Publish EasyKinService: http://" + ip + ":8081/EasyKinService/");
		Endpoint.publish("http://" + ip + ":8081/EasyKinService/", new EasyKinService());
		System.out.println("Publish EasyKinService: http://" + ip + ":8081/EasyKinService/auth");
		Endpoint.publish("http://"+ip+":8081/EasyKinService/auth", new EasyKinAuthService());
		System.out.println("Publish EasyKinService: http://"+ip+":8081/EasyKinService/task");
		Endpoint.publish("http://"+ip+":8081/EasyKinService/task", new EasyKinTaskService());
	}
}