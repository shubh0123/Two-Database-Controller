package com.database2.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="Db2entityManagerFactoryBean",
        basePackages= {"com.database2.FacultyRepository"},
        transactionManagerRef="Db2transactionManager"
)
public class Db2Config {

    @Autowired
    private Environment environment;//It read the data inside application.properties file

    @Bean(name = "Db2DataSource")
    @Primary
    public DataSource datasource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setUrl(environment.getProperty("second.datasource.url"));
        dataSource.setDriverClassName(environment.getProperty("second.datasource.driver-class-name"));
        dataSource.setUsername(environment.getProperty("second.datasource.username"));
        dataSource.setPassword(environment.getProperty("second.datasource.password"));


        return dataSource;
    }

    @Bean(name = "Db2entityManagerFactoryBean")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){


        LocalContainerEntityManagerFactoryBean bean=new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(datasource());
        JpaVendorAdapter adapter=new HibernateJpaVendorAdapter();
        bean.setJpaVendorAdapter(adapter);

        //hibernate properties
        HashMap<String, String> property=new HashMap<>();
        property.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
        property.put("hibernate.show_sql","true");
        property.put("hibernate.hbm2ddl.auto","update");
        bean.setJpaPropertyMap(property);
        bean.setPackagesToScan("com.database2.entity.faculty");
        return bean;
    }

    //platformTransactionManager

    @Primary
    @Bean(name = "Db2transactionManager")
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager manager=new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        return manager;
    }


}
