public class Main {
    public static void main(String[] args) {
        String [] array;

        MyList<Integer> list = new MyList<>();
        System.out.println("List Case : " + (list.isEmpty() ? "Empty" : "Full"));
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(20);
        list.add(50);
        list.add(60);
        list.add(70);

        System.out.println("List Case : " + (list.isEmpty() ? "Empty" : "Full"));
        System.out.println("Index : " + list.indexOf(20));
        System.out.println("Index :" + list.indexOf(100));
        System.out.println("Index : " + list.lastIndexOf(20));
        Object[] array1 = list.toArray();
        System.out.println("First index :" + array1[0]);
        MyList<Integer> subList = list.sublist(0, 3);
        System.out.println(subList.toString());
        System.out.println("20 in my list : " + list.contains(20));
        System.out.println("120 in my list : " + list.contains(120));
        list.clear();
        System.out.println(list.toString());

    }
}