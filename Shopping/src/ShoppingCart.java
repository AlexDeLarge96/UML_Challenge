import java.util.ArrayList;
import java.util.List;

public class ShoppingCart
{
    private List<LineItem> items=new ArrayList<>();

    public ShoppingCart(List<LineItem> items) { this.items=items; }

    public List<LineItem> getItems() { return items; }

    public void addItem(LineItem i) { items.add(i); }

    public void cleanCart(){items.clear();}
}
