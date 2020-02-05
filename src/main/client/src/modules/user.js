import { handleActions } from 'redux-actions';
import produce from 'immer';

const SET_USER_INFO = 'user/SET_USER_INFO';
const REMOVE_USER_INFO = 'user/REMOVE_USER_INFO';

export const setUserInfo = ({ userId }) => ({
  type: SET_USER_INFO,
  userId,
});

export const removeUserInfo = () => ({ type: REMOVE_USER_INFO });

const initialState = {
  logged: false,
  loggedInfo: {
    userId: null,
  },
};

const user = handleActions(
  {
    [SET_USER_INFO]: (state, { userId }) =>
      produce(state, draft => {
        draft.logged = true;
        draft.loggedInfo.userId = userId;
      }),
    [REMOVE_USER_INFO]: state =>
      produce(state, draft => {
        draft.logged = false;
        draft.loggedInfo.userId = null;
      }),
  },
  initialState,
);

export default user;
