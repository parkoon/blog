import React, { useRef } from 'react';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';
import Button from '@material-ui/core/Button';
import OutlinedInput from '@material-ui/core/OutlinedInput';
import InputAdornment from '@material-ui/core/InputAdornment';
import IconButton from '@material-ui/core/IconButton';
import AddIcon from '@material-ui/icons/Add';
import NestedListItem from './NestedListItem';
import EditableListItem from './EditableListItem';
import DeleteButton from './DeleteButton';

const Navigation = ({
  mode,
  menus,
  onClickEdit,
  onClickSave,
  onClickAdd,
  onClickDelete,
  onChangeInput,
}) => {
  const addInputRef = useRef(null);

  return (
    <>
      {mode === 'edit' ? (
        <>
          <div>
            {menus.map((menu, i) => {
              const { root, submenus } = menu;

              return (
                <>
                  <EditableListItem
                    key={root.id}
                    defaultValue={root.text}
                    onChangeInput={e => {
                      onChangeInput({
                        id: root.id,
                        text: e.target.value,
                      });
                    }}
                    EndButton={
                      <DeleteButton onClick={() => onClickDelete(i)} />
                    }
                  />

                  {submenus.length > 0 &&
                    submenus.map((submenu, j) => (
                      <EditableListItem
                        key={submenu.id}
                        defaultValue={submenu.text}
                        onChangeInput={e => {
                          onChangeInput({
                            id: submenu.id,
                            text: e.target.value,
                          });
                        }}
                        EndButton={
                          <DeleteButton onClick={() => onClickDelete(i, j)} />
                        }
                      />
                    ))}
                </>
              );
            })}
            <form
              onSubmit={e => {
                e.preventDefault();
                onClickAdd(addInputRef.current.value);
                addInputRef.current.value = '';
              }}
            >
              <OutlinedInput
                inputRef={addInputRef}
                type='text'
                placeholder='New Menu'
                endAdornment={
                  <InputAdornment position='end'>
                    <IconButton type='submit'>
                      <AddIcon />
                    </IconButton>
                  </InputAdornment>
                }
              />
            </form>
          </div>
          <Button onClick={onClickSave}>SAVE</Button>
        </>
      ) : (
        <>
          <List component='nav'>
            {menus.map(menu => {
              const { root, submenus } = menu;

              return submenus.length > 0 ? (
                <NestedListItem
                  headerItemText={root.text}
                  nestedList={submenus}
                />
              ) : (
                <ListItem button>
                  <ListItemText primary={root.text} />
                </ListItem>
              );
            })}
          </List>
          <Button onClick={onClickEdit}>EDIT</Button>
        </>
      )}
    </>
  );
};

export default Navigation;
