package com.lewickiy.products.repository;

import com.lewickiy.products.model.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class AuthorRepositoryTest {
    @Autowired
    private AuthorRepository authorRepository;
    @Test
    public void saveAuthor() {
        Author author = new Author();
        author.setFirstname("Hamiku");
        author.setBirthday(Date.valueOf("1990-04-26"));
        authorRepository.save(author);
    }

}