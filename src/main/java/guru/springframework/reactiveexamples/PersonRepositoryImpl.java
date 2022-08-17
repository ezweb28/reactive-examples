package guru.springframework.reactiveexamples;

import guru.springframework.reactiveexamples.domain.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by jt on 2/27/21.
 */
public class PersonRepositoryImpl implements PersonRepository {

//    Person michael = new Person(1, "Michael", "Weston");
    Person michael = Person.builder().id(1).firstName("Michael").lastName("Weston").build();
    Person fiona = new Person(2, "fiona", "Glenanne");
    Person sam = new Person(3, "sam", "Axe");
    Person jesse = new Person(4, "jesse", "Porter");

    @Override
    public Mono<Person> getById(Integer id) {
//        return Mono.just(michael);
        return this.findAll().filter(person -> person.getId().equals(id)).next();
    }

    @Override
    public Flux<Person> findAll() {
        return Flux.just(michael, fiona, sam, jesse);
    }
}
