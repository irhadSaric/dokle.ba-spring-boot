package com.dokle.ba.demo.service;

import com.dokle.ba.demo.db.entity.Path;
import com.dokle.ba.demo.db.repository.PathRepository;
import com.dokle.ba.demo.service.dtos.PathDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.List;

@Service
public class PathService {
    @Autowired
    private PathRepository pathRepository;

    public void addPath(PathDTO pathDTO, Long id) {
        pathRepository.addPath(pathDTO, id);
    }

    public List<Path> getAllForUser(Long id) {
        try {
            return pathRepository.getAllForUser(id);
        }
        catch (NoResultException exc){
            return null;
        }
    }
}
