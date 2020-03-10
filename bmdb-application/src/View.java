import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class View {
	UserBuilder currentUserBuilder;
	Scanner userInput;
	
	public View() {
		currentUserBuilder=new UserBuilder();
	}
	
	public User ReadUserData(BufferedReader reader) throws IOException {
		System.out.println("Hello, what is your name?");
		//String name = userInput.nextLine();
		String name = reader.readLine();
		return (User)currentUserBuilder.buildName(name).getObject();
	}
	
	public void PrintWelcomeMessage() {
		System.out.println("Welcome to the movie database!");
	}
	
	public void PrintMedias(List<Media> medias) {
		for(Media media : medias) {
			System.out.println(media.toString());
		}
	}
	
	public void PrintReviews(List<Review> rev) {
		for(Review review : rev) {
			System.out.println(review.toString());
		}
	}
	
	public String PrintGetIdToReview(BufferedReader reader) throws IOException {
		System.out.println("Choose an ID:");
		String chosenId = reader.readLine();
		return chosenId;
	}
	
	public String PrintDoReview(BufferedReader reader) throws IOException {
		System.out.println("Write your review:");
		String userReview = reader.readLine();
		return userReview;
	}
	
	public String PrintDoRating(BufferedReader reader) throws IOException {
		System.out.println("Choose a rating(1-3-5):");
		String userReview = reader.readLine();
		return userReview;
	}
	
	public String PrintExitOrContinue(BufferedReader reader) throws IOException {
		System.out.println("Make another review(1)|Exit(2)");
		String userReview = reader.readLine();
		return userReview;
	}
}
