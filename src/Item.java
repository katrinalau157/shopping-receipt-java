import data.ItemData;

import java.util.HashSet;
import java.util.Set;


public class Item
{
	private static final Set<String> CLOTHING_ITEM_CATEGORY = new HashSet<>();
	static
	{
		CLOTHING_ITEM_CATEGORY.add("shirt");
		CLOTHING_ITEM_CATEGORY.add("dress");
		CLOTHING_ITEM_CATEGORY.add("cloth");
	}

	private static final Set<String> FOOD_ITEM_CATEGORY = new HashSet<>();
	static
	{
		FOOD_ITEM_CATEGORY.add("potato chips");
		FOOD_ITEM_CATEGORY.add("potato");
		FOOD_ITEM_CATEGORY.add("chips");
		FOOD_ITEM_CATEGORY.add("apple");
	}

	public static ItemData createItemDataByString(String inputString)
	{
		String[] itemArray = inputString.trim().split(" ");
		ItemData itemData = new ItemData();
		itemData.setQty(Integer.parseInt(itemArray[0]));
		int arrayLength = itemArray.length;
		StringBuilder itemName = new StringBuilder();
		for (int i = 1; i < arrayLength - 1; i++)
		{
			if (!"at".equals(itemArray[i]))
				itemName.append(itemArray[i]).append(" ");
		}
		itemData.setItemName(itemName.toString().trim());
		itemData.setPrice(Double.valueOf(itemArray[arrayLength - 1]));
		itemData.setItemCategory(determineCategory(itemData.getItemName()));
		return itemData;
	}

	public static boolean checkIsFood(String itemName)
	{
		return FOOD_ITEM_CATEGORY.contains(itemName);
	}

	public static boolean checkIsCloth(String itemName)
	{
		return CLOTHING_ITEM_CATEGORY.contains(itemName);
	}

	private static String determineCategory(String itemName)
	{
		if (checkIsCloth(itemName))
		{
			return "clothing";
		}
		else if (checkIsFood(itemName))
		{
			return "food";
		}
		else
		{
			return "other";
		}
	}
}
