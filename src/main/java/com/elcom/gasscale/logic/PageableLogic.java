/**
 * 
 */
package com.elcom.gasscale.logic;

import org.springframework.data.domain.Sort;

/**
 * @author cuongcv
 *
 */

public class PageableLogic {

	public static Sort sortSetDefault(String sortCol, String sortDirect) {
		if(sortCol == null || sortCol.isEmpty()) sortCol = PageableEnum.CREATE_TIME;
		if(sortDirect == null || sortDirect.isEmpty()) sortDirect = PageableEnum.DESC;
		Sort sort =Sort.by(sortCol);
		if(sortDirect.compareTo(PageableEnum.ASC) == 0) {
			sort = sort.ascending();
		} else {
			sort = sort.descending();
		}
		return sort;
	}
	
}
