package org.example;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;

public final class YamlMapper {

    public static void serializeToFile(File file, Object object) throws IllegalAccessException, IOException {
        Files.writeString(file.toPath(), serializeFieldsToString(object, "").trim());
    }

    public static <T> T deserializeFromFile(String content, Class<T> clazz) throws NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException, IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(content));

            Object object = clazz.getDeclaredConstructor().newInstance();

            parseYaml(reader, object, "");

            return clazz.cast(object);
        } catch (NoSuchFieldException e) {
            System.err.println(e.getMessage());
        }

        return null;
    }

    private static void parseYaml(BufferedReader reader, Object object, String prefix) throws IOException,
            NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException,
            InstantiationException {
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.isBlank()) {
                continue;
            }

            if (line.startsWith(prefix)) {
                String[] parts = line.split(":", 2);
                String key = parts[0].trim();
                String value = parts[1].trim();
                if (value.isEmpty()) {
                    Object nestedObject = object.getClass()
                            .getDeclaredField(key)
                            .getType()
                            .getDeclaredConstructor()
                            .newInstance();
                    parseYaml(reader, nestedObject, prefix + "  ");
                    setField(object, key, nestedObject);
                } else {
                    setField(object, key, value);
                }
            }
        }
    }

    private static <T> void setField(Object object, String fieldName, T value) throws NoSuchFieldException,
            IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);

        if (field.getType().isPrimitive() || isWrapperType(field.getType())) {
            field.set(object, convertValueToType(field.getType(), value));
        } else {
            field.set(object, value);
        }
    }

    private static <T> Object convertValueToType(Class<T> type, Object value) throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        if (type.isPrimitive()) {
            if (type.equals(int.class)) {
                return Integer.parseInt((String) value);
            } else if (type.equals(double.class)) {
                return Double.parseDouble((String) value);
            } else if (type.equals(boolean.class)) {
                return Boolean.parseBoolean((String) value);
            }
        } else if (isWrapperType(type)) {
            return type.getDeclaredMethod("valueOf", String.class).invoke(null, value.toString());
        }
        return null;
    }

    private static String serializeFieldsToString(Object object, String indent) throws IllegalAccessException {
        if (object != null) {
            StringBuilder builder = new StringBuilder();

            for (Field field : object.getClass().getDeclaredFields()) {
                field.setAccessible(true);

                if (field.getType().isPrimitive() || (isWrapperType(field.getType())
                        || field.getType().equals(String.class))) {
                    addToStringBuilder(builder, field.getName(), field.get(object).toString(), indent);
                } else {
                    builder.append(indent)
                            .append(field.getName())
                            .append(":")
                            .append("\n")
                            .append(serializeFieldsToString(field.get(object), indent + "  "));
                }
            }

            return builder.toString();
        }

        return "";
    }

    private static void addToStringBuilder(StringBuilder builder, String key, String value, String indent) {
        builder.append(indent)
                .append(key)
                .append(": ")
                .append(value)
                .append("\n");
    }

    private static boolean isWrapperType(Class<?> clazz) {
        return clazz.equals(Boolean.class) ||
                clazz.equals(Character.class) ||
                clazz.equals(Byte.class) ||
                clazz.equals(Short.class) ||
                clazz.equals(Integer.class) ||
                clazz.equals(Long.class) ||
                clazz.equals(Float.class) ||
                clazz.equals(Double.class);
    }

}
