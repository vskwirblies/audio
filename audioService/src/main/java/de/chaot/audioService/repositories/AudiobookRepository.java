package de.chaot.audioService.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import de.chaot.audioDomain.AudiobookBO;

public interface AudiobookRepository extends JpaRepository<AudiobookBO, Integer> {

	Optional<AudiobookBO> findById(Long id);
}
