package FirstBook;

import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet nums = new TreeSet();
        nums.add(5);
        nums.add(2);
        nums.add(9);
        nums.add(3);
        nums.add(5);
        System.out.println(nums);
        System.out.println(nums.first());
        System.out.println(nums.last());
//        表示范围 小于4集合
        System.out.println(nums.headSet(4));
//        大于等于5集合
        System.out.println(nums.tailSet(5));
//        范围集合
        System.out.println(nums.subSet(-3,4));
    }
}
