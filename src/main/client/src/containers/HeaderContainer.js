import React from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { logout } from '../modules/auth';
import Header from '../components/Header';

const HeaderContainer = () => {
  const user = useSelector(({ auth }) => account.user);
  const dispatch = useDispatch();

  return <Header user={user} onLogout={() => dispatch(logout())} />;
};

export default HeaderContainer;
