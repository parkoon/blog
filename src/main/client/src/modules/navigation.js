import { handleActions } from 'redux-actions';
import produce from 'immer';

const CHANGE_MODE = 'navigation/CHANGE_MODE';

export const changeMode = mode => ({ type: CHANGE_MODE, mode });

const initialState = {
  mode: 'default', // default, edit
  menus: [],
};

const navigation = handleActions(
  {
    [CHANGE_MODE]: (state, action) =>
      produce(state, draft => {
        draft.mode = action.mode;
      }),
  },
  initialState,
);

export default navigation;
