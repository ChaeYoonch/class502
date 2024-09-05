'use client';
import React, { useState, useRef } from 'react';

const Counter = (e) => {
  const [num, setNum] = useState(0);

  let num2 = useRef(1); // 1 = 초기 값 | useRef : current 값 사용

  const onIncrease = () => {
    setNum(num + 1);
    num2.current++; /* .current 추가 */
    console.log('num2', num2.current);
  };

  const onDecrease = () => setNum(num - 1);

  return (
    <>
      <h1>{num}</h1>
      <button type="button" onClick={onDecrease}>
        -1
      </button>
      <button type="button" onClick={onIncrease}>
        +1
      </button>
    </>
  );
};

export default Counter; /* export default = 모듈 내보내기 */
