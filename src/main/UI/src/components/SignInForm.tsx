import React, { useState } from 'react';
import axios from 'axios';

const SignInForm = () => {
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
    <form onSubmit={handleSubmit}>
      
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

export default SignInForm;
// // @ts-nocheck

// import React, { useState, FormEvent } from 'react';
// import axios from 'axios';

// interface User {
//   email: string;
//   password: string;
// }

// const SignInForm = () => {
//   const [email, setEmail] = useState<string>('');
//   const [password, setPassword] = useState<string>('');
//   const [loading, setLoading] = useState<boolean>(false);
//   const [error, setError] = useState<string | null>(null);

//   const handleSubmit = async (event: FormEvent) => {
//     event.preventDefault();
//     setLoading(true);
//     setError(null);

//     const user: User = {
//       email,
//       password,
//     };

//     try {
//       const response = await axios.get('/auth', user);
//       // Handle the response here. You may want to set it in state or redirect the user.
//     } catch (err) {
//       console.log(err);
//     } finally {
//       setLoading(false);
//     }
//   };

//   return (
//     <form onSubmit={handleSubmit}>
//       <h2>Sign In</h2>
//       {error && <p>Error: {error}</p>}
//       <div>
//         <label>Email:</label>
//         <input
//           type="email"
//           value={email}
//           onChange={e => setEmail(e.target.value)}
//           required
//         />
//       </div>
//       <div>
//         <label>Password:</label>
//         <input
//           type="password"
//           value={password}
//           onChange={e => setPassword(e.target.value)}
//           required
//         />
//       </div>
//       <button type="submit" disabled={loading}>
//         {loading ? 'Loading...' : 'Sign In'}
//       </button>
//     </form>
//   );
// };

// export default SignInForm;
