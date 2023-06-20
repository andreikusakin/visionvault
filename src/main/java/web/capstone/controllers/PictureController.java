package web.capstone.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import web.capstone.dao.PictureRepository;
import web.capstone.entities.Picture;

import java.util.List;

@RestController
@RequestMapping("")
public class PictureController {
    final PictureRepository pictureRepository;

    public PictureController(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @GetMapping(path = "/galleryPictures")
    public ResponseEntity<List<Picture>> getGalleryPictures(@RequestParam Long galleryId) {
        List<Picture> galleries = pictureRepository.findPicturesByGalleryId(galleryId);
        return new ResponseEntity<>(galleries, HttpStatus.OK);
    }
}
