import React, { useState } from 'react'
import './login.css'
import axios from 'axios';

export default function Login() {
  const [businessName, setBusinessName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleSubmit = (event: { preventDefault: () => void; }) => {
    event.preventDefault();

    const credentials = {
      email: email,
      password: password
    };

    axios.post(`/auth`, credentials)
    //   .then(res => {
    //     console.log(res);
    //     console.log(res.data);
    //   })
      .catch(error => console.error(error));
  };

    // axios({url: `/auth`, data: {...credentials}})
    //   .then(res => {
    //     console.log(res);
    //     console.log(res.data);
    //   })
    //   .catch(error => console.error(error));
 

  return (
    <div className='login-wrapper'>
      <div className='login-window'>
      <form onSubmit={handleSubmit}>
        
        
        <input placeholder='Email' autoComplete='username' type="email" value={email} onChange={e => setEmail(e.target.value)} required />
      
      
        <input placeholder='Password' type="password" value={password} onChange={e => setPassword(e.target.value)} required />
      
      <button type="submit">Submit</button>
    </form>
      </div>
      
    </div>
  );
  
}
