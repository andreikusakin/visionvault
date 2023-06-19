import React, { useState } from "react";
import "./login.css";
import axios from "axios";
import { Link, useNavigate } from "react-router-dom";
import CloseIcon from "@mui/icons-material/Close";

export default function Login() {
  const [businessName, setBusinessName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const [authUserId, setAuthUserId] = useState();
  const [authBusinessName, setAuthBusinessName] = useState("");




  const navigate = useNavigate();


  const handleSubmit = (event: { preventDefault: () => void }) => {
    event.preventDefault();

    const credentials = {
      email: email,
      password: password,
    };

    axios
      .post(`/auth`, credentials)
      .then((res) => {
        console.log(res);
        console.log(res.data);
        localStorage.setItem("authUserId", res.data.id);
        localStorage.setItem("authBusinessName", res.data.businessName);
        navigate("/dashboard");
      })
      .catch((error) => console.error(error));
  };

  return (
    <div className="login-wrapper">
      <div className="login-window">
        <Link to="/" className="login-close">
          <CloseIcon fontSize="large" />
        </Link>

        <h2 className="login-title">Log in to VisionVault</h2>
        <p className="login-subtitle">
          Don't have an account?{" "}
          <Link to="/SignUp" className="subtitle-signup-link">
            Sign up
          </Link>
        </p>
        <form className="login-form" onSubmit={handleSubmit}>
          <input
            placeholder="Email"
            autoComplete="username"
            type="email"
            className="input-field"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />

          <input
            placeholder="Password"
            type="password"
            className="input-field"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />

          <button type="submit" className="submit-btn">
            Login
          </button>
        </form>
      </div>
    </div>
  );
}
