package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

public class MovieManager {
    private MovieRepository repo;

    public MovieManager(MovieRepository repo) {
        this.repo = repo;
    }

    public MovieManager(MovieRepository repo, int limitMovies) {
        this.repo = repo;
        this.limitMovies = limitMovies;
    }


    private int limitMovies = 10;


    public void save(Movie item) {
        repo.save(item);
    }


    public Movie[] findAll() {                      //вывод всех фильмов в порядке добавления
        return repo.findAll();
    }


    public Movie[] findLast() {
        Movie[] all = repo.findAll();
        Movie[] reversed = new Movie[all.length];
        int resultLenght;
        if (reversed.length < limitMovies) {
            resultLenght = reversed.length;
        } else {
            resultLenght = limitMovies;
        }
        Movie[] tmp = new Movie[resultLenght];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = all[all.length - 1 - i];
        }
        return tmp;
    }


}