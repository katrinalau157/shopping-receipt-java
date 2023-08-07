package data;

public class ItemData
{
	String itemName;

	Double price;

	Integer qty;

	String itemCategory;

	public ItemData(String itemName, Double price, int qty)
	{
		this.itemName = itemName;
		this.price = price;
		this.qty = qty;
	}

	public ItemData()
	{

	}

	public Integer getQty()
	{
		return qty;
	}

	public void setQty(int qty)
	{
		this.qty = qty;
	}

	public Double getPrice()
	{
		return price;
	}

	public void setPrice(Double price)
	{
		this.price = price;
	}

	public String getItemName()
	{
		return itemName;
	}

	public void setItemName(String itemName)
	{
		this.itemName = itemName;
	}

	public String getItemCategory()
	{
		return itemCategory;
	}

	public void setItemCategory(String itemCategory)
	{
		this.itemCategory = itemCategory;
	}
}
