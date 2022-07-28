package com.graphql.learning.springgraphqldemo;

import com.graphql.learning.springgraphqldemo.dto.Customer;
import com.graphql.learning.springgraphqldemo.dto.Profile;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

/**
 * @Author: Meeravali Shaik
 * Date: 7/16/22
 */
@Component
public class CustomerService {

    public Mono<List<Customer>> getCustomers(){
        return Mono.just(List.of(new Customer(1,"Bhavni"),new Customer(2,"Vali"))).subscribeOn(Schedulers.boundedElastic());
    }

    public Mono<Customer> customerById(int id){
        return Mono.just(new Customer(id,"Custom Name"));
    }

    public Mono<Profile> getProfile(Customer customer){
        return Mono.just((new Profile(1 , customer.id()))).subscribeOn(Schedulers.boundedElastic());
    }

}
