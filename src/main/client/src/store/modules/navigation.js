import produce from 'immer';
import uuidv1 from 'uuid/v1';

const initialState = {
  open: true,
  mode: 'default', // default, edit
  menus: [
    {
      root: { id: uuidv1(), text: 'ITEM 1' },
      submenus: [
        { id: uuidv1(), text: '- item A' },
        { id: uuidv1(), text: '- item B' },
        { id: uuidv1(), text: '- item C' },
      ],
    },
    {
      root: { id: uuidv1(), text: 'ITEM 2' },
      submenus: [],
    },
    {
      root: { id: uuidv1(), text: 'ITEM 3' },
      submenus: [
        { id: uuidv1(), text: '- item A' },
        { id: uuidv1(), text: '- item B' },
      ],
    },
  ],
};

const CHANGE_MODE = 'CHANGE_MODE';
const ADD_MENU = 'ADD_MENU';
const DELETE_MENU = 'DELETE_MENU';
const CHANGE_MENU_TEXT = 'CHANGE_MENU_TEXT';
const TOGGLE_NAVIGATION = 'TOGGLE_NAVIGATION';

export function changeMode(mode) {
  return {
    type: CHANGE_MODE,
    mode,
  };
}

export function addMenu({ id, text }) {
  return {
    type: ADD_MENU,
    id,
    text,
  };
}

export function deleteMenu(index, subIndex) {
  return {
    type: DELETE_MENU,
    index,
    subIndex,
  };
}

export function changeMenuText({ id, text }) {
  return {
    type: CHANGE_MENU_TEXT,
    id,
    text,
  };
}

export function toggleNavigation() {
  return {
    type: TOGGLE_NAVIGATION,
  };
}

export default function navigation(state = initialState, action) {
  return produce(state, draft => {
    switch (action.type) {
      case CHANGE_MODE:
        draft.mode = action.mode;
        break;
      case ADD_MENU:
        draft.menus.push({
          root: { id: action.id, text: action.text },
          submenus: [],
        });
        break;
      case DELETE_MENU:
        if (action.subindex !== undefined) {
          draft.menus[action.index].submenus.splice(action.subindex, 1);
        } else {
          draft.menus.splice(action.index, 1);
        }
        break;
      case CHANGE_MENU_TEXT:
        const menuLength = draft.menus.length;
        for (let i = 0; i < menuLength; i++) {
          let menu = draft.menus[i];
          if (menu.root.id === action.id) {
            menu.root.text = action.text;
            break;
          }

          const submenuLength = menu.submenus.length;
          for (let j = 0; j < submenuLength; j++) {
            let submenu = menu.submenus[j];
            if (submenu.id === action.id) {
              submenu.text = action.text;
              break;
            }
          }
        }
        break;
      case TOGGLE_NAVIGATION:
        draft.open = !draft.open;
        break;
      default:
        return draft;
    }
  });
}
