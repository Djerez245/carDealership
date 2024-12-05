package com.pluralsight;

public class SalesContract extends Contract {
    private double salesTaxAmount = .05;
    private double recordingFee = 100;
    private double processingFee;
    private String ifWantToFinance;


    public SalesContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold, String ifWantToFinance) {

        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.salesTaxAmount = salesTaxAmount;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.ifWantToFinance = ifWantToFinance;
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        if (vehicleSold.getPrice() < 10000){
            processingFee = 295;
        }
        else {
            processingFee = 495;
        }
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public String getIfWantToFinance() {
        return ifWantToFinance;
    }

    public void setIfWantToFinance(String ifWantToFinance) {
        this.ifWantToFinance = ifWantToFinance;
    }

    public String toString() {
        return String.format("SALE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%s|%.2f|%.2f|%.2f|%.2f|%s|%.2f\n", dateOfContract, customerName, customerEmail, vehicleSold.getVin(), vehicleSold.getYear(), vehicleSold.getMake(),
                vehicleSold.getModel(), vehicleSold.getVehicleType(), vehicleSold.getColor(), vehicleSold.getOdometer(), vehicleSold.getPrice(),
                salesTaxAmount, getTotalPrice(), getProcessingFee(), recordingFee, ifWantToFinance, getMonthlyPayment());
    }

    @Override
    public double getTotalPrice() {
        totalPrice = vehicleSold.getPrice() + salesTaxAmount + processingFee;
        return totalPrice;
    }

    @Override
    public double getMonthlyPayment() {
        if (ifWantToFinance.equalsIgnoreCase("no")){
            monthlyPayment = 0;
        }
        else if (vehicleSold.getPrice() >= 10000) {
            double p = vehicleSold.getPrice();
            double r = 4.25/100;
            int n = 48;
            r = r / 48;
            double numeratorP = 1 + r;
            double numerator = r * Math.pow(numeratorP, n);
            double denomenatorP = 1 + r;
            double denomenator = Math.pow(denomenatorP, n) - 1;
            monthlyPayment = p * numerator / denomenator;
        }
        else {
            double p = vehicleSold.getPrice();
            double r = 5.25/100;
            int n = 24;
            r = r / n;
            double numeratorP = 1 + r;
            double numerator = r * Math.pow(numeratorP, n);
            double denomenatorP = 1 + r;
            double denomenator = Math.pow(denomenatorP, n) - 1;
            monthlyPayment = p * numerator / denomenator;
        }
        return monthlyPayment;
    }

}
