import React, { useState } from 'react';

const Login = ({ login }) => {
  const [userId, setUserId] = useState('');
  const [password, setPassword] = useState('');

  return (
    <div>
      <h1>로그인</h1>
      <form>
        <fieldset>
          <div>
            <label htmlFor='userEmail'>아이디</label>
            <input
              id='userId'
              type='text'
              onChange={({ target: { value } }) => setUserId(value)}
            />
          </div>
          <div>
            <label htmlFor='userPassword'>패스워드</label>
            <input
              id='userPassword'
              type='password'
              onChange={({ target: { value } }) => setPassword(value)}
            />
          </div>
          <div>
            <button type='submit'>submit</button>
          </div>
        </fieldset>
      </form>
    </div>
  );
};

export default Login;
