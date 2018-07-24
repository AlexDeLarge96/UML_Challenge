public class ConcreteFactoryY implements AbstractFactory
{
    @Override
    public ProductA createProductA()
    {
        return new ProductAY();
    }

    @Override
    public ProductB createProductB()
    {
        return new ProductBY();
    }
}
