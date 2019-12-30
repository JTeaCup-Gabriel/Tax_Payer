package entities;

public class Individual extends TaxPayer {

	private Double healthExpenditures;

	public Individual() {
		super();
	}

	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public final double tax() {

		double finalTaxCalc = anualIncome;

		if (anualIncome < 20000) {

			finalTaxCalc += finalTaxCalc * (15 / 100);

		} else if (anualIncome > 2000) {

			finalTaxCalc += (finalTaxCalc * (25 / 100)) - healthExpenditures / 2;

		}

		return finalTaxCalc;
	}

}
