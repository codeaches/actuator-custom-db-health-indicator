package com.codeaches.actuator;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DBConfig {

  @Value("${smartdb.ds.driverClassName}")
  String driverClassName;

  @Value("${smartdb.ds.url}")
  String url;

  @Value("${smartdb.ds.username}")
  String username;

  @Value("${smartdb.ds.password}")
  String password;

  @Bean(name = "smartdb")
  public DataSource smartdb() {

    DriverManagerDataSource ds = new DriverManagerDataSource(url, username, password);
    ds.setDriverClassName(driverClassName);
    return ds;
  }
}
