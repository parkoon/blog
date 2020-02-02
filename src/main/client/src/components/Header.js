import React from 'react';
import { Link } from 'react-router-dom';
import NavigationContainer from '../containers/NavigationContainer';

const Header = ({ user, onLogout }) => {
  return (
    <header>
      <h1>
        <a href='#'>Blog</a>
      </h1>
      {!!user ? (
        <>
          <button type='button'>NEW POST</button>
          <button type='button' onClick={onLogout}>
            LOGOUT
          </button>
        </>
      ) : (
        <Link to='/login'>LOGIN</Link>
      )}
      {/* <NavigationContainer /> */}
    </header>
  );
};

export default Header;
