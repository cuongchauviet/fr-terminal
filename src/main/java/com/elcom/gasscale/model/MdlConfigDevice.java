/**
 * 
 */
package com.elcom.gasscale.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cuongcv
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MdlConfigDevice {
	
	private short warningPercentGas;
	
	private short warningPercentBattery;
	
	private int idTypeGasTank;
	
	private String nameGasTank;
	
	private double weightCrustGasTank;
	
	private double weightInsidesGasTank;
}
