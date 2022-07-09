package katas;

import com.google.common.collect.ImmutableMap;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.stream.Collectors;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4 {
    public static List<Object> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists.stream()
                .map(movie -> movie.getVideos())
                .flatMap(videos -> videos.stream()
                        .map(video -> ImmutableMap.of(
                                "id", video.getId(),
                                "title", video.getTitle(),
                                "boxart", video.getBoxarts().stream()
                                        .filter(boxArt -> (boxArt.getWidth() == 150.0 && boxArt.getHeight() == 200.0 )))))
                .collect(Collectors.toList());
    }
}
