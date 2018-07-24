public class Issuer
{
    enum Iss{AMEX,VISA,MASTERCARD}
    private Iss issuer;

    public Issuer(Iss issuer){this.issuer=issuer;}

    public Iss getIssuer() { return issuer; }
    public void setIssuer(Iss issuer) { this.issuer = issuer; }
}
