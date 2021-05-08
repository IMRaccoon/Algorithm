import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_11952 {
    static City [] cities;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cityNum = Integer.parseInt(st.nextToken()), roadNum = Integer.parseInt(st.nextToken());
        int addictedCityNum = Integer.parseInt(st.nextToken()), dangerRange = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int originPrice = Integer.parseInt(st.nextToken()), securePrice = Integer.parseInt(st.nextToken());

        long [] map = new long[cityNum];
        cities = new City[cityNum];
        for(int i = 0 ; i< cityNum; i++) {
            cities[i] = new City(originPrice);
            map[i] = Long.MAX_VALUE;
        }

        int [] zombieCity = new int[addictedCityNum];
        for(int i = 0; i < addictedCityNum; i++) {
            int t = Integer.parseInt(br.readLine()) - 1;
            zombieCity[i] = t;
            cities[t].setZombie();
        }

        for(int i = 0 ; i < roadNum; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken()) - 1;
            int dest = Integer.parseInt(st.nextToken()) - 1;

            cities[src].addDest(dest);
            cities[dest].addDest(src);
        }

        setDangerCity(zombieCity, dangerRange, securePrice);


        PriorityQueue<Route> q = new PriorityQueue<>();
        q.add(new Route(0, 0));
        map[0] = 0;
        while(!q.isEmpty()) {
            Route cur = q.poll();

            for(int nextStep : cities[cur.curPos].destination) {
                if(cities[nextStep].isZombie) continue;
                long nextPrice = cities[nextStep].price + cur.curPrice;
                if(map[nextStep] > nextPrice) {
                    map[nextStep] = nextPrice;
                    q.add(new Route(nextStep, nextPrice));
                }
            }
        }
        System.out.println(map[cityNum - 1] - cities[cityNum - 1].price);
    }

    private static void setDangerCity(int [] zombieCity, int range, int securePrice) {
        Queue<Integer> q = new ArrayDeque<>();
        for(int z : zombieCity) {
            q.addAll(cities[z].destination);
        }

        for(int i = 0; i < range; i++) {
            int size = q.size();

            for(int j = 0; j < size; j++) {
                City t = cities[q.poll()];
                if(t.isZombie) continue;
                if(t.price != securePrice) {
                    t.setPrice(securePrice);
                    q.addAll(t.destination);
                }
            }
        }
    }

    private static class Route implements  Comparable<Route> {
        long curPrice;
        int curPos;

        Route(int pos, long price) {
            this.curPos = pos;
            this.curPrice = price;
        }

        @Override
        public int compareTo(Route route) {
            if(this.curPrice - route.curPrice > 0) {
                return 1;
            } else {
                return -1;
            }
        }
    }


    private static class City {
        ArrayList<Integer> destination;
        boolean isZombie = false;
        int price;

        City(int price) {
            destination = new ArrayList<>();
            this.price = price;
        }

        void setZombie() {
            this.isZombie = true;
        }

        void addDest(int dest) {
            destination.add(dest);
        }

        void setPrice(int price) {
            this.price = price;
        }
    }
}
