import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service {
	private List<User> users;
	private List<Media> medias;
	private List<Review> reviews;
	public List<Actor> actors;
	
	public Service() {
		users = new ArrayList<User>();
		medias = new ArrayList<Media>();
		reviews = new ArrayList<Review>();
		actors = new ArrayList<Actor>();
	}
	
	public void SaveUser(String name, String email, String password) {
		UserBuilder b = new UserBuilder();
		User newUser = (User)b.buildName(name)
				.buildEmail(email)
				.buildPassWord(password)
				.getObject();
		users.add(newUser);
	}
	
	public User FindUser(String nameToFind) {
		for (User user : users) {
			if(user.name==nameToFind) {
				return user;
			}
		}
		return null;
	}
	
	public List<Media> FindAllMedia(){
		return medias;
	}
	
	public void SaveReview(Review review) {
		reviews.add(review);
	}
	
	public List<Review> FindAllReviews(Media mediaToFind){
		List<Review> listToReturn = new ArrayList<Review>();
		for (Review review : reviews) {
			if(review.media.id.compareTo(mediaToFind.id)==0) {
				listToReturn.add(review);
			}
		}
		return listToReturn;
	}
	
	public void AddActor(String name, LocalDate born, Sex sex, String bio) {
		ActorBuilder b = new ActorBuilder();
		Actor newActor = (Actor)b.buildName(name)
				.buildBorn(born)
				.buildSex(sex)
				.buildBiography(bio)
				.getObject();
		actors.add(newActor);
	}
	
	public void AddMedia(BigDecimal id, String title, String description, LocalDate premier, List<Actor> cast) {
		MediaBuilder b = new MediaBuilder();
		Media newMedia = (Media)b.buildId(id)
				.buildTitle(title)
				.buildDescription(description)
				.buildPremier(premier)
				.buildCastList(cast)
				.buildMovie()
				.getObject(cast);
		medias.add(newMedia);
	}
	
	public void AddReview(String text,User user ,Media media, Rating rating) {
		ReviewBuilder b = new ReviewBuilder();
		Review newReview = (Review)b.buildText(text)
				.buildUser(user)
				.buildMedia(media)
				.buildRating(rating)
				.getObject();
		reviews.add(newReview);
	}
	
	public Media FindMedia(BigDecimal idToFind) {
		for (Media media : medias) {
			if(media.id.compareTo(idToFind)==0) {
				return media;
			}
		}
		return null;
	}
}
