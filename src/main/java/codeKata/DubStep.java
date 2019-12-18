/**
 * Input
 *
 * The input consists of a single non-empty string,
 * consisting only of uppercase English letters, the string's length doesn't exceed 200 characters
 *
 * Output
 *
 * Return the words of the initial song that Polycarpus used to make a dubsteb remix. Separate the words with a space.
 * Examples
 *
 * songDecoder("WUBWEWUBAREWUBWUBTHEWUBCHAMPIONSWUBMYWUBFRIENDWUB")
 *   // =>  WE ARE THE CHAMPIONS MY FRIEND
 */
package codeKata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DubStep {
    public static String SongDecoder (String song)
    {
        return song.replaceAll("(WUB)+"," ").trim();

        //avec un stream
        /*
        return Arrays.stream(song.split("WUB"))
                   .filter(i -> !"".equals(i))
                   .collect(Collectors.joining(" "));

        return Stream.of(song.split("WUB")).filter(s -> ! s.isEmpty()).collect(Collectors.joining(" "));
         */
    }

    @Test
    public void Test1() {
        assertEquals("ABC", DubStep.SongDecoder("WUBWUBABCWUB"));
    }
    @Test
    public void Test2()
    {
        assertEquals("R L", DubStep.SongDecoder("RWUBWUBWUBLWUB"));
    }
}
