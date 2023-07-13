package HashMap;

public class OwnMapUse {
    public static void main(String[] args) {
        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Map<Character, Integer> map1 = new Map<>();

        int N = 10;
        for(int i=0; i<alphabets.length(); i++, N++){
            char ch = alphabets.charAt(i);
            map1.put(ch, N);
            System.out.println(map1.getLoadFactor());
        }

        map1.print_buckets();
//        map1.insert('A', 100);
//        map1.print_buckets();
        System.out.println(map1.size());

//        System.out.println(map1.getValue('.'));
//        System.out.println(map1.getValueOrDefault('.', 0));

//        System.out.println(map1.remove('D'));
//        System.out.println(map1.remove('Z'));
//        System.out.println(map1.remove('.'));
//        map1.print_buckets();
    }
}
