import React from 'react';
import {SafeAreaView, Button, StyleSheet} from 'react-native';

const App = () => {
  return (
    <SafeAreaView style={stlyes.block}>
      <Button title="확인" style={stlyes.button} />
    </SafeAreaView>
  );
};

const stlyes = StyleSheet.create({
  block: {
    backgroundColor: 'blue',
  },
  button: {
    width: 80,
    height: 45,
  },
});

export default App;
