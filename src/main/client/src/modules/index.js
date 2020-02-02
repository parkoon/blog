import { combineReducers } from 'redux';
import posts from './posts';
import account from './account';

export default combineReducers({ posts, account });
