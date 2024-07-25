package org.choongang.jpa_study;

import org.choongang.global.board.repositories.BoardDataRepository;
import org.choongang.global.board.repositories.HashTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
// @Transactional
public class Ex11 {

    @Autowired
    private BoardDataRepository boardDataRepository;

    @Autowired
    private HashTagRepository hashTagRepository;
}