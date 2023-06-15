import React from 'react'
import './dashboard.css'

export default function Dashboard() {
  return (
    <div className='dashboard-wrapper'>
        {/* <header className="navbar-dashboard">
            <a href="/dashboard" className="nav-logo-dashboard">VisionVault</a>
            <div className="nav-menu-dashboard"></div>
        </header>
        <div>
            <div className='dashboard-menu'>
                <h1>Dashboard</h1>
            </div>
            <div></div>
        </div> */}
        <div className='dashboard-menu'><a href="/dashboard" className="logo-dashboard">VisionVault</a></div>
        <div className='dashboard-content'></div>
        
    </div>
  )
}
