package at.htl.dogschool.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "S_Booking")
public class Booking {

    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Course course;

    @ManyToOne
    private Dog dog;

    private LocalDate bookingDate;
    private double price;

    //region Constructor
    public Booking() {
    }

    public Booking(Course course, Dog dog, LocalDate bookingDate, double price) {
        this.setCourse(course);
        this.setDog(dog);
        this.setBookingDate(bookingDate);
        this.setPrice(price);
    }
    //endregion


    //region Getter and Setter
    public Long getId() {
        return id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    //endregion


    @Override
    public String toString() {
        return String.format("Buchung: %s mit %s (%s %s)",
                course.getName(),
                dog.getName(),
                dog.getOwner().getFirstName(),
                dog.getOwner().getLastName());
    }
}
