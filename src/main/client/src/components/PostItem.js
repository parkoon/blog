import React from 'react';
import { Link } from 'react-router-dom';

const PostItem = ({ post }) => {
  const { title, body, userId } = post;
  return (
    <div>
      <Link to={`/post/${post.id}`}>
        <strong>{title}</strong>
        <p>{body}</p>
        <div>
          <span>{userId}</span>
        </div>
      </Link>
    </div>
  );
};

export default React.memo(PostItem);
