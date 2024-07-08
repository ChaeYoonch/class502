package board.services;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public class BoardService implements InitializingBean, DisposableBean {

    public void write() {
        System.out.println("글쓰기!");
    }

    @Override
    public void afterPropertiesSet() throws Exception { // 컨테이너 생성 시 호출됨
        System.out.println("afterPropertiesSet()!");
    }

    @Override
    public void destroy() throws Exception { // 객체 소멸 직후 호출됨
        System.out.println("destroy()!");
    }
}