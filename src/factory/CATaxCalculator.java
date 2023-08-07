package factory;

import java.util.Collections;
import java.util.Set;


public class CATaxCalculator implements TaxCalculator
{
	private static final double SALES_TAX_RATE = 0.0975; // California sales tax rate (9.75%)

	private static final Set<String> SALES_TAX_EXEMPT_CATEGORIES = Collections.singleton("food");

	@Override
	public double calculateSalesTax(double price, int qty, String itemCategory)
	{
		if (SALES_TAX_EXEMPT_CATEGORIES.contains(itemCategory))
		{
			return 0;
		}
		return price * qty * SALES_TAX_RATE;
	}
}
