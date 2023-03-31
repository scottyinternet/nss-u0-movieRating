package u0.movieratings.scottgriffin;

public class Rating {
    private String movieName;
    private String raterName;
    private int movieRating;

    public String toString(){
        return String.format("%s %s %d", movieName, raterName, movieRating);
    }
}
