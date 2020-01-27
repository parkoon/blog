import React, { useEffect } from 'react';
import { connect } from 'react-redux';
import { getPosts } from '../modules/posts';
import PostList from '../components/PostList';

const PostsContainer = ({ loading, posts, getPosts }) => {
  useEffect(() => {
    getPosts();
    return () => {};
  }, [getPosts]);

  return <PostList loading={loading} posts={posts} />;
};

export default connect(
  ({ posts }) => ({
    loading: posts.loading,
    posts: posts.posts,
  }),
  { getPosts },
)(PostsContainer);
