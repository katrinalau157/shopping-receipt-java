package factory;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class NYTaxCalculator implements TaxCalculator
{
	private static final double SALES_TAX_RATE = 0.08875;
	private static final Set<String> SALES_TAX_EXEMPT_CATEGORIES = Stream.of("clothing", "food")
			.collect(Collectors.toCollection(HashSet::new));

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
