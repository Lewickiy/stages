package com.lewickiy.products.repository;

import com.lewickiy.products.model.Sex;
import com.lewickiy.products.repository.SexRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class SexRepositoryTest {
    @Autowired
    private SexRepository sexRepository;

    @Test
    public void saveSex() {
        Sex sex = new Sex();
        sex.setName("male");
        sexRepository.save(sex);
    }
    @Test
    public void editSex() {
        Optional<Sex> sex = sexRepository.findById(1);
        Sex sexFinded = sex.get();
        sexFinded.setName("female");
        sexRepository.save(sexFinded);

    }

}