package pl.przygodzki.invoicesys.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadline;
    private String description;
    private BigDecimal price;
    private boolean isPaid;

    public Invoice() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public void updateFrom(Invoice toUpdate) {
        this.deadline = toUpdate.deadline;
        this.description = toUpdate.description;
//        this.isPaid = toUpdate.isPaid;
        this.price = toUpdate.price;
    }
}
