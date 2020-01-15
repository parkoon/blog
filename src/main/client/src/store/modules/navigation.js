const initialState = {
  menus: [
    ['ITEM 1', ['ITEM 1-1', 'ITEM 1-2', 'ITEM 1-3']],
    ['ITEM 2'],
    ['ITEM 3', ['ITEM 3-1', 'ITEM 3-2']],
  ],
};

export default function navigation(state = initialState, action) {
  return state;
}
