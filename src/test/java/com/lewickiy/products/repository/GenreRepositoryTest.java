package com.lewickiy.products.repository;

import com.lewickiy.products.model.Genre;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(value = false)
class GenreRepositoryTest {
    @Autowired
    private GenreRepository genreRepository;

    @Test
    public void testCreateCategory() {
        Genre genre = new Genre();
        genre.setName("ballet");
        genreRepository.save(genre);
    }
    @Test
    public void testShowCategories() {
        List<Genre> categories = genreRepository.findAll();
        for (Genre genre : categories) {
            System.out.println(genre);
        }
    }

    @Test
    public void testDeleteCategoryById() {
        Integer id = 5;
        Optional<Genre> category = genreRepository.findById(id);
        genreRepository.delete(category.get());
    }
}
