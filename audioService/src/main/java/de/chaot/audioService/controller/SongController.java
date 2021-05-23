package de.chaot.audioService.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.chaot.audioDomain.SongBO;
import de.chaot.audioService.repositories.SongRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class SongController {
	
	@Autowired
	private SongRepository repo;

	@GetMapping("/songs")
	public List<SongBO> getAllSongs() {
		return (List<SongBO>) repo.findAll();
	}
	
	@GetMapping("/songs/{id}")
	public SongBO getSingleSong(@PathVariable long id) {
	    return repo.findById(id)
	      .orElseThrow(() -> new EntityNotFoundException("getSingleSong was called but no entity with the id was found."));
	}
	
	@GetMapping("/songs/{id}/stream")
    public void srcFromSongId(HttpServletResponse response, @PathVariable long id) throws IOException {
		SongBO songBO = repo.findById(id).get();
    	File file = new File(songBO.getFilepath());
    	FileInputStream in = new FileInputStream(file);
    	response.setContentType("audio/mp3");
    	IOUtils.copy(in, response.getOutputStream());
    }
	
	
	@PostMapping("/songs")
	public SongBO postSong(@RequestBody SongBO newSong) {
	    return repo.save(newSong);
	}
}
