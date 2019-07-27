package com.TR.TRDashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.TR")
public class TrDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrDashboardApplication.class, args);
	}

}
