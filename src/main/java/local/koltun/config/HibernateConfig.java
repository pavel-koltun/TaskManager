package local.koltun.config;

import local.koltun.domain.Task;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:hibernate.properties")
public class HibernateConfig {
    @Bean
    public SessionFactory sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = null;

        try {
            sessionFactoryBean = new LocalSessionFactoryBean();
            sessionFactoryBean.setAnnotatedClasses(Task.class);
            sessionFactoryBean.afterPropertiesSet();
        } catch (Exception e) {
            System.err.println("Error during config hibernate");
            e.printStackTrace();
        }

        return sessionFactoryBean.getObject();
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        return new HibernateTransactionManager(sessionFactory());
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
