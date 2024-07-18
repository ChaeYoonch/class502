package org.choongang.exam;

import lombok.Data;

@Data
public class PostData {
    private long userId;
    private long id;
    private int title;
    private int body;
}