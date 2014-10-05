package com.devdi.persistence.hibernate;

import com.devdi.persistence.Cat;
import com.devdi.persistence.CatService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by devdi on 8/22/14.
 */
@Repository
public class CatHibernateRepository implements CatService {

    private final SessionFactory sessionFactory;

    @Autowired
    public CatHibernateRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public Cat getCat(int id) {
        return (Cat) currentSession().get(Cat.class, id);
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }
}
