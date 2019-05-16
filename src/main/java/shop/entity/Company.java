package shop.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long company_id;

    @Column(name ="company_name")
    private String company_name;
    private int credit_lim;
    private String address;
    private String getCompany_phone;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    private int current_debit;

    @OneToMany(mappedBy = "company")
    private List<Contract> contractList;

    public Company() {
    }

    public Company(String company_name, int credit_lim, String address, String getCompany_phone, int current_debit, Status status) {
        this.company_name = company_name;
        this.credit_lim = credit_lim;
        this.address = address;
        this.getCompany_phone = getCompany_phone;
        this.current_debit = current_debit;
        this.status=status;
    }

    public Long getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Long company_id) {
        this.company_id = company_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public int getCredit_lim() {
        return credit_lim;
    }

    public void setCredit_lim(int credit_lim) {
        this.credit_lim = credit_lim;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGetCompany_phone() {
        return getCompany_phone;
    }

    public void setGetCompany_phone(String getCompany_phone) {
        this.getCompany_phone = getCompany_phone;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getCurrent_debit() {
        return current_debit;
    }

    public void setCurrent_debit(int current_debit) {
        this.current_debit = current_debit;
    }
}
