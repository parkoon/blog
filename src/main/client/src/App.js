import React from 'react';
import ReactDOM from 'react-dom';

class App extends React.Component {
  render() {
    return <div className='main'>메인 페이지</div>;
  }
}

ReactDOM.render(<App />, document.getElementById('root'));
