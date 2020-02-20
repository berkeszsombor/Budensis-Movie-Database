import java.math.*;
import java.time.LocalDate;
public class Media {
	public BigDecimal id;
	public String title;
	public String description;
	public LocalDate premier;
	
	public Media(BigDecimal ID, String Title, String Description, LocalDate Premier) {
		this.id = ID;
		this.title = Title;
		this.description = Description;
		this.premier = Premier;
	}

}
