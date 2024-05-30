package socket;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable; // 직렬화

@Getter @Setter @ToString
public class Data implements Serializable {
    private String from;
    private String to;
    private String message;
}
