package caveofprogramming.prodcons;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class GlobalQ {

	public static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
}
