package entities;

import java.text.DecimalFormat;

public class Company extends TaxPayer {
	private static DecimalFormat df = new DecimalFormat("0.00");

	private Integer numberOfEmployees;

	public Company() {
		super();
	}

	public Company(String name, Double anualIncome, Integer numberOfEmployees) {
		super(name, anualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}

	public Integer getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public final double tax() {

		double res = anualIncome;

		int cx = (numberOfEmployees <= 10) ? 1 : 2;

		switch (cx) {
		
		case 1:
			res = anualIncome * 0.16;
			break;

		case 2:
			res = anualIncome * 0.14;
			break;
		}

		return res;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append(name + ": $ " + df.format(tax()));

		return sb.toString();
	}

}
