public abstract class PaymentMethod
{
    private int id;

    public PaymentMethod(int id)
    {
        this.id=id;
    }

    public abstract void authorize();
}
