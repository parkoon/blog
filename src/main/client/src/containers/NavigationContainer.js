import React from 'react';
import { connect } from 'react-redux';

const NavigationContainer = ({ menus }) => {
  return <div>{menus.map(menu => menu)}</div>;
};

const mapStateToProps = ({ navigation }) => ({
  menus: navigation.menus,
});

export default connect(mapStateToProps)(NavigationContainer);
