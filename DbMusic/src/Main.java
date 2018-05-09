import java.util.List;

public class Main {

	public static void main(String[] args) {
		DataSource dataSource = new DataSource();
		
		dataSource.open();
       List<Artist>artists = dataSource.queryArtist();
       if (artists == null) {
			System.out.println("Not selected");
		}else {
		for (Artist artist : artists) {
			System.out.println(artist.getName());
		}
		}
	
		dataSource.close();
		

	}

}
