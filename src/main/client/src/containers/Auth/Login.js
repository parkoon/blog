import React, { useState, useEffect } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { AuthContent } from '../../components/Auth';
import { login } from '../../modules/auth';
import { setUserInfo } from '../../modules/user';

const Login = ({ history }) => {
  const [userId, setUserId] = useState('');
  const [userPassword, setUserPassword] = useState('');
  const { loading, logged } = useSelector(({ auth: { login } }) => ({
    loading: login.loading,
    logged: login.logged,
  }));
  const dispatch = useDispatch();

  useEffect(() => {
    if (logged) {
      dispatch(setUserInfo({ userId }));
      history.push('/');
    }
  }, [logged]);

  const handleSubmit = e => {
    e.preventDefault();
    dispatch(login({ userId, userPassword }));
  };

  return (
    <AuthContent title='로그인'>
      <form onSubmit={handleSubmit}>
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
              onChange={({ target: { value } }) => setUserPassword(value)}
            />
          </div>
          <div>
            <button type='submit'>submit</button>
          </div>
        </fieldset>
      </form>
      {loading && <div>로그인 중...</div>}
    </AuthContent>
  );
};

export default Login;
