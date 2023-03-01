package ru.netology.manager;

import ru.netology.domain.Movie;

public class Manager {
    private Movie[] movies = new Movie[0];
    private int limitMovies = 10;

    public Manager() {

    }

    public Manager(int limitMovies) {
        this.limitMovies = limitMovies;
    }


    public void save(Movie movie) {                 //добавить новый фильм
        Movie[] tmp = new Movie[movies.length + 1]; //времянка
        for (int i = 0; i < movies.length; i++) {   //переписать из массива во времянку
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;                //добавить новый
        movies = tmp;                               //переписать из времянки
    }

    public Movie[] findAll() {                      //вывод всех фильмов в порядке добавления
        return movies;
    }


    public Movie[] findLast() {
        int resultLenght;
        if (movies.length < limitMovies) {
            resultLenght = movies.length;
        } else {
            resultLenght = limitMovies;
        }
        Movie[] x = new Movie[resultLenght];
        for (int i = 0; i < x.length; i++) {
            x[i] = movies[movies.length - 1 - i];
        }
        return x;
    }


}
