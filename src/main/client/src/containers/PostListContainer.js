import React, { useEffect } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { getPosts } from '../modules/posts';
import PostList from '../components/PostList';

const PostsListContainer = () => {
  const { posts, loading } = useSelector(state => ({
    posts: state.posts.posts,
    loading: state.posts.loading,
  }));
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(getPosts());
  }, []);

  return <PostList loading={loading} posts={posts} />;
};

export default PostsListContainer;
