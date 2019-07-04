package br.com.gpa.james.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages="br.com.gpa")
@EnableScheduling
public class ApiCoreJamesApplication  {

//	@Autowired
//	private DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(ApiCoreJamesApplication.class, args);
	}


//	@Bean
//	public DataSource dataSource() {
//		return DataSourceBuilder.create().build();
//	}
}


