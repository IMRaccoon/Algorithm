import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_5021 {
    static ArrayList<Person> person = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int familyNumber = Integer.parseInt(st.nextToken()), claimNumber = Integer.parseInt(st.nextToken());


        Person king = new Person(br.readLine());
        person.add(king);

        for(int i = 0 ; i < familyNumber; i++) {
            st = new StringTokenizer(br.readLine());
            String childName = st.nextToken();
            String parentFirstName = st.nextToken();
            String parentSecondName = st.nextToken();

            Person child = findPerson(childName);
            Person parentFirst = findPerson(parentFirstName);
            Person parentSecond = findPerson(parentSecondName);

            parentFirst.children.add(child);
            parentSecond.children.add(child);
        }

        double blood = 0;
        String name = "";
        for(int i = 0 ; i <claimNumber; i++) {
            Person cur = findPerson(br.readLine());
            double curBlood =  dfs(cur, king, 0);
            if(blood < curBlood) {
                blood = curBlood;
                name = cur.name;
            }
        }
        System.out.println(name);
    }

    public static double dfs(Person target, Person cur, int depth) {
        double ret = 0;

        if(target.name.equals(cur.name)) {
            return Math.pow(0.5, depth);
        }
        else {
            for(Person child : cur.children) {
                ret += dfs(target, child, depth + 1);
            }
        }

        return ret;
    }

    public static Person findPerson(String name) {
        for(Person p : person) {
            if(p.name.equals(name)) {
                return p;
            }
        }
        Person newPerson = new Person(name);
        person.add(newPerson);
        return newPerson;
    }

    static class Person {
        ArrayList<Person> children;
        String name;

        public Person(String name) {
            this.name = name;
            children = new ArrayList<>();
        }
    }
}
