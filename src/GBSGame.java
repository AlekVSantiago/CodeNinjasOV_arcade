public class GBSGame extends Game{
    /*
   Fields
     */
	private Template template;

   /*
   Constructor
    */
	GBSGame(String name, String[] author, String url, Template template){
	    super(name, author, url);
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
