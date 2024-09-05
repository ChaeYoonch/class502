import React from 'react'; /* 맥에서는 안 쓰면 오류 발생 | 리액트 네이티브 : 안 쓰면 윈도우, 맥 모두 오류 발생 */

const Greeting = ({ name, age, children }) => {
  age = age ?? 20; /* Greeting.defaultProps 대신 사용 */
  return (
    <div>
      <h1>{name}님, 안녕하세요!</h1>
      <h2>나이는 : {age} 입니다!</h2>
      <div>{children(100)}</div>
      {/* <div>{children}</div> */}
    </div> /* {props.name} = {name} */
  );
};

/*Greeting.defaultProps = {
  age: 20,
}; 기본 값 설정 */

export default Greeting;
