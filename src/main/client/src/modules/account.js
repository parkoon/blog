import { handleActions } from 'redux-actions';

const LOGIN = 'account/LOGIN';
const LOGIN_SUCCESS = 'account/LOGIN_SUCCESS';
const LOGIN_FAILURE = 'account/LOGIN_FAILURE';
const LOGOUT = 'account/LOGOUT';

export const login = ({ email, password }) => async dispatch => {
  dispatch({ type: LOGIN, loading: true });
  try {
    // const response = await
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
