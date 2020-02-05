import React from 'react';
import { Link } from 'react-router-dom';
import NavigationContainer from '../containers/NavigationContainer';

const Header = ({ userLogged, userLoggedInfo, onLogout }) => {
  const { userId } = userLoggedInfo;

  return (
    <header>
      <h1>
        <a href='#'>Blog</a>
      </h1>
      {!!userLogged ? (
        <>
          <div>{userId}</div>
          <button type='button'>NEW POST</button>
          <button type='button' onClick={onLogout}>
            LOGOUT
          </button>
        </>
      ) : (
        <Link to='/auth/login'>LOGIN</Link>
      )}
      {/* <NavigationContainer /> */}
    </header>
  );
};

export default Header;
