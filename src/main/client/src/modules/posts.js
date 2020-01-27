import { handleActions } from 'redux-actions';
import produce from 'immer';
import * as api from '../lib/api';

const GET_POSTS = 'posts/GET_POSTS';
const GET_POSTS_SUCCESS = 'posts/GET_POSTS_SUCCESS';
const GET_POSTS_FAILURE = 'posts/GET_POSTS_FAILURE';

export const getPosts = () => async dispatch => {
  dispatch({ type: GET_POSTS });
  try {
    const response = await api.getPosts();
    dispatch({ type: GET_POSTS_SUCCESS, payload: response.data });
  } catch (e) {
    dispatch({ type: GET_POSTS_FAILURE, payload: e, error: true });
    throw e; // 컴포넌트단에서 에러를 조회할 수 있게 해줌(?)
  }
};

const initialState = {
  loading: false,
  posts: null,
};

const posts = handleActions(
  {
    [GET_POSTS]: state =>
      produce(state, draft => {
        draft.loading = true;
      }),
    [GET_POSTS_SUCCESS]: (state, { payload: posts }) =>
      produce(state, draft => {
        draft.loading = false;
        draft.posts = posts;
      }),
    [GET_POSTS_FAILURE]: (state, action) =>
      produce(state, draft => {
        draft.loading = false;
      }),
  },
  initialState,
);

export default posts;
