package codeKata;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Complete the solution so that it strips all text that follows any of a set of comment markers passed in.
 * Any whitespace at the end of the line should also be stripped out.
 */
public class StripComments {

	private static Object stripComments(String s, String[] strings) {
		String prout = "";
		for(String x : strings){
			prout = prout.concat(x);
		}
		return s.replaceAll("\\s?["+prout+"].*\\s?", "\n").trim();
	}

	@Test
	public void stripComments() throws Exception {
		assertEquals(
				"apples, pears\ngrapes\nbananas",
				StripComments.stripComments( "apples, pears # and bananas\ngrapes\nbananas !apples", new String[] { "#", "!" } )
		);

		assertEquals(
				"a\nc\nd",
				StripComments.stripComments( "a #b\nc\nd $e f g", new String[] { "#", "$" } )
		);

	}


}
