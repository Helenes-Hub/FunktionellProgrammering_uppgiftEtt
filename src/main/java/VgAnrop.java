import java.util.List;
import java.util.stream.Collectors;

public class VgAnrop {

    public VgAnrop() {

    }
    public int unique(List<Movie> list, SearchInterface cs) {
        return list
                .stream()
                .map(cs::searchUnique)
                .flatMap(List::stream)
                .collect(Collectors.toSet())
                .size();
    }

    public double highestDigit (List<Movie> list, HighestNumberInterface hn) {
        return list
                .stream()
                .mapToDouble(hn::highestFetcher)
                .max()
                .orElse(0);
    }
    public String bestRated (List<Movie> list, SearchForList sts, HighestNumberInterface hn) {
        //HighestNumberInterface rating= m-> (m).getImdbRating();
        Double bestRating=highestDigit(list, hn);

        return list
                .stream()
                .filter(m -> m.getImdbRating() == bestRating)
                .map(sts::searchList)
                .flatMap(searchlist -> searchlist.stream())
                .collect(Collectors.joining(", "));

    }

}
