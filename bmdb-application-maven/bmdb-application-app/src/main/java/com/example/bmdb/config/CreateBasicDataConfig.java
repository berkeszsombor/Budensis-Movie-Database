package com.example.bmdb.config;

import com.example.bmdb.domain.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Calendar;

@Configuration
public class CreateBasicDataConfig {
    private Calendar calendarToSetDates = Calendar.getInstance();
    private ActorBuilder actorBuilder;
    private MediaBuilder mediaBuilder;
    private ReviewBuilder reviewBuilder;
    private UserBuilder userBuilder;
    @Inject
    public void setActorBuilder(ActorBuilder actorBuilder) {
        this.actorBuilder = actorBuilder;
    }
    @Inject
    public void setMediaBuilder(MediaBuilder mediaBuilder) {
        this.mediaBuilder = mediaBuilder;
    }
    @Inject
    public void setReviewBuilder(ReviewBuilder reviewBuilder) {
        this.reviewBuilder = reviewBuilder;
    }
    @Inject
    public void setUserBuilder(UserBuilder userBuilder) {
        this.userBuilder = userBuilder;
    }

    @Bean
    public Actor createActor_1(){
        calendarToSetDates.set(1980,1,1);
        return actorBuilder.buildName("Scarlett Johansson")
                .buildBorn(calendarToSetDates.getTime())
                .buildBiography("Best actress")
                .buildSex(Sex.FEMALE)
                .buildList(new ArrayList<>())
                .build();
    }
    @Bean
    public Actor createActor_2(){
        calendarToSetDates.set(1980,1,1);
        return actorBuilder.buildName("Robert Downey Jr.")
                .buildBorn(calendarToSetDates.getTime())
                .buildBiography("Best actror")
                .buildSex(Sex.MALE)
                .buildList(new ArrayList<>())
                .build();
    }
    @Bean
    public Actor createActor_3(){
        calendarToSetDates.set(1980,1,1);
        return actorBuilder.buildName("Gwyneth Paltrow")
                .buildBorn(calendarToSetDates.getTime())
                .buildBiography("Best actress")
                .buildSex(Sex.FEMALE)
                .buildList(new ArrayList<>())
                .build();
    }
    @Bean
    public Actor createActor_4(){
        calendarToSetDates.set(1970,1,1);
        return actorBuilder.buildName("Chris Evans")
                .buildBorn(calendarToSetDates.getTime())
                .buildBiography("Best actress")
                .buildSex(Sex.FEMALE)
                .buildList(new ArrayList<>())
                .build();
    }
    @Bean
    public Actor createActor_5(){
        calendarToSetDates.set(1980,1,1);
        return actorBuilder.buildName("Mark Ruffalo")
                .buildBorn(calendarToSetDates.getTime())
                .buildBiography("Best actress")
                .buildSex(Sex.FEMALE)
                .buildList(new ArrayList<>())
                .build();
    }
    @Bean
    public Actor createActor_6(){
        calendarToSetDates.set(1980,1,1);
        return actorBuilder.buildName("Jeremy Renner")
                .buildBorn(calendarToSetDates.getTime())
                .buildBiography("Best actress")
                .buildSex(Sex.FEMALE)
                .buildList(new ArrayList<>())
                .build();
    }
    @Bean
    public Actor createActor_7(){
        calendarToSetDates.set(1980,1,1);
        return actorBuilder.buildName("Tom Hiddleston")
                .buildBorn(calendarToSetDates.getTime())
                .buildBiography("Best actress")
                .buildSex(Sex.FEMALE)
                .buildList(new ArrayList<>())
                .build();
    }
    @Bean
    public Actor createActor_8(){
        calendarToSetDates.set(1980,1,1);
        return actorBuilder.buildName("Samuel L. Jackson")
                .buildBorn(calendarToSetDates.getTime())
                .buildBiography("Best actress")
                .buildSex(Sex.FEMALE)
                .buildList(new ArrayList<>())
                .build();
    }
    @Bean
    public Actor createActor_9(){
        calendarToSetDates.set(1980,1,1);
        return actorBuilder.buildName("Paul Bettany")
                .buildBorn(calendarToSetDates.getTime())
                .buildBiography("Best actress")
                .buildSex(Sex.FEMALE)
                .buildList(new ArrayList<>())
                .build();
    }

