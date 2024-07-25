package org.choongang.jpa_study;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.global.board.entities.HashTag;
import org.choongang.global.board.repositories.BoardDataRepository;
import org.choongang.global.board.repositories.HashTagRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
// @Transactional
public class Ex11 {

    @Autowired
    private BoardDataRepository boardDataRepository;

    @Autowired
    private HashTagRepository hashTagRepository;

    @PersistenceContext
    private EntityManager em;

    @BeforeEach
    void init() {
        List<HashTag> tags = IntStream.rangeClosed(1, 5) // 5개 태그 생성
                                      .mapToObj(i -> HashTag.builder().tag("태그" + i).build()).toList();

        hashTagRepository.saveAllAndFlush(tags);
    }
}