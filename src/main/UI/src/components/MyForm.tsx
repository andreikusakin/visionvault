import React, { useState } from 'react';
import axios from 'axios';

const MyForm = () => {
  const [businessName, setBusinessName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleSubmit = (event: { preventDefault: () => void; }) => {
    event.preventDefault();

    const user = {
      businessName: businessName,
      email: email,
      password: password
    };

    axios.post(`/users`, user)
    //   .then(res => {
    //     console.log(res);
    //     console.log(res.data);
    //   })
      .catch(error => console.error(error));
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>
        Business Name:
        <input type="text" value={businessName} onChange={e => setBusinessName(e.target.value)} />
      </label>
      <label>
        Email:
        <input type="email" value={email} onChange={e => setEmail(e.target.value)} required />
      </label>
      <label>
        Password:
        <input type="password" value={password} onChange={e => setPassword(e.target.value)} required />
      </label>
      <button type="submit">Submit</button>
    </form>
  );
}

export default MyForm;
