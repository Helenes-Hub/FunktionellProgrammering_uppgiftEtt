import java.util.List;
import static java.util.Arrays.asList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnropGTest {
    //6 movies, one language dupe, one movie title dupe,
    AnropG anropTest=new AnropG();
    final List<Movie> testMovies = List.of(
            new Movie("573a139af29313caabcf1aed", "Pastorali", 1975,
                    List.of("Drama"), "null",
                    List.of("Nana Ioseliani", "Tamar Gabarashvili", "Mikhail Naneishvili"),
                    7.3, List.of("English"), 95),

            new Movie("573a139bf29313caabcf25df", "Iracema - Uma Transa Amazènica", 1975,
                    List.of("Drama"), "null",
                    List.of("Paulo Cèsar Perèio", "Edna de Cèssia", "Lècio Dos Santos", "Elma Martins"),
                    7.0, List.of("Portuguese"), 90),

            new Movie("573a139bf29313caabcf43e5", "Pastorali", 1975,
                    List.of("Drama"), "null",
                    List.of("Nana Ioseliani", "Tamar Gabarashvili", "Mikhail Naneishvili"),
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
    final List<Movie> testMoviesNoDupe = List.of(
            new Movie("573a139af29313caabcf1aed", "Pastorali", 1975,
                    List.of("Drama"), "null",
                    List.of("Nana Ioseliani", "Tamar Gabarashvili", "Mikhail Naneishvili"),
                    7.3, List.of("English"), 95),

            new Movie("573a139bf29313caabcf25df", "Iracema - Uma Transa Amazènica", 1975,
                    List.of("Drama"), "null",
                    List.of("Paulo Cèsar Perèio", "Edna de Cèssia", "Lècio Dos Santos", "Elma Martins"),
                    7.0, List.of("Portuguese"), 90) );
    @Test
    public void countMoviesTest(){
        assertEquals(6, anropTest.countAll(testMovies));
        assertNotEquals(5,anropTest.countAll(testMovies));
        assertNotEquals(7,anropTest.countAll(testMovies));
    }

    @Test
    void longestMovieTest() {
        assertEquals(200, anropTest.longestMovie(testMovies));
        assertNotEquals(0, anropTest.longestMovie(testMovies));
        assertNotEquals(201, anropTest.longestMovie(testMovies));
    }

    @Test
    void uniqueGenreTest() {
        assertEquals(2, anropTest.uniqueGenre(testMovies));
        assertNotEquals(0, anropTest.uniqueGenre(testMovies));
        assertNotEquals(20, anropTest.uniqueGenre(testMovies));
    }

    @Test
    void bestRatedActorsTest() {
        List <String> notBestRatedActors= asList("Shin Saburi", "Mayumi Ogawa", "Keiko Kishi", "Komaki Kurihara");
        List <String> bestRatedActors =asList("Paul Copley", "Pamela Brighton", "Nikolas Simmonds", "Gary Roberts");
        assertEquals(bestRatedActors, anropTest.bestRatedActors(testMovies));
        assertNotEquals(0, anropTest.bestRatedActors(testMovies));
        assertNotEquals(notBestRatedActors, anropTest.bestRatedActors(testMovies));
    }

    @Test
    void movieWithLeastActorsTest() {
        assertEquals("Pastorali, Pastorali", anropTest.movieWithLeastActors(testMovies));
        assertNotEquals("Pastorali", anropTest.movieWithLeastActors(testMovies));
        assertNotEquals(0, anropTest.movieWithLeastActors(testMovies));
    }

    @Test
    void howManyActorsInMultipleMoviesTest() {
        assertEquals(3, anropTest.howManyActorsInMultipleMovies(testMovies));
        assertNotEquals(0, anropTest.howManyActorsInMultipleMovies(testMovies));
        assertNotEquals(20, anropTest.howManyActorsInMultipleMovies(testMovies));
    }

    @Test
    void actorInMostMovies() {
        assertEquals("Mikhail Naneishvili", anropTest.actorInMostMovies(testMovies));
        assertNotEquals("Henry", anropTest.actorInMostMovies(testMovies));
        assertNotEquals(0, anropTest.actorInMostMovies(testMovies));
    }

    @Test
    void uniqueLanguages() {
        assertEquals(5, anropTest.uniqueLanguages(testMovies));
        assertEquals(2, anropTest.uniqueLanguages(testMoviesNoDupe));
        assertNotEquals(3, anropTest.uniqueLanguages(testMoviesNoDupe));
        assertNotEquals(6, anropTest.uniqueLanguages(testMovies));
    }

    @Test
    void dupes() {
        assertTrue(anropTest.dupes(testMovies));
        assertFalse(anropTest.dupes(testMoviesNoDupe));
    }
}
