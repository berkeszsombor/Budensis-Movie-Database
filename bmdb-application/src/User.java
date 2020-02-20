import java.util.List;

public class User {
	public String name;
	public String email;
	public String passWord;
	
	public List<Review> userReviews;
	
	public User(String Name, String Email, String PassWord) {
		this.name = Name;
		this.email = Email;
		this.passWord = PassWord;
	}
	
	public void addReview(String text) {
		this.userReviews.add(new Review(text, this));
	}
	
	public List<Review> getReview(){
		return this.userReviews;
	}
}
