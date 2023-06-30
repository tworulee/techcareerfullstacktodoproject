import React, { Component } from 'react';

class Input extends Component {
  static displayName = 'Input';

  // CONSTRUCTOR
  constructor(props) {
    super(props);
  }

  render() {
    const { t } = this.props;
    return (
      <form className="create_form" method="post" autoComplete="true">
        <div className="inputBox">
          <div className="row">
            <div className="input-group mb-2">
              <input
                type="text"
                className="form-control"
                placeholder="Yeni Görevin"
                id="testid"
                name="test"
                required={true}
                onChange={this.props.onChangeInputValue}
              />
            </div>
            <div className="row">
              <button
                className="btn text-white myButton"
                onClick={this.props.todoCreateSubmit}
              >
                Yeni Görev Ekle
              </button>
            </div>
          </div>
        </div>
      </form>
    ); // end return
  } // end render
} // end Inpt
export default Input;
