import java.util.Arrays;

public class Polynomial {
    private int[] coefficients;

    // Constructor to represent a polynomial
    public Polynomial(int[] coefficients) {
        this.coefficients = coefficients;
    }

    // Method to perform addition of polynomials
    public Polynomial add(Polynomial other) {
        int maxDegree = Math.max(this.coefficients.length, other.coefficients.length);
        int[] resultCoefficients = new int[maxDegree];
        for (int i = 0; i < maxDegree; i++) {
            int coefficient1 = (i < this.coefficients.length) ? this.coefficients[i] : 0;
            int coefficient2 = (i < other.coefficients.length) ? other.coefficients[i] : 0;
            resultCoefficients[i] = coefficient1 + coefficient2;
        }
        return new Polynomial(resultCoefficients);
    }

    // Method to perform subtraction of polynomials
    public Polynomial subtract(Polynomial other) {
        int maxDegree = Math.max(this.coefficients.length, other.coefficients.length);
        int[] resultCoefficients = new int[maxDegree];
        for (int i = 0; i < maxDegree; i++) {
            int coefficient1 = (i < this.coefficients.length) ? this.coefficients[i] : 0;
            int coefficient2 = (i < other.coefficients.length) ? other.coefficients[i] : 0;
            resultCoefficients[i] = coefficient1 - coefficient2;
        }
        return new Polynomial(resultCoefficients);
    }

    // Method to perform multiplication of polynomials
    public Polynomial multiply(Polynomial other) {
        int[] resultCoefficients = new int[this.coefficients.length + other.coefficients.length - 1];
        Arrays.fill(resultCoefficients, 0);
        for (int i = 0; i < this.coefficients.length; i++) {
            for (int j = 0; j < other.coefficients.length; j++) {
                resultCoefficients[i + j] += this.coefficients[i] * other.coefficients[j];
            }
        }
        return new Polynomial(resultCoefficients);
    }

    // Method to find the derivative of the polynomial
    public Polynomial derivative() {
        int[] resultCoefficients = new int[coefficients.length - 1];
        for (int i = 1; i < coefficients.length; i++) {
            resultCoefficients[i - 1] = coefficients[i] * i;
        }
        return new Polynomial(resultCoefficients);
    }

    // Method to display the polynomial
    public void display() {
        for (int i = 0; i < coefficients.length; i++) {
            System.out.print(coefficients[i] + "x^" + i);
            if (i < coefficients.length - 1) {
                System.out.print(" + ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] coefficients1 = {1, 2, 3}; // Represents 1 + 2x + 3x^2
        int[] coefficients2 = {4, 5, 6}; // Represents 4 + 5x + 6x^2

        Polynomial poly1 = new Polynomial(coefficients1);
        Polynomial poly2 = new Polynomial(coefficients2);

        System.out.println("Polynomial 1:");
        poly1.display();

        System.out.println("Polynomial 2:");
        poly2.display();

        Polynomial sum = poly1.add(poly2);
        System.out.println("Sum of polynomials:");
        sum.display();

        Polynomial difference = poly1.subtract(poly2);
        System.out.println("Difference of polynomials:");
        difference.display();

        Polynomial product = poly1.multiply(poly2);
        System.out.println("Product of polynomials:");
        product.display();

        System.out.println("Derivative of Polynomial 1:");
        poly1.derivative().display();
    }
}