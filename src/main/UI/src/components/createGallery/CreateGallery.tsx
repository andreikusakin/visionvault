import React, { useState } from 'react'
import { Link } from 'react-router-dom';
import './createGallery.css'

export default function CreateGallery() {
  
  const [photoList, setPhotoList] = useState<string[]>([]);
  const [photoUrl, setPhotoUrl] = useState('');

  const addPhoto = () => {
    setPhotoList(prevList => [...prevList, photoUrl]);
    setPhotoUrl(''); 
  }
  

  return (
    <div className='create-gallery-wrapper'><Link to="/dashboard" className="btn-add-gallery">Back</Link>
    <form>
        
        
        <input placeholder='Gallery Name' autoComplete='username' type="email"  required />
      
      
        <input placeholder='Gallery Password' type="password"  required />
        <input placeholder='Link to Photo' type='url' value={photoUrl}  required onChange={e => setPhotoUrl(e.target.value)} /><button type="button" onClick={addPhoto}>Add Photo</button>
        <div className='photo-list'>
          {photoList.map((photoUrl, index) => (
            <div key={index}>{photoUrl}</div>
          ))}
        </div>
      
      <button type="submit">Submit</button>
    </form>
    </div>
    
  )
}
