package model.audio;

import model.audio.type.MusicModel;

import java.time.LocalDate;

abstract public class AudioModel implements Comparable<AudioModel>{
    private static int code = 0;
    private final long ID;
    private final String audioName;
    private final String artistName;
    private int numberOfPlays;
    private int numberOfLikes;
    private final LocalDate dateOfRelease;
    private Genre genre;
    private final String link;
    private final String cover;

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
    public void setNumberOfPlays(int numberOfPlays) {
        this.numberOfPlays = numberOfPlays;
    }
    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    @Override
    public String toString(){
        return "audio name: " + audioName + "\tartist name: " + artistName + "\tID: " + ID + "\tgenre: " + genre +
                "\n\tlink: " + link + "\tcover: " + cover + "\tnumber of plays: " + numberOfPlays +
                "\n\tnumber of likes: " + numberOfLikes + "\tdate of release: " + dateOfRelease;
    }

    @Override
    public int compareTo(AudioModel o){
        if(this.audioName.compareTo(o.audioName) == 0){
            return this.getNumberOfLikes() - o.getNumberOfLikes();
        }
        return this.audioName.compareTo(o.audioName);
    }
}
