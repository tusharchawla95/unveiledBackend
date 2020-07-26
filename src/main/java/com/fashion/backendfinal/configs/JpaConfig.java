package com.fashion.backendfinal.configs;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import java.util.Properties;


@Configuration
@EnableJpaRepositories(basePackages = {"com.fashion.backendfinal.repositories"}, entityManagerFactoryRef = "entityManager", transactionManagerRef = "transactionManager")
public class JpaConfig {
    @Value("${datasource.url}")
    private String dbUrl;
    @Value("${datasource.username}")
    private String dbUserName;
    @Value("${datasource.password}")
    private String dbPassword;
    @Value("${datasource.driver}")
    private String dbDriver;
    @Value("${datasource.dialect}")
    private String dbDialect;
    @Value("${datasource.max.active}")
    private Integer dbMaxActiveConnections;
    @Value("${datasource.min.idle}")
    private Integer dbMinIdleConnections;
    @Value("${datasource.validation.query}")
    private String dbValidationQuery;
    @Value("${datasource.validation.interval}")
    private Integer dbValidationInterval;
    @Value("${datasource.test.while.idle}")
    private boolean dbIdleTest;
    @Value("${datasource.test.on.borrow}")
    private boolean dbBorrowTest;
    @Value("${datasource.remove.abandoned}")
    private boolean dbremoveAbandoned;

    @Bean(name = "dataSource")
    @Primary
    public DataSource dataSource() {
        DataSource dataSource = new DataSource();
        dataSource.setDriverClassName(dbDriver);
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUserName);
        dataSource.setPassword(dbPassword);
        dataSource.setMaxActive(dbMaxActiveConnections);
        dataSource.setMinIdle(dbMinIdleConnections);
        dataSource.setValidationQuery(dbValidationQuery);
        dataSource.setValidationInterval(dbValidationInterval);
        dataSource.setTestWhileIdle(dbIdleTest);
        dataSource.setTestOnBorrow(dbBorrowTest);
        dataSource.setRemoveAbandoned(dbremoveAbandoned);
        return dataSource;
    }

    @Bean(name = "entityManager")
    @Primary
    public EntityManagerFactory entityManager() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(false);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.fashion.backendfinal.entities");
        factory.setDataSource(dataSource());
        factory.setPersistenceUnitName("entityManager");
        factory.setJpaProperties(getJpaProperties());
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean(name = "transactionManager")
    @Primary
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManager());
        return txManager;
    }

    private Properties getJpaProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", dbDialect);
        return properties;
    }
}