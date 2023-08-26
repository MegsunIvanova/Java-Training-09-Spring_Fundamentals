package bg.softuni.intro.ioc;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;

public class Dog implements Animal, BeanNameAware, DisposableBean {

    private boolean superDog;

    public Dog() {
        this(false);
    }

    public Dog(boolean superDog) {
        this.superDog = superDog;
    }

    @Override
    public void makeNoise() {
        if (superDog) {
            System.out.println("Super bark super bark");
        } else {
            System.out.println("Bark bark");
        }
    }

    //Spring calls methods annotated with @PostConstruct only once, just after the initialization of bean
    @PostConstruct
    public void postConstructInit() {
        System.out.println("Dog is ready to bite!");
    }

    //BeanNameAware makes the object aware of the bean name defined in the container
    @Override
    public void setBeanName(String name) {
        System.out.println("The name of this Dog bean is: " +
                name);
    }

    //For bean implemented DisposableBean, it will run destroy() after Spring container is released the bean
    @Override
    public void destroy() throws Exception {
        System.out.println("Dog has been destroyed ... Bye!");
    }
}
