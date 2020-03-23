package com.main.controller;

import com.main.exception.RecordNotFoundException;
import com.main.model.Song;
import com.main.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/song")
public class SongController {
    @Autowired
    private SongService service;
    @GetMapping("/list")
    public ResponseEntity<List<Song>> getAllSong() {
        List<Song> list = service.getAllSong();
        return new ResponseEntity<List<Song>>(list,new HttpHeaders(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Song> createOrUpdateSong(@RequestBody Song product)
            throws RecordNotFoundException {
        Song optional = service.createOrUpdateSong(product);
        if (optional != null) {
            return new ResponseEntity<Song>(optional, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<Song  >(optional, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteSongById(@PathVariable("id") Integer id)
            throws RecordNotFoundException {
        service.deleteSongById(id);
        return HttpStatus.OK;
    }
}
