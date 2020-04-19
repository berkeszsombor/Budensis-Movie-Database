package com.example.bmdb.view;

import java.util.List;
import java.util.Scanner;

import com.example.bmdb.Internationalizer;
import com.example.bmdb.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Inject;


public class View {
    Scanner userInput;
    @Autowired
    private Internationalizer internationalizer;
    private static Logger logger = LoggerFactory.getLogger(View.class);


    public View() {
        logger.info("Constructor");
        userInput=new Scanner(System.in);
    }

    public User ReadUserData() {
        logger.info("ReadUserData");
        System.out.println(this.internationalizer.getMessage("view.readUserData.WelcomeMessage"));
        String name = userInput.nextLine();
        System.out.println(this.internationalizer.getMessage("view.readUserData.EmailMessage"));
        String email = userInput.nextLine();
        System.out.println(this.internationalizer.getMessage("view.readUserData.PasswordMessage"));
        String password = userInput.nextLine();
        return new User(name, email, password);
    }

    public void PrintWelcomeMessage() {
        logger.info("PrintWelcomeMessage");
        System.out.println(this.internationalizer.getMessage("view.printWelcomeMessage.SecondWelcomeMessage"));
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

    public long PrintGetIdToReview() {
       logger.info("PrintGetIdToReview");
        System.out.println(this.internationalizer.getMessage("view.printGetIdToReview.ChooseIdText"));
        String chosenId = userInput.nextLine();
        return Long.parseLong(chosenId);
    }

    public String PrintDoReview() {
        logger.info("PrintDoReview");
        System.out.println(this.internationalizer.getMessage("view.printDoReview.WriteReview"));
        String userReview = userInput.nextLine();
        return userReview;
    }

    public String PrintDoRating() {
        logger.info("PrintDoRating");
        System.out.println(this.internationalizer.getMessage("view.printDoRating.WriteRating"));
        String userReview = userInput.nextLine();
        return userReview;
    }

    public String PrintExitOrContinue() {
        logger.info("PrintExitOrContinue");
        System.out.println(this.internationalizer.getMessage("view.printExitOrContinue.chooseOption"));
        String userReview = userInput.nextLine();
        return userReview;
    }
}