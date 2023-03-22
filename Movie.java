public class Movie {
    private String movieName;
    private int year;
    private String certificate;
    private String genre1;
    private String genre2;
    private String genre3;
    private float rating;
    private int metascore;
    private int duration;
    private int votes;

    public Movie(String[] headers) {

        this.movieName = headers[0];
        this.year = Integer.parseInt(headers[1]);
        this.certificate = headers[2];
        this.genre1 = headers[3];
        this.genre2 = headers[4];
        this.genre3 = headers[5];
        this.rating = Integer.parseInt(headers[6]);
        this.metascore = Integer.parseInt(headers[7]);
        this.duration = Integer.parseInt(headers[8]);
        this.votes = Integer.parseInt(headers[9]);
    }

    public String getMovieName() {
        return movieName;
    }

    public int getYear() {
        return year;
    }

    public String getCertificate() {
        return certificate;
    }

    public String getGenre1() {
        return genre1;
    }

    public String getGenre2() {
        return genre2;
    }

    public String getGenre3() {
        return genre3;
    }

    public float getRating() {
        return rating;
    }

    public int getMetascore() {
        return metascore;
    }

    public int getDuration() {
        return duration;
    }

    public int getVotes() {
        return votes;
    }

    // Setters
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public void setGenre1(String genre1) {
        this.genre1 = genre1;
    }

    public void setGenre2(String genre2) {
        this.genre2 = genre2;
    }

    public void setGenre3(String genre3) {
        this.genre3 = genre3;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setMetascore(int metascore) {
        this.metascore = metascore;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

}
