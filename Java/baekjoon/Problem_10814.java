import java.io.*;
import java.util.*;

public class Problem_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        ArrayList<Person> arr = new ArrayList<>();
        for(int i = 0 ; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr.add(new Person(Integer.parseInt(st.nextToken()), st.nextToken()));
        }
        Collections.sort(arr, new MyComparator());

        for(Person p : arr) {
            bw.write(p.age + " " + p.name + "\n");
        }
        bw.flush();
    }

    static class Person {
        int age;
        String name;

        Person(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    static class MyComparator implements Comparator<Person> {
        @Override
        public int compare(Person person, Person t1) {
            return person.age - t1.age;
        }
    }
}