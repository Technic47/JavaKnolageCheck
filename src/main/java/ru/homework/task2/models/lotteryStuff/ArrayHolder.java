package ru.homework.task2.models.lotteryStuff;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class ArrayHolder {
    @NotNull
    @Min(0)
    @Max(1)
    private Integer firstNumber;
    @NotNull
    @Min(0)
    @Max(1)
    private Integer secondNumber;
    @NotNull
    @Min(0)
    @Max(1)
    private Integer thirdNumber;
    @NotNull
    @Min(0)
    @Max(1)
    private Integer fourthNumber;
    @NotNull
    @Min(0)
    @Max(1)
    private Integer fifthNumber;
    @NotNull
    @Min(0)
    @Max(1)
    private Integer sixthNumber;
    @NotNull
    @Min(0)
    @Max(1)
    private Integer seventhNumber;
    @NotNull
    @Min(0)
    @Max(1)
    private Integer eighthNumber;
    @NotNull
    @Min(0)
    @Max(1)
    private Integer ninthNumber;
    @NotNull
    @Min(0)
    @Max(1)
    private Integer tenthNumber;

    public int[] getArray() {
        return new int[]{firstNumber, secondNumber, thirdNumber
                , fourthNumber, fifthNumber, sixthNumber, seventhNumber
                , eighthNumber, ninthNumber, tenthNumber};
    }

    public ArrayHolder() {
    }

    public void setArray(int[] newArray) {
        this.firstNumber = newArray[0];
        this.secondNumber = newArray[1];
        this.thirdNumber = newArray[2];
        this.fourthNumber = newArray[3];
        this.fifthNumber = newArray[4];
        this.sixthNumber = newArray[5];
        this.seventhNumber = newArray[6];
        ;
        this.eighthNumber = newArray[7];
        this.ninthNumber = newArray[8];
        this.tenthNumber = newArray[9];
    }

    public ArrayHolder(int[] newArray) {
        this.firstNumber = newArray[0];
        this.secondNumber = newArray[1];
        this.thirdNumber = newArray[2];
        this.fourthNumber = newArray[3];
        this.fifthNumber = newArray[4];
        this.sixthNumber = newArray[5];
        this.seventhNumber = newArray[6];
        ;
        this.eighthNumber = newArray[7];
        this.ninthNumber = newArray[8];
        this.tenthNumber = newArray[9];
    }

    public ArrayHolder(Integer firstNumber, Integer secondNumber, Integer thirdNumber, Integer fourthNumber,
                       Integer fifthNumber, Integer sixthNumber, Integer seventhNumber, Integer eighthNumber,
                       Integer ninthNumber, Integer tenthNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.thirdNumber = thirdNumber;
        this.fourthNumber = fourthNumber;
        this.fifthNumber = fifthNumber;
        this.sixthNumber = sixthNumber;
        this.seventhNumber = seventhNumber;
        this.eighthNumber = eighthNumber;
        this.ninthNumber = ninthNumber;
        this.tenthNumber = tenthNumber;
    }

    public Integer getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(Integer firstNumber) {
        this.firstNumber = firstNumber;
    }

    public Integer getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(Integer secondNumber) {
        this.secondNumber = secondNumber;
    }

    public Integer getThirdNumber() {
        return thirdNumber;
    }

    public void setThirdNumber(Integer thirdNumber) {
        this.thirdNumber = thirdNumber;
    }

    public Integer getFourthNumber() {
        return fourthNumber;
    }

    public void setFourthNumber(Integer fourthNumber) {
        this.fourthNumber = fourthNumber;
    }

    public Integer getFifthNumber() {
        return fifthNumber;
    }

    public void setFifthNumber(Integer fifthNumber) {
        this.fifthNumber = fifthNumber;
    }

    public Integer getSixthNumber() {
        return sixthNumber;
    }

    public void setSixthNumber(Integer sixthNumber) {
        this.sixthNumber = sixthNumber;
    }

    public Integer getSeventhNumber() {
        return seventhNumber;
    }

    public void setSeventhNumber(Integer seventhNumber) {
        this.seventhNumber = seventhNumber;
    }

    public Integer getEighthNumber() {
        return eighthNumber;
    }

    public void setEighthNumber(Integer eighthNumber) {
        this.eighthNumber = eighthNumber;
    }

    public Integer getNinthNumber() {
        return ninthNumber;
    }

    public void setNinthNumber(Integer ninthNumber) {
        this.ninthNumber = ninthNumber;
    }

    public Integer getTenthNumber() {
        return tenthNumber;
    }

    public void setTenthNumber(Integer tenthNumber) {
        this.tenthNumber = tenthNumber;
    }
}
