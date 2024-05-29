package view;

import controller.userType.Artist.ArtistController;
import controller.userType.Artist.type.SingerController;
import controller.userType.Listener.type.FreeController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.user.type.AdminModel;
import model.user.type.artist.type.SingerModel;

import java.io.IOException;
import java.time.LocalDate;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        View.getView().setStage(stage);
        View.getView().showMainPage("home.fxml");
    }

    public static void main(String[] args) {
        AdminModel.getAdmin();
        SingerModel singerModel1 = new SingerModel("Adele", "Ad88", "Adele Adkins", "Adele.Adkins@gmail.com", "09945632105", LocalDate.of(1988,5,5) ,"Musician\nadele.com");
        SingerModel singerModel2 = new SingerModel("bad omens", "12345fGGG@", "bad omens band", "bad_omens@gmail.com", "09911039121", LocalDate.of(2004,10,12) ,"BAD OMENS\nCONCRETE\nbadomensofficial.com");
        SingerModel singerModel3 = new SingerModel("Charlie Puth", "1224fGGG@", "Charles Otto Puth", "Charles_Puth@gmail.com", "09910039122", LocalDate.of(1991,12,2) ,"charlieputh.lnk.to/Hero");
        SingerModel singerModel4 = new SingerModel("Sasha Sloan", "slo", "Sasha Alex Sloan", "Sasha_Sloan@gmail.com", "09910039182", LocalDate.of(1995,3,11) ,"voted most creative in\nmy 9th grade yearbook");

        //PodcasterModel podcasterModel = new PodcasterModel("RokhPodcast", "Rp99", "Amir Sodbakhsh", "RokhPodcast@gmail.com", "09456789012", LocalDate.of(1992,3,20),"History lover ☕");

        SingerController.getSingerController().loginArtist("Adele");
        SingerController.getSingerController().publishing("Hello", "Jazz", """
                        Hello, it's me
                        I was wondering if after all these years you'd like to meet
                        To go over everything
                        They say that time's supposed to heal ya, but I ain't done much healing
                        Hello, can you hear me?
                        I'm in California dreaming about who we used to be
                        When we were younger and free
                        I've forgotten how it felt before the world fell at our feet
                        There's such a difference between us
                        And a million miles
                        Hello from the other side
                        I must've called a thousand times
                        To tell you I'm sorry for everything that I've done
                        But when I call, you never seem to be home
                        Hello from the outside
                        At least I can say that I've tried
                        To tell you I'm sorry for breaking your heart
                        But it don't matter, it clearly doesn't tear you apart anymore""",
                "https://ts1.tarafdari.com/contents/user360611/content-sound/adele_-_hello_mytextmusic.com_.mp3",
                HelloApplication.class.getResource("img/cover/hello.png").toExternalForm());
        SingerController.getSingerController().publishing("When we were young", "Pop",
                """
                        Everybody loves the things you do
                        From the way you talk
                        To the way you move
                        Everybody here is watching you
                        'Cause you feel like home
                        You're like a dream come true
                        But if by chance you're here alone
                        Can I have a moment?
                        Before I go?
                        'Cause I've been by myself all night long
                        Hoping you're someone I used to know
                        You look like a movie
                        You sound like a song
                        My God this reminds me, of when we were young
                        Let me photograph you in this light
                        In case it is the last time
                        That we might be exactly like we were
                        Before we realized
                        We were scared of getting old
                        It made us restless
                        It was just like a movie
                        It was just like a song
                        I was so scared to face my fears
                        Nobody told me that you'd be here
                        And I'd swear you moved overseas
                        That's what you said, when you left me""",
                "https://ts15.tarafdari.com/contents/user687779/content-sound/when_we_were_young.mp3",
                HelloApplication.class.getResource("img/cover/when we were young.jpg").toExternalForm());
        SingerController.getSingerController().publishing("Send My Love", "Jazz",
                """
                        This was all you, none of it me
                        You put your hands all over my body and told me, umm
                        You told me you were ready
                        For the big one, for the big jump
                        I'd be your last love everlasting you and me
                        That was what you told me
                        I'm giving you up
                        I've forgiven it allYou set me free
                        Send my love to your new lover
                        Treat her better
                        We've gotta let go of all of our ghosts
                        We both know we ain't kids no more
                        Send my love to your new lover
                        Treat her better
                        We've gotta let go of all of our ghosts
                        We both know we ain't kids no more
                        I was too strong, you were trembling
                        You couldn't handle the hot heat rising (rising), mmm
                        Baby, I'm still rising
                        I was running, you were walking
                        You couldn't keep up, you were falling down (down), mmm
                        There's only one way down""",
                "https://ts2.tarafdari.com/contents/user6984/content-sound/04_-_send_my_love_to_your_new_lover.mp3",
                HelloApplication.class.getResource("img/cover/send my love.jpg").toExternalForm());
        SingerController.getSingerController().publishing("Easy on ME", "Pop", """
                        There ain't no gold in this river
                        That I've been washin' my hands in forever
                        I know there is hope in these waters
                        But I can't bring myself to swim
                        When I am drowning in this silence
                        Baby, let me in
                        Go easy on me, baby
                        I was still a child
                        Didn't get the chance to
                        Feel the world around me
                        I had no time to choose
                        What I chose to do
                        So go easy on me
                        There ain't no room for things to change
                        When we are both so deeply stuck in our ways
                        You can't deny how hard I've tried
                        I changed who I was to put you both first
                        But now I give up
                        Go easy on me, baby
                        I was still a child
                        Didn't get the chance to
                        Feel the world around me
                        Had no time to choose
                        What I chose to do
                        So go easy on me""",
                "https://ts10.tarafdari.com/contents/user493647/content-sound/easy_on_me_-_adele_320.mp3",
                HelloApplication.class.getResource("img/cover/easy on me.jpg").toExternalForm());
        SingerController.getSingerController().publishing("Rolling in the Deep", "Pop", """
            There's a fire starting in my heart
            Reaching a fever pitch and it's bringing me out the dark
            Finally, I can see you crystal clear
            Go ahead and sell me out and I'll lay your shit bare
            See how I'll leave with every piece of you
            Don't underestimate the things that I will do
            There's a fire starting in my heart
            Reaching a fever pitch, and it's bringing me out the dark

            The scars of your love remind me of us
            They keep me thinkin' that we almost had it all
            The scars of your love, they leave me breathless
            I can't help feeling
            We could've had it all
            (You're gonna wish you never had met me)
            Rolling in the deep
            (Tears are gonna fall, rolling in the deep)
            You had my heart inside of your hand
            (You're gonna wish you never had met me)
            And you played it to the beat
            (Tears are gonna fall, rolling in the deep)
            """,
                "https://ts14.tarafdari.com/contents/user837317/content-sound/01_rolling_in_the_deep.mp3",
                HelloApplication.class.getResource("img/cover/deep.jpg").toExternalForm());

        SingerController.getSingerController().loginArtist("bad omens");
        SingerController.getSingerController().publishing("Just Pretend", "Rock",
                """
                        I'm not afraid of the war you've come to wage against my sins
                        I'm not okay, but I can try my best to just pretend
                        So will you wait me out
                        Or will you drown me out?
                        So will you wait me out
                        Or will you drown me out? (at the bottom)
                        I can wait for you at the bottom
                        I can stay away if you want me to
                        I can wait for years if I gotta
                        Heaven knows I ain't getting over you""", "https://ts13.tarafdari.com/contents/user742612/content-sound/bad_omens_-_just_pretend.mp3",
                HelloApplication.class.getResource("img/cover/just pretend.jpg").toExternalForm());
        SingerController.getSingerController().publishing("The Death of Peace of Mind", "Rock",
                """
                        Thought I could make it out
                        Promises break, need to hear you say
                        You're gonna keep it now
                        I miss the way you say my name
                        The way you bend, the way you break
                        Your makeup running down your face
                        The way you touch, the way you taste
                        When the curtains call the time
                        Will we both go home alive?
                        It wasn't hard to realize
                        Love's the death of peace of mind
                        You're in the walls that I made with crosses and frames
                        Hanging upside down
                        For granted, in vain, I took everything
                        I ever cared about"""
                , "https://ts13.tarafdari.com/contents/user823957/content-sound/bad-omens-the-death-of-peace-of-mind.mp3",
                HelloApplication.class.getResource("img/cover/the death of peace of mind.jpg").toExternalForm());
        SingerController.getSingerController().publishing("Take My First", "Rock",
                """
                        Oh God, I tried but I don't know how
                        I want to be someone you used to hate
                        Without the memory of the pain
                        I went too far, now we can't restart
                        It's like we cut the brakes, tore 'em off the car
                        Ninety miles inside the dark
                        Familiar scars, and electric hearts
                        I know I'm gonna die in this bed I made
                        And I'm drowning in a dream that I can't escape
                        If I could wake up I'd hesitate
                        But it's too late to turn back now
                        Oh God, I tried but I don't know how
                        If I could escape it
                        I'd trade in the blame, you can take it
                        If I doesn't take me first
                        If I doesn't take me first""","https://ts15.tarafdari.com/contents/user810598/content-sound/13_-_take_me_first_-_bad_omens_128.mp3",
                HelloApplication.class.getResource("img/cover/take my first.jpg").toExternalForm());

        SingerController.getSingerController().loginArtist("Charlie Puth");
        SingerController.getSingerController().publishing("I love U dangerously", "Pop",
                """
                        This is gonna hurt, but I blame myself first
                        'Cause I ignored the truth
                        Drunk off of that love, it my head up
                        There's no forgetting you
                        You've awoken me, but you're choking me
                        I was so obsessed
                        Gave you all of me
                        And now, honestly, I got nothing left
                        I loved you dangerously
                        More than the air that I breathe
                        Knew we would crash at the speed that we were going
                        Didn't care if the explosion ruined me (me, me)
                        Baby, I loved you dangerously
                        Mm, mm
                        I loved you dangerously
                        Usually, I hold the power with both my hands tied behind my back
                        Look at how things change
                        'Cause now you're the train
                        And I'm tied to the track
                        You've awoken me, but you're choking me
                        I was so obsessed
                        Gave you all of me
                        And now, honestly, I got nothing left
                        'Cause I loved you dangerously
                        More than the air that I breathe
                        Knew we would crash at the speed that we were going
                        Didn't care if the explosion ruined me (me, me)
                        Baby, I loved you dangerously""",
                "https://ts2.tarafdari.com/contents/user478021/content-sound/dangerously_-_charlie_puth.mp3",
                HelloApplication.class.getResource("img/cover/Charlie_Puth_-_Dangerously.jpg").toExternalForm());
        SingerController.getSingerController().publishing("We don't talk anymore ", "Pop", """
                        We don't talk anymore
                        We don't talk anymore
                        We don't talk anymore
                        Like we used to do
                        We don't love anymore
                        What was all of it for?
                        Oh, we don't talk anymore
                        Like we used to do
                        I just heard you found the one you've been looking
                        You've been looking for
                        I wish I would have known that wasn't me
                        'Cause even after all this time, I still wonder
                        Why I can't move on
                        Just the way you did so easily
                        Don't wanna know
                        Kind of dress you're wearing tonight
                        If he's holding onto you so tight
                        The way I did before
                        I overdosed
                        Should've known your love was a game
                        Now I can't get you out of my brain
                        Oh, it's such a shame"""
                ,"https://ts9.tarafdari.com/contents/user678699/content-sound/charlie_puth_-_we_dont_talk_anymore_lyrics_feat._selena_gomez.mp3",
                HelloApplication.class.getResource("img/cover/We_Don't_Talk_Anymore.png").toExternalForm());
        SingerController.getSingerController().publishing("See You Again", "HipHop", """
                     It's been a long day without you, my friend
                     And I'll tell you all about it when I see you again
                     We've come a long way from where we began
                     Oh, I'll tell you all about it when I see you again
                     When I see you again
                     … Damn, who knew?
                     All the planes we flew, good things we been through
                     That I'd be standing right here talking to you
                     'Bout another path, I know we loved to hit the road and laugh
                     But something told me that it wouldn't last
                     Had to switch up, look at things different, see the bigger picture
                     Those were the days, hard work forever pays
                     Now I see you in a better place (see you in a better place)
                     Uh
                     … How can we not talk about family when family's all that we got?
                     Everything I went through, you were standing there by my side
                     And now you gon' be with me for the last ride
                     … It's been a long day without you, my friend
                     And I'll tell you all about it when I see you again (I'll see you again)
                     We've come a long way (yeah, we came a long way)
                     From where we began (you know we started)
                     Oh, I'll tell you all about it when I see you again (I'll tell you)
                     When I see you again
                     … First, you both go out your way and the vibe is feeling strong
                     And what's small turned to a friendship, a friendship turned to a bond
                     And that bond will never be broken, the love will never get lost
                     (The love will never get lost)
                     And when brotherhood come first, then the line will never be crossed
                     Established it on our own when that line had to be drawn
                     And that line is what we reached, so remember me when I'm gone
                     (Remember me when I'm gone)"""
                ,"https://ts1.tarafdari.com/contents/user188286/content-sound/wiz_khalifa_ft._charlie_puth_-_see_you_again.mp3",
                HelloApplication.class.getResource("img/cover/see you again.jpg").toExternalForm());

        ArtistController.getArtistController().loginArtist("Sasha Sloan");
        ArtistController.getArtistController().publishing("Older","Pop", """
                I used to shut my door while my mother screamed in the kitchen
                I'd turn the music up, get high and try not to listen
                To every little fight, 'cause neither one was right
                I swore I'd never be like them
                But I was just a kid back then
                The older I get the more that I see
                My parents aren't heroes, they're just like me
                And loving is hard, it don't always work
                You just try your best not to get hurt
                I used to be mad but now I know
                Sometimes it's better to let someone go
                It just hadn't hit me yet
                The older I get
                I used to wonder why, why they could never be happy
                I used to close my eyes and pray for a whole 'nother family
                Where everything was fine, one that felt like mine
                I swore I'd never be like them
                But I was just a kid back then
                The older I get the more that I see
                My parents aren't heroes, they're just like me
                And loving is hard, it don't always work
                You just try your best not to get hurt
                I used to be mad but now I know
                Sometimes it's better to let someone go
                It just hadn't hit me yet
                The older I get
                The older I get the more that I see
                My parents aren't heroes, they're just like me
                And loving is hard, it don't always work
                You just try your best not to get hurt
                I used to be mad but now I know
                Sometimes it's better to let someone go
                It just hadn't hit me yet
                The older I get
                ""","https://ts12.tarafdari.com/contents/user677085/content-sound/sasha_sloan_-_older.mp3",
                HelloApplication.class.getResource("img/cover/older.jpg").toExternalForm());
        ArtistController.getArtistController().publishing("Dancing With Your Ghost", "Pop",
        """
                Yelling at the sky
                Screaming at the world
                Baby, why'd you go away?
                I'm still your girl
                Holding on too tight
                Head up in the clouds
                Heaven only knows where you are now
                How do I love, how do I love again?
                How do I trust, how do I trust again?
                I stay up all night, tell myself I'm alright
                Baby, you're just harder to see than most
                I put the record on, wait 'til I hear our song
                Every night, I'm dancing with your ghost
                Every night, I'm dancing with your ghost
                Never got the chance
                To say a last goodbye
                I gotta move on
                But it hurts to try
                How do I love, how do I love again?
                How do I trust, how do I trust again?
                I stay up all night, tell myself I'm alright
                Baby, you're just harder to see than most
                I put the record on, wait 'til I hear our song
                Every night, I'm dancing with your ghost
                Every night, I'm dancing with your ghost
                How do I love, how do I love again?
                How do I trust, how do I trust again?
                I stay up all night, tell myself I'm alright
                Baby, you're just harder to see than most
                I put the record on, wait 'til I hear our song
                Every night, I'm dancing with your ghost
                Every night, I'm dancing with your ghost
                Every night, I'm dancing with your ghost""",
                "https://ts10.tarafdari.com/contents/user768849/content-sound/sasha-sloan-dancing-with-your-ghost.mp3",
                HelloApplication.class.getResource("img/cover/dancing.jpg").toExternalForm());
        ArtistController.getArtistController().publishing("Is It Just Me","Pop",
                """
                    Is it just me?
                    Is it just me?
                    I hate holding babies and people tryna save me
                    Think religion is a business where you pay for God's forgiveness
                    Modern art is borin', politicians are annoyin'
                    I don't think love lasts forever and old music was better
                    Am I just high
                    Or am I kinda right?
                    Is it just me or does anybody
                    Feel the way that I feel?
                    They're just not being real
                    Tell me, is it just me or is anybody
                    Thinking all the same shit?
                    They're just not saying it
                    Or is it just me?
                    Is it just me?
                    (Is it just me?)
                    Weddings are outdated, the show 'Friends' was overrated
                    I think rich kids have it easy and PDA is creepy
                    The internet's obnoxious, people my age make me nauseous
                    I think marijuana's classy and doing coke is trashy
                    Am I just high
                    Or am I kinda right?
                    Is it just me or does anybody
                    Feel the way that I feel?
                    They're just not being real
                    Tell me, is it just me or is anybody
                    Thinking all the same shit?
                    They're just not saying it
                    Or is it just me?
                    Is it just me?""","https://ts13.tarafdari.com/contents/user627598/content-sound/sasha_sloan_-_is_it_just_me.mp3",
                HelloApplication.class.getResource("img/cover/is it.jpg").toExternalForm());
        ArtistController.getArtistController().publishing("Hero", "Pop", """
                Been here before, it's in my muscle memory
                I'm pretty sure I recognize you
                There is somethin' in your eyes
                Won't let you get away tonight
                You leave me in the dark
                I'm stumblin' around like I'm a question mark
                Wonderin' if you're around to catch me if I fall
                If I come crashin' to the wall
                Will you light me up, jumpstart my heart?
                I need someone before the sun goes down
                Who's gonna save me now?
                Some kind of hero
                I can't breathe
                Hopin' you're here to rescue me
                Before the sun goes down
                Who's gonna save me now?
                Some kind of hero
                Been here before, it's in my muscle memory
                I'm pretty sure I've felt this energy
                There's somethin' in your touch
                Somethin' reminded me of us
                Will you light me up, jumpstart my heart?
                I need someone before the sun goes down
                Who's gonna save me now?
                Some kind of hero
                I can't breathe
                Hopin' you're here to rescue me
                Before the sun goes down
                Who's gonna save me now?
                Some kind of hero
                Some kind of hero
                Da, da-da, da-da
                Da-da-da-da-da-da-da
                Da-da, da-da, da-da-da-da-da-da""",
                "https://ts14.tarafdari.com/contents/user804506/content-sound/alan_walker_-_hero.mp3",
                HelloApplication.class.getResource("img/cover/Hero.jpg").toExternalForm());

        FreeController.getFreeController().signupListener("Mina","mnbbspr","Mina Abbaspour", "Mina@gmail.com","09133138555",LocalDate.of(2005,1,2));

        launch();
    }
}