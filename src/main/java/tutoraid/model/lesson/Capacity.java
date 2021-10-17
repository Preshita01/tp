package tutoraid.model.lesson;

import static java.util.Objects.requireNonNull;
import static tutoraid.commons.util.AppUtil.checkArgument;

/**
 * Represents a Lesson's capacity in TutorAid.
 * Guarantees: immutable; is valid as declared in {@link #isValidCapacity(String)}
 */
public class Capacity {

    public static final String MESSAGE_CONSTRAINTS =
            "Capacity should only contain numbers, and it should be at least 1 digit long";
    public static final String VALIDATION_REGEX = "\\d+";
    public final String capacity;

    /**
     * Constructs a {@code Capacity}.
     *
     * @param capacity A valid capacity.
     */
    public Capacity(String capacity) {
        requireNonNull(capacity);
        checkArgument(isValidCapacity(capacity), MESSAGE_CONSTRAINTS);
        this.capacity = capacity;
    }

    /**
     * Returns true if a given string is a valid capacity.
     */
    public static boolean isValidCapacity(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return capacity;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Capacity // instanceof handles nulls
                && capacity.equals(((Capacity) other).capacity)); // state check
    }

    @Override
    public int hashCode() {
        return capacity.hashCode();
    }

}
