import React from 'react';

import ReactDOM from 'react-dom/client';

import reportWebVitals from './reportWebVitals';

import RouterMain from './component/RouterMain';

// CSS
import './index.css';

// DOM ROOT
const root = ReactDOM.createRoot(document.getElementById('root'));

// RENDER
root.render(
  <React.StrictMode>
    <React.Fragment>
      <RouterMain />
    </React.Fragment>
  </React.StrictMode>
);

reportWebVitals();
