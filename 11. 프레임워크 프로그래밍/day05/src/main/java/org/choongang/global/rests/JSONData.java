package org.choongang.global.rests;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@RequiredArgsConstructor
public class JSONData {
    private HttpStatus status = HttpStatus.OK; // 성공하든 실패하든 동일한 형식 | 200 (조회) 이 주로 많음
    private boolean success = true; // 성공, 실패 확인 | 실제 응답은 성공 시 가 실패 시 보다 많기 때문에
    private String message; // 실패 시 메세지
    @NonNull
    private Object data; // 성공 시 데이터 | 모든 값이 들어오므로 Object | 데이터를 변경해야 하는 경우도 있으므로 @NonNull
}