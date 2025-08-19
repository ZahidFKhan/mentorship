package com.epam;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApi {

    //Stream Generation
    public Stream<Prop> generate(int n) {
        return IntStream.range(0, n).mapToObj(i -> new Prop(UUID.randomUUID(), "Record-" + i, i));
    }

    //Flattening
    public Stream<UUID> toIds(List<List<Prop>> propList) {
        return propList.stream()
                .flatMap(list -> list.stream()).map(Prop::id);
    }

    //Count Even Numbers
    public long countEven(Stream<Integer> numbers) {
        return numbers.filter(num -> num % 2 == 0).count();
    }

    //Shortening Operations
    public Stream<Character> getFirstWord(Stream<Character> characterStream) {
        return characterStream.dropWhile(Character::isWhitespace)
                .takeWhile(c -> !Character.isWhitespace(c));

    }

    //Indirect Mapping
    public Stream<String> getNotNullProperties(Stream<Prop> props) {
        return props.filter(prop -> prop.id() != null && !prop.name().isBlank() && prop.value() != 0)
                .map(prop -> prop.id() + prop.name() + prop.value());
    }

    //Sorting
    public List<Prop> sortByValueAndName(Stream<Prop> props) {
        return props.sorted(Comparator.comparing(Prop::value)
                .thenComparing(Prop::name)).toList();
    }

    //Filter by Property
    public List<Prop> filterByProperty(Stream<Prop> props) {
        return props.filter(prop -> !prop.name().isBlank()).toList();
    }

    //Stateful filter
    public Stream<Prop> removeDuplicateIds(Stream<Prop> props) {
        return props.collect(Collectors.toMap(Prop::id, p -> p, (p1, p2) -> p1)).values().stream();
    }

    //Aggregation
    public Optional<Prop> highestValueObject(Stream<Prop> props) {
        return props.max(Comparator.comparing(Prop::value));
    }

    //Combining Collectors
    public List<Prop> combiningCollectors(Stream<Prop> props) {
        return props.collect(Collectors.groupingBy(Prop::name, Collectors.toList()))
                .values().stream().filter(list -> list.size() > 1).flatMap(Collection::stream).toList();
    }

    //Custom Aggregation
    public List<Prop> highestAndLowestValue(Stream<Prop> props) {
        return props.collect(Collectors.teeing(Collectors.maxBy(Comparator.comparing(Prop::value)), Collectors.minBy(Comparator.comparing(Prop::value)), ((m1, m2) ->
                List.of(m1.get(), m2.get())
        )));
    }
}
