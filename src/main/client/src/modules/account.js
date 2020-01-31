import { handleActions } from 'redux-actions';

const initialState = {
  authenticated: false,
  user: null,
};

const account = handleActions({}, initialState);
