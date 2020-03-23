package com.main.service;

import com.main.ActivityUtil;
import com.main.exception.RecordNotFoundException;
import com.main.model.Film;
import com.main.model.Song;
import com.main.repository.FilmRepository;
import com.main.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    private final FilmRepository repository;

    public FilmService(FilmRepository repository) {
        this.repository = repository;
    }

    //get all
    public List<Film> getAllSong() {
        List<Film> songs = repository.findAll();
        if (songs.size() > 0) {
            return songs;
        } else {
            return new ArrayList<Film>();
        }
    }

    //update or create
    public Film createOrUpdateFilm(Film entity) throws RecordNotFoundException {
        if (entity.getId() != null) {
            Optional<Film> oldPro = repository.findById(entity.getId());
            if (oldPro.isPresent()) {
                Film newEntity = oldPro.get();
                if (entity.getName() != null) {
                    newEntity.setName(entity.getName());
                }
                if (entity.getImages() !=null){
                    newEntity.setImages(ActivityUtil.getBaseUrl() + entity.getImages());
                }
                if (entity.getActor() !=null){
                    newEntity.setActor(entity.getActor());
                }
                newEntity = repository.save(newEntity);
                return newEntity;
            } else {
                entity = repository.save(entity);
                return entity;
            }
        } else {
            entity = repository.save(entity);
            return entity;
        }
    }

    //delete
    public void deleteFilmById(Integer id) throws RecordNotFoundException {
        Optional<Film> song = repository.findById(id);

        if (song.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No product record exist for given id", id);
        }
    }
}
