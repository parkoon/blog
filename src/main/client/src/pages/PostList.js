import React from 'react';
import Header from '../components/Header';
import PostListContainer from '../containers/PostListContainer';

const PostList = () => {
  return (
    <>
      <Header />
      <main role='main'>
        <PostListContainer />
      </main>
    </>
  );
};

export default PostList;
