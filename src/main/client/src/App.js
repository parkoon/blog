import React from 'react';
import { Route } from 'react-router-dom';
import { Posts } from './pages';

const App = () => {
  return (
    <>
      <Route path='/' exact component={Posts}></Route>
    </>
  );
};

export default App;
