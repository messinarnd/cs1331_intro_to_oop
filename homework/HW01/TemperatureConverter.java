//I worked on the homework assignment alone, using only course materials.

import java.util.Scanner;
public class TemperatureConverter{
	public static void main(String[] args) {
		System.out.print("Enter a temperature in Fahrenheit: ");
		Scanner myScan = new Scanner(System.in);
		double tempF = myScan.nextDouble();
		double tempC = (tempF - 32) * (double)5/9;
		System.out.print(tempF + " degrees Fahrenheit is ");
		System.out.printf("%3.2f degrees Celsius\n",tempC);
	}
}