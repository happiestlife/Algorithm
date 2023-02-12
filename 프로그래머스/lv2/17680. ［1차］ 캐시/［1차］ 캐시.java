import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0)
            return cities.length * 5;
        
        // key : 도시이름, value : 도시 정보
        Map<String, City> map = new HashMap<>();

        // 정렬하여 가장 생존시간이 긴 도시를 삭제하기 위한 배열
        List<City> cityList = new ArrayList<>();

        int rs = 0;
        for (int i = 0; i < cities.length; i++) {
            // 1. 캐쉬에 도시가 있는 경우
            String cityName = cities[i].toLowerCase();
            City existCity = null;
            if(map.containsKey(cityName)){
                // 해당 도시의 시간 초기화하기
                existCity = map.get(cityName);
                existCity.time = 0;

                rs += 1;
            }
            // 2. 캐쉬에 도시가 없는 경우
            else{
                // 캐시가 꽉 차있는데 캐시에 데이터를 넣어야 하는 경우
                if(map.size() == cacheSize){
                    // 오름차순으로 정렬시키고 마지막에 위치한 가장 오래된 도시 삭제
                    Collections.sort(cityList, Comparator.comparingInt(o -> o.time));
                    String removeCityName = cityList.get(cityList.size() - 1).name;

                    map.remove(removeCityName);
                    cityList.remove(cityList.size() - 1);
                }

                // 새롭게 추가하기
                City c = new City(cityName, 0);
                cityList.add(c);
                map.put(cityName, c);

                rs += 5;
            }

            // 캐시에 있는 나머지 도시들 시간 증가 -> 객체 레퍼런스로 비교
            for(City c : cityList){
                c.time += 1;
            }
        }

        return rs;
    }

    static class City{
        public String name;
        public int time;

        public City(String name, int time) {
            this.name = name;
            this.time = time;
        }
    }
}