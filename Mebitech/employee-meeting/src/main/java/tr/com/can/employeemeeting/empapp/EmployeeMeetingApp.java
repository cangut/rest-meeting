package tr.com.can.employeemeeting.empapp;

import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


@SpringBootApplication(scanBasePackages={"tr.com.can.employeemeeting"})
@PropertySources(value = {@PropertySource("classpath:application.properties")})
public class EmployeeMeetingApp {
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeMeetingApp.class, args);
	}
}
