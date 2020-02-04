import React from 'react';
import { Route } from 'react-router-dom';
import { AuthWrapper } from '../components/Auth';
import { Login, Register } from '../containers/Auth';

const Auth = () => {
  return (
    <AuthWrapper>
      <Route path='/auth/login' component={Login} />
      <Route path='/auth/register' component={Register} />
    </AuthWrapper>
  );
};

export default Auth;
