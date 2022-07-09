package katas;

import com.google.common.collect.ImmutableList;
import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.stream.Collectors;

/*
    Goal: Chain filter() and map() to collect the ids of videos that have a rating of 5.0
    DataSource: DataUtil.getMovies()
    Output: List of Integers
*/
public class Kata2 {
    public static List<ImmutableList<Integer>> execute() {
        List<Movie> movies = DataUtil.getMovies();

        return movies.stream()
                .filter(movie -> movie.getRating() == 5.0)
                .map(movie ->  ImmutableList.of( movie.getId()))
                .collect(Collectors.toList());
    }
}
