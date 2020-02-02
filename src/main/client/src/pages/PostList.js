import React from 'react';
import HeaderContainer from '../containers/HeaderContainer';
import PostListContainer from '../containers/PostListContainer';

const PostList = () => {
  return (
    <>
      <HeaderContainer />
      <hr />
      <main role='main'>
        <PostListContainer />
      </main>
    </>
  );
};

export default PostList;
