import React, { Component } from 'react';
import Main from './Main';
import Update from './Update';

import {
  BrowserRouter as Router,
  Redirect,
  Route,
  Switch,
} from 'react-router-dom';

class RouterMain extends Component {
  static displayName = 'Todo_Router';

  constructor(props) {
    super(props);
  }
  render() {
    return (
      <React.Fragment>
        <Router>
          <div className="container">
            <Switch>
              <Route path="/" exact component={Main}></Route>
              <Route path="/:id" component={Update}></Route>
              <Redirect to="/" />
            </Switch>
          </div>
        </Router>
      </React.Fragment>
    ); //end return
  } // end render
} //end clas
export default RouterMain;
