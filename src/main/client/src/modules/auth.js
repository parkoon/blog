import { handleActions } from 'redux-actions';
import produce from 'immer';
import * as authAPI from '../lib/api/auth';

const LOGIN = 'auth/LOGIN';
const LOGIN_SUCCESS = 'auth/LOGIN_SUCCESS';
const LOGIN_FAILURE = 'auth/LOGIN_FAILURE';
const LOGOUT = 'auth/LOGOUT';

export const login = ({ userId, userPassword }) => async dispatch => {
  dispatch({ type: LOGIN });
  try {
    await authAPI.login({ userId, userPassword });
    dispatch({ type: LOGIN_SUCCESS });
  } catch (e) {
    dispatch({ type: LOGIN_FAILURE });
    throw e;
  }
};

export const logout = () => ({
  type: LOGOUT,
});

const initialState = {
  login: {
    loading: false,
    logged: false,
  },
};

const auth = handleActions(
  {
    [LOGIN]: state =>
      produce(state, draft => {
        draft.login.loading = true;
      }),
    [LOGIN_SUCCESS]: state =>
      produce(state, draft => {
        draft.login.loading = false;
        draft.login.logged = true;
      }),
    [LOGOUT]: state =>
      produce(state, draft => {
        draft.login.logged = false;
      }),
  },
  initialState,
);

export default auth;
