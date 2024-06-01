package controller;

import model.Database;
import model.audio.AudioModel;
import model.audio.Genre;

import java.time.LocalDate;
import java.util.*;

public class AudioController {
    private static AudioController audioController;
    private AudioModel audio;
    private AudioController() {}

    public static AudioController getAudioController() {
        if(audioController == null)
            audioController = new AudioController();
        return audioController;
    }

    public AudioModel getAudio() {
        return audio;
    }

    public void setAudio(AudioModel audio) {
        this.audio = audio;
    }
    public int getMaxLength() {
        return 12;
    }

    //جست و جو
    public List<AudioModel> search(String name){
        List <AudioModel> result1 =new ArrayList<>(Database.getDatabase().getAudios()
                .stream().filter(n -> n.getArtistName().equals(name)).toList());
        List <AudioModel> result2 = Database.getDatabase().getAudios()
                .stream().filter(n -> n.getAudioName().equals(name)).toList();
        result1.addAll(result2);
        return result1;
    }

    //مرتب سازی
    public List<AudioModel> sort(List <AudioModel> sorted){
        Collections.sort(sorted);
        return sorted;
    }
    public List<AudioModel> likeSort(List <AudioModel> audios){
        Comparator<AudioModel> byLike = Comparator.comparingInt(AudioModel::getNumberOfLikes);
        List <AudioModel> sorted = audios.stream().sorted(byLike).toList();
        return reverse(sorted);
    }
    public List<AudioModel> playSort(List <AudioModel> audios){
        Comparator <AudioModel> byPlay = Comparator.comparingInt(AudioModel::getNumberOfPlays);
        List <AudioModel> sorted = audios.stream().sorted(byPlay).toList();
        return reverse(sorted);
    }
    private List<AudioModel> reverse (List<AudioModel> list){
        ArrayList<AudioModel> reverse = new ArrayList<>();
        for (int i=list.size()-1; i>=0; i--)
            reverse.add(list.get(i));

        return reverse;
    }

    //فیلتر
    public List<AudioModel> artistFilter (List <AudioModel> audios, String name){
        return audios.stream().filter(a -> a.getArtistName().equals(name)).toList();
    }
    public List<AudioModel> genreFilter(List <AudioModel> audios, String filter){
        return audios.stream().filter(a -> a.getGenre().equals(Genre.valueOf(filter))).toList();
    }
    public List<AudioModel> dateFilter(List <AudioModel> audios, LocalDate localDate){
        return audios.stream().filter(a -> a.getDateOfRelease().equals(localDate)).toList();
    }
    public List<AudioModel> twoDateFilter(List <AudioModel> audios, LocalDate firstDate , LocalDate secondDate){
        List<AudioModel> filtered = new ArrayList<>();
        int day = 0;
        while (!secondDate.isBefore(firstDate.plusDays(day))){
            filtered.addAll(dateFilter(audios , firstDate.plusDays(day)));
            day ++;
        }
        return filtered;
    }

    public boolean isGenre(String genreName){
        ArrayList<String> genres = new ArrayList<>();
        genres.add(Genre.TrueCrime.toString());
        genres.add(Genre.Rock.toString());
        genres.add(Genre.Pop.toString());
        genres.add(Genre.Jazz.toString());
        genres.add(Genre.HipHop.toString());
        genres.add(Genre.Country.toString());
        genres.add(Genre.Society.toString());
        genres.add(Genre.InterView.toString());
        genres.add(Genre.History.toString());

        return genres.contains(genreName);
    }
}
