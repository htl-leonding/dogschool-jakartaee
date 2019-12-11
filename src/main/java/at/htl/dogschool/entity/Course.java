package at.htl.dogschool.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "S_COURSE")
public class Course {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private LocalDateTime startDatetime;
    private int noOfMeetings;


    @ManyToOne
    private CourseType courseType;

    //region Constructors
    public Course() {
    }

    public Course(
            String name,
            double price,
            LocalDateTime startDatetime,
            int noOfMeetings,
            CourseType courseType) {

        this.name = name;
        this.price = price;
        this.startDatetime = startDatetime;
        this.noOfMeetings = noOfMeetings;
        this.courseType = courseType;
    }

    //endregion

    //region Getter and Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNoOfMeetings() {
        return noOfMeetings;
    }

    public void setNoOfMeetings(int noOfMeetings) {
        this.noOfMeetings = noOfMeetings;
    }
    //endregion


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Double.compare(course.price, price) == 0 &&
                noOfMeetings == course.noOfMeetings &&
                name.equals(course.name) &&
                startDatetime.equals(course.startDatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, startDatetime, noOfMeetings);
    }

    @Override
    public String toString() {
        return name;
    }
}
