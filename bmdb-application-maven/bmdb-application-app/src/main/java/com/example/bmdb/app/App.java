package com.example.bmdb.app;

import com.example.bmdb.domain.Media;
import com.example.bmdb.domain.Rating;
import com.example.bmdb.domain.Review;
import com.example.bmdb.domain.User;
import com.example.bmdb.service.*;
import com.example.bmdb.view.View;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class App {
    private static Logger logger = LoggerFactory.getLogger(App.class);
    @Autowired
    private ActorService actorService;
    @Autowired
    private MediaService mediaService;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private UserService userService;
    @Autowired
    private CreateBasicData createBasicData;
    @Autowired
    private View view;
    private boolean stillRunning = true;

    private Review review;
    private List<Media> medias;
    private Media selectedMedia;
    private User currentUser;

    public App() {
        this.medias = new ArrayList<>();
    }

    public void launch() {
        logger.info("app launched");
        this.createBasicData.CreateData();
        this.medias.addAll(this.mediaService.findAllMedia());

        this.view.PrintWelcomeMessage();
        User newUser = this.view.ReadUserData();
        this.userService.saveUser(newUser);
        logger.info("user created");

        while(this.stillRunning == true){
            this.view.PrintMedias(this.mediaService.findAllMedia());
            this.selectedMedia = this.mediaService.findMedia(this.view.PrintGetIdToReview());
            this.review.setMedia(this.selectedMedia);
            this.review.setText(this.view.PrintDoReview());
            int chosenRating = Integer.parseInt(view.PrintDoRating());
            this.review.setRating(Rating.intToRating(chosenRating));
            this.reviewService.saveReview(this.review);
            this.view.PrintReviews(this.reviewService.findAllReview(this.selectedMedia));
            ExitOrContinue();
        }
    }

    public void ExitOrContinue() {
        String option = this.view.PrintExitOrContinue();
        String yesOption = "1";
        if (option.equals(yesOption)) {
            this.stillRunning=true;
        }
        else {
            this.stillRunning=false;
        }
    }
}
