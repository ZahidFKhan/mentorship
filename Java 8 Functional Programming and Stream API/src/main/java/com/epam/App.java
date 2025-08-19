package com.epam;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {

        StreamApi streamApiObj = new StreamApi();

        //Stream Generation
        Stream<Prop> generateStream = streamApiObj.generate(10);
        generateStream.forEach(System.out::println);

        //Flattening
        Stream<Prop> flatternStream = streamApiObj.generate(10);
        Stream<UUID> uuidStream = streamApiObj.toIds(List.of(flatternStream.toList()));
        uuidStream.forEach(System.out::println);

        //Count Even Numbers
        Stream<Prop> evenCountStream = streamApiObj.generate(10);
        long evenCount = streamApiObj.countEven(evenCountStream.map(Prop::value));
        System.out.println("Even Count Sum:" + evenCount);

        //Shortening Operations
        String input = "  Hello World from Java";
        Stream<Character> firstWord = streamApiObj.getFirstWord(input.chars().mapToObj(c -> (char) c));
        String collect = firstWord.map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println(collect);

        //Indirect Mapping
        Stream<Prop> mappingStream = streamApiObj.generate(5);
        List<String> notNullProperties = streamApiObj.getNotNullProperties(mappingStream).toList();
        System.out.println(":::::Indirect Mapping:::::");

        System.out.println(notNullProperties);

        //Sorting
        Stream<Prop> initialSortingStream = streamApiObj.generate(10);
        List<Prop> props1 = streamApiObj.sortByValueAndName(initialSortingStream);
        System.out.println("::::Sorting::::::");
        System.out.println(props1);

        //Filter by Property
        Stream<Prop> filterPropertyStream = streamApiObj.generate(7);
        System.out.println("::::Filter By Property::::");
        List<Prop> props = streamApiObj.filterByProperty(filterPropertyStream);
        System.out.println(props);

        //Aggregation
        Stream<Prop> aggregrateStream = streamApiObj.generate(8);
        System.out.println(":::::Highest Value Object:::::");
        Optional<Prop> highestValueObject = streamApiObj.highestValueObject(aggregrateStream);
        System.out.println(highestValueObject.get());

        //Combining Collectors
        Stream<Prop> combinedStream = Stream.of(new Prop(UUID.randomUUID(), "Alice", 10),
                new Prop(UUID.randomUUID(), "Bob", 20),
                new Prop(UUID.randomUUID(), "Alice", 30),
                new Prop(UUID.randomUUID(), "Charlie", 40));
        System.out.println(":::::Collector Chaining:::::");
        List<Prop> combinedProp = streamApiObj.combiningCollectors(combinedStream);
        System.out.println(combinedProp);

        //Custom Aggregation
        Stream<Prop> highestAndLowestValueStream = streamApiObj.generate(7);
        System.out.println(":::highest and lowest value:::");
        List<Prop> highestAndLowestValue = streamApiObj.highestAndLowestValue(highestAndLowestValueStream);
        System.out.println(highestAndLowestValue);


    }
}
