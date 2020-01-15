import React from 'react';
import { Route } from 'react-router-dom';
import { List, Login, Article, Post, Register, Account } from './pages';

const App = () => {
  return (
    <>
      <Route path='/' exact component={List}></Route>
      <Route path='/login' component={Login}></Route>
      <Route path='/article' component={Article}></Route>
      <Route path='/post' component={Post}></Route>
      <Route path='/register' component={Register}></Route>
      <Route path='/account' component={Account}></Route>
    </>
  );
};

export default App;
