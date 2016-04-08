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
