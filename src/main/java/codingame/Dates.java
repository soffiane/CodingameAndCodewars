/**
 * Un code issu d'un test technique en ligne
 */

package codingame;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Dates {
    public static void main(String... args){
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now(ZoneId.of("+02:00"));
        LocalDateTime localDateTime =localDate.atTime(localTime);
        //Duration duration = Duration.of(5, ChronoUnit.MONTHS); -> Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unit must not have an estimated duration
        //localDateTime.plus(duration);
        System.out.println(localDateTime.atZone(ZoneOffset.UTC));
    }
}
