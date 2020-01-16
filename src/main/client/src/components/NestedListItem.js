import React, { useState } from 'react';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ExpandLess from '@material-ui/icons/ExpandLess';
import ExpandMore from '@material-ui/icons/ExpandMore';
import Collapse from '@material-ui/core/Collapse';
import ListItemText from '@material-ui/core/ListItemText';

const NestedListItem = ({ headerItemText = '', nestedList = [] }) => {
  const [open, setOpen] = useState(false);

  const onClick = () => {
    setOpen(!open);
  };

  return (
    <>
      <ListItem button onClick={onClick}>
        <ListItemText primary={headerItemText} />
        {open ? <ExpandLess /> : <ExpandMore />}
      </ListItem>
      <Collapse in={open}>
        <List component='ul'>
          {nestedList.map(nestedListItem => (
            <ListItem button>
              <ListItemText primary={nestedListItem.text} />
            </ListItem>
          ))}
        </List>
      </Collapse>
    </>
  );
};

export default NestedListItem;
