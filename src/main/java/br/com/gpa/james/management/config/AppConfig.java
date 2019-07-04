package br.com.gpa.james.management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class AppConfig {

    @Bean
    public DataSource dataSource() throws SQLException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@10.100.10.231:1521:hom1091");
        dataSource.setUsername( "mrs_user" );
        dataSource.setPassword( "cms_109795" );
        //dataSource.setSchema("hom1091");

        return dataSource;
    }

}
