//package com.focuspod.configuration;
//
//
//import jakarta.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(entityManagerFactoryRef = "dbEntityManagerFactory", transactionManagerRef = "dbTransactionManager", basePackages = {
//        "com.focuspod.repository"})
//public class DBConfig {
//    @Bean(name = "dbDataSource")
//    @ConfigurationProperties(prefix = "db.datasource")
//    public DataSource dataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "dbEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean barEntityManagerFactory(EntityManagerFactoryBuilder builder,
//                                                                          @Qualifier("dbDataSource") DataSource dbDataSource) {
//        return builder.dataSource(dbDataSource).packages("com.focuspod.entity").persistenceUnit("dbdata").build();
//    }
//
//    @Bean(name = "dbTransactionManager")
//    public PlatformTransactionManager apzTransactionManager(
//            @Qualifier("dbEntityManagerFactory") EntityManagerFactory apzEntityManagerFactory) {
//        return new JpaTransactionManager(apzEntityManagerFactory);
//    }
//}
