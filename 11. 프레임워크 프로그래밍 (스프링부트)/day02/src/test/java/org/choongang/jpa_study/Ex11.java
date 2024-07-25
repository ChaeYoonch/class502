package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.choongang.global.board.entities.BoardData;
import org.choongang.global.board.entities.HashTag;
import org.choongang.global.board.repositories.BoardDataRepository;
import org.choongang.global.board.repositories.HashTagRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
@Transactional
public class Ex11 {

    @Autowired
    private BoardDataRepository boardDataRepository;

    @Autowired
    private HashTagRepository hashTagRepository;

    @PersistenceContext
    private EntityManager em;

    @BeforeEach
    void init() {
        List<HashTag> tags = IntStream.rangeClosed(1, 5) // 5개 태그 추가
                                      .mapToObj(i -> HashTag.builder().tag("태그" + i).build()).toList();

        hashTagRepository.saveAllAndFlush(tags);

        List<BoardData> items = IntStream.rangeClosed(1, 5) // 5개 게시글 추가
                                         .mapToObj(i -> BoardData.builder()
                                         .subject("제목" + i)
                                         .content("내용" + i)
                                         .tags(tags)
                                         .build()).toList();

        boardDataRepository.saveAllAndFlush(items);
    }

    @Test
    void test1() {
        BoardData item = boardDataRepository.findById(1L).orElse(null);
        List<HashTag> tags = item.getTags();
        tags.forEach(System.out::println); // 출력
    }

    @Test
    void test2() {
        HashTag tag = hashTagRepository.findById("태그2").orElse(null);
        List<BoardData> items = tag.getItems();
        items.forEach(System.out::println);
    }
}