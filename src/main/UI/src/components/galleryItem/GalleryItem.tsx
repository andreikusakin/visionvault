import React, { useState } from 'react'
import './galleryItem.css'
import { Photo } from "./../../pages/dashboard/Dashboard"
import { Link } from 'react-router-dom';

interface GalleryItemProps{
    photo: Photo;
}

export default function GalleryItem(props: GalleryItemProps) {
  const { photo } = props;

  const [btnClicked, setButtonClicked] = useState(false);
  
  return (
    <div className='gallery-item'>
      <div onClick={() => setButtonClicked(true)}>
        <img src={photo.url} alt="" />
      </div>
      <p>Gallery Name</p>
      <p>FEB 20 2023</p>
      {btnClicked ? <div className='edit-gallery'><button onClick={() => setButtonClicked(false)}>Close</button></div> : <></>}
    </div>
  )
}
