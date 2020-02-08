import React from 'react';
import PostItem from './PostItem';

const PostList = ({ loading, posts=[] }) => {
  return (
    <>
    {
      loading ? `Loading ...` : posts.map(post => <PostItem key={post.id} post={post} />)
    }
    </>
  );
};

export default PostList;
