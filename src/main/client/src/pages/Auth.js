import React from 'react';
import { Route, Redirect } from 'react-router-dom';

const Auth = ({ authenticated, component: Component, render, ...rest }) => {
  return (
    <Route
      {...rest}
      render={props =>
        authenticated ? (
          render ? (
            render(props)
          ) : (
            <Component {...props} />
          )
        ) : (
          <Redirect to={{ pathname: '/login' }} />
        )
      }
    />
  );
};

export default Auth;
