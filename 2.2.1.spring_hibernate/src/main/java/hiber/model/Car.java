package hiber.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    private String model;

    private int series;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Car() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
       this.user = user;
    }

    public int getSeries() {
        return series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Car{" +
                ", model='" + model + '\'' +
                ", series=" + series +
                '}';
    }

}
