import React, { useState } from 'react';
import { AuthContent } from '../../components/Auth';

const Login = () => {
  const [userId, setUserId] = useState('');
  const [password, setPassword] = useState('');

  return (
    <AuthContent title='로그인'>
      <form>
        <fieldset>
          <div>
            <label htmlFor='userId'>아이디</label>
            <input
              id='userId'
              type='text'
              onChange={({ target: { value } }) => setUserId(value)}
            />
          </div>
          <div>
            <label htmlFor='userPassword'>비밀번호</label>
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
    </AuthContent>
  );
};

export default Login;
