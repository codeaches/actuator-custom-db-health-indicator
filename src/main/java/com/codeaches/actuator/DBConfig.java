package com.codeaches.actuator;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.jdbc.DataSourceHealthIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DBConfig {

  @Value("${spring.smartdb.datasource.driverClassName}")
  String driverClassName;

  @Value("${spring.smartdb.datasource.url}")
  String url;

  @Value("${spring.smartdb.datasource.username}")
  String username;

  @Value("${spring.smartdb.datasource.password}")
  String password;

  @Bean(name = "smartDB")
  public DataSource bdrDataSource() {

    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(driverClassName);
    dataSource.setUrl(url);
    dataSource.setUsername(username);
    dataSource.setPassword(password);
    return dataSource;
  }

  @Value("${spring.smartdb.datasource.validationquery}")
  String validationquery;

  @Bean("smartDBHealthIndicator")
  public HealthIndicator smartDBHealthIndicator(@Autowired @Qualifier("smartDB") DataSource dataSource) {

    DataSourceHealthIndicator indicator = new DataSourceHealthIndicator(dataSource);
    indicator.setQuery(validationquery);
    return indicator;
  }
}
