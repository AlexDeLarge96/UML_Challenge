import java.util.*;

public class main
{

    public static void main(String[] args)
    {
     //Creación de objetos provisinales para crear cuenta

        //crear objeto tipo consumidor
        Customer customer=new Customer(1,"Juan Castillo",8928000,"Juancho","juan1996");

        //crear objeto tipo direccion
        Address address=new Address(1,"Calle 8","# 7-45","Bogotá D.C","Colombia",true);

        //crear medio de pago por cheque
        PaymentMethod method=new Check(1,12345,4567,"Juan Castillo");

        //crear objeto tipo issuer
        Issuer issuer=new Issuer(Issuer.Iss.MASTERCARD);

        //obtener fecha
        Calendar calendar = GregorianCalendar.getInstance();
        Date date = calendar.getTime();
        //crear medio de pago por tarjeta de credito
        PaymentMethod method1=new CreditCard(2,123456789,date,10,issuer);

        //crear lista con medios de pago
        List<PaymentMethod> l=new ArrayList<>();
        l.add(method);
        l.add(method1);

        //crear lista de direcciones
        List<Address> a=new ArrayList<>();
        a.add(address);

        //--------------------------------------------------
        //CREACION DE ORDEN Y CARRO DE COMPRAS

        //crear producto
        Product p=new Product("CF01-300","Healthy Coffee","Coffee sweet and delicious");
        //crear lineItem
        LineItem lItem=new LineItem(1,8350.99,p);
        List<LineItem> listItems=new ArrayList<>();
        listItems.add(lItem);

        //crear orden
        Order ord=new Order(123,date,OrderStatus.SHIPPED,address.getAddress(),0,listItems);

        //agregar nuevo producto a la orden
        p=new Product("PH02-B","Toilet paper","Soft toilet paper");
        lItem=new LineItem(2,12999.99,p);
        ord.addItem(lItem);

        //crear carrito de compras
        ShoppingCart cart=new ShoppingCart(ord.getItems());

     //CREAR CUENTA
        Account account=new Account(1,customer,AccountStatus.ACTIVE,cart,a,l);

     //Eliminar objetos provisionales
        customer=null;address=null;method=null;issuer=null;calendar=null;date=null;method1=null;l=null;a=null;
        p=null;lItem=null;listItems=null;
        System.gc();

        //INICIO DE SESION EN CUENTA
        Scanner sc=new Scanner(System.in);
        System.out.println("\t\tINICIO DE SESIÓN\n");
        System.out.println("//El usuario es --> Juancho");
        System.out.println("//La contraseña es --> juan1996\n");
        System.out.print("* Digite su nombre de usuario:");
        String username=sc.next();
        System.out.print("\n* Digite contraseña:");
        String password=sc.next();
        if(account.getCustomer().getUsername().equals(username) && account.getCustomer().getPassword().equals(password))
        {
            //VER INFO DE USUARIO
            System.out.println("\nSesión iniciada con exito");
            System.out.println("\n\t\tINFO USUARIO:\n");
            System.out.println("Name:"+account.getCustomer().getName());
            System.out.println("Contact:"+account.getCustomer().getContact());
            System.out.println("UserName:"+account.getCustomer().getUsername());
            System.out.println("Password:"+account.getCustomer().getPassword());

            //VER LISTADO DE DIRECCIONES DEL USUARIO
            System.out.println("\n\t\tLISTADO DE DIRECCIONES\n");
            for(int i=0;i<account.getAddresses().size();i++)
            {
                System.out.println(account.getAddresses().get(i).getAddress());
            }

            //VER RESPUESTAS DE LOS METODOS AUTHORIZE DE CADA MEDIO DE PAGO DEL USUARIO
            System.out.println("\n\t\tLISTADO AUTORIZACIONES MEDIOS DE PAGO\n");
            for(int i=0;i<account.getMethod().size();i++)
            {
                account.getMethod().get(i).authorize();
            }

            //VER PRODUCTOS AGREGADOS EN EL CARRITO Y ORDEN DE COMPRA Y CALCULAR EL TOTAL DE LA MISMA
            System.out.println("\n\t\tORDEN DE COMPRA\n");
            System.out.println("PRODUCT\t\t\tQUANTITY\t\t\tPRICExUNIT");
            for(int i=0;i<account.getCart().getItems().size();i++)
            {
                System.out.print("\n"+cart.getItems().get(i).getProduct().getName());
                System.out.print("\t\t\t"+cart.getItems().get(i).getQuantity());
                System.out.print("\t\t\t"+cart.getItems().get(i).getPrice());

            }
            System.out.println("\n\n* TOTAL:"+ord.getTotal());
        }
        else{System.out.println("Error");}

    }
}
