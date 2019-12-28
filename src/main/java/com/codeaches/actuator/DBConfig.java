package com.codeaches.actuator;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
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

  @Bean(name = "smartdb")
  public DataSource smartdb() {

    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setDriverClassName(driverClassName);
    ds.setUsername(username);
    ds.setPassword(password);
    ds.setUrl(url);
    return ds;
  }
}
