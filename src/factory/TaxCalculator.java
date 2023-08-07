package factory;

public interface TaxCalculator
{
	double calculateSalesTax(double price, int qty, String itemCategory);
}