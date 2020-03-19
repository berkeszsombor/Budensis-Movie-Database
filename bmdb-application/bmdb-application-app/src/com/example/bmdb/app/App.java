package com.example.bmdb.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.bmdb.domain.*;
import com.example.bmdb.service.*;
import com.example.bmdb.view.*;



public class App {
    Review review;
    List<Media> medias;
    Media selectedMedia;
    View view;
    Service service;
    Boolean stillPlaying = true;

    public App() {
        this.view=new View();
        this.service=new Service();
    }

    public void CreateTestData() {
        //10db Actor
        this.service.AddActor("Scarlett Johansson", LocalDate.parse("1980-01-01"), Sex.FEMALE, "Best actress");
        this.service.AddActor("Robert Downey Jr.", LocalDate.parse("1965-02-01"), Sex.MALE, "Best actor");
        this.service.AddActor("Chris Evans", LocalDate.parse("1970-01-01"), Sex.MALE, "Best actor");
        this.service.AddActor("Scarlett Johansson", LocalDate.parse("1978-01-01"), Sex.FEMALE, "Best actress");
        this.service.AddActor("Mark Ruffalo", LocalDate.parse("1999-01-01"), Sex.MALE, "Best actor");
        this.service.AddActor("Jeremy Renner", LocalDate.parse("1987-01-01"), Sex.MALE, "Best actor");
        this.service.AddActor("Tom Hiddleston", LocalDate.parse("1986-01-01"), Sex.MALE, "Best actor");
        this.service.AddActor("Samuel L. Jackson", LocalDate.parse("1998-01-01"), Sex.MALE, "Best actor");
        this.service.AddActor("Gwyneth Paltrow", LocalDate.parse("1978-01-01"), Sex.FEMALE, "Best actress");
        this.service.AddActor("Paul Bettany", LocalDate.parse("1989-01-01"), Sex.MALE, "Best actor");
        //3db User
        this.service.SaveUser("BenUser", "ben@email.com", "password");
        this.service.SaveUser("JoeUser", "joe@email.com", "password");
        this.service.SaveUser("PeterUser", "peter@email.com", "password");
        //5db Media
        List<Actor> cast1 = new ArrayList<Actor>();
        cast1.add(this.service.actors.get(0));
        cast1.add(this.service.actors.get(1));
        cast1.add(this.service.actors.get(2));
        List<Actor> cast2 = new ArrayList<Actor>();
        cast2.add(this.service.actors.get(4));
        cast2.add(this.service.actors.get(5));
        cast2.add(this.service.actors.get(6));
        List<Actor> cast3 = new ArrayList<Actor>();
        cast3.add(this.service.actors.get(3));
        cast3.add(this.service.actors.get(7));
        cast3.add(this.service.actors.get(8));
        this.service.AddMedia(new BigDecimal("1"), "A sajtok támadása", "Jó film", LocalDate.parse("2010-01-01"), cast1);
        this.service.AddMedia(new BigDecimal("2"), "A répák támadása", "Közepes film", LocalDate.parse("2011-01-01"), cast2);
        this.service.AddMedia(new BigDecimal("3"), "Az autók támadása", "Jó film", LocalDate.parse("2012-01-01"), cast3);
        this.service.AddMedia(new BigDecimal("4"), "A retkek támadása", "Rossz film", LocalDate.parse("2013-01-01"), cast2);
        this.service.AddMedia(new BigDecimal("5"), "A saláták támadása", "Jó film", LocalDate.parse("2014-01-01"), cast1);
        //6db Review
        this.service.AddReview("Good film", this.service.FindUser("BenUser"), this.service.FindMedia(new BigDecimal("1")), Rating.GOOD);
        this.service.AddReview("Bad film", this.service.FindUser("JoeUser"), this.service.FindMedia(new BigDecimal("2")), Rating.BAD);
        this.service.AddReview("Bad film", this.service.FindUser("BenUser"), this.service.FindMedia(new BigDecimal("3")), Rating.BAD);
        this.service.AddReview("Average film", this.service.FindUser("JoeUser"), this.service.FindMedia(new BigDecimal("4")), Rating.AVERAGE);
        this.service.AddReview("Good film", this.service.FindUser("PeterUser"), this.service.FindMedia(new BigDecimal("5")), Rating.GOOD);
        this.service.AddReview("Good film", this.service.FindUser("BenUser"), this.service.FindMedia(new BigDecimal("4")), Rating.GOOD);
    }

    public void DoReview(User currentUser) throws IOException {
        String choosenId = this.view.PrintGetIdToReview(new BufferedReader(new InputStreamReader(System.in)));
        this.selectedMedia = this.service.FindMedia(new BigDecimal(choosenId));
        String userReview = this.view.PrintDoReview(new BufferedReader(new InputStreamReader(System.in)));
        int choosenRating = Integer.parseInt(this.view.PrintDoRating(new BufferedReader(new InputStreamReader(System.in))));
        this.service.AddReview(userReview, currentUser, selectedMedia, Rating.intToRating(choosenRating));
        this.view.PrintReviews(this.service.FindAllReviews(this.selectedMedia));
    }

    public void ExitOrContinue() throws IOException {
        String option = this.view.PrintExitOrContinue(new BufferedReader(new InputStreamReader(System.in)));
        String yesOption = "1";
        if (option.equals(yesOption)) {
            this.stillPlaying=true;
        }
        else {
            this.stillPlaying=false;
        }
    }

    public void GetReviewAverage(Media media) {
        List<Review> revs = this.service.FindAllReviews(media);
        int sum = 0;
        int count = 0;
        for (Review rev : revs) {
            sum += Rating.valueOfRating(rev.rating);
            count++;
        }
        int val = sum/count;
        media.averageRating = val;
    }

    public void Play(App app) throws IOException{
        app.CreateTestData();
        for (Media media : this.service.FindAllMedia()) {
            GetReviewAverage(media);
        }
        User currentUser = this.view.ReadUserData(new BufferedReader(new InputStreamReader(System.in)));
        this.view.PrintWelcomeMessage();
        this.view.PrintMedias(this.service.FindAllMedia());
        while(this.stillPlaying==true) {
            app.DoReview(currentUser);
            app.ExitOrContinue();
        }
    }

    public static void main(String[] args) throws IOException {
        App app = new App();
        app.Play(app);
    }

}