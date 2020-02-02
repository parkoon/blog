import React from 'react';
import { Route, Switch } from 'react-router-dom';
import { PostList, Post, Login } from './pages';

const App = () => {
  return (
    <>
      <Route path='/' exact component={PostList} />
      <Route path='/login' component={Login} />
      {/* <Route path='/post/:id' component={Post} /> */}
      {/* <Switch>
        <Route component={} />
      </Switch> */}
    </>
  );
};

export default App;
