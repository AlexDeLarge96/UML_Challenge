import java.util.Date;
import java.util.List;

public class Order
{
    private  int id;
    private Date modified;
    private OrderStatus status;
    private String shippingAddress;
    private double total;
    private List<LineItem> items;

    public Order(int id,Date modified,OrderStatus status,String shippingAddress,double total,List<LineItem> items)
    {
        this.id=id;
        this.modified=modified;
        this.status=status;
        this.shippingAddress=shippingAddress;
        this.total=total;
        this.items=items;
    }

    public List<LineItem> getItems() { return items; }

    public void addItem(LineItem i) { items.add(i); }

    public double getTotal()
    {
        double total=0.0;
        for(int i=0;i<items.size();i++)
        {
            total=total + items.get(i).getQuantity()*items.get(i).getPrice();
        }
        return total;
    }
}
