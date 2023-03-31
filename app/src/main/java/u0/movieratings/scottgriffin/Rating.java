package u0.movieratings.scottgriffin;

public class Rating {
    private String movieName;
    private String raterName;
    private int movieRating;

    public Rating(String movieName, String raterName, int movieRating){
        this.movieName = movieName;
        this.raterName = raterName;
        this.movieRating = movieRating;
    }

    public String getMovieName(){
        return movieName;
    }
    public String getRaterName(){
        return raterName;
    }
    public int getMovieRating(){
        return movieRating;
    }

    public String toString(){
        return String.format("Movie Name: %s | Rater Name: %s | Rating: %d", movieName, raterName, movieRating);
    }
}
