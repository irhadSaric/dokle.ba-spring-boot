package com.dokle.ba.demo.service;

import com.dokle.ba.demo.db.repository.PathRepository;
import com.dokle.ba.demo.service.dtos.PathDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PathService {
    @Autowired
    private PathRepository pathRepository;

    public void addPath(PathDTO pathDTO, Long id) {
        pathRepository.addPath(pathDTO, id);
    }
}
