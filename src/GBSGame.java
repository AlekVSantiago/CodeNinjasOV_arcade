import java.time.LocalDate;
import java.util.ArrayList;

public class GBSGame extends Game{
    /*
   Fields
     */
	private Template template;

   /*
   Constructor
    */
	GBSGame(String name, String author, String url, LocalDate releaseDate, Template template){
	    super(name, author, url, releaseDate);
	    this.template = template;
    }


  /*
  Getters and Setters
   */
    public Template getTemplate(){
        return this.template;
    }

    public void setTemplate(Template template){
        this.template = template;
    }

}
