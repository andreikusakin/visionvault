import React, { useState } from "react";
import axios from "axios";
import "./signUp.css";
import { Link } from "react-router-dom";
import CloseIcon from "@mui/icons-material/Close";

export default function SignUp() {
  const [businessName, setBusinessName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [passwordError, setPasswordError] = useState("");

  const handleSubmit = (event: { preventDefault: () => void }) => {
    event.preventDefault();

    if(password.length < 8) {
      setPasswordError('Password must be at least 8 characters long');
      return
    }

    const user = {
      businessName: businessName,
      email: email,
      password: password,
    };

    axios
      .post(`/users`, user)
        .then(res => {
          console.log(res);
          console.log(res.data);
          window.location.href = "/login";
        })
      .catch((error) => console.error(error));
  };

  return (
    <div className="sign-up-wrapper">
      <div className="sign-up-window">
        <Link to="/" className="login-close">
          <CloseIcon fontSize="large" />
        </Link>
        <h2 className="login-title">Create your new account</h2>
          <p className="login-subtitle">
          Already have an account?{" "}
            <Link to="/Login" className="subtitle-signup-link">
              Log in
            </Link>
          </p>
        <form onSubmit={handleSubmit} className="login-form">
          <input
            className="input-field"
            placeholder="Business Name"
            type="text"
            value={businessName}
            onChange={(e) => setBusinessName(e.target.value)}
            required
          />

          <input
            className="input-field"
            placeholder="Email"
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />

          <input
            className="input-field"
            placeholder="Password"
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />

          <p className="password-error">{passwordError}</p>

          <button type="submit" className="submit-btn">
            Sign Up
          </button>
        </form>
      </div>
    </div>
  );
}
