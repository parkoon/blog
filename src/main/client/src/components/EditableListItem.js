import React from 'react';
import { DragSource } from 'react-dnd';
import OutlinedInput from '@material-ui/core/OutlinedInput';
import InputAdornment from '@material-ui/core/InputAdornment';

const EditableListItem = ({
  defaultValue = '',
  onChangeInput = () => {},
  EndButton = null,
}) => {
  return (
    <OutlinedInput
      type='text'
      placeholder='Untitled'
      variant='outlined'
      defaultValue={defaultValue}
      onChange={onChangeInput}
      endAdornment={<InputAdornment position='end'>{EndButton}</InputAdornment>}
    />
  );
};

export default EditableListItem;
