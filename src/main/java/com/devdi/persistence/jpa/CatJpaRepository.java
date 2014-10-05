package com.devdi.persistence.jpa;

import com.devdi.persistence.Cat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by devdi on 8/24/14.
 */
public interface CatJpaRepository extends CrudRepository<Cat, Integer> {

    List<Cat> findByName(int name);
}
