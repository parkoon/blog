import React from 'react';
import { connect } from 'react-redux';
import uuidv1 from 'uuid/v1';
import Navigation from '../components/Navigation';
import {
  changeMode,
  addMenu,
  deleteMenu,
  changeMenuText,
} from '../store/modules/navigation';

const NavigationContainer = ({
  mode,
  menus,
  onClickEdit,
  onClickSave,
  onClickAdd,
  onClickDelete,
  onChangeInput,
}) => {
  return (
    <Navigation
      mode={mode}
      menus={menus}
      onClickEdit={onClickEdit}
      onClickSave={onClickSave}
      onClickAdd={onClickAdd}
      onClickDelete={onClickDelete}
      onChangeInput={onChangeInput}
    />
  );
};

const mapStateToProps = ({ navigation }) => ({
  mode: navigation.mode,
  menus: navigation.menus,
});

const mapDispatchToProps = dispatch => ({
  onClickEdit: () => dispatch(changeMode('edit')),
  onClickSave: () => dispatch(changeMode('default')),
  onClickAdd: text => {
    const id = uuidv1();
    dispatch(addMenu({ id, text: !!text ? text : 'Untitled' }));
  },
  onClickDelete: (index, subindex) => {
    !subindex && alert('하위 메뉴가 모두 삭제됩니다.');
    console.log(index, subindex);
    dispatch(deleteMenu(index, subindex));
  },
  onChangeInput: ({ id, text }) =>
    dispatch(changeMenuText({ id, text: !!text ? text : 'Untitled' })),
});

export default connect(
  mapStateToProps,
  mapDispatchToProps,
)(NavigationContainer);
