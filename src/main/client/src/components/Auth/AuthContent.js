import React from 'react';

const AuthContent = ({ title, children }) => {
  return (
    <div>
      <h1>{title}</h1>
      {children}
    </div>
  );
};

export default AuthContent;
