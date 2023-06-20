import React, { useState } from "react";
import "./galleryItem.css";
import { Link } from "react-router-dom";
import ModeEditIcon from "@mui/icons-material/ModeEdit";
import IosShareIcon from "@mui/icons-material/IosShare";
import { Gallery } from "../interfaces";
import DeleteForeverIcon from '@mui/icons-material/DeleteForever';
import axios from "axios";

interface GalleryItemProps {
  gallery: Gallery;
}

export default function GalleryItem(props: GalleryItemProps) {
  const { gallery } = props;

  const [btnClicked, setButtonClicked] = useState(false);

  function deleteGallery() {
    axios
    .delete(`/gallery/${gallery.id}`)
    .then((res) => {
      console.log("Succesfully deleted", res.data);
      window.location.href = "/dashboard";
    })
    .catch((error) => console.error(error));
  }

  return (
    <div className="gallery-item">
      <div onClick={() => setButtonClicked(true)}>
        <img src={gallery.coverUrl} alt="" />
      </div>
      <div className="gallery-item-flexbox">
        <div > 
          <p>{gallery.name}</p>
          <p>{gallery.description}</p>
          <p>FEB 20 2023</p>
        </div>
       
        <div className="gallery-item-icons">
          <Link to={`./editgallery/${gallery.id}`} className="gallery-item-icons"><ModeEditIcon /></Link>
          <Link to="./sharegallery" className="gallery-item-icons"><IosShareIcon /></Link>
          <button onClick={deleteGallery} className="gallery-item-icons"><DeleteForeverIcon /></button>
          
        </div>
      </div>

      {btnClicked ? (
        <div className="edit-gallery">
          <button onClick={() => setButtonClicked(false)}>Close</button>
        </div>
      ) : (
        <></>
      )}
    </div>
  );
}