    @Bean
    public User createUser_1() {
    return userBuilder.buildName("BenUser")
            .buildEmail("ben@email.com")
            .buildPassWord("password")
            .buildList(new ArrayList<>())
            .build();
}
    @Bean
    public User createUser_2() {
        return userBuilder.buildName("JoeUser")
                .buildEmail("joe@email.com")
                .buildPassWord("password")
                .buildList(new ArrayList<>())
                .build();
    }
    @Bean
    public User createUser_3() {
    return userBuilder.buildName("PeterUser")
            .buildEmail("peter@email.com")
            .buildPassWord("password")
            .buildList(new ArrayList<>())
            .build();
}

    @Bean
    public Media createMedia_1(){
        calendarToSetDates.set(2010,1,1);
        return mediaBuilder.buildTitle("A sajtok támadása")
                .buildDescription("Jó film")
                .buildPremier(calendarToSetDates.getTime())
                .buildCastList(new ArrayList<>())
                .buildMovie()
                .addActor(createActor_1())
                .addActor(createActor_2())
                .addActor(createActor_3())
                .build();
    }
    @Bean
    public Media createMedia_2(){
        calendarToSetDates.set(2011,1,1);
        return mediaBuilder.buildTitle("A répák támadása")
                .buildDescription("Jó sorozat")
                .buildPremier(calendarToSetDates.getTime())
                .buildCastList(new ArrayList<>())
                .buildMovie()
                .addActor(createActor_3())
                .addActor(createActor_4())
                .addActor(createActor_5())
                .build();
    }
    @Bean
    public Media createMedia_3(){
        calendarToSetDates.set(2012,1,1);
        return mediaBuilder.buildTitle("Az autók támadása")
                .buildDescription("Jó film")
                .buildPremier(calendarToSetDates.getTime())
                .buildCastList(new ArrayList<>())
                .buildMovie()
                .addActor(createActor_5())
                .addActor(createActor_6())
                .addActor(createActor_7())
                .build();
    }
    @Bean
    public Media createMedia_4(){
        calendarToSetDates.set(2009,1,1);
        return mediaBuilder.buildTitle("A retkek támadása")
                .buildDescription("Jó film")
                .buildPremier(calendarToSetDates.getTime())
                .buildCastList(new ArrayList<>())
                .buildMovie()
                .addActor(createActor_7())
                .addActor(createActor_8())
                .addActor(createActor_9())
                .build();
    }
    @Bean
    public Media createMedia_5(){
        calendarToSetDates.set(2018,1,1);
        return mediaBuilder.buildTitle("A saláták támadása")
                .buildDescription("Rossz film")
                .buildPremier(calendarToSetDates.getTime())
                .buildCastList(new ArrayList<>())
                .buildMovie()
                .addActor(createActor_1())
                .addActor(createActor_6())
                .addActor(createActor_3())
                .build();
    }

    @Bean
    public Review createReview_1(){
        return reviewBuilder
                .buildText("Good film")
                .buildMedia(createMedia_1())
                .buildRating(Rating.GOOD)
                .buildUser(createUser_1())
                .build();
    }
    @Bean
    public Review createReview_2(){
        return reviewBuilder
                .buildText("Bad film")
                .buildMedia(createMedia_2())
                .buildRating(Rating.BAD)
                .buildUser(createUser_2())
                .build();
    }
    @Bean
    public Review createReview_3(){
        return reviewBuilder
                .buildText("Bad film")
                .buildMedia(createMedia_3())
                .buildRating(Rating.BAD)
                .buildUser(createUser_3())
                .build();
    }
    @Bean
    public Review createReview_4(){
        return reviewBuilder
                .buildText("Average film")
                .buildMedia(createMedia_4())
                .buildRating(Rating.AVERAGE)
                .buildUser(createUser_1())
                .build();
    }
    @Bean
    public Review createReview_5(){
        return reviewBuilder
                .buildText("Good film")
                .buildMedia(createMedia_5())
                .buildRating(Rating.GOOD)
                .buildUser(createUser_2())
                .build();
    }
    @Bean
    public Review createReview_6(){
        return reviewBuilder
                .buildText("Good film")
                .buildMedia(createMedia_2())
                .buildRating(Rating.GOOD)
                .buildUser(createUser_1())
                .build();
    }
}
