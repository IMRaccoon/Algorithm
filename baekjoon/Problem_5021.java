import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem_5021 {
    static ArrayList<Person> person = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int familyNumber = Integer.parseInt(st.nextToken()), claimNumber = Integer.parseInt(st.nextToken());


        Person king = new Person(br.readLine());
        king.royalBlood = 1;
        person.add(king);

        for(int i = 0 ; i < familyNumber; i++) {
            st = new StringTokenizer(br.readLine());
            String childName = st.nextToken();
            String parentFirstName = st.nextToken();
            String parentSecondName = st.nextToken();

            Person child = findPerson(childName);
            Person parentFirst = findPerson(parentFirstName);
            Person parentSecond = findPerson(parentSecondName);

            child.parent1 = parentFirst;
            child.parent2 = parentSecond;
        }


        String nextKingName = "";
        float royalBlood = -1;

        for(int i = 0; i < claimNumber; i++) {
            Person target = findPerson(br.readLine());
            float targetBlood = traceBlood(target);
            if (targetBlood > royalBlood) {
                nextKingName = target.name;
                royalBlood = targetBlood;
            }
        }
        System.out.println(nextKingName);
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

    public static float traceBlood(Person p) {
        if(p.parent1 == null) {
            return p.royalBlood;
        }
        return (traceBlood(p.parent1) + traceBlood(p.parent2)) / 2;
    }


    static class Person {
        Person parent1 = null, parent2 = null;
        float royalBlood = 0;
        String name;

        public Person(String name) {
            this.name = name;
        }
    }
}
