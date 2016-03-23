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
		String imgCSV = "0,255,255,0,255,255," +
						"0,255,0,0,255,0," +
						"255,255,0,255,255,0";
		
		Image testChar = new Image ( imgChar, 3, 2);
		Image testCSV = new Image ( imgCSV, 3, 2);
		
		// getBuffer()
		char[] bufferChar = testChar.getBuffer();
		char[] bufferCSV = testCSV.getBuffer();
		assertEquals(bufferChar.length, bufferCSV.length);
		for (int i = 0; i < bufferChar.length; i++) {
			assertEquals(bufferChar[i], imgChar[i]);
			assertEquals(bufferCSV[i], imgChar[i]);
		}
		
		// setPixel()
		assertEquals(testChar.getBuffer()[7], 0);
		testChar.setPixel(2, 0, Image.G, (char)255);
		assertEquals(testChar.getBuffer()[7], 255);
		
		assertEquals(testCSV.getBuffer()[7], 0);
		testCSV.setPixel(2, 0, Image.G, (char)255);
		assertEquals(testCSV.getBuffer()[7], 255);
		
		// getPixel()
		assertEquals(testChar.getPixel(2, 0, Image.G), 255);

		assertEquals(testCSV.getPixel(2, 0, Image.G), 255);
		
		// getLabel() / setLabel()
		assertEquals(testChar.getLabel(), 0);
		testChar.setLabel(42);
		assertEquals(testChar.getLabel(), 42);

		assertEquals(testCSV.getLabel(), 0);
		testCSV.setLabel(42);
		assertEquals(testCSV.getLabel(), 42);
		
		// getWidth() / getHeight
		assertEquals(testChar.getWidth(), 3);
		assertEquals(testChar.getHeight(), 2);

		assertEquals(testCSV.getWidth(), 3);
		assertEquals(testCSV.getHeight(), 2);
		
	}

}
