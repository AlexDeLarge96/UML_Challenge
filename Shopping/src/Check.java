public class Check extends PaymentMethod
{
    private int number;
    private int bankId;
    private String holder;

    public Check(int id,int number,int bankId,String holder)
    {
        super(id);
        this.number=number;
        this.bankId=bankId;
        this.holder=holder;
    }

    @Override
    public void authorize()
    {
        System.out.println("Pago autorizado con cheque");
    }
}
