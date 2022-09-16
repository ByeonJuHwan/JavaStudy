package edu.java.map01;

import java.util.HashMap;
import java.util.Set;

/*
 * Collection<E>
 * |__ List<E>, Set<E>
 * List<E>, Set<E> 의 공통점 : 한 가지 타입의 객체를 여러개 저장할 수 있는 자료 타입.
 * List<E> : 인덱스가 있음. 저장하는 순서가 중요.
 * Set<E> : 인덱스가 없음. 중복된 값들을 저장할 수 없음.
 * 
 * ArrayList<E> : get 속도 빠름. add/remove 속도 느림.
 * LinkedList<E> : add/remove 속도 빠름. get 속도 느림.
 * 
 * HashSet<E> : 검색을 빨리 하기 위한 Set.
 * TreeSet<E> : 정렬을 빨리 하기 위한 Set.
 * 
 * Map<K, V>
 * |__ HashMap<K, V> , TreeMap<K,V>
 * Map<K, V> : Key(키) 와 Value(값)의 쌍으로 구성된 데이터를 저장하는 자료 구조.
 * 1) Key : 중복된 값을 가질 수 없음. 리스트의 인덱스와 비슷한 역할.
 *    Key의 역할은 데이터를 저장/검색/수정/삭제할 때 값을 찾기 위한 용도.
 * 2) Value: 중복된 값을 가질 수 있음.
 * 3) HashMap<K, V> : 검색을 빨리 하기 위한 Map
 * 4) TreeMap<K, V> : 정렬을 빨리 하기 위한 Map
 * 
 */

public class MapMain01 {

    public static void main(String[] args) {
        // 정수를 Key, 문자열을 Value로 하는 HashMap을 선언, 생성
        HashMap<Integer, String> map = new HashMap<>();
        System.out.println(map);
        
        
        // put(K, V) : Map<K, V> 에 key-value 쌍의 데이터를 저장.
        map.put(1, "홍길동");
        System.out.println(map);
        
        map.put(10, "변주환");
        System.out.println(map);
        
        map.put(5, "scott");
        System.out.println(map);
        
        // get(K) : key에 해당하는 value를 리턴. 만야 key가 존재하지 않으면 null을 리턴.
        System.out.println(map.get(1));
        System.out.println(map.get(2));
        
        
        // getOrDefault(K, V) : 검색할 key와 key가 존재하지 않을 때 리턴할 기본 값을 argument로 전달.
        System.out.println(map.getOrDefault(1, "Unknown"));
        System.out.println(map.getOrDefault(2, "Unknown"));
        
        // remove(K): key에 매핑된 key - value 원소를 삭제하고 삭제한 value(값)을 리턴.
        map.remove(1);
        System.out.println(map);
        
        // remove() 메서드는 key에 매핑된 key-value 원소가 없으면 null을 리턴.
        map.remove(2);
        System.out.println(map);
        

        // put(K, V) : key가 존재하지 않으면 key-value원소를 저장.
        // key가 존재하면 해당 키의 value만 변경
        map.put(5, "손흥민");
        System.out.println(map);
        
        // Map<K, V> 과 반복문.
        // keySet() : Set<K>를 리턴. Map에서 key들로만 이루어진 Set을 리턴.
        Set<Integer>kset = map.keySet();
        System.out.println(kset);
        for(Integer k : kset) {
            String v = map.get(k);
            System.out.println(k + " - " + v);
        }
    }

}
