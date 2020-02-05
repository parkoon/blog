import axios from 'axios';

export const login = ({ userId, userPassword }) => {
  const data = JSON.stringify({ userId, userPassword });
  return axios.post(`/login/processing`, data, {
    headers: {
      'Content-type': 'application/json',
    },
  });
};
