import React, { useState } from "react";
import "./dashboard.css";
import GalleryItem from "../../components/galleryItem/GalleryItem";
import CreateGallery from "../../components/createGallery/CreateGallery";
import { Link, Outlet } from "react-router-dom";

export interface Photo {
  url: string;
}

export default function Dashboard() {
  const [isUserId, setIsUserId] = useState(
    localStorage.getItem("authUserId") !== null
  );

  function signOut() {
    localStorage.clear();
    setIsUserId(false);
  }

  console.log(localStorage.getItem("authUserId") + "USER ID");
  console.log(localStorage.getItem("authBusinessName") + "Business Name");

  return (
    <div className="dashboard-wrapper">
      {isUserId ? (
        <><div className="dashboard-menu">
        <a href="/dashboard" className="logo-dashboard">
          VisionVault
        </a>
        <div>Edit Account</div>
        <Link to="/" onClick={signOut}>
          Sign Out
        </Link>
      </div>
      <div className="dashboard-content">
        <Link to="./creategallery" className="btn-add-gallery">
          Create Gallery
        </Link>
        <div className="gallaries-grid">
          <GalleryItem
            photo={{
              url: "https://ippei-janine.com/photography/wp-content/uploads/DSC03503.jpg",
            }}
          />
        </div>
        <Outlet />
      </div></>
      ) : (
        <><div className="dashboard-menu">
        <a href="/dashboard" className="logo-dashboard">
          VisionVault
        </a>
        
      </div>
      <div className="dashboard-content">
        <h3>Sign In to View Your Galleries</h3>
        <a href="/login" className="btn-add-gallery">
          Login
        </a>
      </div></>
        
      )}
      
    </div>
  );
}
