package com.dokle.ba.demo.service;

import com.dokle.ba.demo.db.entity.Country;
import com.dokle.ba.demo.db.entity.Details;
import com.dokle.ba.demo.db.repository.DetailsRepository;
import com.dokle.ba.demo.service.dtos.DetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class DetailsService {
    @Autowired
    private DetailsRepository detailsRepository;

    public Details getDetailsByUserId(Long id) {
        return detailsRepository.getDetailsByUserId(id);
    }

    public void uploadAvatar(Long id, MultipartFile file) throws IOException {
        try {
            String fileName = file.getOriginalFilename();

            if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg") || fileName.endsWith(".png")){
                detailsRepository.uploadAvatar(id, file.getBytes());
            }
            else{
                throw new UnsupportedOperationException("Allowed formats: .jpg .jpeg .png");
            }
        } catch (IOException e) {
            throw new IOException("Uploading file failed.");
        }
    }

    public void editDetails(Long id, DetailsDTO details) {
        System.out.println("Service" + details);
        detailsRepository.editDetails(id, details);
    }

    public List<Country> getCountries() {
        return detailsRepository.getCountries();
    }
}
