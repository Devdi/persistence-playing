package com.devdi.persistence;

import com.devdi.persistence.Cat;

import javax.transaction.Transactional;

/**
 * Created by devdi on 10/4/14.
 */
public interface CatSaviour {

    void save(Cat cat);
}
