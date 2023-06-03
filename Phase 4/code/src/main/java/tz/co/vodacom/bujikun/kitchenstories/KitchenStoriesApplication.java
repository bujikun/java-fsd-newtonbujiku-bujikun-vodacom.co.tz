package tz.co.vodacom.bujikun.kitchenstories;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.auditing.CurrentDateTimeProvider;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAccessor;
import java.util.Optional;

@SpringBootApplication
public class KitchenStoriesApplication {
	public static void main(String[] args) {
		SpringApplication.run(KitchenStoriesApplication.class, args);
	}

}
