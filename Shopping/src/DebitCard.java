import java.util.Date;

public class DebitCard extends PaymentMethod
{
    private int number;
    private Date expDate;
    private Issuer issuer;

    public DebitCard(int id,int number,Date expDate,Issuer issuer)
    {
        super(id);
        this.number=number;
        this.expDate=expDate;
        this.issuer=issuer;
    }

    @Override
    public void authorize()
    {
        System.out.println("Pago autorizado con tarjeta débito");
    }
}
