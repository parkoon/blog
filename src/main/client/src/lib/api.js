import axios from 'axios';

export const getPosts = () =>
  axios.get(`https://jsonplaceholder.typicode.com/posts`);

export const login = (userId, userPassword) =>
  axios.post(`http://localhost:8080/login/processing`, {
    headers: {
      'Content-type': 'application/json',
    },
    userId,
    userPassword,
  });
