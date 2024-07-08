package board.services;

import org.springframework.stereotype.Service;

@Service
public class BoardService {

    public void write() {
        System.out.println("글쓰기!");
    }
}