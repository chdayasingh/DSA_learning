import java.util.LinkedList;

// TODO: do this using own linkedlist class

public class AddTwoLargeNums {

    public static void main(String[] args) {
        LinkedList<Integer> num1 = new LinkedList<>();
        num1.add(9);
        num1.add(9);
        num1.add(9);
        num1.add(9);

        LinkedList<Integer> num2 = new LinkedList<>();
        num2.add(1);
        num2.add(2);
        num2.add(3);


        LinkedList<Integer> result = addTwoLargeNums(num1, num2);
        System.out.println("Num1: " + num1.toString());
        System.out.println("Num2: " + num2.toString());
        System.out.println(result.toString());
    }

    private static LinkedList<Integer> addTwoLargeNums(LinkedList<Integer> number1, LinkedList<Integer> number2) {
        LinkedList<Integer> num1 = new LinkedList<>(number1);
        LinkedList<Integer> num2 = new LinkedList<>(number2);
        LinkedList<Integer> result = new LinkedList<>();
        int carry = 0;
        while(!num1.isEmpty() || !num2.isEmpty()){
            int d1 = 0, d2 = 0;
            if(!num1.isEmpty()){
                d1 = num1.removeLast();
            }if(!num2.isEmpty()){
                d2 = num2.removeLast();
            }
            int sum = d1 + d2 + carry;
            result.addFirst(sum % 10);
            carry = sum / 10;
//            System.out.println("sum: " + sum + "  carry: " + carry);
        }

        if(carry > 0){
            result.addFirst(carry);
        }
        return result;
    }
}
