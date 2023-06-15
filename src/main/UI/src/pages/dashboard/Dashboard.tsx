import React from 'react'
import './dashboard.css'
import GalleryItem from '../../components/galleryItem/GalleryItem'
import CreateGallery from '../../components/createGallery/CreateGallery'
import { Link, Outlet } from 'react-router-dom'

export interface Photo {
    url: string
}

export default function Dashboard() {
  return (
    <div className='dashboard-wrapper'>
        
        <div className='dashboard-menu'><a href="/dashboard" className="logo-dashboard">VisionVault</a></div>
        <div className='dashboard-content'>
            <Link to="./creategallery" className="btn-add-gallery">Create Gallery</Link>
            <div className='gallaries-grid'>
                <GalleryItem photo={{url: "https://ippei-janine.com/photography/wp-content/uploads/DSC03503.jpg"}} />
                <GalleryItem photo={{url: "https://ippei-janine.com/photography/wp-content/uploads/DSC02515.jpg"}} />
                <GalleryItem photo={{url: "https://ippei-janine.com/photography/wp-content/uploads/DSC05053-1.jpg"}} />
                <GalleryItem photo={{url: "https://ippei-janine.com/photography/wp-content/uploads/DSC05933.jpg"}} />
                <GalleryItem photo={{url: "https://ippei-janine.com/photography/wp-content/uploads/DSC03790.jpg"}} />
                <GalleryItem photo={{url: "https://ippei-janine.com/photography/wp-content/uploads/DSC06886.jpg"}} />
                <GalleryItem photo={{url: "https://ippei-janine.com/photography/wp-content/uploads/DSC03503.jpg"}} />
                <GalleryItem photo={{url: "https://ippei-janine.com/photography/wp-content/uploads/DSC02515.jpg"}} />
                <GalleryItem photo={{url: "https://ippei-janine.com/photography/wp-content/uploads/DSC05053-1.jpg"}} />
                <GalleryItem photo={{url: "https://ippei-janine.com/photography/wp-content/uploads/DSC05933.jpg"}} />
                <GalleryItem photo={{url: "https://ippei-janine.com/photography/wp-content/uploads/DSC03790.jpg"}} />
                <GalleryItem photo={{url: "https://ippei-janine.com/photography/wp-content/uploads/DSC06886.jpg"}} />
                
                
            </div>
            <Outlet />
        </div>
        
    </div>
  )
}
