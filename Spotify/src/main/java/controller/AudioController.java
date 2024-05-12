package controller;

import model.Database;
import model.audio.AudioModel;

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

    public void findAudio(long ID){
        for(AudioModel audio : Database.getDatabase().getAudios())
            if(audio.getID() == ID)
                this.audio = audio;
    }
}
