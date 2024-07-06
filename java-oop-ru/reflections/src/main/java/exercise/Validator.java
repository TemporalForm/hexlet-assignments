package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Address address) {
        List<String> notValidatedAddresses = new ArrayList<>();
        for (Field field : address.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                try {
                    if (field.get(address) == null) {
                        notValidatedAddresses.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return notValidatedAddresses;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Map<String, List<String>> notValidatedAddresses = new HashMap<>();
        for (Field field : address.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                try {
                    if (field.get(address) == null) {
                        notValidatedAddresses.put(field.getName(), List.of("can not be null"));
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            if (field.isAnnotationPresent(MinLength.class)) {
                MinLength minLength = field.getAnnotation(MinLength.class);
                int declaredLength = minLength.minLength();
                field.setAccessible(true);
                try {
                    if (field.get(address) != null && (String.valueOf(field.get(address)).length() < declaredLength)) {
                        notValidatedAddresses.put(field.getName(), List.of("length less than " + declaredLength));
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return notValidatedAddresses;
    }
}
// END
