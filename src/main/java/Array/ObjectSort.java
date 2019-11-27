package Array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by yuehu on 4/19/19.
 */

public class ObjectSort {
        public static void main(String[] args) {
            Student[] persons = new Student[5];
            persons[0] =new Student(8,8);
            persons[1] =new Student(2,2);
            persons[2] =new Student(3,3);
            persons[3] =new Student(6,6);
            persons[4] =new Student(4,4);
            System.out.println("排序前的数据：");
            for (Student student:persons) {
                System.out.println(student);
            }
            //创建SortByNumber对象，将其作为参数传入Arrays.sort(persons,sortByNumber)方法中
            SortByNumber sortByNumber = new SortByNumber();
            Arrays.sort(persons,sortByNumber);
            System.out.println("根据学生编号由低到高排序：");
            for (Student student:persons) {
                System.out.println(student);
            }
        }

    }

    class Student {
        private int number;
        private int score;

        public Student(int number,int score){
            this.number = number;
            this.score = score;
        }
        //重写Student类的toString()方法，在输入对象时按照以下方式输出
        @Override
        public String toString() {
            return "Student[number:"+number+",score:"+score+"]";
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

    }
    //按照学号由低到高排列,创建SortByNumber类，该类实现Comparator，重写该接口的compare()
    class SortByNumber implements Comparator<Student>{
        //重写该接口的compare()使其按照学号由小到大排序（前者减去后者）
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getNumber()-o2.getNumber();
        }
    }


