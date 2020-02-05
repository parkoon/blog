import React from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { logout } from '../modules/auth';
import { removeUserInfo } from '../modules/user';
import Header from '../components/Header';

const HeaderContainer = () => {
  const { userLogged, userInfo } = useSelector(({ user }) => ({
    userLogged: user.logged,
    userLoggedInfo: user.loggedInfo,
  }));
  const dispatch = useDispatch();

  return (
    <Header
      userLogged={userLogged}
      userLoggedInfo={userLoggedInfo}
      onLogout={() => {
        dispatch(logout());
        dispatch(removeUserInfo());
      }}
    />
  );
};

export default HeaderContainer;
