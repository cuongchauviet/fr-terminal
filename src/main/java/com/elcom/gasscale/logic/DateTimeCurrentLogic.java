/**
 * 
 */
package com.elcom.gasscale.logic;

import java.time.Instant;

/**
 * @author cuongcv
 *
 */
public class DateTimeCurrentLogic {
	
	public static final long getTimeStem() {
//		long time = Long.valueOf(System.currentTimeMillis()/1000);
		long unix_time = Instant.now().getEpochSecond();
		return unix_time;
	}
}
