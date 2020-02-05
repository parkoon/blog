import { handleActions } from 'redux-actions';
import * as api from '../lib/api';

const LOGIN = 'auth/LOGIN';
const LOGIN_SUCCESS = 'auth/LOGIN_SUCCESS';
const LOGIN_FAILURE = 'auth/LOGIN_FAILURE';
const LOGOUT = 'auth/LOGOUT';

export const login = ({ userId, userPassword }) => async dispatch => {
  dispatch({ type: LOGIN, loading: true });
  try {
    const response = await api.login(userId, userPassword);
    console.log(response);
    dispatch({
      type: LOGIN_SUCCESS,
      // token: response. ... ,
      user: { email, password },
      loading: false,
    });
  } catch (e) {
    dispatch({ type: LOGIN_FAILURE, loading: false });
    throw e;
  }
};

export const logout = () => ({
  type: LOGOUT,
});

const initialState = {
  token: null,
  user: { id: 'test' },
  loading: false,
};

const account = handleActions(
  {
    // [LOGIN]
    [LOGOUT]: state => ({
      user: null,
    }),
  },
  initialState,
);

export default account;
