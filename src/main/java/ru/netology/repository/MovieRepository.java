package ru.netology.repository;

import ru.netology.domain.Movie;

public class MovieRepository {


    private Movie[] movies = new Movie[0];

    public Movie[] findAll() {
        return movies;
    }

    public void save(Movie movie) {                 //добавить новый фильм
        Movie[] tmp = new Movie[movies.length + 1]; //времянка
        for (int i = 0; i < movies.length; i++) {   //переписать из массива во времянку
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;                //добавить новый
        movies = tmp;                               //переписать из времянки
    }

//movie.getId() == id
    public Movie[] findById(int id) {
        Movie[] tmp = new Movie[1];
        int copyToIndex = 0;
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                tmp[copyToIndex] = movie;
                copyToIndex++;
            }

        }
        movies = tmp;
        return movies;

    }

    public void removeById(int id) {
        Movie[] tmp = new Movie[movies.length - 1];
        int copyToIndex = 0;
        for (Movie movie : movies) {
            if (movie.getId() != id) {
                tmp[copyToIndex] = movie;
                copyToIndex++;
            }

        }
        movies = tmp;

    }

    public void removeAll() {
        Movie[] tmp = new Movie[0];
        movies = tmp;

    }
}
