package com.example.bmdb.service;

import com.example.bmdb.domain.*;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class MainService {
    private MediaService mediaService;
    private ActorService actorService;
    private ReviewService reviewService;
    private UserService userService;

    @Inject
    public void setMediaService(MediaService mediaService){
        this.mediaService = mediaService;
    }
    @Inject
    public void setActorService(ActorService actorService){
        this.actorService = actorService;
    }
    @Inject
    public void setReviewService(ReviewService reviewService){
        this.reviewService = reviewService;
    }
    @Inject
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    public void AddReview(String userEmail,
                          String userPassword,
                          String newReviewText,
                          String chosenMediaId,
                          Rating chosenRating) {
        Media chosenMedia = mediaService.findMediaById(chosenMediaId);
        ReviewBuilder builder = new ReviewBuilder();
        Review newReview = builder.buildText(newReviewText)
                .buildUser(userService.findUser(userEmail, userPassword))
                .buildMedia(chosenMedia)
                .buildRating(chosenRating)
                .build();
        chosenMedia.addReviews(newReview);
        reviewService.saveReview(newReview);
        mediaService.saveMedia(chosenMedia);
    }

    //private List<User> users;
    //private List<Media> medias;
    //private List<Review> reviews;
    //public List<Actor> actors;

    //public Service() {
    //    users = new ArrayList<User>();
    //    medias = new ArrayList<Media>();
    //    reviews = new ArrayList<Review>();
    //    actors = new ArrayList<Actor>();
    //}

    //public void SaveUser(String name, String email, String password) {
    //    UserBuilder b = new UserBuilder();
    //    User newUser = (User)b.buildName(name)
    //            .buildEmail(email)
    //            .buildPassWord(password)
    //            .getObject();
    //    users.add(newUser);
    //}

    //public User FindUser(String nameToFind) {
    //    for (User user : users) {
    //        if(user.name==nameToFind) {
    //            return user;
    //        }
    //    }
    //    return null;
    //}

    //public List<Media> FindAllMedia(){
    //    return medias;
    //}

    //public void SaveReview(Review review) {
    //    reviews.add(review);
    //}

    //public List<Review> FindAllReviews(Media mediaToFind){
    //    List<Review> listToReturn = new ArrayList<Review>();
    //    for (Review review : reviews) {
    //        if(review.media.id.compareTo(mediaToFind.id)==0) {
    //            listToReturn.add(review);
    //        }
    //    }
    //    return listToReturn;
    //}

    //public void AddActor(String name, LocalDate born, Sex sex, String bio) {
    //    ActorBuilder b = new ActorBuilder();
    //    Actor newActor = (Actor)b.buildName(name)
    //            .buildBorn(born)
    //            .buildSex(sex)
    //            .buildBiography(bio)
    //            .getObject();
    //    actors.add(newActor);
    //}

    //public void AddMedia(BigDecimal id, String title, String description, LocalDate premier, List<Actor> cast) {
    //    MediaBuilder b = new MediaBuilder();
    //    Media newMedia = (Media)b.buildId(id)
    //            .buildTitle(title)
    //            .buildDescription(description)
    //            .buildPremier(premier)
    //            .buildCastList(cast)
    //            .buildMovie()
    //            .getObject(cast);
    //    medias.add(newMedia);
    //}



    //public Media FindMedia(BigDecimal idToFind) {
    //    for (Media media : medias) {
    //        if(media.id.compareTo(idToFind)==0) {
    //            return media;
    //        }
    //    }
    //    return null;
    //}
}