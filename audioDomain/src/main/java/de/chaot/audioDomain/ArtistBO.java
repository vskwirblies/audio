package de.chaot.audioDomain;

import static java.util.Objects.requireNonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ArtistBO extends AbstractBO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "name")
	private String name = Constants.DEFAULT_VALUE_STRING;

	@OneToMany
	@JoinColumn(name = "albums")
	private List<AlbumBO> albums;
	
	/**
	 * Constructor
	 * @throws SmpException 
	 */
	public ArtistBO() {
		if (this.albums == null) this.albums = new ArrayList<>();
	}
	
	public void addAlbum(AlbumBO album) throws Exception {
		requireNonNull(album);
		if (albums.contains(album)) {
			throw new Exception("Artist" + this.name + " contains the album already.");
		}
		this.albums.add(album);
	}
	
	public boolean hasAlbum(AlbumBO albumBO) {
		return this.albums.contains(albumBO);
	}
}
