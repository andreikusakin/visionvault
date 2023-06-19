import React, { useState } from "react";
import "./galleryItem.css";
import { Photo } from "./../../pages/dashboard/Dashboard";
import { Link } from "react-router-dom";
import ModeEditIcon from "@mui/icons-material/ModeEdit";
import IosShareIcon from "@mui/icons-material/IosShare";

interface GalleryItemProps {
  photo: Photo;
}

export default function GalleryItem(props: GalleryItemProps) {
  const { photo } = props;

  const [btnClicked, setButtonClicked] = useState(false);

  return (
    <div className="gallery-item">
      <div onClick={() => setButtonClicked(true)}>
        <img src={photo.url} alt="" />
      </div>
      <div className="gallery-item-flexbox">
        <div > 
          <p>Gallery Name</p>
          <p>FEB 20 2023</p>
        </div>
       
        <div className="gallery-item-icons">
          <Link to="./editgallery" className="gallery-item-icons"><ModeEditIcon /></Link>
          <Link to="./sharegallery" className="gallery-item-icons"><IosShareIcon /></Link>
          
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
