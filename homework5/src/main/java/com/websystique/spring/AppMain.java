package com.websystique.spring;

import com.websystique.spring.domain.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AppMain {

	private static ApplicationContext context;

	public static void main(String args[]) {
		context = SpringApplication.run(AppMain.class, args);

		// Byname Autowiring
		Application application = (Application) context.getBean("application");
		System.out.println("Application Details : " + application);

		// ByType Autowiring
		Employee employee = (Employee) context.getBean("employee");
		System.out.println("Employee Details : " + employee);

		// By Constructor Autowiring
		Performer performer = (Performer) context.getBean("performer");
		System.out.println("Performer Details : " + performer);

		// Setter Autowiring
		Driver driver = (Driver) context.getBean("driver");
		System.out.println("Driver Details : " + driver);

		Bond bond = (Bond) context.getBean("bond");
		bond.showCar();
	}

}
