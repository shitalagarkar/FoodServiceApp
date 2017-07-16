package com.fsa.utilities;

import java.util.List;

import com.fsa.formatter.DisplayFormatCreatorFactory;
import com.fsa.formatter.FormatCreatorTypes;
import com.fsa.formatter.Formatter;
import com.fsa.formatter.FormatterCreator;
import com.fsa.formatter.FormatterTypes;
import com.fsa.service.contract.RestaurantInfo;

public class RestaurantDisplayUtility {
	FormatCreatorTypes creatorType = null;
	FormatterTypes formatterType = null;
	FormatterCreator creator = null;
	Formatter displayFormatter = null;

	public RestaurantDisplayUtility(FormatCreatorTypes creatorType, FormatterTypes formatterType) {
		this.creatorType = creatorType;
		this.formatterType = formatterType;
		
		creator = DisplayFormatCreatorFactory.getFormatCreatorFactory()
				.createFormatter(creatorType);
		 displayFormatter = creator.createFormatter(formatterType);
	}

	public boolean displayRestaurantInformation(List<RestaurantInfo> restInfoLst ) {
		StringBuilder builder = new StringBuilder();
		if (null != restInfoLst && !restInfoLst.isEmpty()) {
			builder.append(displayFormatter.format("id")).append(displayFormatter.format("Name"))
					.append(displayFormatter.format("Address")).append(displayFormatter.format("Rating"));
			for (RestaurantInfo restInfo : restInfoLst) {
				builder.append("\n");
				builder.append(displayFormatter.format(restInfo.getId().toString()))
						.append(displayFormatter.format(restInfo.getRestarantName()))
						.append(displayFormatter.format(restInfo.getRestarantAddress()))
						.append(displayFormatter.format(restInfo.getRestarantRating().toString()));
			}
			System.out.println(builder.toString());

			return true;
		} else {
			System.out.println("There is no restaurant found for given criteria");
			return false;
		}

	}

	
	public boolean displayRestaurantMenuInformation(RestaurantInfo restInfo) {
 		StringBuilder builder = new StringBuilder();
		if (null != restInfo ) {
			/*builder.append(displayFormatter.format("id")).append(displayFormatter.format("Name"))
					.append(displayFormatter.format("Address")).append(displayFormatter.format("Rating"));
			builder.append("\n");
				builder.append(displayFormatter.format(restInfo.getId().toString()))
						.append(displayFormatter.format(restInfo.getRestarantName()))
						.append(displayFormatter.format(restInfo.getRestarantAddress()))
						.append(displayFormatter.format(restInfo.getRestarantRating().toString()));
			System.out.println(builder.toString());*/
			System.out.println(restInfo.getMenu());
			return true;
		} else {
			System.out.println("There is no restaurant found for given criteria");
			return false;
		}

	}
	
	
}
