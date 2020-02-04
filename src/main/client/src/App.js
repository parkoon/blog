import React from 'react';
import { Route, Switch } from 'react-router-dom';
import { PostList, Auth } from './pages';

const App = () => {
  return (
    <>
      <Route path='/' exact component={PostList} />
      <Route path='/auth' component={Auth} />
      {/* <Route path='/post/:id' component={Post} /> */}
    </>
  );
};

export default App;
