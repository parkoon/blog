import React from 'react';
import { AuthContent } from '../../components/Auth';

const Register = () => {
  return (
    <AuthContent title='회원가입'>
      <form>
        <fieldset>
          <div>
            <label htmlFor='userId'>아이디</label>
            <input id='userId' type='text' />
          </div>
          <div>
            <label htmlFor='userPassword'>비밀번호</label>
            <input id='userPassword' type='password' />
          </div>
          <div>
            <label htmlFor='userPasswordAgain'>비밀번호 재입력</label>
            <input id='userPasswordAgain' type='password' />
          </div>
          <div>
            <button type='submit'>submit</button>
          </div>
        </fieldset>
      </form>
    </AuthContent>
  );
};

export default Register;
