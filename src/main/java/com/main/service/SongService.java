package com.main.service;

import com.main.ActivityUtil;
import com.main.exception.RecordNotFoundException;
import com.main.model.Song;
import com.main.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SongService  {

    private final SongRepository repository;

    public SongService(SongRepository repository) {
        this.repository = repository;
    }

    //get all
    public List<Song> getAllSong() {
        List<Song> songs = repository.findAll();
        if (songs.size() > 0) {
            return songs;
        } else {
            return new ArrayList<Song>();
        }
    }

    //update or create
    public Song createOrUpdateSong(Song entity) throws RecordNotFoundException {
        if (entity.getId() != null) {
            Optional<Song> oldPro = repository.findById(entity.getId());
            if (oldPro.isPresent()) {
                Song newEntity = oldPro.get();
                if (entity.getName() != null) {
                    newEntity.setName(entity.getName());
                }
                if (entity.getImages() !=null){
                    newEntity.setImages(ActivityUtil.getBaseUrl() + entity.getImages());
                }
                if (entity.getSinger() !=null){
                    newEntity.setSinger(entity.getSinger());
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
    public void deleteSongById(Integer id) throws RecordNotFoundException {
        Optional<Song> song = repository.findById(id);

        if (song.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No product record exist for given id", id);
        }
    }
}
