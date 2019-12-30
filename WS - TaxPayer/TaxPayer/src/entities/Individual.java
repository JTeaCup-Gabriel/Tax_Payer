package entities;

import java.text.DecimalFormat;

public class Individual extends TaxPayer {
	private static DecimalFormat df = new DecimalFormat("0.00");

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

		double res = anualIncome;

		int cx = (anualIncome <= 20000) ? 1 : 2;

		switch (cx) {

		case 1:

			res = anualIncome * 0.15;
			break;

		case 2:
			
			res = (anualIncome * 0.25) - (healthExpenditures * 0.5);
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
