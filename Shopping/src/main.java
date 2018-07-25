import java.util.*;

public class main
{

    public static void main(String[] args)
    {
        //CREAR CUENTA
        Account account=new Account(1,new Customer(1,"Juan Castillo",8928000,"Juancho","juan1996"),
                AccountStatus.ACTIVE,new ShoppingCart(new ArrayList<>()), new ArrayList<>(), new ArrayList<>());
        //AGREGAR ITEMS AL CARRO, METODOS DE PAGO Y DIRECCIONES AL USUARIO
        account.getCart().addItem(new LineItem(1,8350.99,new Product("CF01-300","Healthy Coffee","Coffee sweet and delicious")));
        account.getCart().addItem(new LineItem(2,12999.99,new Product("PH02-B","Toilet paper","Soft toilet paper")));
        account.getMethod().add(new Check(1,12345,4567,"Juan Castillo"));
        account.getMethod().add(new CreditCard(2,123456789,GregorianCalendar.getInstance().getTime(),10,new Issuer(Issuer.Iss.MASTERCARD)));
        account.getAddresses().add(new Address(1,"Calle 8","# 7-45","Bogotá D.C","Colombia",true));
        //CREAR ORDEN
        Order ord=new Order(123,GregorianCalendar.getInstance().getTime(),OrderStatus.SHIPPED,
                new Address(1,"Calle 8","# 7-45","Bogotá D.C","Colombia",true).getAddress(),
                0,new ArrayList<>());
        //AGREGAR ITEMS A LA ORDEN
        ord.addItem(new LineItem(1,8350.99,new Product("CF01-300","Healthy Coffee","Coffee sweet and delicious")));
        ord.addItem(new LineItem(2,12999.99,new Product("PH02-B","Toilet paper","Soft toilet paper")));

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
                System.out.print("\n"+account.getCart().getItems().get(i).getProduct().getName());
                System.out.print("\t\t\t"+account.getCart().getItems().get(i).getQuantity());
                System.out.print("\t\t\t"+account.getCart().getItems().get(i).getPrice());

            }
            System.out.println("\n\n* TOTAL:"+ord.getTotal());
        }
        else{System.out.println("Error");}

    }
}
