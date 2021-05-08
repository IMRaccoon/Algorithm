import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem_1043 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int personNumber = Integer.parseInt(st.nextToken());
        int partyNumber = Integer.parseInt(st.nextToken());

        Person [] person = new Person[personNumber];
        Party [] parties = new Party[partyNumber];
        for(int i = 0 ; i < person.length ; i ++) {
            person[i] = new Person(false);
        }

        st = new StringTokenizer(br.readLine());
        int knowIndex = Integer.parseInt(st.nextToken());
        ArrayList<Person> checkPerson = new ArrayList<>();

        for(int i = 0 ; i < knowIndex; i++) {
            int personIndex = Integer.parseInt(st.nextToken()) - 1;
            person[personIndex].setKnow(true);
            checkPerson.add(person[personIndex]);
        }

        for(int i = 0; i < partyNumber; i++) {
            st = new StringTokenizer(br.readLine());

            int invitedPersonNumber = Integer.parseInt(st.nextToken());
            Person [] invitedPerson = new Person[invitedPersonNumber];

            for(int j = 0; j < invitedPersonNumber; j++) {
                int personIndex = Integer.parseInt(st.nextToken());
                invitedPerson[j] = person[personIndex - 1];
            }

            parties[i] = new Party(invitedPerson);
        }


        while(checkPerson.size() != 0) {
            Person targetPerson = checkPerson.remove(0);

            for (Party targetParty : targetPerson.party) {
                if (targetParty.canLie) {
                    targetParty.setCanLie(false);
                    for (Person p : targetParty.involve) {
                        if (!p.know) {
                            p.setKnow(true);
                            checkPerson.add(p);
                        }
                    }
                }
            }
        }

        int result = 0;
        for(Party p : parties) {
            if (p.canLie){
                result += 1;
            }
        }

        System.out.println(result);
    }

    static class Person {
        ArrayList<Party> party;
        boolean know;

        public Person(boolean know) {
            this.setKnow(know);
            this.party = new ArrayList<>();
        }

        public void setKnow(boolean know) {
            this.know = know;
        }

        public void setParty(Party party) {
            this.party.add(party);
        }
    }

    static class Party {
        Person [] involve;
        boolean canLie = true;

        public Party(Person [] involve) {
            this.involve = involve;
            for(Person p : involve) {
                p.setParty(this);
            }
        }

        public void setCanLie(boolean lie) {
            this.canLie = lie;
        }
    }
}

