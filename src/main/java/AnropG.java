import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AnropG {

    public AnropG (){}

    //Hur många filmer gjordes 1975 (enligt vårt data). Returnera ett tal
    public long countAll(List<Movie> list) {
        return list
                .stream()
                .count();
    }

    //Hitta längden på den film som var längst (högst runtime). Returnera ett tal.
    public double longestMovie (List<Movie> list) {
        return list
                .stream()
                .mapToDouble(Movie::getRuntime)
                .max()
                .orElse(0);
    }

    //Hur många UNIKA genrer hade filmerna från 1975. Returnera ett tal
    public int uniqueGenre (List<Movie> list) {
        return list
                .stream()
                .map(m -> m.getGenres())
                .flatMap(List::stream)
                .collect(Collectors.toSet())
                .size();
    }


    public void bestMovieForTestingPurposes(List<Movie> list){
        double bestRating=
                list
                .stream()
                .mapToDouble(Movie::getImdbRating)
                .max()
                .orElse(0);

                System.out.println( list
                .stream()
                .filter(m -> m.getImdbRating()==bestRating)
                .map(Movie::getTitle)
                .collect(Collectors.toList())+ "\n");
    }

    //Vilka skådisar som spelade i den film som hade högst imdb-rating. Returnera en
    //List<String> med deras namn.
    public List<String> bestRatedActors (List<Movie> list) {
                double bestRating=
                list
                .stream()
                .mapToDouble(Movie::getImdbRating)
                .max()
                .orElse(0);

        return  list
                .stream()
                .filter(m -> m.getImdbRating()==bestRating)
                .map(Movie::getCast)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());

    }

    //Vad är titeln på den film som hade minst antal skådisar listade? Returnera en String.
    public String movieWithLeastActors (List<Movie> list) {

        int lowestCast=
                list
                .stream()
                .mapToInt(m -> m.getCast().size())
                .min()
                .orElse(0);

        return list
                .stream()
                .filter(m -> m.getCast().size() == lowestCast)
                .map(Movie::getTitle)
                .collect(Collectors.joining(", "));
    }



}
