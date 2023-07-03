package com.njt.upkg.Domain;
import jakarta.persistence.*;


@Entity
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String address;
    private String phone;
    private String email;

    @ManyToOne
    @JoinColumn(name = "type")
    private WorkerType type;

    private float pricePerHour;

    public Worker() {
    }

    public Worker(int id, String name, String address, String phone, String email, WorkerType type, float pricePerHour) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.type = type;
        this.pricePerHour = pricePerHour;
    }

    public Worker(String name, String address, String phone, String email, WorkerType type, float pricePerHour) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.type = type;
        this.pricePerHour = pricePerHour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public WorkerType getType() {
        return type;
    }

    public void setType(WorkerType type) {
        this.type = type;
    }

    public float getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(float pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", type=" + type +
                ", pricePerHour=" + pricePerHour +
                '}';
    }
}
