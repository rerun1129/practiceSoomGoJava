package chapter07.composition;

import chapter07.extend.Luggage;
import chapter07.extend.NotEnoughSpaceException;

import java.util.ArrayList;
import java.util.List;

public class Composition {
    /**
     * - 여러 객체를 묶어서 더 복잡한 기능을 제공
     * - 상속은 다중 상속이 불가능하나 조립은 다중 조립이 얼마든지 가능하며 충돌 발생도 없음
     * - IS-A 관계가 아니라면 상속보다는 조립을 고려함이 옳음
     * - 보통 필드로 다른 객체를 참조하는 방식으로 조립 또는 객체를 필요 시점에 생성(런타임)
     * */

    static class Container /*extends ArrayList<Luggage>*/ {
        private int maxSize;
        private int currentSize;
        private List <Luggage> luggages = new ArrayList ();
        //super의 메서드와 하위 클래스의 메서드를 동시에 쓰지 않으므로 하나의 로직에서 돌아감

        public Container(int maxSize){
            this.maxSize = maxSize;
        }

        public void put(Luggage lug) throws NotEnoughSpaceException { //Container 에서는 add 사용이 불가능하고 put으로만 값을 넣을 수가 있으므로
            if(!canContain(lug)) throw new NotEnoughSpaceException ();
            luggages.add(lug);
            currentSize += lug.getSize ();
        }

        public void extract ( Luggage lug ){
            luggages.remove(lug);
            this.currentSize -= lug.getSize();
        }

        public boolean canContain(Luggage lug) {
            return maxSize >= currentSize + lug.getSize();
        }
    }

    public static void main ( String[] args ) throws NotEnoughSpaceException {
        Container container = new Container ( 10 );
//        container.add(); //사용 불가
        container.put(new Luggage ());//이것만 사용 가능
    }
}
