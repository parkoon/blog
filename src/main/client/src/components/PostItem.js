import React from 'react';

const PostItem = ({ post }) => {
  return (
    <div>
      <a href='/'>
        <strong>{post.title}</strong>
        <p>{post.body}</p>
        <div>
          <span>{post.userId}</span>
        </div>
      </a>
    </div>
  );
};

export default PostItem;
