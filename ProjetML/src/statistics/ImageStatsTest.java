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
