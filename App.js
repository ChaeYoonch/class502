import React from 'react';
import {SafeAreaView, Button, StyleSheet} from 'react-native';

const App = () => {
  return (
    <SafeAreaView style={stlyes.block}>
      <Button title="확인" />
    </SafeAreaView>
  );
};

const stlyes = StyleSheet.create({
  block: {
    backgroundColor: 'skyblue',
  },
});

export default App;
