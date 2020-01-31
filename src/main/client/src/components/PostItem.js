import React from 'react';

const PostItem = ({ post }) => {
  const { title, body, userId } = post;
  return (
    <div>
      <a href='/'>
        <strong>{title}</strong>
        <p>{body}</p>
        <div>
          <span>{userId}</span>
        </div>
      </a>
    </div>
  );
};

export default React.memo(PostItem);
