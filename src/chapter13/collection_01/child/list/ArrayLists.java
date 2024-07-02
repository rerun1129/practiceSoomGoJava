package chapter13.collection_01.child.list;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayLists {
    /**
     * 구현체는 직접적인 사용 예와 함께 설명함
     * */


    public static void main ( String[] args ) {
        List <String> listSizeZero = new ArrayList <> ( ); //new 할 때는 구현체, 인스턴스를 받을 때는 추상 객체
        List <String> listSizeTen = new ArrayList <> ( 10 ); //파라미터에 정수를 넘기면 해당 크기 만큼의 메모리 공간을 미리 점유함
        //만약 10이 넘는 객체가 내부에 들어간다면 특정 시점에 다시 리스트 크기를 일정하게 늘려서 다음 객체를 받을 준비를 함
        List <String> listByOldList = new ArrayList <> ( listSizeTen ); //다른 컬렉션 객체를 파라미터로 받아서 그 내용 그대로 새로운 리스트 객체를 반환, 주의사항 맨 아래에 기술

        /**
         * 리스트의 가용 공간이 늘어날 수록 생기는 변화
         *
         * 기본적으로 ArrayList는 내부에 배열을 가지고 동작한다. 배열은 앞에서 배웠다시피 첫번째 요소 자리의 메모리 주소를 자신의 객체 주소로 가지는데
         * 만약 가용 공간을 늘려야 한다면 배열을 키워야 하는데 자바에서는 이미 선언된 배열의 크기를 키우는 방법이 없다.
         * 따라서 가용 공간이 늘어나는 순간에 이전에 사용하던 배열은 GC에 의해서 사라지고 새로운 가용 공간을 제공하는 배열이 리스트에 들어가서 동작한다.
         * */

        //add - 유사한 메서드인 set이 있지만 일반적으로는 add를 사용함
        listSizeTen.add ( "안녕1" );
        listSizeTen.add ( "안녕2-1" );
        listSizeTen.add ( "안녕3" ); //리스트의 마지막에 객체를 추가함.
        listSizeTen.add ( 2, "안녕2-2" ); //리스트의 특정 위치에 객체를 추가함.
        listSizeTen.forEach ( System.out::println );
        System.out.println ( "=========================================================" );
        //addAll
        listSizeZero.addAll ( listSizeTen );//해당 리스트의 마지막에 컬렉션 객체를 저장
        listSizeZero.forEach ( System.out::println );
        System.out.println ( "=========================================================" );
        listSizeZero.addAll ( 2, listSizeTen );//해당 리스트의 특정 위치에 컬렉션 객체를 저장
        listSizeZero.forEach ( System.out::println );
        System.out.println ( "=========================================================" );
        //clear
        listSizeTen.clear ();
        listSizeTen.forEach ( System.out::println );
        System.out.println ( "비어 있어야 함" );
        System.out.println ( "=========================================================" );
        //contains / containsAll / of
        System.out.println ( listSizeZero.contains ( "안녕1" ) ? "참" : "거짓" );
        System.out.println ( listSizeZero.contains ( "안녕?" ) ? "참" : "거짓" );
        System.out.println ( "=========================================================" );
        List <String> compareList = List.of ( "안녕1", "안녕2-1", "안녕2-2", "안녕3" );
        //위에서 처럼 리스트를 선언하고 add로 객체를 넣는 것이 아닌 of 정적 팩터리 메서드로 값을 바로 넣어서 인스턴스를 생성함
        List <String> compareList2 = List.of ( "안녕1", "안녕2-1", "안녕2-2", "안녕3" );
        List <String> compareList3 = List.of ( "안녕1", "안녕2-1", "안녕2-2", "안녕2-3" );
        System.out.println ( compareList2.containsAll ( compareList ) ? "참" : "거짓" ); //동일한 리스트들을 비교
        System.out.println ( compareList.containsAll ( listSizeZero ) ? "참" : "거짓" ); //자신보다 범위가 크고 자신의 요소들을 모두 가진 리스트와 비교
        System.out.println ( compareList3.containsAll ( listSizeZero ) ? "참" : "거짓" );//자신과 다른 요소를 가진 리스트와 비교
        System.out.println ( "=========================================================" );
        //get / indexOf / lastIndexOf / isEmpty
        System.out.println ( compareList.get ( 0 ) ); //리스트의 첫번째 요소를 반환
        System.out.println ( compareList.indexOf ( "안녕2-2" ) ); //리스트의 특정 요소의 순방향에서 순회하여 위치를 반환
        System.out.println ( compareList.lastIndexOf ( "안녕2-2" ) ); //리스트의 특정 요소의 역방향에서 순회하여 위치를 반환
        //결과는 같지만 위치를 대충 안다면 적절한 메서드를 사용해서 순회해야할 횟수를 줄일 수 있다
        System.out.println ( listSizeTen.isEmpty ( ) ); //리스트가 비어있는지를 확인
        System.out.println ( "=========================================================" );
        //remove
        List <String> removeTestList = new ArrayList <> ( compareList );
        removeTestList.remove ( "안녕3" ); //삭제할 값
        removeTestList.remove ( 0 ); //삭제할 인덱스
        removeTestList.forEach ( System.out::println );
        System.out.println ( "=========================================================" );
        removeTestList.add ( "안녕!" );
        removeTestList.add ( "안녕!" );
        removeTestList.add ( "안녕!" );
        removeTestList.remove ( "안녕!" ); //중복된 값이 들어가 있다면 하나만 지워짐
        removeTestList.forEach ( System.out::println );
        System.out.println ( "=========================================================" );
        //removeAll - 이걸로 두 집합 간의 중복 요소를 제거하는데 사용할 수 있다
        List <String> removeAllTestList1 = new ArrayList <> ( compareList );
        List <String> removeAllTestList2 = new ArrayList <> ( compareList2 );
        removeAllTestList1.removeAll ( removeAllTestList2 );
        removeAllTestList1.forEach ( System.out::println );
        System.out.println ( "비어 있어야 함" );
        System.out.println ( "=========================================================" );
        //retainAll / size
        List <String> removeAllTestList3 = new ArrayList <> ( compareList2 );
        List <String> removeAllTestList4 = new ArrayList <> ( compareList3 );
        removeAllTestList3.retainAll ( removeAllTestList4 ); //교집합
        removeAllTestList3.forEach ( System.out::println );
        System.out.println ( removeAllTestList3.size ( ) );
        System.out.println ( "=========================================================" );
        //sort(정렬)
        List <Integer> sortList = new ArrayList <> ( );
        sortList.add ( 2 );
        sortList.add ( 5 );
        sortList.add ( 3 );
        sortList.add ( 4 );
        sortList.add ( 1 );
        //리스트는 순서를 보장하기 때문에 리스트에 넣은 순서대로 출력된다.
        sortList.forEach ( System.out::print );
        System.out.println ( );
        //정렬을 하는데 정렬을 위해서는 어떤 기준으로 정렬을 해야하는지가 정의되어야 한다.
        //그에 대한 정의는 Comparator라는 타입의 객체가 하게 된다.
        sortList.sort ( Comparator.naturalOrder () ); //정방향 정렬
        sortList.forEach ( System.out::print );
        System.out.println ( );
        sortList.sort ( Comparator.reverseOrder () ); //역방향 정렬
        sortList.forEach ( System.out::print );
        System.out.println ( );
        //기본적인 정렬 말고도 특수한 기준의 정렬도 가능하다. 이는 compare 에서 더 자세히 다룬다.
        System.out.println ( "=========================================================" );
        //subList
        List <Integer> subList = sortList.subList ( 1, 3 ); //시작 인덱스는 자기 자신의 결과를 포함, 엔드 인덱스는 자기 자신의 결과를 제외
        subList.forEach ( System.out::println );
        System.out.println ( "=========================================================" );


        /**
         * 단, new ArrayList <> ( listSizeTen )는 리스트가 새롭게 반환되는 것이지 리스트 내부의 객체 주소까지 new 로 하여 새로운 주소가 생성되는 것이 아님
         * */
        //Ex)
        //원본
//        List <Map<String, String>> maps = new ArrayList <> ( List.of (
//                new HashMap <> ( Map.of ( "1", "안녕하세요1" )),
//                new HashMap <> ( Map.of ( "2", "안녕하세요2" )),
//                new HashMap <> ( Map.of ( "3", "안녕하세요3" )) ));
//        //사본 작성
//        List <Map<String, String>> mapsNew = new ArrayList <> ( maps ); //여기서 새로운 리스트 객체를 만들었지만
//        List <Map <String, String>> mapsPut = mapsNew.stream ( ).peek ( m -> {
//            m.put ( "1", "안녕하세요11111" );
//            m.put ( "2", "안녕하세요22222" );
//            m.put ( "3", "안녕하세요33333" );
//        } ).toList ( );
//        mapsPut.forEach ( System.out::println ); //새로운 리스트 객체에서 put으로 내부 객체에 변동을 주면 동일한 메모리 주소에 대한 작업이므로 동시에 영향을 받음
//        mapsNew.forEach ( System.out::println );
//        maps.forEach ( System.out::println );


    }
}
