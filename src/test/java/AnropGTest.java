import java.util.List;
import static java.util.Arrays.asList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnropGTest {
    //6 movies, one language dupe, one movie title dupe,
    AnropG anropTest=new AnropG();
    List<Movie> testMovies = List.of(
            new Movie("573a139af29313caabcf1aed", "Pastorali", 1975,
                    List.of("Drama"), "null",
                    List.of("Nana Ioseliani", "Tamar Gabarashvili", "Mikhail Naneishvili", "Nukri Davitashvili"),
                    7.3, List.of("English"), 95),

            new Movie("573a139bf29313caabcf25df", "Iracema - Uma Transa Amazènica", 1975,
                    List.of("Drama"), "null",
                    List.of("Paulo Cèsar Perèio", "Edna de Cèssia", "Lècio Dos Santos", "Elma Martins"),
                    7.0, List.of("Portuguese"), 90),

            new Movie("573a139bf29313caabcf43e5", "Pastorali", 1975,
                    List.of("Drama"), "null",
                    List.of("Nana Ioseliani", "Tamar Gabarashvili", "Mikhail Naneishvili", "Nukri Davitashvili"),
                    7.3, List.of("Georgian"), 95),

            new Movie("573a139bf29313caabcf4631", "Kaseki", 1975,
                    List.of("Drama"), "null",
                    List.of("Shin Saburi", "Mayumi Ogawa", "Keiko Kishi", "Komaki Kurihara"),
                    7.7, List.of("Japanese"), 200),

            new Movie("573a139cf29313caabcf7dd6", "Days of Hope", 1975,
                    List.of("Drama"), "null",
                    List.of("Paul Copley", "Pamela Brighton", "Nikolas Simmonds", "Gary Roberts"),
                    8.2, List.of("English"), 90),

            new Movie("573a139ef29313caabcfc154", "Yuppi du", 1975,
                    List.of("Comedy", "Drama"), "null",
                    List.of("Claudia Mori", "Charlotte Rampling", "Gino Santercole", "Adriano Celentano"),
                    6.2, List.of("Italian"), 120)
    );
    @Test
    public void countMoviesTest(){
        assertEquals(6, anropTest.countAll(testMovies));
        assertNotEquals(5,anropTest.countAll(testMovies));
        assertNotEquals(7,anropTest.countAll(testMovies));
    }

    @Test
    void longestMovie() {
    }

    @Test
    void uniqueGenre() {
    }

    @Test
    void bestMovieForTestingPurposes() {
    }

    @Test
    void bestRatedActors() {
    }

    @Test
    void movieWithLeastActors() {
    }

    @Test
    void howManyActorsInMultipleMovies() {
    }

    @Test
    void actorInMostMovies() {
    }

    @Test
    void uniqueLanguages() {
    }

    @Test
    void dupes() {
    }
}
