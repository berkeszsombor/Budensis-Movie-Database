package com.example.bmdb.view;


import java.util.List;
import java.util.Scanner;

import com.example.bmdb.Internationalizer;
import com.example.bmdb.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class View {
    UserBuilder currentUserBuilder;
    Scanner userInput;
    private Internationalizer internationalizer;
    private static Logger logger = LoggerFactory.getLogger(View.class);

    public View(/*Internationalizer internationalizer*/) {
        currentUserBuilder=new UserBuilder();
        //this.internationalizer = internationalizer;
        logger.info("Constructor");
        userInput=new Scanner(System.in);
    }

    public User ReadUserData() {
        logger.info("ReadUserData");
        //System.out.println(this.internationalizer.getMessage("view.readUserData.WelcomeMessage"));
        System.out.println("name");
        String name = userInput.nextLine();
        return (User)currentUserBuilder.buildName(name).getObject();
    }

    public void PrintWelcomeMessage() {
        logger.info("PrintWelcomeMessage");
        //System.out.println(this.internationalizer.getMessage("view.printWelcomeMessage.SecondWelcomeMessage"));
        System.out.println("hello");
    }

    public void PrintMedias(List<Media> medias) {
        logger.info("PrintMedias");
        for(Media media : medias) {
            System.out.println(media.toString());
        }
    }

    public void PrintReviews(List<Review> rev) {
        logger.info("PrintReviews");
        for(Review review : rev) {
            System.out.println(review.toString());
        }
    }

    public String PrintGetIdToReview() {
       logger.info("PrintGetIdToReview");
        //System.out.println(this.internationalizer.getMessage("view.printGetIdToReview.ChooseIdText"));
        System.out.println("choose id to review");
        String chosenId = userInput.nextLine();
        return chosenId;
    }

    public String PrintDoReview() {
        logger.info("PrintDoReview");
        //System.out.println(this.internationalizer.getMessage("view.printDoReview.WriteReview"));
        System.out.println("do review");
        String userReview = userInput.nextLine();
        return userReview;
    }

    public String PrintDoRating() {
        logger.info("PrintDoRating");
        //System.out.println(this.internationalizer.getMessage("view.printDoRating.WriteRating"));
        System.out.println("do rating");
        String userReview = userInput.nextLine();
        return userReview;
    }

    public String PrintExitOrContinue() {
        logger.info("PrintExitOrContinue");
        //System.out.println(this.internationalizer.getMessage("view.printExitOrContinue.chooseOption"));
        System.out.println("exit/continue");
        String userReview = userInput.nextLine();
        return userReview;
    }
}