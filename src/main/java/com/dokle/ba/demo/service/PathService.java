package com.dokle.ba.demo.service;

import com.dokle.ba.demo.db.entity.Path;
import com.dokle.ba.demo.db.repository.PathRepository;
import com.dokle.ba.demo.service.dtos.PathDTO;
import com.dokle.ba.demo.service.dtos.PathResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.sql.SQLException;
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

    public List<Path> getAll() {
        try{
            return pathRepository.getAll();
        }
        catch (NoResultException exc){
            return null;
        }
    }

    public List<PathResponse> getAllForHomePage() {
        try{
            return pathRepository.getAllForHomePage();
        }
        catch (NoResultException | SQLException exc){
            return null;
        }
    }

    public List<PathResponse> filterPathsForHomePage(PathDTO pathDTO) {
        try{
            return pathRepository.filterAllForHomePageV2(pathDTO);
        }
        catch (NoResultException | SQLException exc){
            return null;
        }
    }
}
