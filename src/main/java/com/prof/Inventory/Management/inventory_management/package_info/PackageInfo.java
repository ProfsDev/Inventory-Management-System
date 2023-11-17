package com.prof.Inventory.Management.inventory_management.package_info;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class PackageInfo {
    @Id
    @GeneratedValue
    private Long id;
    @Positive(message = "Field should be greater than zero")
    private long numberOfPiecesInPack;
    @PositiveOrZero(message = "Field should be zero or more")
    private long numberOfPacksInBox;

    public PackageInfo() {
    }

    public PackageInfo(long numberOfPiecesInPack, long numberOfPacksInBox) {
        this.numberOfPiecesInPack = numberOfPiecesInPack;
        this.numberOfPacksInBox = numberOfPacksInBox;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getNumberOfPiecesInPack() {
        return numberOfPiecesInPack;
    }

    public void setNumberOfPiecesInPack(long piecesInPack) {
        this.numberOfPiecesInPack = piecesInPack;
    }

    public long getNumberOfPacksInBox() {
        return numberOfPacksInBox;
    }

    public void setNumberOfPacksInBox(long packsInBox) {
        this.numberOfPacksInBox = packsInBox;
    }

    @Override
    public String toString() {
        return "PackageInfo{" +
                "id=" + id +
                ", numberOfPiecesInPack=" + numberOfPiecesInPack +
                ", numberOfPacksInBox=" + numberOfPacksInBox +
                '}';
    }
}
