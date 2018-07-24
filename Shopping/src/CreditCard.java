import java.util.Date;

public class CreditCard extends PaymentMethod
{
    private int number;
    private Date expDate;
    private int maxInstallements;
    private Issuer issuer;

    public CreditCard(int id,int number,Date expDate,int maxInstallements,Issuer issuer)
    {
        super(id);
        this.number=number;
        this.expDate=expDate;
        this.maxInstallements=maxInstallements;
        this.issuer=issuer;
    }

    @Override
    public void authorize()
    {
        System.out.println("Pago autorizado con tarjeta de crédito");
    }
}
