package lastfm.album.info;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Attribute {

	@JsonProperty private int rank;
	
	public void setRank(int rank){
		this.rank = rank;
	}
	public int getRank(){
		return rank;
	}
	
}
