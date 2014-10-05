package com.devdi.persistence;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by devdi on 7/2/14.
 */
@Configuration
@EnableAutoConfiguration
public class Main {


    public static void main(String[] args) {
        System.out.println("Working with kitties");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        initializeDatabase(applicationContext);
//        findByJdbc(applicationContext);
//        findByHibernate(applicationContext);
        findByJpa(applicationContext);
    }

    private static void findByJpa(ApplicationContext applicationContext) {
        Cat jpaCat = ((CatService) applicationContext.getBean("catJpaService")).getCat(1);
        System.out.println("Received kitty by jpa: " + jpaCat.getName());
    }

    private static void findByHibernate(ApplicationContext applicationContext) {
        Cat hibernateCat = ((CatService) applicationContext.getBean("catHibernateRepository")).getCat(1);
        System.out.println("Received kitty by hibernate: " + hibernateCat);
    }

    private static void findByJdbc(ApplicationContext applicationContext) {
        Cat jdbcCat = ((CatService) applicationContext.getBean("catJdbcRepository")).getCat(1);
        System.out.println("Received kitty by jdbc: " + jdbcCat);
    }

    private static void initializeDatabase(ApplicationContext applicationContext) {
        CatSaviour catJpaService = (CatSaviour) applicationContext.getBean("catJpaService");
        Cat cat = new Cat();
        cat.setName("kitty");
        catJpaService.save(cat);
        System.out.println("Kitty saved");
    }
}
