package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryTest {
    MovieRepository repo = new MovieRepository();

    Movie one = new Movie(1, "Матрица 1", "fantastic", "none", false);
    Movie two = new Movie(2, "Матрица 2: Перезагрузка", "fantastic", "none", false);
    Movie three = new Movie(3, "Матрица 3: Воскрешение", "fantastic", "none", false);
    Movie four = new Movie(4, "Матрица 4: Воскрешение", "fantastic", "none", true);
    Movie five = new Movie(5, "Бладшот", "action", "none", false);
    Movie six = new Movie(6, "Вперёд", "cartoon", "none", false);
    Movie seven = new Movie(7, "Отель Белград", "comedy", "none", false);
    Movie eight = new Movie(8, "Джентльмены", "action", "none", false);
    Movie nine = new Movie(9, "Человек-невидимка", "scary", "none", false);
    Movie ten = new Movie(10, "Тролли.Мировой тур", "cartoon", "none", true);
    Movie eleven = new Movie(11, "Номер Один", "comedy", "none", true);
    Movie twelve = new Movie(12, "Астрал", "scary", "none", false);


    @BeforeEach
    public void setUp() {
        repo.save(one);
        repo.save(two);
        repo.save(three);
        repo.save(four);
        repo.save(five);
        repo.save(six);
        repo.save(seven);
        repo.save(eight);
        repo.save(nine);
        repo.save(ten);
        repo.save(eleven);
        repo.save(twelve);
    }


    @Test
    public void shouldAddNewMovieAndFindAll() {

        repo.removeById(12);


        Movie[] expected = {one, two, three, four, five, six, seven, eight, nine, ten, eleven};
        Movie[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAll() {

        repo.removeAll();


        Movie[] expected = {};
        Movie[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowById() {


        Movie[] expected = {five};
        Movie[] actual = repo.findById(5);
        Assertions.assertArrayEquals(expected, actual);
    }


}