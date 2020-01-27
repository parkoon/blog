import React from 'react';
import PostItem from './PostItem';

const PostList = ({ loading, posts }) => {
  return (
    <>
      {loading && `로딩중..`}
      {!loading &&
        posts &&
        posts.map(post => <PostItem key={post.id} post={post} />)}
    </>
  );
};

export default PostList;
