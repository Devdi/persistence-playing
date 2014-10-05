package com.devdi.persistence.jpa;

import com.devdi.persistence.Cat;
import com.devdi.persistence.CatSaviour;
import com.devdi.persistence.CatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Created by devdi on 8/24/14.
 */
@Service
public class CatJpaService implements CatService, CatSaviour {

    @Resource
    private CatJpaRepository catJpaRepository;

    @Override
    @Transactional
    public Cat getCat(int id) {
        return catJpaRepository.findOne(id);
    }

    @Override
    @Transactional
    public void save(Cat cat) {
        catJpaRepository.save(cat);
    }
}
