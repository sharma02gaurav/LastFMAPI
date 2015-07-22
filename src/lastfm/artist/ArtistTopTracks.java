package lastfm.artist;

import lastfm.artist.toptracks.LastFMTopTracksWrapper;
import lastfm.artist.toptracks.LastFMTopTracks;
import lastfm.util.DeserializeObject;
import lastfm.util.FetchJSON;

/**
 * Class to fetch the artist top tracks
 * @author gaurav
 *
 */
public class ArtistTopTracks {

	private String genMethod = EventsAPIMethods.ARTIST_TOP_TRACKS;
	private int count = 5;
	private int page = 1;
	
	/**
	 * the default constructor 
	 * @param apiKey represents the last.fm API key
	 * @param artist represents the artists to fetch top tracks of
	 */
	public ArtistTopTracks(String apiKey, String artist){
		
		genMethod += "&api_key="+ apiKey;
		genMethod += "&artist="+ artist;
	}
	
	/**
	 * fetch the top tracks for the given artist
	 * @return <code>lastfm.artist.toptracks.TopTracks</code> if tracks found
	 */
	public LastFMTopTracks fetchTopTracks(){
		genMethod += "&limit=" +count;
		genMethod += "&page=" +page;
		
		String json = FetchJSON.fetchJSONFrom(genMethod);
		DeserializeObject<LastFMTopTracksWrapper> deserializer = new DeserializeObject<>();
		LastFMTopTracksWrapper tracksWrapper = deserializer.deserealize(json, LastFMTopTracksWrapper.class);
		
			return tracksWrapper.getToptracks();
	}
	
	/**
	 * set the result limit. This method must be called before calling <code>fetchTopTracks()</code>
	 * @param count represents the limit of results to set
	 */
	public void setLimit(int count){
		this.count = count;
	}
	
	/**
	 * use this setter to set the page number to fetch.The default is 1st page
	 * @param page represents the page number
	 */
	public void setPage(int page){
		this.page = page;
	}
	
}
