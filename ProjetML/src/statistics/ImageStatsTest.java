package statistics;

import static org.junit.Assert.*;
import org.junit.Test;
import image.Image;

public class ImageStatsTest {

	@Test
	public void test() {
		
		char[] imgTest1 = {0,1,2,0,1,2,0,1,2,0,1,2,
						   0,1,2,0,1,2,0,1,2,0,1,2,
						   0,1,2,0,1,2,0,1,2,0,1,2,
						   0,1,2,0,1,2,0,1,2,0,1,2};
		
		char[] imgTest2 = {1,1,1,1,1,1,1,1,1,1,1,1,
						   1,1,1,1,1,1,1,1,1,1,1,1,
						   1,1,1,1,1,1,1,1,1,1,1,1,
						   1,1,1,1,1,1,1,1,1,1,1,1};
		
		Image imgT1 = new Image(imgTest1, 4, 50);
		Image imgT2 = new Image(imgTest2, 4, 20);
		
		assertEquals(ImageStats.sparsity(imgT1), 16./48., 0.01);
		assertEquals(ImageStats.sparsity(imgT2), 0., 0.01);
		
	}

}

//////////////////////////////////////////////////////////////////////////////

package statistics;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import image.ImageDB;
import io.CSVContiguous;

public class DBStatsTest {

	@Test
	public void test() throws IOException {
		
		ImageDB db = (new CSVContiguous()).readDB("test.csv");
		
		int[] lab = {0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		
		assertEquals(DBStats.sparsity(db), 64./1024., 0.01);
		assertArrayEquals(DBStats.labelEffectives(db), lab);
	}
}
