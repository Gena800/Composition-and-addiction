package ru.netology.manager;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

import static org.mockito.Mockito.*;

class MovieManagerTest {
    MovieRepository repo = Mockito.mock(MovieRepository.class);
    MovieManager manager = new MovieManager(repo);
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


    @Test
    public void shouldAddNewMovieAndFindAll() {
        Movie[] movies = {one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve};
        doReturn(movies).when(repo).findAll();


        Movie[] expected = {one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve};
        Movie[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLast() {
        Movie[] movies = {one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve};
        doReturn(movies).when(repo).findAll();


        Movie[] expected = {twelve, eleven, ten, nine, eight, seven, six, five, four, three};
        Movie[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindLastLessLimit() {
        Movie[] movies = {nine, ten, eleven, twelve};
        doReturn(movies).when(repo).findAll();


        Movie[] expected = {twelve, eleven, ten, nine};
        Movie[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindLastFive() {
        MovieManager manager = new MovieManager(repo, 5);
        Movie[] movies = {one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve};
        doReturn(movies).when(repo).findAll();


        Movie[] expected = {twelve, eleven, ten, nine, eight};
        Movie[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void ShouldFindLastIfFour() {
        MovieManager manager = new MovieManager(repo, 5);
        Movie[] movies = {one, two, three, four};
        doReturn(movies).when(repo).findAll();

        Movie[] expected = {four, three, two, one};
        Movie[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }


}