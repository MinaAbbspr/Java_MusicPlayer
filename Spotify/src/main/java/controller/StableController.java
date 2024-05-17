package controller;

import javafx.scene.control.Control;
import model.Database;
import model.audio.AlbumModel;
import model.audio.AudioModel;
import model.audio.Genre;
import model.user.UserAccountModel;
import model.user.type.artist.ArtistModel;
import model.user.type.artist.type.PodcasterModel;
import model.user.type.artist.type.SingerModel;

import java.time.LocalDate;
import java.util.*;

public class StableController {
    private static StableController stableController;
    private final int maxLength = 12;

    private StableController() {}

    public static StableController getStableController() {
        if(stableController == null)
            stableController = new StableController();
        return stableController;
    }

    public List<ArtistModel> artistsInfo(){
        List<ArtistModel> artists = new ArrayList<>();
        for(UserAccountModel user : Database.getDatabase().getUserAccounts())
            if(user instanceof SingerModel || user instanceof PodcasterModel)
                artists.add((ArtistModel) user);

        return artists;
    }

    public List<AudioModel> artistList(ArtistModel artistModel){
        List<AudioModel> audios = new ArrayList<>();
        if(artistModel instanceof SingerModel){
            for (AlbumModel album : ((SingerModel) artistModel).getAlbumList()){
                for(AudioModel audio : album.getMusicList())
                    audios.add(audio);
            }
        }
        else {
            for(AudioModel audio : ((PodcasterModel)artistModel).getPodcastList()){
                audios.add(audio);
            }
        }
        return audios;
    }
    public int getMaxLength() {
        return maxLength;
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
        Arrays.sort(sorted.toArray());
        return reverse(sorted);
    }
    public List<AudioModel> likeSort(List <AudioModel> audios){
        Comparator <AudioModel> byLike = Comparator.comparingInt(AudioModel::getNumberOfLikes);
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
        List <AudioModel> filtered = audios.stream().filter(a -> a.getArtistName().equals(name)).toList();
        return filtered;
    }
    public List<AudioModel> genreFilter(List <AudioModel> audios, String filter){
        List <AudioModel> filtered = audios.stream().filter(a -> a.getGenre().toString().equals(filter)).toList();
        return filtered;
    }
    public List<AudioModel> dateFilter(List <AudioModel> audios, LocalDate localDate){
        List <AudioModel> filtered = audios.stream().filter(a -> a.getDateOfRelease().equals(localDate)).toList();
        return filtered;
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
