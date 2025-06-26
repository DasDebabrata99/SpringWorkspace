package com.boot.demo.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Controller;

@Controller
public class HealthMonitor implements HealthIndicator{

	public final String service="DBService";
	public boolean isHealthFine() {
		//custom logic
		return false;
	}
	
	@Override
	public Health health() {
		if(isHealthFine()) {
			return Health.up().withDetail(service, "Database service is up and running .. ").build();
		}else {
			return Health.down().withDetail(service, "Database service is down").build();
		}
	}
}