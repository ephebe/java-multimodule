package com.acme.authorization.infrastructure.configuration;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.acme.authorization.infrastructure.repository",
        entityManagerFactoryRef = "authEntityManagerFactory",
        transactionManagerRef = "authTransactionManager")
public class JpaConfiguration {
    @Bean
    @ConfigurationProperties("spring.datasource.authorization")
    public DataSourceProperties authorizationDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean("authDataSource")
    public DataSource authorizationDataSource() {
        return authorizationDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    @Bean(name = "authEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean authoriEntityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean emfactpry = new LocalContainerEntityManagerFactoryBean();
        emfactpry.setDataSource(authorizationDataSource());
        emfactpry.setPackagesToScan("com.acme.authorization.domain.entities");
        emfactpry.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emfactpry.setJpaProperties(authoriJpaProperties());
        emfactpry.setPersistenceUnitName("auth");
        emfactpry.afterPropertiesSet();
        return emfactpry;
    }


    @Bean(name = "authTransactionManager")
    public PlatformTransactionManager ebTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(authoriEntityManagerFactory().getObject());
        return transactionManager;
    }

    private Properties authoriJpaProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "none");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
        return properties;
    }


}
