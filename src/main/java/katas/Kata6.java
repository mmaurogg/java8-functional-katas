package katas;

import model.Movie;
import util.DataUtil;

import java.util.List;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();

        return movies.stream()
                .map(movie -> movie.getBoxarts())
                .flatMap(boxArt -> boxArt.stream())
                .reduce((box1 ,box2) -> {
                    if ((box1.getHeight() * box1.getHeight()) > (box2.getHeight() * box2.getHeight())){
                        return box1;
                    }
                    return box2;
                }).get().getUrl();
    }
}
