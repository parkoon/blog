import React from 'react';
import NavigationContainer from '../containers/NavigationContainer';

const Header = () => {
  return (
    <header>
      <h1>
        <a href='#'>Blog</a>
      </h1>
      <NavigationContainer />
    </header>
  );
};

export default Header;
