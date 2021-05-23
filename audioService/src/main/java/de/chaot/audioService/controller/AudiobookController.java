package de.chaot.audioService.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.chaot.audioDomain.AudiobookBO;
import de.chaot.audioService.repositories.AudiobookRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AudiobookController {
	
	@Autowired
	private AudiobookRepository repo;

	@GetMapping("/audiobooks")
	public List<AudiobookBO> getAllAudiobooks() {
		return repo.findAll();
	}
	
	@GetMapping("/audiobooks/{id}")
	public AudiobookBO getSingleAudiobook(@PathVariable long id) {
	    return repo.findById(id)
	      .orElseThrow(() -> new EntityNotFoundException("getSingleAudiobook was called but no entity with the id was found."));
	}
	
	@PostMapping("/audiobooks")
	public AudiobookBO postAudiobook(@RequestBody AudiobookBO newAudiobook) {
	    return repo.save(newAudiobook);
	}
}
