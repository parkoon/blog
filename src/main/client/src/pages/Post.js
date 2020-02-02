import React from 'react';
import Header from '../components/Header';
import PostContainer from '../containers/PostContainer';

const Post = ({ match }) => {
  console.log(match.params.id);
  return (
    <>
      <Header />
      <main role='main'>
        <PostContainer />
      </main>
    </>
  );
};

export default Post;
