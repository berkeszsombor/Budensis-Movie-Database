import java.time.LocalDate;

public class Actor {
	public String name;
	public LocalDate born;
	public String biography;
	
	public Actor(String Name, LocalDate Born, String Biography) {
		this.name = Name;
		this.born = Born;
		this.biography = Biography;
	}
}
