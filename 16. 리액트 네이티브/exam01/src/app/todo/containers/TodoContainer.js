'use client';
import React, { useEffect, useState, useRef, useCallback } from 'react';
import { produce } from 'immer';
import TodoForm from '../components/TodoForm';
import TodoList from '../components/TodoList';

const TodoContainer = () => {
  const [items, setItems] = useState([
    /*{ id: 1, title: '할일 1', content: '내용 1', done: true },
    { id: 2, title: '할일 2', content: '내용 2', done: false },
    { id: 3, title: '할일 3', content: '내용 3', done: false },*/
  ]); /* const [items, setItems] = useState([]) | 0 = items : 상태값, 1 = setItems : 상태 변경 함수, [] 2 : 기본 값 */
  const [form, setForm] = useState({});
  const [errors, setErrors] = useState({});

  const titleRef = useRef(); // useRef 사용

  /*useEffect(() => {
    if (titleRef) {
      titleRef.current.focus();
    }
    console.log('useEffect() 호출');
    return () => {
      console.log('뒷정리 함수 - 2번째 부터 처음 호출 - 정리 작업');
    };
  }, [titleRef]);*/ // [titleRef] = 2번째 -> 변화 기준이 바뀌었을 때 호출

  useEffect(() => {
    if (titleRef) {
      titleRef.current.focus();
    }
  }, [titleRef]);

  const onToggle = useCallback((id) => {
    /*const newItems = items.map((item) =>
      id === item.id ? { ...item, done: !item.done } : item,
    ); setItems(newItems);*/
    /*setItems((prev) =>
      prev.map((item) =>
        item.id === id ? { ...item, done: !item.done } : item,
      ),
    );*/
    setItems(
      produce((draft) => {
        draft
          .filter((item) => item.id === id)
          .forEach((item) => {
            item.done = !item.done;
          });
      }),
    );
  }, []);

  const onRemove = useCallback((id) => {
    // filter 메서드 -> 해당 아이디가 아닌 것만 모아서 제거 -> 새로운 객체 설정
    setItems((items) => items.filter((item) => item.id !== id));
  }, []);

  const onChange = useCallback((e) => {
    /**
     * e.target
     * // e.currentTarget
     */

    const name = e.target.name; /* TodoForm.js 의 name="content" 있는 부분 */
    const value = e.target.value;
    setForm((form) => ({ ...form, [name]: value })); // 지금 상태값을 보내므로 -> 매개변수 따로 입력하지 않아도 됨 | 최초 한 번 만들어지고 계속 활용됨
  }, []);

  const onClick = useCallback((done) => {
    setForm((form) => ({ ...form, done }));
  }, []);

  const onSubmit = useCallback(
    (e) => {
      e.preventDefault(); // 양식 기본 동작 차단

      // 검증
      const _errors = {};
      let hasErrors = false;

      const requiredFields = {
        title: '제목을 입력하세요.',
        content: '내용을 입력하세요.',
      };

      for (const [field, message] of Object.entries(requiredFields)) {
        if (!form[field] || form[field].trim()) {
          _errors[field] = _errors[field] ?? [];
          _errors[field].push(message);
          hasErrors = true;
        }
      }

      setErrors(_errors);
      if (hasErrors) {
        // 검증 실패
        return;
      }

      // 일정 등록 처리
      const nextId = items ? Math.max(...items.map((item) => item.id)) + 1 : 1; // 처음 숫자는 1로 고정
      setItems((items) => items.concat({ ...form, id: nextId }));

      // 양식 초기화
      setForm({});
      titleRef.current.focus();
    },
    [form, items],
  ); // form 과 items 를 사용하고 있으므로 변화 감지 기준의 기본값을 넣어줘야 함

  return (
    <>
      <TodoForm
        onSubmit={onSubmit}
        onChange={onChange}
        onClick={onClick}
        form={form}
        titleRef={titleRef}
        errors={errors}
      />
      <TodoList items={items} onToggle={onToggle} onRemove={onRemove} />
    </>
  );
};

export default React.memo(TodoContainer); // 변화가 있을 때만 로딩될 수 있도록
