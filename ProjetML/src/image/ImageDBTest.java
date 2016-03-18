/*
 * JUnit test for ImageDB class
 * 
 * @author Théophile Walter
 */

package image;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class ImageDBTest {

	@Test
	public void ImageDB() {

		// Creating some images
		Image frenchFlag = new Image ( new char[] {0, 0, 255, 255, 255, 255, 255, 0, 0,
				0, 0, 255, 255, 255, 255, 255, 0, 0}, 3, 2);
		Image italianFlag = new Image ( new char[] {0, 255, 0, 255, 255, 255, 255, 0, 0,
			0, 255, 0, 255, 255, 255, 255, 0, 0}, 3, 2);
		Image black = new Image (new char[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 2, 2);
		Image white = new Image (new char[] {255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, 2, 2);
		
		ArrayList<Image> list = new ArrayList<Image>();
		list.add(frenchFlag); list.add(italianFlag); list.add(black); list.add(white); 
		
		// Creating full database
		ImageDB fullDB = new ImageDB ( list);
		
		// Creating empty database
		ImageDB emptyDB = new ImageDB();
		
		// Creating variable size database
		list.remove(0); list.remove(0);
		ImageDB vsDB = new ImageDB ( list);
		
		// size()
		assertEquals(fullDB.size(), 4);
		assertEquals(emptyDB.size(), 0);
		assertEquals(vsDB.size(), 2);
		
		// add()
		assertEquals(vsDB.size(), 2);
		vsDB.add(frenchFlag);
		assertEquals(vsDB.size(), 3);
		
		// Remove()
		vsDB.remove(1);
		assertEquals(vsDB.size(), 2);
		
		// get()
		Assert.assertArrayEquals(fullDB.get(2).getBuffer(), black.getBuffer());
		
		// Test the iteratability of the class
		int count = 0;
		for (Image i : fullDB) {
			assertTrue(i.getHeight() == 2);
			count++;
		}
		assertEquals(count, 4);
		
	}

}
