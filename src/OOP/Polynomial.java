package OOP;

public class Polynomial {
    DynamicArray coefficients;

    public Polynomial(){
        coefficients = new DynamicArray();
    }

    public int getCoefficient(int degree){
        return coefficients.get(degree);
    }
    public void setCoefficients(int deg, int coeff){
        coefficients.set(deg,coeff);
    }
    public void print(){
        for(int i=coefficients.size()-1; i>=0; i--){
            System.out.print(coefficients.get(i) + "x^" + i + " + ");
        }
        System.out.println();
    }

    public long evaluate(int valueOFX){
        long ans = 0;
        for(int i=coefficients.size()-1; i>=0; i--){
            ans += coefficients.get(i) * (long)Math.pow(valueOFX, i);
        }
        return ans;
    }

    public int getDegree(){
        return coefficients.size()-1;
    }
    public static Polynomial addTwoPolynomial(Polynomial p1, Polynomial p2){
        Polynomial p3 = new Polynomial();
        for(int i=0; i<=p1.getDegree(); i++){
            p3.setCoefficients(i,(p1.getCoefficient(i) + p2.getCoefficient(i)));
        }
        return p3;
    }
}
