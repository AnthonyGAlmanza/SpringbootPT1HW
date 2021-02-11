package com.tts.playground.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tts.playground.domain.VideoGame;

public interface GameNameRepository extends CrudRepository<VideoGame, Long> {

	List<VideoGame> findByTitle(String title);

}
