package ru.netology.manager;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    Manager manager = new Manager();

    Movie one = new Movie("matrix1", "Матрица 1", "fantastic", "none", false);
    Movie two = new Movie("matrix2", "Матрица 2: Перезагрузка", "fantastic", "none", false);
    Movie three = new Movie("matrix3", "Матрица 3: Воскрешение", "fantastic", "none", false);
    Movie four = new Movie("matrix4", "Матрица 4: Воскрешение", "fantastic", "none", true);
    Movie five = new Movie("bloodshot", "Бладшот", "action", "none", false);
    Movie six = new Movie("forward", "Вперёд", "cartoon", "none", false);
    Movie seven = new Movie("hotel-belgrade", "Отель Белград", "comedy", "none", false);
    Movie eight = new Movie("gentlemen", "Джентльмены", "action", "none", false);
    Movie nine = new Movie("invisible-man", "Человек-невидимка", "scary", "none", false);
    Movie ten = new Movie("trolls-world-tour", "Тролли.Мировой тур", "cartoon", "none", true);
    Movie eleven = new Movie("number-one", "Номер Один", "comedy", "none", true);
    Movie twelve = new Movie("astral", "Астрал", "scary", "none", false);


    @Test
    public void shouldAddNewMovieAndFindAll() {
        manager.save(one);
        manager.save(two);
        manager.save(three);
        manager.save(four);
        manager.save(five);
        manager.save(six);
        manager.save(seven);
        manager.save(eight);
        manager.save(nine);
        manager.save(ten);
        manager.save(eleven);
        manager.save(twelve);


        Movie[] expected = {one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve};
        Movie[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLast() {
        manager.save(one);
        manager.save(two);
        manager.save(three);
        manager.save(four);
        manager.save(five);
        manager.save(six);
        manager.save(seven);
        manager.save(eight);
        manager.save(nine);
        manager.save(ten);
        manager.save(eleven);
        manager.save(twelve);

        Movie[] expected = {twelve, eleven, ten, nine, eight, seven, six, five, four, three};
        Movie[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindLastLessLimit() {

        manager.save(nine);
        manager.save(ten);
        manager.save(eleven);
        manager.save(twelve);

        Movie[] expected = {twelve, eleven, ten, nine};
        Movie[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindLastFive() {
        Manager manager = new Manager();
        manager.save(one);
        manager.save(two);
        manager.save(three);
        manager.save(four);
        manager.save(five);
        manager.save(six);
        manager.save(seven);
        manager.save(eight);
        manager.save(nine);
        manager.save(ten);
        manager.save(eleven);
        manager.save(twelve);

        Movie[] expected = {twelve, eleven, ten, nine, eight};
        Movie[] actual = manager.findLast(5);
        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void shouldFindLastFiveIfFour() {
        Manager manager = new Manager();

        manager.save(nine);
        manager.save(ten);
        manager.save(eleven);
        manager.save(twelve);

        Movie[] expected = {twelve, eleven, ten, nine};
        Movie[] actual = manager.findLast(5);
        Assertions.assertArrayEquals(expected, actual);

    }


}