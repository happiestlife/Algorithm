import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] comps = br.readLine().split(" ");
        int n = Integer.parseInt(comps[0]);
        int m = Integer.parseInt(comps[1]);

        comps = br.readLine().split(" ");
        if(comps.length == 1) {
            System.out.println(m);
            return;
        }

        Set<Integer> truthPeople = new HashSet<>();
        for(int i = 1; i < comps.length; i++) {
            truthPeople.add(Integer.parseInt(comps[i]));
        }

        Map<Integer, List<Integer>> partiesPeopleJoin = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            partiesPeopleJoin.put(i, new ArrayList<>());
        }

        Set[] parties = new Set[m];
        for(int i = 0; i < parties.length; i++) {
            comps = br.readLine().split(" ");

            parties[i] = new HashSet<Integer>();
            for(int j = 1; j < comps.length; j++) {
                int people = Integer.parseInt(comps[j]);

                parties[i].add(people);
                partiesPeopleJoin.get(people).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int truthPerson : truthPeople) {
            q.add(truthPerson);
        }

        Set<Integer> truthParties = new HashSet<>();
        while(!q.isEmpty()) {
            int truthPerson = q.poll();

            for(int party : partiesPeopleJoin.get(truthPerson)) {
                truthParties.add(party);

                Set<Integer> joinPeople = parties[party];
                for(int joinPerson : joinPeople) {
                    if(!truthPeople.contains(joinPerson)) {
                        truthPeople.add(joinPerson);
                        q.add(joinPerson);
                    }
                }
            }
        }

        System.out.println(parties.length - truthParties.size());
    }
}