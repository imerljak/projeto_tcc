package br.com.imerljak.controller.util;

//@Provider
public class CustomParamConverterProvider
//        implements ParamConverterProvider
{

//    @Override
//    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
//        if (rawType.getName().equals(boolean.class.getName())) {
//
//            return new ParamConverter<T>() {
//                @Override
//                public T fromString(String value) {
//                    return (T) Boolean.toString(value != null && value.equals("on"));
//                }
//
//                @Override
//                public String toString(T value) {
//                    return ((Boolean) value) ? "on" : "";
//                }
//            };
//
//        } else if (rawType.getName().equals(int.class.getName())) {
//
//            return new ParamConverter<T>() {
//                @Override
//                public T fromString(String value) {
//
//                    try {
//                        return (T) (Integer) Integer.parseInt(value);
//                    } catch (NumberFormatException e) {
//                    }
//
//                    return (T) (Integer) 0;
//                }
//
//                @Override
//                public String toString(T value) {
//                    return "" + value;
//                }
//            };
//
//        } else {
//            return null;
//        }
//    }
}
