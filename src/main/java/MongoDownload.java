
import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;


public class MongoDownload {
    public MongoDownload() {
        AnropG anrop=new AnropG();
        //Skriv in rätt url!
        String uri = "mongodb+srv://helenerydberg:sanna07@cluster0.n1n53.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("sample_mflix");
            MongoCollection<Document> moviesCollection = database.getCollection("movies");

            //Get all movies from 1975
            List<Movie> movieList = new ArrayList<>();
            for (Document doc : moviesCollection.find(new Document("year", 1975))) {
                {
                    movieList.add(Movie.fromDocument(doc));
                }
            }

            // Skriver ut alla filmer
            for (Movie movie : movieList) {
                System.out.println(movie);
            }
            //fråga1
            Long all=anrop.countAll(movieList);
            System.out.println("Question one: \n");
            System.out.println("Total amount of movies: "+ all + "\n");

            //fråga2
            System.out.println("Question two: \n");
            double longestMovie= anrop.longestMovie(movieList);
            System.out.println("Longest runtime in minutes: "+ longestMovie + "\n");

            //fråga3
            System.out.println("Question three: \n");
            int uniqueGenres=anrop.uniqueGenre(movieList);
            System.out.println("Number of unique genres: "+ uniqueGenres + "\n");

            //fråga4
            System.out.println("Question four: \n");
            List <String> bestActors= anrop.bestRatedActors(movieList);
            System.out.println("The actor/s from the top rated movie/s are: "+bestActors);
            System.out.println("from the movie/s: ");
            anrop.bestMovieForTestingPurposes(movieList);

            //fråga5
            System.out.println("Question five: \n");
            String movieWithLowestCast=anrop.movieWithLeastActors(movieList);
            System.out.println("The movie with the lowest amount of actors is: "+movieWithLowestCast+"\n");

            //fråga6
            System.out.println("Question six: \n");

            //Här gör du anrop till alla dina funktioner som ska skriva ut svaren på frågorna som
            //efterfrågas i uppgiften


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MongoDownload m = new MongoDownload();
    }
}