
public class ReviewBuilder {
	private String text;
	private User user;
	private Media media;
	private Rating rating;
	
	ReviewBuilder(){
		Initialise();
	}
	
	public void Initialise() {
		text="deafult";
		user=new User("name", "email", "password");
		media=new Media(null, "deafult", "deafult", null);
		rating=Rating.AVERAGE;
	}
	
	public ReviewBuilder buildText(String text) {
		this.text=text;
		return this;
	}
	
	public ReviewBuilder buildUser(User user) {
		this.user=user;
		return this;
	}
	
	public ReviewBuilder buildMedia(Media media) {
		this.media=media;
		return this;
	}
	
	public ReviewBuilder buildRating(Rating rating) {
		this.rating=rating;
		return this;
	}
	
	public Object getObject() {
		Review sam = new Review(text, user, media, rating);
		this.media.addReviews(sam);
		return sam;
	}
}
