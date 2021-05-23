package de.chaot.audioDomain;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class representing an audiobook.
 * An audiobook is a book read out loud by a reader.
 * 
 * @author valentin
 *
 */
@Entity
@Data
@EqualsAndHashCode
public class AudiobookBO extends AbstractBO {

	private String title = Constants.DEFAULT_VALUE_STRING;
	
	private String author = Constants.DEFAULT_VALUE_STRING;
}
