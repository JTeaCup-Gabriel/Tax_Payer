package entities;

public class Company extends TaxPayer {

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

		double finalTaxCalc = anualIncome;

		if (numberOfEmployees < 10) {

			anualIncome += anualIncome * (16 / 100);

		} else if (numberOfEmployees > 10) {

			anualIncome += anualIncome * (14 / 100);

		}

		return finalTaxCalc;
	}

}
