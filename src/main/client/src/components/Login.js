import React from 'react';

const Login = () => {
  return (
    <div>
      <h1>로그인</h1>
      <form>
        <fieldset>
          <div>
            <label htmlFor='userId'>아이디</label>
            <input id='userId' type='email' />
          </div>
          <div>
            <label htmlFor='userPassword'>패스워드</label>
            <input id='userPassword' type='password' />
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
