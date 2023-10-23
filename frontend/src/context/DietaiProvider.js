import React, { useMemo, useState } from 'react';
import PropTypes from 'prop-types';
import dietAiContext from './DietaiContext';

function Provider({ children }) {
  const [username, setUsername] = useState('');

  const value = useMemo(() => (
    {
        username,
        setUsername,
    }
  ), [username, setUsername]);

  return (
    <dietAiContext.Provider value={ value }>
      {children}
    </dietAiContext.Provider>
  );
}

Provider.propTypes = {
  children: PropTypes.node,
}.isRequired;

export default Provider;