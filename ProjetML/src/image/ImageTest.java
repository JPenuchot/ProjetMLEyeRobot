/*
 * JUnit test for Image class
 * 
 * @author Théophile Walter
 */

package image;

import static org.junit.Assert.*;

import org.junit.Test;

public class ImageTest {

	@Test
	public void Image() {

		// Default test image (3x2 French flag)
		char[] imgChar = {0, 0, 255, 255, 255, 255, 255, 0, 0,
						0, 0, 255, 255, 255, 255, 255, 0, 0};
		
		Image testChar = new Image ( imgChar, 3, 2);
		
		// getBuffer()
		char[] bufferChar = testChar.getBuffer();
		for (int i = 0; i < bufferChar.length; i++) {
			assertEquals(bufferChar[i], imgChar[i]);
		}
		
		// setPixel()
		assertEquals(testChar.getBuffer()[7], 0);
		testChar.setPixel(2, 0, Image.G, (char)255);
		assertEquals(testChar.getBuffer()[7], 255);
		
		// getPixel()
		assertEquals(testChar.getPixel(2, 0, Image.G), 255);
		
		// getLabel() / setLabel()
		assertEquals(testChar.getLabel(), 2);
		testChar.setLabel(42);
		assertEquals(testChar.getLabel(), 42);
		
		// getWidth() / getHeight
		assertEquals(testChar.getWidth(), 3);
		assertEquals(testChar.getHeight(), 2);
		
	}

}
