package application;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		DecimalFormat df = new DecimalFormat("0.00");
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> list = new ArrayList<TaxPayer>();
		// -------------------------------------------------------------------- >
		System.out.print("Enter the number of tax payers: ");
		int N = sc.nextInt();
		// -------------------------------------------------------------------- >
		for (int i = 1; i <= N; i++) {

			System.out.println("Tax payer #" + i + " data:");

			System.out.print("Individual or company (i/c)? ");
			char type = sc.next().toLowerCase().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();

			int cx = (type == 'i') ? 1 : (type == 'c') ? 2 : 0;

			switch (cx) {

			case 1:
				// Individual
				// System.out.println("individual");
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();

				TaxPayer TPI = new Individual(name, anualIncome, healthExpenditures);
				list.add(TPI);

				break;

			case 2:
				// Company
				// System.out.println("company");
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();

				TaxPayer TPC = new Company(name, anualIncome, numberOfEmployees);
				list.add(TPC);

				break;

			}

		}
		// -------------------------------------------------------------------- >
		System.out.println("\nTAXES PAID:");
		// -------------------------------------------------------------------- >
		for (TaxPayer tP : list) {

			System.out.println(tP.toString());

		}
		// -------------------------------------------------------------------- >
		System.out.print("\nTOTAL TAXES: ");

		double sum = 0;

		for (TaxPayer tP : list) {

			sum += tP.tax();
		}

		System.out.println("TOTAL TAXES: $ " + df.format(sum));
		// -------------------------------------------------------------------- >
		sc.close();

	}

}
