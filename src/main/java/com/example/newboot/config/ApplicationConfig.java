//package com.example.newboot.config;
//
//import com.aerospike.client.Host;
//import com.example.newboot.service.PersonRepository;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.aerospike.config.AbstractAerospikeDataConfiguration;
//import org.springframework.data.aerospike.repository.config.EnableAerospikeRepositories;
//
//import java.util.Collection;
//import java.util.Collections;
//
//@Configuration
//@EnableAerospikeRepositories(basePackageClasses = PersonRepository.class)
//public class ApplicationConfig extends AbstractAerospikeDataConfiguration {
//    @Override
//    protected Collection<Host> getHosts() {
//        return Collections.singleton(new Host("192.168.2.2", 3000));
//    }
//
//    @Override
//    protected String nameSpace() {
//        return "bsfit";
//    }
//}
