package chapter15.annotation_02.custom;

import java.lang.reflect.Field;

public class FieldInjector {

    public static void injectValues(Object obj) {
        Class<?> clazz = obj.getClass();
        //this나 인스턴스로 넘어오는 객체의 클래스 정보를 리플렉션을 통해서 뽑아냄
        //class가 예약어이기 때문에 일반적으로 Class 타입의 변수를 추출할 때는 clazz로 관습적으로 사용함
        Field[] fields = clazz.getDeclaredFields();
        Field[] fieldsUnAccessible = clazz.getFields();
        //위의 클래스 객체의 필드 전체를 가져옴
        //getFields()메서드도 있으나 getFields()는 접근 제한자로 인해 접근이 불가능한 필드에 대해서는
        //데이터를 아예 가져오지 않으므로 getDeclaredFields()로 존재하는 모든 필드를 가져옴

//        try {
//            fieldsUnAccessible[0].set ( obj, "값을 넣어볼까?" );
//            //java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0 예외가 발생함
//            //대상 객체의 필드들은 모두 private 접근 제한이 걸려있기 때문에 가져올 값이 없어 배열의 길이가 0이기 때문
//        } catch ( IllegalAccessException e ) {
//            throw new RuntimeException ( "접근 불가함!" );
//        }

        for (Field field : fields) { //가져온 필드 객체를 순회함
            Class <InjectValue> injectValueClass = InjectValue.class;
            //위처럼 클래스 타입에 대해서 class 키워드를 통해서 Class 타입의 인스턴스를 만들 수 있음
            //InjectValue도 일종의 클래스이기 때문에 InjectValue.class로 클래스 메타 데이터를 뽑아낼 수 있음
            if (field.isAnnotationPresent(injectValueClass)) {
                //필드 객체는 자신에 대한 여러가지 메타 데이터를 가지고 있는데
                //그 데이터 중 어떤 어노테이션이 붙어있는지를 isAnnotationPresent 메서드로 파악할 수 있음
                InjectValue injectValue = field.getAnnotation(InjectValue.class);
                //InjectValue 타입의 어노테이션이 있는지 if 조건문으로 체크하여 존재하는 경우에 한정하여
                //아래 try 문의 동작을 수행하도록 함
                field.setAccessible(true);
                //해당 필드들의 접근 제어자가 private이라면 위에서 모든 필드를 가져왔다고 해도 set 등의 작업이 불가능
                //따라서 접근 제어를 이곳에서만 해제해주는 setAccessible을 true 로 설정해줌
                try {
                    Class<?> fieldType = field.getType();
                    //필드의 클래스 타입을 가져옴
                    if (fieldType == int.class) {
                        //필드의 타입이 int인 경우에는 어노테이션에서 선언한 intValue의 값을 꺼내서 해당 객체에 set 해줌
                        field.setInt(obj, injectValue.intValue());
                    } else if (fieldType == String.class) {
                        //필드의 타입이 String인 경우에는 어노테이션에서 선언한 stringValue의 값을 꺼내서 해당 객체에 set 해줌
                        field.set(obj, injectValue.stringValue ());
                    }
                    //어노테이션 타입의 인스턴스는 자신이 가진 필드에 담긴 값을 꺼내서 getter 처럼 사용할 수 있다
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
