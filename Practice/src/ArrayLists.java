import java.util.ArrayList;

public class ArrayLists {
    public static void main(String[] args) throws Exception { //
        System.out.println("Lab 10");

        ArrayList <String> myInfoList = new ArrayList<>(); // "new" of type string

        myInfoList.add("Summer Voeller");
        myInfoList.add("Computer Science");
        myInfoList.add("4.0");

        double currentGPA = Double.parseDouble(myInfoList.get(2));

        System.out.println(myInfoList);

        for (int index = 0; index < myInfoList.size(); index++){
            System.out.println(myInfoList.get(index));

        }
    } // but for todays lab we use type integer, not string
}
