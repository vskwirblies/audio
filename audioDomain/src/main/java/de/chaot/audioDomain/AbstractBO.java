package de.chaot.audioDomain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class AbstractBO {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
}
