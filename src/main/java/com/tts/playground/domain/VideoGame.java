package com.tts.playground.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VideoGame {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String title;
	private String genre;
	private String console;

	public VideoGame() {}

	public VideoGame(String title, String genre, String console) {
		this.title = title;
		this.genre = genre;
		this.console = console;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		this.console = console;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "VidoGame [id=" + id + ", title=" + title + ", genre=" + genre + ", console=" + console + "]";
	}

}