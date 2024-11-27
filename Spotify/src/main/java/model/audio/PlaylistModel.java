package model.audio;

import java.util.ArrayList;
import java.util.Iterator;

public class PlaylistModel implements Iterable<AudioModel> {
    private final String playlistName;
    private final ArrayList <AudioModel> audioList;

    public PlaylistModel(String playlistName) {
        this.playlistName = playlistName;
        audioList = new ArrayList<>();
    }

    //Getter
    public String getPlaylistName() {
        return playlistName;
    }
    public ArrayList<AudioModel> getAudioList() {
        return audioList;
    }


    @Override
    public Iterator iterator() {
        return new Iterator() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < audioList.size();
            }

            @Override
            public AudioModel next() {
                return audioList.get(index++);
            }
        };
    }
}
