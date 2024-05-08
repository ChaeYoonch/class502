package exam02;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class Ex09 {
    public static void main(String[] args) {
        ZonedDateTime zdt1 = ZonedDateTime.now();
        System.out.println(zdt1);

        // ZoneId.getAvailableZoneIds().forEach(System.out::println);
        ZoneId london = ZoneId.of("Europe/London"); // GMT 기준 시간대
        ZonedDateTime londonZdt = zdt1.withZoneSameInstant(london);
        System.out.println(londonZdt);

        ZonedDateTime newYorkZdt = zdt1.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println(newYorkZdt);
    }
}
