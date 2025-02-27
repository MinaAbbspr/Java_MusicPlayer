package controller.user.userType.artist.type;

import controller.user.userType.artist.ArtistController;
import model.Database;
import model.audio.AudioModel;
import model.audio.type.PodcastModel;
import model.user.UserAccountModel;
import model.user.type.artist.ArtistModel;
import model.user.type.artist.type.PodcasterModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PodcasterController extends ArtistController {
    private PodcasterModel podcaster;
    private static PodcasterController podcasterController;

    private PodcasterController() {
        super();
    }

    public PodcasterModel getPodcaster() {
        return podcaster;
    }
    public void setPodcaster(PodcasterModel podcaster) {
        this.podcaster = podcaster;
    }
    public static PodcasterController getPodcasterController() {
        if(podcasterController == null)
            podcasterController = new PodcasterController();
        return podcasterController;
    }

    @Override
    public void loginArtist(String username){
        for(UserAccountModel user : Database.getDatabase().getUserAccounts())
            if(username.equals(user.getUserName())) {
                ArtistController.getArtistController().setArtist((ArtistModel) user);
                setPodcaster((PodcasterModel) user);
                setArtistController(this);
                break;
            }
    }
    @Override
    public void signupArtist(String userName, String password, String name, String email, String phoneNumber, LocalDate birthDate, String bio){
        PodcasterModel podcasterModel = new PodcasterModel(userName, password, name, email, phoneNumber, birthDate,bio);
        setPodcaster(podcasterModel);
        setArtist(podcasterModel);
    }
    @Override
    //پلی شدن آثار
    public int showNumberOfPlayed(){
        int counter = 0;
        for(PodcastModel podcast : getPodcaster().getPodcastList())
            counter += podcast.getNumberOfPlays();

        return counter;
    }
    @Override
    //محاسبه درآمد
    public String calculateEarnings(){
        getPodcaster().setIncome( showNumberOfPlayed() * 0.5);
        return "your income is "+ getPodcaster().getIncome() + " dollars" ;
    }
    @Override
    //انتشار پادکست
    public String publishing(String audioName, String genre, String caption, String link, String cover){
        if(audioName.isEmpty() || genre.isEmpty() || caption.isEmpty() || link.isEmpty() || cover.isEmpty())
            throw new NullPointerException("write all information");

        PodcastModel podcast = new PodcastModel(audioName,getPodcaster().getUserName(),genre,link,cover,caption);
        getPodcaster().getPodcastList().add(podcast);
        return "podcast published successfully";
    }

    @Override
    public List<AudioModel> getAudios(){
        return new ArrayList<>(getPodcaster().getPodcastList());
    }
}
