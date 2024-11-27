package controller;

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
}
