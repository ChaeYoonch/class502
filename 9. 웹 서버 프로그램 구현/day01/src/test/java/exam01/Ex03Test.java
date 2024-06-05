package exam01;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Ex03Test {

    @TempDir
    private File tempDir;

    @Test
    void test1() {
        String path = tempDir.getAbsolutePath(); // 절대경로 확인
        System.out.println(path);
    }

    @Test
    @Timeout(value = 2500, unit= TimeUnit.MILLISECONDS)
        // Timeout : positive number (정수) & default SECONDS ('초'단위) | @Timeout(3) : 3초 내에 수행되면 테스트 통과
    void test2() throws Exception {
        Thread.sleep(2000); // 5초 지연
    }
}
