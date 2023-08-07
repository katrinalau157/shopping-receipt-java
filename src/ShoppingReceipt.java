import data.ItemData;
import factory.TaxCalculator;
import factory.TaxCalculatorFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ShoppingReceipt
{
	public static void main(String[] args)
	{
		try (Scanner scanner = new Scanner(System.in))
		{
			System.out.print("Input: ");
			//example input
			//Location: CA, 1 book at 17.99, 1 potato chips at 3.99
			//Location: NY, 1 book at 17.99, 3 pencils at 2.99
			//Location: NY, 2 pencils at 2.99, 1 shirt at 29.99
			String input = scanner.nextLine();

			//split input string by comma and space
			String[] splitInput = input.split("(,\\s)|(,)");

			//create list of itemData using user input
			List<ItemData> itemDataList = new ArrayList<>();
			String location = getLocationByString(splitInput[0]);
			for (int i = 1; i < splitInput.length; i++)
			{
				ItemData itemData = Item.createItemDataByString(splitInput[i]);
				itemDataList.add(itemData);
			}
			//start print receipt after create item list
			printReceipt(location, itemDataList);
		}
		catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException)
		{
			System.out.println("Invalid input");
		}
		catch (Exception e)
		{
			System.out.println("Exception occurred " + e.getMessage());
		}
	}

	public static String getLocationByString(String locationString)
	{
		String[] stringArray = locationString.trim().split(" ");
		return stringArray[1];
	}

	public static void printReceipt(String location, List<ItemData> itemDataList)
	{
		System.out.printf("%-15s %15s %15s %n %n", "item", "price", "qty");
		double salesTax = 0;
		double subTotal = 0;
		//calculate tax
		TaxCalculatorFactory taxCalculatorFactory = new TaxCalculatorFactory();
		TaxCalculator locationTaxCalculator = taxCalculatorFactory.createTaxCalculator(location);
		for (ItemData itemData : itemDataList)
		{
			System.out.printf("%-15s %15s %15s %n", itemData.getItemName(), "$" + itemData.getPrice().toString(),
					itemData.getQty().toString());
			subTotal += itemData.getPrice() * itemData.getQty();
			salesTax += locationTaxCalculator.calculateSalesTax(itemData.getPrice(), itemData.getQty(), itemData.getItemCategory());
		}
		//rounded up to the nearest 0.05
		salesTax = Math.ceil(salesTax * 20) / 20.0;
		System.out.printf("%-31s %15s %n", "subtotal:", "$" + String.format("%.2f", subTotal));
		System.out.printf("%-31s %15s %n", "tax:", "$" + String.format("%.2f", salesTax));
		System.out.printf("%-31s %15s %n", "total:", "$" + String.format("%.2f", salesTax + subTotal));
	}
}
