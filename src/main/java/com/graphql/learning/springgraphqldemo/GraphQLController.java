package com.graphql.learning.springgraphqldemo;

/**
 * @Author: Meeravali Shaik
 * Date: 7/16/22
 */

/*@RestController
public class GraphQLController {

    @Autowired
    CustomerService customerService;

    *//*@SchemaMapping(typeName = "Query" , field = "customers")
    public Mono<List<Customer>> getCustomerDetails(){
      return customerService.getCustomers();
    }*//*

    @QueryMapping(name = "customers")
    public Mono<List<Customer>> fetchCustomers(){
        return customerService.getCustomers();
    }

   *//* @SchemaMapping(typeName = "Query" , field = "customerById")
    public Mono<Customer> getCustomerById(@Argument  int id){
        return customerService.customerById(id);
    }*//*

    @QueryMapping(name = "customerById")
    public Mono<Customer> fetchCustomerById(@Argument  int id){
        return customerService.customerById(id);
    }

   *//* @SchemaMapping(typeName = "Customer" , field = "profile")
    public Mono<Profile> getCustomerProfile(Customer customer){
       return customerService.getProfile(customer);
    }*//*

    @BatchMapping(field = "profile")
    public Mono<Map<Customer,Profile>> fetchProfileInfo(List<Customer> customers){
        return Mono.just(customers.stream()
                .collect(Collectors.toMap(customer->customer, customer->new Profile(1,customer.id()))));
    }

    *//*@QueryMapping
    public Mono<Profile> profile(Customer customer){
        return customerService.getProfile(customer);
    }*//*
}*/
