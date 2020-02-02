import React from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { logout } from '../modules/account';
import Header from '../components/Header';

const HeaderContainer = () => {
  const user = useSelector(({ account }) => account.user);
  const dispatch = useDispatch();

  return <Header user={user} onLogout={() => dispatch(logout())} />;
};

export default HeaderContainer;
