import React from "react";
import { displayPartsToString } from "typescript";
import "./mainPage.css";
import { Link, Outlet } from "react-router-dom";

function MainPage() {
    return(
        <div className="main-page-wrapper">
            <Outlet />
            <header className="navbar">
                    <a href="/" className="nav-logo">VisionVault</a>
                <div className="nav-menu">
                    <Link to="/login" className="nav-btn">Login</Link>
                    <Link to="/signup" className="nav-btn">Sign Up</Link>
                </div>
            </header>
            <div className="main-page-bg">
                <div className="main-page-image"></div>
            </div>
            <div className="main-page-content">
                <h1>Capture Moments</h1>
                <h1>Deliver Memories</h1>
                <p>Share beautiful photo galleries with your clients.</p>    
                <a href="">Get Started</a>
                
            </div>
        </div>
    )
}

export default MainPage;