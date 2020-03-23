package com.main.controller;

import com.main.exception.RecordNotFoundException;
import com.main.model.Film;
import com.main.model.Song;
import com.main.service.FilmService;
import com.main.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    private FilmService service;
    @GetMapping("/list")
    public ResponseEntity<List<Film>> getAllSong() {
        List<Film> list = service.getAllSong();
        return new ResponseEntity<List<Film>>(list,new HttpHeaders(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Film> createOrUpdateFilm(@RequestBody Film product)
            throws RecordNotFoundException {
        Film optional = service.createOrUpdateFilm(product);
        if (optional != null) {
            return new ResponseEntity<Film>(optional, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<Film  >(optional, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteFilmById(@PathVariable("id") Integer id)
            throws RecordNotFoundException {
        service.deleteFilmById(id);
        return HttpStatus.OK;
    }
}
