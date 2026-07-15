public class GBSGame extends Game{
	private Template gameTemplate;

	
	
	GBSGame(String name, String[] author, String url, Template template){
	    super(name, author, url);
	    this.gameTemplate = template;
    }

    public Template getGameTemplate(){
        return this.gameTemplate;
    }
    
	

}
