package web.capstone.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.capstone.dao.GalleryRepository;
import web.capstone.dao.PictureRepository;
import web.capstone.dao.UserRepository;
import web.capstone.entities.Gallery;
import web.capstone.entities.Picture;
import web.capstone.entities.User;
import web.capstone.model.request.CreateGalleryRequest;
import web.capstone.model.request.UpdateGalleryRequest;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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

    @GetMapping(path = "/mygalleries")
    public ResponseEntity<List<Gallery>> getMyGalleries(@RequestParam Long userId) {
        List<Gallery> galleries = galleryRepository.findAllByUserId(userId);
        List<Gallery> galleriesWithCovers = galleries.stream().peek(gallery -> {
            List<Picture> pictures = pictureRepository.findPicturesByGalleryId(gallery.getId());
            pictures.stream().findFirst().ifPresent(p -> gallery.setCoverUrl(p.getUrl()));
            gallery.setPictures(Set.copyOf(pictures));
        }).collect(Collectors.toList());
        return new ResponseEntity<>(galleriesWithCovers, HttpStatus.OK);
    }

    @GetMapping(path = "/mygallery")
    public ResponseEntity<Gallery> getMyGalleries(@RequestParam Long id, @RequestParam Long userId) {
        Optional<Gallery> maybeGallery = galleryRepository.findByIdAndUserId(id, userId);
        if (maybeGallery.isPresent()) {
            Gallery gallery = maybeGallery.get();
            List<Picture> pictures = pictureRepository.findPicturesByGalleryId(gallery.getId());
            gallery.setPictures(Set.copyOf(pictures));
            return new ResponseEntity<>(gallery, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/updategallery", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Gallery> updateGallery(@RequestBody UpdateGalleryRequest request) {
        Gallery gallery = galleryRepository.findById(request.getId()).get();

        gallery.setName(request.getName());
        gallery.setDescription(request.getDescription());
        gallery.setPassword(request.getPassword());
        Gallery updatedGallery = galleryRepository.save(gallery);

        pictureRepository.deleteAllByGalleryId(request.getId());

        request.getPictures().forEach(pictureUrl -> {
            Picture picture = new Picture();
            picture.setGallery(updatedGallery);
            picture.setUrl(pictureUrl);
            pictureRepository.save(picture);
        });

        return new ResponseEntity<>(updatedGallery, HttpStatus.OK);
    }

    @DeleteMapping("/gallery/{id}")
    public void deleteGallery(@PathVariable Long id) {
        pictureRepository.deleteAllByGalleryId(id);
        galleryRepository.deleteById(id);
    }

}
