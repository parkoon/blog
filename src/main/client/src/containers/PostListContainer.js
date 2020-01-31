import React, { useEffect } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { getPosts } from '../modules/posts';
import PostList from '../components/PostList';

const PostsListContainer = () => {
  const posts = useSelector(({ posts }) => posts);
  const dispatch = useDispatch();

  const { loading, posts } = posts;

  useEffect(() => {
    dispatch(getPosts());
  }, []);

  return <PostList loading={loading} posts={posts} />;
};

export default PostsListContainer;
