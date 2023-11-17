package com.prof.Inventory.Management.inventory_management.available_quantity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.prof.Inventory.Management.inventory_management.product.Product;
import jakarta.persistence.*;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class Quantity {
    @Id
    @GeneratedValue
    private Long id;
    @PositiveOrZero(message = "number of boxes cannot be negative")
    private int box;
    @PositiveOrZero(message = "number of packs cannot be negative")
    private int pack;
    @PositiveOrZero(message = "number of pieces cannot be negative")
    private int piece;

    public Quantity() {
    }

    public Quantity(int box, int pack, int piece) {
        this.box = box;
        this.pack = pack;
        this.piece = piece;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public int getBox() {
        return box;
    }

    public void setBox(int box) {
        this.box = box;
    }

    public int getPack() {
        return pack;
    }

    public void setPack(int pack) {
        this.pack = pack;
    }

    public int getPiece() {
        return piece;
    }

    public void setPiece(int piece) {
        this.piece = piece;
    }


    @Override
    public String toString() {
        return "Quantity{" +
                "id=" + id +
                ", box=" + box +
                ", pack=" + pack +
                ", piece=" + piece +
                '}';
    }
}
