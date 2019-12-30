/**
 * 
 */
package com.elcom.gasscale.logic;

/**
 * @author cuongcv
 *
 */
public enum PageableEnum {
	STATUS("status");
	
	
    public static final String ASC = "ASC";
    public static final String DESC = "DESC";
    public static final String CREATE_TIME = "createTime";
    public static final String UPDATE_TIME = "updateTime";
    public static final byte STATUS_ENABLE = 0;
    public static final byte STATUS_DISABLE = 1;
    
    
    private final String text;
    PageableEnum(final String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        return text;
    }
}
