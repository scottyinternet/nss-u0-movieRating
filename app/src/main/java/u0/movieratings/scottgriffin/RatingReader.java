package u0.movieratings.scottgriffin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class RatingReader {
    //  F I E L D S
    private String filename;

    //  C O N S T R U C T O R
    public RatingReader(String filename){
        this.filename = filename;
    }

    //  M E T H O D S
    public List<Rating> getAllRatings() throws IOException{
        //create empty list<Rating>
        List<Rating> ratingList = new ArrayList<Rating>();

        // read csv file
        InputStream input = this.getClass().getClassLoader().getResourceAsStream(filename);
        BufferedReader csv = new BufferedReader(new InputStreamReader(input));

        //  iterate through lines
        String line; 
        List<String> movies = new ArrayList<String>();

        boolean firstLine = true;
        while ( (line = csv.readLine()) != null) {
            String[] ratings = line.split(",");
                // case movie titles
            if (firstLine == true){
                movies = Arrays.asList(ratings)  ;
                firstLine = false;
            }   //not movie titles
            else {
                //[Rater Name,The Godfather,The Shawshank Redemption,Schindler's List,Raging Bull,Casablanca,Citizen Kane,Gone with the Wind,The Wizard of Oz,One Flew Over the Cuckoo's Nest,Lawrence of Arabia]
                //[Kora Chene,4,7,8,3,7,1,8,4,4,1]
                String raterName = ratings[0];
                for(int i = 1; i < ratings.length; i++ ){
                    String movieName = movies.get(i);
                    int movieRating = Integer.parseInt(ratings[i]);
                    // populate rating object with local variables
                    Rating rating = new Rating(movieName, raterName, movieRating);
                    //  add to list
                    ratingList.add(rating);
                }
            }
        }

        csv.close();

        return ratingList;
    }
}
