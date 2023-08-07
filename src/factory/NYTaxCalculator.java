package factory;

import java.util.Set;


public class NYTaxCalculator implements TaxCalculator
{
	private static final double SALES_TAX_RATE = 0.08875;
	private static final Set<String> SALES_TAX_EXEMPT_CATEGORIES = Set.of("food", "clothing");
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
