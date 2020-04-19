package com.example.bmdb.service;

import com.example.bmdb.domain.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Calendar;

public class CreateBasicData {
    @Autowired
    private ActorService actorService;
    @Autowired
    private MediaService mediaService;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private UserService userService;

    private static Calendar calendarToSetDates = Calendar.getInstance();

    public void CreateData() {
        calendarToSetDates.set(1980, 1, 1);
        Actor actor0 = new ActorBuilder().buildName("Scarlett Johansson")
                .buildBorn(calendarToSetDates.getTime())
                .buildBiography("Best actress")
                .buildSex(Sex.FEMALE)
                .build();
        calendarToSetDates.set(1980, 1, 1);
        Actor actor1 = new ActorBuilder().buildName("Robert Downey Jr.")
                .buildBorn(calendarToSetDates.getTime())
                .buildBiography("Best actror")
                .buildSex(Sex.MALE)
                .build();
        calendarToSetDates.set(1980, 1, 1);
        Actor actor2 = new ActorBuilder().buildName("Gwyneth Paltrow")
                .buildBorn(calendarToSetDates.getTime())
                .buildBiography("Best actress")
                .buildSex(Sex.FEMALE)
                .build();
        calendarToSetDates.set(1970, 1, 1);
        Actor actor3 = new ActorBuilder().buildName("Chris Evans")
                .buildBorn(calendarToSetDates.getTime())
                .buildBiography("Best actress")
                .buildSex(Sex.FEMALE)
                .build();
        calendarToSetDates.set(1980, 1, 1);
        Actor actor4 = new ActorBuilder().buildName("Mark Ruffalo")
                .buildBorn(calendarToSetDates.getTime())
                .buildBiography("Best actress")
                .buildSex(Sex.FEMALE)
                .build();
        calendarToSetDates.set(1980, 1, 1);
        Actor actor5 = new ActorBuilder().buildName("Jeremy Renner")
                .buildBorn(calendarToSetDates.getTime())
                .buildBiography("Best actress")
                .buildSex(Sex.FEMALE)
                .build();
        calendarToSetDates.set(1980, 1, 1);
        Actor actor6 = new ActorBuilder().buildName("Tom Hiddleston")
                .buildBorn(calendarToSetDates.getTime())
                .buildBiography("Best actress")
                .buildSex(Sex.FEMALE)
                .build();
        calendarToSetDates.set(1980, 1, 1);
        Actor actor7 = new ActorBuilder().buildName("Samuel L. Jackson")
                .buildBorn(calendarToSetDates.getTime())
                .buildBiography("Best actress")
                .buildSex(Sex.FEMALE)
                .build();
        calendarToSetDates.set(1980, 1, 1);
        Actor actor8 = new ActorBuilder().buildName("Paul Bettany")
                .buildBorn(calendarToSetDates.getTime())
                .buildBiography("Best actress")
                .buildSex(Sex.FEMALE)
                .build();
        this.actorService.saveActor(actor0);
        this.actorService.saveActor(actor1);
        this.actorService.saveActor(actor2);
        this.actorService.saveActor(actor3);
        this.actorService.saveActor(actor4);
        this.actorService.saveActor(actor5);
        this.actorService.saveActor(actor6);
        this.actorService.saveActor(actor7);
        this.actorService.saveActor(actor8);

        User user0 = new UserBuilder().buildName("BenUser")
                .buildEmail("ben@email.com")
                .buildPassWord("password")
                .buildList(new ArrayList<>())
                .build();
        User user1 = new UserBuilder().buildName("JoeUser")
                .buildEmail("joe@email.com")
                .buildPassWord("password")
                .buildList(new ArrayList<>())
                .build();
        User user2 = new UserBuilder().buildName("PeterUser")
                .buildEmail("peter@email.com")
                .buildPassWord("password")
                .buildList(new ArrayList<>())
                .build();
        this.userService.saveUser(user0);
        this.userService.saveUser(user1);
        this.userService.saveUser(user2);

        calendarToSetDates.set(2010,1,1);
        Media media0 =  new MediaBuilder().buildTitle("A sajtok támadása")
                .buildDescription("Jó film")
                .buildPremier(calendarToSetDates.getTime())
                .buildCastList(new ArrayList<>())
                .buildMovie()
                .addActor(this.actorService.findAllActor().get(0))
                .addActor(this.actorService.findAllActor().get(1))
                .addActor(this.actorService.findAllActor().get(2))
                .build();
        calendarToSetDates.set(2011,1,1);
        Media media1 =  new MediaBuilder().buildTitle("A répák támadása")
                .buildDescription("Jó sorozat")
                .buildPremier(calendarToSetDates.getTime())
                .buildCastList(new ArrayList<>())
                .buildSeries()
                .addActor(this.actorService.findAllActor().get(2))
                .addActor(this.actorService.findAllActor().get(3))
                .addActor(this.actorService.findAllActor().get(4))
                .build();
        calendarToSetDates.set(2012,1,1);
        Media media2 =  new MediaBuilder().buildTitle("Az autók támadása")
                .buildDescription("Jó film")
                .buildPremier(calendarToSetDates.getTime())
                .buildCastList(new ArrayList<>())
                .buildMovie()
                .addActor(this.actorService.findAllActor().get(4))
                .addActor(this.actorService.findAllActor().get(5))
                .addActor(this.actorService.findAllActor().get(6))
                .build();
        calendarToSetDates.set(2009,1,1);
        Media media3 =  new MediaBuilder().buildTitle("A retkek támadása")
                .buildDescription("Jó film")
                .buildPremier(calendarToSetDates.getTime())
                .buildCastList(new ArrayList<>())
                .buildMovie()
                .addActor(this.actorService.findAllActor().get(6))
                .addActor(this.actorService.findAllActor().get(7))
                .addActor(this.actorService.findAllActor().get(8))
                .build();
        calendarToSetDates.set(2018,1,1);
        Media media4 =  new MediaBuilder().buildTitle("A saláták támadása")
                .buildDescription("Rossz film")
                .buildPremier(calendarToSetDates.getTime())
                .buildCastList(new ArrayList<>())
                .buildMovie()
                .addActor(this.actorService.findAllActor().get(3))
                .addActor(this.actorService.findAllActor().get(4))
                .addActor(this.actorService.findAllActor().get(2))
                .build();
        this.mediaService.saveMedia(media0);
        this.mediaService.saveMedia(media1);
        this.mediaService.saveMedia(media2);
        this.mediaService.saveMedia(media3);
        this.mediaService.saveMedia(media4);

        Review review0 = new ReviewBuilder()
                .buildText("Good film")
                .buildMedia(this.mediaService.findAllMedia().get(0))
                .buildRating(Rating.GOOD)
                .buildUser(this.userService.findAllUser().get(0))
                .build();
        Review review1 = new ReviewBuilder()
                .buildText("Average film")
                .buildMedia(this.mediaService.findAllMedia().get(4))
                .buildRating(Rating.AVERAGE)
                .buildUser(this.userService.findAllUser().get(1))
                .build();
        Review review2 = new ReviewBuilder()
                .buildText("Bad film")
                .buildMedia(this.mediaService.findAllMedia().get(2))
                .buildRating(Rating.BAD)
                .buildUser(this.userService.findAllUser().get(2))
                .build();
        Review review3 = new ReviewBuilder()
                .buildText("Bad film")
                .buildMedia(this.mediaService.findAllMedia().get(3))
                .buildRating(Rating.BAD)
                .buildUser(this.userService.findAllUser().get(2))
                .build();
        Review review4 = new ReviewBuilder()
                .buildText("Good film")
                .buildMedia(this.mediaService.findAllMedia().get(1))
                .buildRating(Rating.GOOD)
                .buildUser(this.userService.findAllUser().get(1))
                .build();
        Review review5 = new ReviewBuilder()
                .buildText("Good film")
                .buildMedia(this.mediaService.findAllMedia().get(2))
                .buildRating(Rating.GOOD)
                .buildUser(this.userService.findAllUser().get(0))
                .build();
        this.reviewService.saveReview(review0);
        this.reviewService.saveReview(review1);
        this.reviewService.saveReview(review2);
        this.reviewService.saveReview(review3);
        this.reviewService.saveReview(review4);
        this.reviewService.saveReview(review5);
    }
}
