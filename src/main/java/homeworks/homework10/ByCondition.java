package homeworks.homework10;

import java.lang.annotation.*;

// Аннотация для функционального интерфейса
@FunctionalInterface
public interface ByCondition {
    boolean isOk(int number);
}
