package de.chaot.audioDomain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class SongBO extends AbstractBO implements Serializable {

	/*
	 * Fields
	 */
	
	private static final long serialVersionUID = 1L;
	
	private String filepath = Constants.DEFAULT_VALUE_STRING;
	
	private String artist = Constants.DEFAULT_VALUE_STRING;
	
	private String title = Constants.DEFAULT_VALUE_STRING;

}
