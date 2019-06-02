package shop.entity;

import javax.persistence.*;

@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dog_id;

    private String date_zak;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String date_shipping;
    private String type_dog;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    private double total_sum;
    private String type_payment;

    private String status_dog;

    public Contract() {
    }

    public Contract(String date_zak, String date_shipping, String type_dog, double total_sum, String type_payment, String status_dog, User user, Company company) {
        this.date_zak = date_zak;
        this.date_shipping = date_shipping;
        this.type_dog = type_dog;
        this.total_sum = total_sum;
        this.type_payment = type_payment;
        this.status_dog = status_dog;
        this.user=user;
        this.company=company;
    }

    public Long getDog_id() {
        return dog_id;
    }

    public void setDog_id(Long dog_id) {
        this.dog_id = dog_id;
    }

    public String getDate_zak() {
        return date_zak;
    }

    public void setDate_zak(String date_zak) {
        this.date_zak = date_zak;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDate_shipping() {
        return date_shipping;
    }

    public void setDate_shipping(String date_shipping) {
        this.date_shipping = date_shipping;
    }

    public String getType_dog() {
        return type_dog;
    }

    public void setType_dog(String type_dog) {
        this.type_dog = type_dog;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public double getTotal_sum() {
        return total_sum;
    }

    public void setTotal_sum(double total_sum) {
        this.total_sum = total_sum;
    }

    public String getType_payment() {
        return type_payment;
    }

    public void setType_payment(String type_payment) {
        this.type_payment = type_payment;
    }

    public String getStatus_dog() {
        return status_dog;
    }

    public void setStatus_dog(String status_dog) {
        this.status_dog = status_dog;
    }
}
