package com.fsa.utilities;

import java.util.List;

import com.fsa.formatter.DisplayFormatCreatorFactory;
import com.fsa.formatter.FormatCreatorTypes;
import com.fsa.formatter.Formatter;
import com.fsa.formatter.FormatterCreator;
import com.fsa.formatter.FormatterTypes;
import com.fsa.model.contract.MenuItem;
import com.fsa.service.contract.RestaurantInfo;

public class RestaurantMenuDisplayUtility {
	List<MenuItem> menuLst = null;

	public RestaurantMenuDisplayUtility(List<MenuItem> menuItemLst) {
		this.menuLst = menuItemLst;
	}

	public String displayRestaurantMenuInformation() {
		FormatterCreator creator = DisplayFormatCreatorFactory.getFormatCreatorFactory()
				.createFormatter(FormatCreatorTypes.TAB_CHAR);
		Formatter displayFormatter = creator.createFormatter(FormatterTypes.TWOTAB_LOWER);
		StringBuilder builder = new StringBuilder();
		if (null != menuLst && !menuLst.isEmpty()) {
			builder.append(displayFormatter.format("id")).append(displayFormatter.format("Name"))
					.append(displayFormatter.format("Category")).append(displayFormatter.format("Price"));
			for (MenuItem menuInfo : menuLst) {
				builder.append("\n");
				builder.append(displayFormatter.format(menuInfo.getMenuId().toString()))
						.append(displayFormatter.format(menuInfo.getItemName()))
						.append(displayFormatter.format(menuInfo.getItemCategory().toString()))
						.append(displayFormatter.format(menuInfo.getItemPrice().toString()));
			}
//			System.out.println(builder.toString());

			return builder.toString();
		} else {
			System.out.println("There is no menu found for this restaurant");
			return "There is no menu found for this restaurant";
		}

	}

}
