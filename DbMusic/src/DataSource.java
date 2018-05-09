import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
	public static final String DB_NAME ="music.db";
	public static final String URL_STRING ="jdbc:sqlite:C:\\Users\\Broken\\Desktop\\"+DB_NAME;

	public static final String TABLE_ALBUMS = "albums";
	public static final String COLUMN_ALBUM_ID ="_id";
	public static final String COLUMN_ALBUM_NAME ="name";
	public static final String COLUMN_ALBUM_ARTIST ="artist";
	
	public static final String TABLE_ARTIST ="artists";
	public static final String COLUMN_ARTIST_ID ="_id";
	public static final String COLUMN_ARTIST_NAME = "name";
	
	public static final String TABLE_SONGS = "songs";
	public static final String COLUMN_SONG_TRACK ="track";
	public static final String COLUMN_SONG_TITLE ="title";
	public static final String COLUMN_SONG_ALBUM="album";

	 public Connection conn;

	
	//METHODS//
	public boolean open() {
		try {
			conn = DriverManager.getConnection(URL_STRING);
			return true;
		}catch(SQLException e) {
			return false;
			
		}
	}
	//CLOSE//
	public void close() {
		try {
			conn.close();
		}catch(SQLException e) {
			System.out.println("Unable to close database");
		}
	}
	//QUERY//
	public List<Artist> queryArtist(){
		List<Artist> artists = new ArrayList();
	   try(Statement state = conn.createStatement();
			   ResultSet results = state.executeQuery("SELECT*FROM "+TABLE_ARTIST)){
		   while (results.next()) {
			   Artist artist = new Artist();
			   artist.setName(results.getString(COLUMN_ARTIST_NAME));
			   artist.setId(results.getInt(COLUMN_ARTIST_ID));
		        artists.add(artist);
		        
		   
		   
			   }
		   return artists;
		   
	   }catch(SQLException e) {
		   System.out.println(e.getMessage());
		   return null;
		   
	   }
		
		
	}

	

}

