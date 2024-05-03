package model.audio;

import java.time.LocalDate;

abstract public class AudioModel {
    private static int code = 0;
    private final long ID;
    private String audioName;
    private String artistName;
    private int numberOfPlays;
    private int numberOfLikes;
    private LocalDate dateOfRelease;
    private Genre genre;
    private String link;
    private String cover;

    public AudioModel(String audioName, String artistName, String genre, String link, String cover) {
        this.audioName = audioName;
        this.artistName = artistName;
        this.numberOfPlays = 0;
        this.numberOfLikes = 0;
        this.dateOfRelease = LocalDate.now();
        this.genre = Genre.valueOf(genre);
        this.link = link;
        this.cover = cover;
        ID = createID();
    }
    private long createID(){
        code++;
        return code;
    }
    //Getter
    public long getID() {
        return ID;
    }
    public String getAudioName() {
        return audioName;
    }
    public String getArtistName() {
        return artistName;
    }
    public int getNumberOfPlays() {
        return numberOfPlays;
    }
    public int getNumberOfLikes() {
        return numberOfLikes;
    }
    public LocalDate getDateOfRelease() {
        return dateOfRelease;
    }
    public Genre getGenre() {
        return genre;
    }
    public String getLink() {
        return link;
    }
    public String getCover() {
        return cover;
    }
    //Setter
    public void setAudioName(String audioName) {
        this.audioName = audioName;
    }
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
    public void setNumberOfPlays(int numberOfPlays) {
        this.numberOfPlays = numberOfPlays;
    }
    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }
    public void setDateOfRelease(LocalDate dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    public void setLink(String link) {
        this.link = link;
    }
    public void setCover(String cover) {
        this.cover = cover;
    }
    @Override
    public String toString(){
        return "audio name: " + audioName + "\tartist name: " + artistName + "\tID: " + ID + "\tgenre: " + genre +
                "\n\tlink: " + link + "\tcover: " + cover + "\tnumber of plays: " + numberOfPlays +
                "\n\tnumber of likes: " + numberOfLikes + "\tdate of release: " + dateOfRelease;
    }
}
