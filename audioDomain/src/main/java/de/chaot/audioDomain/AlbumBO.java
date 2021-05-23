package de.chaot.audioDomain;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class AlbumBO extends AbstractBO {
	
	private String title = Constants.DEFAULT_VALUE_STRING;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "artist")
	private ArtistBO artist;
	
	@OneToMany
	private List<SongBO> songs;
	
	public AlbumBO() {
		if (this.songs == null) this.songs = new ArrayList<>();
	}
	
	public void addSong(SongBO songBO) throws Exception {
		requireNonNull(songBO);
		if (songs.contains(songBO)) {
			throw new Exception("Album" + this.title + "contains the song already.");
		}
		this.songs.add(songBO);
	}
}
