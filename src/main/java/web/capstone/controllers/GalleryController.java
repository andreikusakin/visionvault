package web.capstone.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import web.capstone.dao.GalleryRepository;
import web.capstone.dao.PictureRepository;
import web.capstone.dao.UserRepository;
import web.capstone.entities.Gallery;
import web.capstone.entities.Picture;
import web.capstone.entities.User;
import web.capstone.model.request.CreateGalleryRequest;

@RestController
@RequestMapping("")
public class GalleryController {
    final GalleryRepository galleryRepository;
    final PictureRepository pictureRepository;
    final UserRepository userRepository;

    public GalleryController(GalleryRepository galleryRepository, PictureRepository pictureRepository, UserRepository userRepository) {
        this.galleryRepository = galleryRepository;
        this.pictureRepository = pictureRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping(path = "/creategallery", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Gallery> createGallery(@RequestBody CreateGalleryRequest request) {
        Gallery gallery = new Gallery();
        User user = userRepository.findById(request.getUserId()).get();
        gallery.setUser(user);
        gallery.setName(request.getName());
        gallery.setDescription(request.getDescription());
        gallery.setPassword(request.getPassword());
        Gallery createdGallery = galleryRepository.save(gallery);

        request.getPictures().forEach(pictureUrl -> {
            Picture picture = new Picture();
            picture.setGallery(createdGallery);
            picture.setUrl(pictureUrl);
            pictureRepository.save(picture);
        });
        return new ResponseEntity<>(createdGallery, HttpStatus.CREATED);
    }
}
