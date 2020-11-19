package com.moviedb.webservice_MovieDB.controller;

import com.moviedb.webservice_MovieDB.model.MovieDB;
import com.moviedb.webservice_MovieDB.parsing.PopularMovie;
import org.jdom2.JDOMException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@RestController
public class MovieDBController {

    @GetMapping("/getmovie/{movieid}")
    public MovieDB getMovieById (@PathVariable("movieid") int movidId) throws Exception
    {

        MovieDB movieDB = new MovieDB();
        RestTemplate restTemplate = new RestTemplate();
        movieDB = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movidId + "?api_key=05e00aec1b6318f6f5a4702d18a8f725", MovieDB.class);

        return movieDB;
    }


    @GetMapping("/movie/top_rated")
    public List getTopRating () throws JDOMException, IOException {

        RestTemplate restTemplate = new RestTemplate();
        String rawData = restTemplate.getForObject("https://api.themoviedb.org/3/movie/top_rated?api_key=05e00aec1b6318f6f5a4702d18a8f725", String.class);

        System.out.println(rawData);

        PopularMovie pm = new PopularMovie();
        List list = pm.getPopularMovies(rawData);
        return list;
    }



}
