package com.main.repository;

import com.main.model.Film;
import com.main.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository  extends JpaRepository<Film, Integer> {
}
