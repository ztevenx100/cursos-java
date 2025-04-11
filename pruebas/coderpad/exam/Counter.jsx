import React from 'react';

class Counter extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      value: 0
    };
    // Binding explícito de los métodos
    this.increment = this.increment.bind(this);
    this.decrement = this.decrement.bind(this);
  }

  increment() {
    this.setState(prevState => ({
      value: prevState.value + 1
    }));
  }

  decrement() {
    this.setState(prevState => ({
      value: prevState.value - 1
    }));
  }

  render() {
    return (
      <div>
        <p id="value">{this.state.value}</p>
        <button id="increment" onClick={this.increment}>+</button>
        <button id="decrement" onClick={this.decrement}>-</button>
      </div>
    );
  }
}

export default Counter;