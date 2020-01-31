import React from 'react';
import { Route, Switch } from 'react-router-dom';
import { PostList } from './pages';

const App = () => {
  return (
    <>
      <Route path='/' exact component={PostList}></Route>
      <Switch>
        <Route path='/p/:id' component={} />
        {/* <Route component={} /> */}
      </Switch>
    </>
  );
};

export default App;
