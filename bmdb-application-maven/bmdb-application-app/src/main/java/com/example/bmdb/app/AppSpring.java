package com.example.bmdb.app;

import com.example.bmdb.config.AppConfig;
import com.example.bmdb.domain.*;
import com.example.bmdb.service.*;
import com.example.bmdb.view.View;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.inject.Inject;
import java.util.List;

public class AppSpring {
    private static Logger logger = LoggerFactory.getLogger(AppSpring.class);
    private MediaService mediaService;
    private ActorService actorService;
    private UserService userService;
    private ReviewService reviewService;
    private MainService mainService;
    private View view;
    private boolean stillRunning = true;

    @Inject
    public void setMediaService(MediaService mediaService) {
        this.mediaService = mediaService;
    }
    @Inject
    public void setActorService(ActorService actorService) {
        this.actorService = actorService;
    }
    @Inject
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Inject
    public void setReviewService(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @Inject
    public void setMainService(MainService mainService) {
        this.mainService = mainService;
    }
    @Inject
    public void setView(View view) { this.view = view; }
    @Inject
    private List<Media> mediaList;
    @Inject
    private List<Actor> actorList;
    @Inject
    private List<Review> reviewList;
    @Inject
    private List<User> userList;

    private void launch() {
        actorService.saveAll(actorList);
        mediaService.saveAll(mediaList);
        userService.saveAll(userList);
        reviewService.saveAll(reviewList);

        logger.info("app launched");

        this.view.PrintWelcomeMessage();
        User newUser = this.view.ReadUserData();
        userService.saveUser(newUser);
        logger.info("user created");

        while(this.stillRunning == true){
            view.PrintMedias(this.mediaService.findAllMedia());
            String chosenId = view.PrintGetIdToReview();
            String reviewText = view.PrintDoReview();
            int chosenRating = Integer.parseInt(view.PrintDoRating());
            mainService.AddReview(newUser.getEmail(),
                    newUser.getPassword(),
                    reviewText,
                    chosenId,
                    Rating.intToRating(chosenRating));
            this.view.PrintReviews(this.reviewService.findAll());
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

    private ActorBuilder actorBuilder;
    @Inject
    public void setActorBuilder(ActorBuilder actorBuilder){
        this.actorBuilder = actorBuilder;
    }

    public static void main(String[] args) {
        try (ConfigurableApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class)) {
            AppSpring app = appContext.getBean(AppSpring.class);
            app.launch();
        }
    }
}
