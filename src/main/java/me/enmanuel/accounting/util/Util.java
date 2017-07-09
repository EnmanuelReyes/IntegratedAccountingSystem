package me.enmanuel.accounting.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: enmanuelreyes
 * Date: 7/1/17
 * Time: 10:17 AM
 */
public class Util {

    public static <T> List<T> toList(Iterable<T> iterable) {
        List<T> target = new ArrayList<T>();
        iterable.forEach(target::add);
        return target;
    }
}
