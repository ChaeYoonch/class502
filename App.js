import React from 'react';
import {SafeAreaView, Button, View, StyleSheet} from 'react-native';
import Counter from './components/Counter';

const App = () => {
  return <SafeAreaView style={stlyes.block}></SafeAreaView>;
};

const styles = StyleSheet.create({
  block: {
    flex: 1,
  },
});

/*const stlyes = StyleSheet.create({
  block: {
    backgroundColor: 'blue',
    flexGrow: 1,
    justifyContent: 'center',
  },
  buttons: {
    flexDirection: 'row',
    justifyContent: 'center',
  },
  button: {
    width: 80,
    height: 45,
  },
});*/

export default App;
