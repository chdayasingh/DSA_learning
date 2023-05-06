import HashMap.MapNode;
public class Try {
    public static void main(String[] args) {
//        String[] arr = new String[3];
//        arr[0] = "helo";
//        arr[1] = "ags";
//
//        for(String str : arr){
//            System.out.println(str);
//        }

        MapNode<Integer, Integer>[] arr = new MapNode[5];
        arr[0] = new MapNode<>(1, 10);
        for(MapNode<Integer,Integer> mnode: arr){
            System.out.println(mnode);
        }
    }
}
