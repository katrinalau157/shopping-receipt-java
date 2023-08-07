package factory;
public class TaxCalculatorFactory
{
	public TaxCalculator createTaxCalculator(String location)
	{
		if ("CA".equalsIgnoreCase(location))
		{
			return new CATaxCalculator();
		}
		else if ("NY".equalsIgnoreCase(location))
		{
			return new NYTaxCalculator();
		}
		else
		{
			throw new IllegalArgumentException("Invalid location: " + location);
		}
	}
}