package day02;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest{
    @Test
    void MovieSrviceTestOK(){
        MovieService movieService=new MovieService(Paths.get("src/main/resources/movie.csv"));
        assertEquals("Star Wars",movieService.getMoviesList().get(2).getTitle());
        assertEquals(2002,movieService.getMoviesList().get(3).getYear());
        assertEquals("Steven Spielberg",movieService.getMoviesList().get(4).getDirector());
    }
}