package day02;

import day04.Courier;
import day04.Ride;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MovieService {
    List<Movie> MoviesList = new ArrayList<>();


    public MovieService(Path path) {
        List<String> all = readFile(path);
        Movie movie;
        String[] record;
        for (int i=0; i<all.size();i++){
            record=all.get(i).split(";");
            movie=new Movie(record[0],Integer.parseInt(record[1]),record[2]);
            MoviesList.add(movie);
        }
    }


    private List<String> readFile(Path path) {
        try {
            return Files.readAllLines(path);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file: "+path, ioe);
        }
    }
    public List<Movie> getMoviesList() {
        return MoviesList;
    }

}
