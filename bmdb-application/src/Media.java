import java.math.*;
import java.time.LocalDate;
import java.util.List;
public class Media {
	public BigDecimal id;
	public String title;
	public String description;
	public LocalDate premier;
	
	private List<String> cast;
	
	public Media(BigDecimal ID, String Title, String Description, LocalDate Premier) {
		this.id = ID;
		this.title = Title;
		this.description = Description;
		this.premier = Premier;
	}

	public List<String> getCast(){
		return this.cast;
	}
	
	public void addCast(String actor) {
		this.cast.add(actor);
	}
}
